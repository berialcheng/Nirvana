package com.nirvana;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String name = null;

// ...

        CompletableFuture<String> completableFuture
            = CompletableFuture.supplyAsync(() -> {
            if (name == null) {
                throw new RuntimeException("Computation error!");
            }
            return "Hello, " + name;
        }).handle((s, t) ->s !=null?s :"Hello, Stranger!");

        System.out.println(completableFuture.get());;
    }
}
