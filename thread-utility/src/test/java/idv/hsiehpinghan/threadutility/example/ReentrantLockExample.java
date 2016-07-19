package idv.hsiehpinghan.threadutility.example;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample implements Runnable {
	private static final long ONE_SECOND = 1000;
	private static final long TEN_SECONDS = 10000;
	private String name;
	private ReentrantLockClass obj;

	public ReentrantLockExample(String name, ReentrantLockClass obj) {
		this.name = name;
		this.obj = obj;
	}

	@Override
	public void run() {
		obj.print(name);
	}

	public static class ReentrantLockClass {
		private ReentrantLock reentrantLock = new ReentrantLock();

		public void print(String name) {
			try {
				reentrantLock.lock();
				for (int i = 0; i < 5; ++i) {
					System.err.printf("%s append %d.%n", name, i);
					Thread.sleep(ONE_SECOND);
				}
			} catch (InterruptedException e) {
				System.err.println("interrupted !!!");
			} finally {
				reentrantLock.unlock();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ReentrantLockClass obj = new ReentrantLockClass();
		Thread thread_0 = new Thread(new ReentrantLockExample("thread_0", obj));
		Thread thread_1 = new Thread(new ReentrantLockExample("thread_1", obj));
		thread_0.setDaemon(true);
		thread_1.setDaemon(true);
		thread_0.start();
		thread_1.start();
		Thread.sleep(TEN_SECONDS);
		System.err.println("done !!!");
	}
}
