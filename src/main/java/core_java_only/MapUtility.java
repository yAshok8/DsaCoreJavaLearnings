package core_java_only;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class MapUtility {

    private static final ConcurrentMap<String, String> inMemAccounts = new ConcurrentHashMap<>();

    public static synchronized String getObject(String account){
        if(inMemAccounts.containsKey(account))
            return inMemAccounts.get(account);
        String obj = new String(account);
        inMemAccounts.put(account, obj);
        return inMemAccounts.get(account);
    }


}
