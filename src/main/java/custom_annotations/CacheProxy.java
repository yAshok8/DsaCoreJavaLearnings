package custom_annotations;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.ConcurrentHashMap;

public class CacheProxy implements InvocationHandler {
    private Object wrappedObject;
    public CacheProxy(Object wrappedObject) {
        this.wrappedObject = wrappedObject;
    }

    public static <T> T createProxy(T obj) {
        return (T) Proxy.newProxyInstance(
                obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),
                new CacheProxy(obj));
    }

    @Override
    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
        Method targetMethod = wrappedObject.getClass()
                .getMethod(method.getName(), method.getParameterTypes());
        CacheIt cacheIt = targetMethod.getAnnotation(CacheIt.class);
        if (cacheIt != null) {
            int arg_0 = (int) args[0];
            int arg_1 = (int) args[1];
            String cacheName = method.getName();
            ConcurrentHashMap<Object, Object> cache = CacheManager.getCache(cacheName);
            String cacheKey = method.getName() + "_" + arg_0 + "_" + arg_1;
            if (cache.containsKey(cacheKey)) {
                System.out.println("Cache Hit : " + cacheKey);
                return cache.get(cacheKey);
            } else {
                System.out.println("Cache Miss : " + cacheKey);
                Object result = method.invoke(wrappedObject, args);
                cache.put(cacheKey, result);
                return result;
            }
        }
        return method.invoke(wrappedObject, args);
    }
}
