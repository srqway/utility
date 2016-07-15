package idv.hsiehpinghan.collectionutility.java.util.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ArrayBlockingQueueTest {
	private static final long FIVE_SECONDS = 5000;

	public static class Producer implements Runnable {
		private BlockingQueue<Integer> products;

		public Producer(BlockingQueue<Integer> products) {
			this.products = products;
		}

		@Override
		public void run() {
			for (int product = 1; product < 10; ++product) {
				try {
					products.put(product);
					System.err.printf("put %d.%n", product);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static class Consumer implements Runnable {
		private BlockingQueue<Integer> products;

		public Consumer(BlockingQueue<Integer> products) {
			this.products = products;
		}

		@Override
		public void run() {
			for (int i = 1; i <= 10; i++) {
				try {
					Integer product = products.take();
					System.err.printf("take %d.%n", product);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		final int SIZE = 3;
		BlockingQueue<Integer> products = new ArrayBlockingQueue<>(SIZE);
		Thread producerThread = new Thread(new Producer(products));
		Thread consumerThread = new Thread(new Consumer(products));
		producerThread.setDaemon(true);
		consumerThread.setDaemon(true);
		producerThread.start();
		consumerThread.start();
		Thread.sleep(FIVE_SECONDS);
	}
}
