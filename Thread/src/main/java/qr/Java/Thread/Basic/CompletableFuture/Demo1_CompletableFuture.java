package qr.Java.Thread.Basic.CompletableFuture;

import org.junit.jupiter.api.Test;
import qr.Java.Thread.Utils.ThreadUtils;

import java.util.concurrent.CompletableFuture;

/**
 *  CompletableFuture的API是真滴多 ＞﹏＜
 *  按照接受参数和返回值分类: run accept apply
 *
 *      例如thenApply等方法都会有thenApplyAsync()的异步方法
 */
public class Demo1_CompletableFuture {

    @Test
    public void thenCombineTest(){
        ThreadUtils.printTimeAndThreadInfo("A customer XiaoBai enter a restaurant");
        ThreadUtils.printTimeAndThreadInfo("XiaoBai order a fried eggs with tomato and a bowl of rice");
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(()->{
            ThreadUtils.printTimeAndThreadInfo("Cook is cooking");
            ThreadUtils.sleepMillis(200);
            return "fried eggs with tomato";
        }).thenCombine(CompletableFuture.supplyAsync(()->{
            ThreadUtils.printTimeAndThreadInfo("Waiter steam rice");
            ThreadUtils.sleepMillis(100);
            return "a bowl of rice";
        }),
            // BiFunction() 把两个结果合成一个
            (dish, rice)->{
            ThreadUtils.printTimeAndThreadInfo("Waiter fill a bowl of rice");
            ThreadUtils.sleepMillis(100);
            return String.format("%s + %s is Ok", dish, rice);
        });
        ThreadUtils.printTimeAndThreadInfo("XiaoBai is playing games");
        ThreadUtils.printTimeAndThreadInfo("XiaoBao get " + cf1.join());
    }

    @Test
    public void thenComposeTest(){
        ThreadUtils.printTimeAndThreadInfo("A customer XiaoBai enter a restaurant");
        ThreadUtils.printTimeAndThreadInfo("XiaoBai order a fried eggs with tomato and a bowl of rice");
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(()->{
            ThreadUtils.printTimeAndThreadInfo("Cook is cooking");
            ThreadUtils.sleepMillis(200);
            return "Fried eggs with tomato";
        }).thenComposeAsync(dish -> CompletableFuture.supplyAsync(()->{
            ThreadUtils.printTimeAndThreadInfo("Waiter is filling a bowl of rice");
            ThreadUtils.sleepMillis(100);
            return dish + " + a bowl of rice";
        }));
        ThreadUtils.printTimeAndThreadInfo("XiaoBai is playing games");
        ThreadUtils.printTimeAndThreadInfo("XiaoBao get " + cf1.join());
    }

    @Test
    public void thenApplyTest(){
        ThreadUtils.printTimeAndThreadInfo("XiaoBai is full");
        ThreadUtils.printTimeAndThreadInfo("XiaoBai ask the waiter for the bill");
        CompletableFuture<String> invoice = CompletableFuture.supplyAsync(()->{
            ThreadUtils.printTimeAndThreadInfo("Waiter get 50$");
            ThreadUtils.sleepMillis(200);
            return "500";
        }).thenApplyAsync(money->{
            ThreadUtils.printTimeAndThreadInfo(String.format("Another waiter invoice XiaoBai for %s", money));
            ThreadUtils.sleepMillis(100);
            return String.format("A receipt for %s", money);
        });
        ThreadUtils.printTimeAndThreadInfo("XiaoBai cell his friends to play video games");
        ThreadUtils.printTimeAndThreadInfo(String.format("XiaoBai get %s", invoice.join()));
    }

    // applyToEither可用于获得两个线程中先返回的值的线程
    @Test
    public void applyToEitherTest(){
        ThreadUtils.printTimeAndThreadInfo("XiaoBai waits for the bus 700 or the bus 800");
        CompletableFuture<String> bus = CompletableFuture.supplyAsync(()->{
            ThreadUtils.printTimeAndThreadInfo("Bus 700 is coming");
            ThreadUtils.sleepMillis(100);
            return "Bus 700";
        }).applyToEither(CompletableFuture.supplyAsync(()->{
            ThreadUtils.printTimeAndThreadInfo("Bus 800 is coming");
            ThreadUtils.sleepMillis(200);
            return "Bus 800";
        }), firstBus -> firstBus).exceptionally(e->{
            ThreadUtils.printTimeAndThreadInfo(e.getMessage());
            ThreadUtils.printTimeAndThreadInfo("XiaoBai is forced to take a taxi home");
            return "Taxi";
        });
        ThreadUtils.printTimeAndThreadInfo(String.format("XiaoBai go home by the %s", bus.join()));
    }
}
