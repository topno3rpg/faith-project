package thread.future;


import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by yunyun on 2017/8/28.
 */
public interface IFuture<V> extends Future<V> {

    boolean isSuccess();

    V getNow();

    Throwable cause();

    boolean isCancellable();

    IFuture<V> await() throws InterruptedException;

    boolean await(long timeoutMillis) throws InterruptedException;

    boolean await(long timeout, TimeUnit timeUnit) throws InterruptedException;

    IFuture<V> awaitUninterruptibly();

    boolean awaitUninterruptibly(long timeoutMillis);

    boolean awaitUninterruptibly(long timeout, TimeUnit timeUnit);

    IFuture<V> addListenner(IFutureListenner<V> l);

    IFuture<V> removeListenner(IFutureListenner<V> l);

}
