package org.qrl.juc.thread.basic.CompletableFuture;

import org.qrl.tools.util.thread.ThreadTool;

import java.util.concurrent.CompletableFuture;

/**
 *  CompletableFuture的API是真滴多 ＞﹏＜
 *  按照接受参数和返回值分类: run accept apply
 *
 *      例如thenApply等方法都会有thenApplyAsync()的异步方法
 */
public class Demo1_CompletableFuture {

    public void thenCombineTest(){
        ThreadTool.printTimeAndThreadInfo("A customer XiaoBai enter a restaurant");
        ThreadTool.printTimeAndThreadInfo("XiaoBai order a fried eggs with tomato and a bowl of rice");
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(()->{
            ThreadTool.printTimeAndThreadInfo("Cook is cooking");
            ThreadTool.sleepMillis(200);
            return "fried eggs with tomato";
        }).thenCombine(CompletableFuture.supplyAsync(()->{
            ThreadTool.printTimeAndThreadInfo("Waiter steam rice");
            ThreadTool.sleepMillis(100);
            return "a bowl of rice";
        }),
            // BiFunction() 把两个结果合成一个
            (dish, rice)->{
            ThreadTool.printTimeAndThreadInfo("Waiter fill a bowl of rice");
            ThreadTool.sleepMillis(100);
            return String.format("%s + %s is Ok", dish, rice);
        });
        ThreadTool.printTimeAndThreadInfo("XiaoBai is playing games");
        ThreadTool.printTimeAndThreadInfo("XiaoBao get " + cf1.join());
    }

    public void thenComposeTest(){
        ThreadTool.printTimeAndThreadInfo("A customer XiaoBai enter a restaurant");
        ThreadTool.printTimeAndThreadInfo("XiaoBai order a fried eggs with tomato and a bowl of rice");
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(()->{
            ThreadTool.printTimeAndThreadInfo("Cook is cooking");
            ThreadTool.sleepMillis(200);
            return "Fried eggs with tomato";
        }).thenComposeAsync(dish -> CompletableFuture.supplyAsync(()->{
            ThreadTool.printTimeAndThreadInfo("Waiter is filling a bowl of rice");
            ThreadTool.sleepMillis(100);
            return dish + " + a bowl of rice";
        }));
        ThreadTool.printTimeAndThreadInfo("XiaoBai is playing games");
        ThreadTool.printTimeAndThreadInfo("XiaoBao get " + cf1.join());
    }

    public void thenApplyTest(){
        ThreadTool.printTimeAndThreadInfo("XiaoBai is full");
        ThreadTool.printTimeAndThreadInfo("XiaoBai ask the waiter for the bill");
        CompletableFuture<String> invoice = CompletableFuture.supplyAsync(()->{
            ThreadTool.printTimeAndThreadInfo("Waiter get 50$");
            ThreadTool.sleepMillis(200);
            return "500";
        }).thenApplyAsync(money->{
            ThreadTool.printTimeAndThreadInfo(String.format("Another waiter invoice XiaoBai for %s", money));
            ThreadTool.sleepMillis(100);
            return String.format("A receipt for %s", money);
        });
        ThreadTool.printTimeAndThreadInfo("XiaoBai cell his friends to play video games");
        ThreadTool.printTimeAndThreadInfo(String.format("XiaoBai get %s", invoice.join()));
    }

    // applyToEither可用于获得两个线程中先返回的值的线程
    public void applyToEitherTest(){
        ThreadTool.printTimeAndThreadInfo("XiaoBai waits for the bus 700 or the bus 800");
        CompletableFuture<String> bus = CompletableFuture.supplyAsync(()->{
            ThreadTool.printTimeAndThreadInfo("Bus 700 is coming");
            ThreadTool.sleepMillis(100);
            return "Bus 700";
        }).applyToEither(CompletableFuture.supplyAsync(()->{
            ThreadTool.printTimeAndThreadInfo("Bus 800 is coming");
            ThreadTool.sleepMillis(200);
            return "Bus 800";
        }), firstBus -> firstBus).exceptionally(e->{
            ThreadTool.printTimeAndThreadInfo(e.getMessage());
            ThreadTool.printTimeAndThreadInfo("XiaoBai is forced to take a taxi home");
            return "Taxi";
        });
        ThreadTool.printTimeAndThreadInfo(String.format("XiaoBai go home by the %s", bus.join()));
    }
}
