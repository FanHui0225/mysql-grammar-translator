package com.glodon.translator.translate.props;

import com.glodon.translator.translate.SQLTranslatorException;

import java.io.*;
import java.util.*;

public abstract class TypedProperties<E extends Enum<?> & TypedPropertyKey> {

    private final Properties props;

    public Properties getProps() {
        return props;
    }

    private final Map<E, TypedPropertyValue> cache;


    protected TypedProperties(final Class<E> keyClass, final String path) {
        Properties props = parseConfig(path);
        this.props = null == props ? new Properties() : props;
        cache = preload(keyClass);
    }

    protected Properties parseConfig(String confFile) {
        Properties sysCfg = new Properties();
        try {
            File file = new File(confFile);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String str;
            while ((str = br.readLine()) != null) {
                if (str.startsWith("#") || str.length() == 0) {
                    continue;
                }
                String[] pairs = str.split("=");
                if (pairs.length > 1) {
                    sysCfg.put(pairs[0], pairs[1]);
                }
            }
            br.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return sysCfg;
    }

    private Map<E, TypedPropertyValue> preload(final Class<E> keyClass) {
        E[] enumConstants = keyClass.getEnumConstants();
        Map<E, TypedPropertyValue> result = new HashMap<>(enumConstants.length, 1F);
        Collection<String> errorMessages = new LinkedList<>();
        for (E each : enumConstants) {
            TypedPropertyValue value = null;
            try {
                value = new TypedPropertyValue(each, props.getOrDefault(each.getKey(), each.getDefaultValue()).toString());
            } catch (final TypedPropertyValueException ex) {
                errorMessages.add(ex.getMessage());
            }
            result.put(each, value);
        }
        if (!errorMessages.isEmpty()) {
            throw new SQLTranslatorException(String.join(System.lineSeparator(), errorMessages));
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    public final <T> T getValue(final E key) {
        return (T) cache.get(key).getValue();
    }
}
