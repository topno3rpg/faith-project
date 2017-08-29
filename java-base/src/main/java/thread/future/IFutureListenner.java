package thread.future;

/**
 * Created by yunyun on 2017/8/29.
 */
public interface IFutureListenner<V> {

    void operationCompleted(IFuture<V> future) throws Exception;

}
