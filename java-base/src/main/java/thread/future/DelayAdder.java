package thread.future;

/**
 * Created by yunyun on 2017/8/29.
 */
public class DelayAdder {

    public static void main(String[] args) {
        new DelayAdder().add(3 * 1000, 1, 2).addListenner(
                new IFutureListenner<Integer>() {
                    @Override
                    public void operationCompleted(IFuture<Integer> future) throws Exception {
                        System.out.println(future.getNow());
                    }
                }
        );
    }


    public DelayAdditionFuture add(long delay, int a, int b) {
        DelayAdditionFuture future = new DelayAdditionFuture();
        new Thread(new DelayAddtionTask(delay, a, b, future)).start();
        return future;
    }

    private class DelayAddtionTask implements Runnable {

        private long delay;

        private int a, b;

        private DelayAdditionFuture future;

        public DelayAddtionTask(long delay, int a, int b, DelayAdditionFuture future) {
            super();
            this.delay = delay;
            this.a = a;
            this.b = b;
            this.future = future;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(delay);
                Integer i = a + b;
                future.setSuccess(i);
            } catch (InterruptedException e) {
                future.setFailure(e);
            }

        }
    }
}
