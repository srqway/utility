package idv.hsiehpinghan.threadutility.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample implements Runnable {
	private static final int SIZE = 3;
	private static final long ONE_SECOND = 1000;
	private int id;

	public ExecutorServiceExample(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; ++i) {
			try {
				Thread.sleep(ONE_SECOND);
				System.err.printf("ExecutorServiceExample %d %d.%n", id, i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = null;
		try {
			executorService = Executors.newFixedThreadPool(SIZE);
			for (int i = 0; i < 5; ++i) {
				Runnable runnable = new ExecutorServiceExample(i);
				executorService.submit(runnable);
			}
		} finally {
			if (executorService != null) {
				executorService.shutdown();
			}
		}
	}
}
