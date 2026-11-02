package core_java_only.general;

import java.util.HashMap;
import java.util.Map;

public class TtlCache {

    Map<String, String> cache = new HashMap<>();
    Map<String, Long> cacheDuration = new HashMap<>();

    void put(String key, String value, long now, long ttl) {
        long newTime = now + ttl;
        cache.put(key, value);
        cacheDuration.put(key, newTime);
    }

    String get(String key, long now) {
        if (!cache.containsKey(key)) return null;
        long savedWindow = cacheDuration.get(key);
        if (savedWindow < now) {
            return cache.get(key);
        }
        return null;
    }
}

