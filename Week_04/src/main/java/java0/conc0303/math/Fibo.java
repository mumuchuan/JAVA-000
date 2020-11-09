package java0.conc0303.math;

/**
 * @author ：huabin
 * @date ：Created in 2020/11/9 20:21
 * @description：
 * @modified By：
 * @version: $
 */
public class Fibo {

    public static int sum() {
        return fibo(36);
    }

    public static int fibo(int a) {
        if ( a < 2)
            return 1;
        return fibo(a-1) + fibo(a-2);
    }

}
