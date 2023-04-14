package core_java_only.java8;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;

public class CombiningCompletableFutureResults {
    public static void main(String[] args) {
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            try{Thread.sleep(1000);} catch (Exception e){}
            return "hello";
        });
        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(() -> {
            try{Thread.sleep(2000);} catch (Exception e){}
            return "Ashok Bhai";
        });
        CompletableFuture<String> cf3 = CompletableFuture.supplyAsync(() -> {
            try{Thread.sleep(4000);} catch (Exception e){}
            return "!";
        });
        BiFunction<String, String, String> bf = (res1, res2) -> res1 + " " + res2;
        CompletableFuture<String> combinedCf = cf1.thenCombine(cf2.thenCombine(cf3, bf), bf);
        System.out.println(combinedCf.join());
    }
}
