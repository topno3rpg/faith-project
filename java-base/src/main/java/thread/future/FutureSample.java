package thread.future;

import java.util.concurrent.*;

/**
 * Created by Admin on 2016/9/19.
 */
public class FutureSample {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> result = executor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return " hello world !";
            }
        });
        try {
            System.out.println(result.get(60, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }

    }

}
