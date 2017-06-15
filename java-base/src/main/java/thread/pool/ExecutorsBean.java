package thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Admin on 2016/9/19.
 */
public class ExecutorsBean {

    public static ExecutorService getSingleThreadExecutor() {
        return Executors.newSingleThreadExecutor();
    }

    public static ExecutorService getFixedThreadPool(Integer num) {
        return Executors.newFixedThreadPool(num == null ? 3 : num);
    }

    /**
     * 无界线程池
     *
     * @return Executor
     */
    public static ExecutorService getCachedThreadPool() {
        return Executors.newCachedThreadPool();
    }

    /**
     * 定时任务线程池
     *
     * @param num
     * @return Executor
     */
    public static ScheduledExecutorService getScheduledThreadPoolExecutor(Integer num) {
        return Executors.newScheduledThreadPool(num == null ? 3 : num);
    }

    public static void main(String[] args) {
        Thread singleThreadExecutor_t1 = new ThreadBean();
        Thread singleThreadExecutor_t2 = new ThreadBean();
        Thread fixedTreadPool_t1 = new ThreadBean();
        Thread fixedTreadPool_t2 = new ThreadBean();
        Thread cachedThreadPool_t1 = new ThreadBean();
        Thread cachedThreadPool_t2 = new ThreadBean();

        ExecutorService singleThreadExecutor = getSingleThreadExecutor();
        singleThreadExecutor.execute(singleThreadExecutor_t1);
        singleThreadExecutor.execute(singleThreadExecutor_t2);
        singleThreadExecutor.shutdown();

        ExecutorService fixedTreadPool = getFixedThreadPool(1);
        fixedTreadPool.execute(fixedTreadPool_t1);
        fixedTreadPool.execute(fixedTreadPool_t2);
        fixedTreadPool.shutdown();

        ExecutorService cachedThreadPool = getCachedThreadPool();
        cachedThreadPool.execute(cachedThreadPool_t1);
        cachedThreadPool.execute(cachedThreadPool_t2);
        cachedThreadPool.shutdown();


        ScheduledExecutorService scheduledThreadPoolExecutor = getScheduledThreadPoolExecutor(1);
        scheduledThreadPoolExecutor.scheduleAtFixedRate(new Runnable() {//每隔一段时间就触发异常
            @Override
            public void run() {
                //throw new RuntimeException();
                System.out.println("================");
            }
        }, 1000, 5000, TimeUnit.MILLISECONDS);
        scheduledThreadPoolExecutor.scheduleAtFixedRate(new Runnable() {//每隔一段时间就触发异常
            @Override
            public void run() {
                //throw new RuntimeException();
                System.out.println(System.currentTimeMillis());
            }
        }, 1000, 5000, TimeUnit.MILLISECONDS);
    }

}
