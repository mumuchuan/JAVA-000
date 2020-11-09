package java0.conc0303;

import java0.conc0303.math.Fibo;

import java.util.concurrent.Semaphore;

/**
 * @author ：huabin
 * @date ：Created in 2020/11/9 20:44
 * @description： 只是为了敲敲Semaphore用法
 * @modified By：
 * @version: $
 */
public class Homework_04 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Semaphore semaphore = new Semaphore(1);
        InnerThread innerThread = new InnerThread(start,semaphore);
        innerThread.start();

    }

    static class InnerThread extends Thread {

        private long start;
        private Semaphore semaphore;

        private InnerThread(long start, Semaphore semaphore) {
            this.start = start;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                int result = Fibo.sum();
                System.out.println("异步计算结果为：" + result);
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
            }

        }

    }

}
