package core_java_only.java8;

import java.util.concurrent.CompletableFuture;

public class CompletionFutureDemo {
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(CompletionFutureDemo::getOrder)
                .thenApply(CompletionFutureDemo::processOrder)
                .thenApply(CompletionFutureDemo::processPayment)
                .thenApply(CompletionFutureDemo::dispatch)
                .thenAccept(CompletionFutureDemo::sendEmail);
    }

    public static Order getOrder() {
        System.out.println("getOrder() started.");
        System.out.println("getOrder() completed.");
        return new Order();
    }

    public static Order processOrder(Order order) {
        System.out.println("processOrder() started.");
        System.out.println("processOrder() completed.");
        return new Order();
    }

    public static Order processPayment(Order order) {
        System.out.println("processPayment() started.");
        System.out.println("processPayment() completed.");
        return new Order();
    }

    public static Order dispatch(Order order) {
        System.out.println("dispatch() started.");
        System.out.println("dispatch() completed.");
        return new Order();
    }

    public static Order sendEmail(Order order) {
        System.out.println("sendEmail() started.");
        System.out.println("sendEmail() completed.");
        return new Order();
    }
}
