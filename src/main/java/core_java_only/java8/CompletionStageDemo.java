package core_java_only.java8;

import java.util.concurrent.CompletableFuture;

public class CompletionStageDemo {
    public static void main(String[] args) {
        System.out.println("coming here");
        CompletableFuture.supplyAsync(CompletionStageDemo::getOrder)
                .thenApply(CompletionStageDemo::processOrder)
                .thenApply(CompletionStageDemo::processPayment)
                .thenApply(CompletionStageDemo::processPayment)
                .thenAccept(CompletionStageDemo::sendEmail);
    }

    public static Order getOrder() {
        System.out.println("getOrder() started.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("getOrder() completed.");
        return new Order();
    }

    public static Order processOrder(Order order) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("processOrder() completed.");
        return new Order();
    }

    public static Order processPayment(Order order) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("processPayment() completed.");
        return new Order();
    }

    public static Order dispatch(Order order) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("dispatch() completed.");
        return new Order();
    }

    public static Order sendEmail(Order order) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sendEmail() completed.");
        return new Order();
    }
}
