package idv.hsiehpinghan.threadutility.example;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableAndFutureExample {
	private static final long ONE_SECONDS = 1000;

	public static class MyCallable implements Callable<String> {

		@Override
		public String call() throws Exception {
			for (int i = 0; i < 5; ++i) {
				System.err.printf("do job(%d).%n", i);
				Thread.sleep(ONE_SECONDS);
			}
			return "job finish.";
		}
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Callable<String> callable = new MyCallable();
		FutureTask<String> futureTask = new FutureTask<String>(callable);
		Thread thread = new Thread(futureTask);
		thread.setDaemon(true);
		thread.start();
		while (futureTask.isDone() == false) {
			System.err.printf("sleeping...%n");
			Thread.sleep(ONE_SECONDS);
		}
		System.err.printf(futureTask.get());
	}
}
