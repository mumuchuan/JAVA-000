package java0.conc0303;

import java0.conc0303.math.Fibo;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author ：huabin
 * @date ：Created in 2020/11/9 20:51
 * @description：
 * @modified By：
 * @version: $
 */
public class Homework_02 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        long start = System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        InnerCallable innerCallable = new InnerCallable(countDownLatch);
        FutureTask futureTask = new FutureTask(innerCallable);
        new Thread(futureTask).start();
        countDownLatch.await();
        System.out.println("异步计算结果为：" + futureTask.get());
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
    }

    static class InnerCallable implements Callable {

        private CountDownLatch countDownLatch;

        private InnerCallable(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public Integer call() {
            int result = Fibo.sum();
            countDownLatch.countDown();
            return result;
        }

    }

}
