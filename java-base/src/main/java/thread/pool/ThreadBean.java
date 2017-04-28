package thread.pool;

/**
 * Created by Admin on 2016/9/19.
 */
public class ThreadBean extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " running ");
    }

}
