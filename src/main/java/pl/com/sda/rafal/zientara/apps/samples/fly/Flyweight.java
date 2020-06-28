package pl.com.sda.rafal.zientara.apps.samples.fly;

import java.util.HashMap;
import java.util.Map;

public class Flyweight {
    private final ConfigInfo configInfo = new ConfigInfo();

    private Map<String, String> configMap = new HashMap<>();

    public String getConfig(String type) {
        String normalizedType = type.toLowerCase();
        if (configMap.containsKey(normalizedType)) {
            return configMap.get(normalizedType);
        } else {
            String config = configInfo.getConfig(normalizedType);
            configMap.put(normalizedType, config);
            return config;
        }
    }

}
