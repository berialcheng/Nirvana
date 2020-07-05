package com.nirvana;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class FutureTaskExample {

    static ExecutorService executor = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {
        option1();
        option2();
    }

    public static void option1() {
        Callable c = () -> {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                .url("https://www.baidu.com")
                .method("GET", null)
                .build();
            Thread.currentThread().sleep(5000);
            Response response = client.newCall(request).execute();
            return response.body().string();
        };

        FutureTask<String> stringFutureTask = new FutureTask<>(c);
        executor.execute(stringFutureTask);

        try {
            System.out.println("=========get result");
            System.out.println(stringFutureTask.get());
            System.out.println("=========finish result");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void option2() {
        Runnable r = () -> {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                .url("https://www.baidu.com")
                .method("GET", null)
                .build();
            try {
                Thread.currentThread().sleep(5000);
                Response response = client.newCall(request).execute();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        };
        String result = "predefinedResult";
        FutureTask<String> stringFutureTask = new FutureTask<>(r, result);
        executor.execute(stringFutureTask);

        try {
            System.out.println("=========get result");
            System.out.println(stringFutureTask.get());
            System.out.println("=========finish result");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
