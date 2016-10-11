package idv.hsiehpinghan.threadutility.example;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorExample {
	private static final int THREAD_SIZE = 100;
	private static final long ONE_SECOND = 1000;

	private static class PriorityBlockingQueueExample implements Runnable, Comparable<PriorityBlockingQueueExample> {
		private int priority;
		private String name;

		public PriorityBlockingQueueExample(int priority, String name) {
			this.priority = priority;
			this.name = name;
		}

		@Override
		public void run() {
			try {
				System.err.println(name + " running.");
				Thread.sleep(ONE_SECOND);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}

		@Override
		public int compareTo(PriorityBlockingQueueExample o) {
			return Integer.valueOf(priority).compareTo(o.priority);
		}

	}

	public static void main(String[] args) throws InterruptedException {
		int corePoolSize = 10;
		int maximumPoolSize = 20;
		long keepAliveTime = 0L;
		TimeUnit unit = TimeUnit.SECONDS;
		BlockingQueue<Runnable> workQueue = new PriorityBlockingQueue<Runnable>();
		RejectedExecutionHandler handler = new AbortPolicy();
		ExecutorService executorService = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit,
				workQueue, handler);
		for (int i = THREAD_SIZE - 1; i >= 0; --i) {
			Runnable runnable = new PriorityBlockingQueueExample(i, "name_" + i);
			executorService.execute(runnable);
		}
	}
}
