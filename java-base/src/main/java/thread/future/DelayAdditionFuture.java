package thread.future;

/**
 * Created by yunyun on 2017/8/29.
 */
public class DelayAdditionFuture extends AbstractFuture<Integer> {

    @Override
    public IFuture<Integer> setSuccess(Object result) {
        return super.setSuccess(result);
    }

    @Override
    public IFuture<Integer> setFailure(Throwable cause) {
        return super.setFailure(cause);
    }

}
