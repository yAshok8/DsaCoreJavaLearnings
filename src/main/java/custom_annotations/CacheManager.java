package custom_annotations;

import java.util.concurrent.ConcurrentHashMap;

public class CacheManager {

    private static final ConcurrentHashMap<String, ConcurrentHashMap<Object, Object>> caches = new ConcurrentHashMap<>();

    // Get or create a cache by name
    public static ConcurrentHashMap<Object, Object> getCache(String cacheName) {
        return caches.computeIfAbsent(cacheName, k -> new ConcurrentHashMap<>());
    }


}
