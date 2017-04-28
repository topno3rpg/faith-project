package thread.pool;

import java.util.concurrent.*;

/**
 * Created by Admin on 2016/9/19.
 */
public class ExecutorThreadPoolBean {

    /**
     * 直接提交队列线程池
     * 使用synchornousQueue做直接提交
     * 主线程设置为0个
     * 最大线程设置为int 最大值
     *
     * @return ExecutorService
     */
    public static ExecutorService getSynchornousTheadPool() {
        return new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
    }

    /**
     * 无界队列线程池
     * 使用LinkedBlockingQueue实现无界
     * 主线程数=（线程等待时间%线程cpu时间+1）*cpu核数
     * 最大线程数已无意义，因为当池中线程大于主线程数时会提交到队列，只有队列满了才会用到最大线程数
     * 然而队列是无界的
     *
     * @return ExecutorService
     */
    public static ExecutorService getUnboundedThreadPool() {
        return new ThreadPoolExecutor(3, 3, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
    }


    /**
     * 有界队列
     * 使用ArrayBlockingQueue实现有界，防止系统资源耗尽
     * 使用可以防止系统资源耗尽
     * 主线程数=（线程等待时间%线程cpu时间+1）*cpu核数
     * 最大线程数需要参考系统资源、ArrayBlockingQueue大小、线程空闲时间等综合考虑
     * 需要增加线程数越界的异常处理
     *
     * @return ExecutorService
     */
    public static ExecutorService getBoundedThreadPool() {
        return new ThreadPoolExecutor(3, 3, 60L, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(2048),
                new ThreadPoolExecutor.CallerRunsPolicy() //当前线程执行
                // new ThreadPoolExecutor.AbortPolicy() //抛异常
                // new ThreadPoolExecutor.DiscardPolicy() //丢弃任务
                // new ThreadPoolExecutor.DiscardOldestPolicy() //丢弃队列最早任务，重试执行当前任务
        );
    }

}
