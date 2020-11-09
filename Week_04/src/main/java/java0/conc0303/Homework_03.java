package java0.conc0303;

import java0.conc0303.math.Fibo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.FutureTask;

/**
 * @author ：huabin
 * @date ：Created in 2020/11/9 20:35
 * @description：
 * @modified By：
 * @version: $
 */
public class Homework_03 {


    public static void main(String[] args){
        long start = System.currentTimeMillis();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(1, new Runnable() {
            @Override
            public void run() {
                System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
            }
        });
        InnerCallable innerCallable = new InnerCallable(cyclicBarrier);
        FutureTask futureTask = new FutureTask(innerCallable);
        new Thread(futureTask).start();
    }

    static class InnerCallable implements Callable {

        private CyclicBarrier cyclicBarrier;

        private InnerCallable(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public Integer call() {
            int result = Fibo.sum();
            System.out.println("异步计算结果为：" + result);
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            return result;
        }

    }

}
