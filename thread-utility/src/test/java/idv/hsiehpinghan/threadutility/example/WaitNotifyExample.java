package idv.hsiehpinghan.threadutility.example;

import java.util.LinkedList;
import java.util.Queue;

public class WaitNotifyExample {
	private static final long FIVE_SECONDS = 5000;

	public static class Clerk {
		private Queue<Integer> products = new LinkedList<>();

		public synchronized void addProduct(int product) {
			if (products.size() >= 3) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			products.add(product);
			System.out.printf("add product (%d)%n", product);
			notify();
		}

		public synchronized int removeProduct() {
			if (products.size() <= 0) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			Integer product = products.remove();
			System.out.printf("remove product (%d)%n", product);
			notify();
			return product;
		}
	}

	public static class Producer implements Runnable {
		private Clerk clerk;

		public Producer(Clerk clerk) {
			this.clerk = clerk;
		}

		public void run() {
			for (int product = 1; product < 10; ++product) {
				clerk.addProduct(product);
			}
		}
	}

	public static class Consumer implements Runnable {
		private Clerk clerk;

		public Consumer(Clerk clerk) {
			this.clerk = clerk;
		}

		public void run() {
			for (int i = 1; i <= 10; i++) {
				clerk.removeProduct();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Clerk clerk = new Clerk();
		Thread producerThread = new Thread(new Producer(clerk));
		Thread consumerThread = new Thread(new Consumer(clerk));
		producerThread.setDaemon(true);
		consumerThread.setDaemon(true);
		producerThread.start();
		consumerThread.start();
		Thread.sleep(FIVE_SECONDS);
	}
}
