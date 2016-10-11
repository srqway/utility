package idv.hsiehpinghan.threadutility.example;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class SemaphoreExample implements Runnable {
	private static final long FIVE_SECOND = 5000;
	private static final int THREAD_SIZE = 10;
	private String name;
	private SemaphoreClass obj;

	public SemaphoreExample(String name, SemaphoreClass obj) {
		this.name = name;
		this.obj = obj;
	}

	@Override
	public void run() {
		try {
			String resource = obj.acquire();
			System.err.println("name(" + name + ") processing with resource(" + resource + ")");
			obj.release(resource);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	public static class SemaphoreClass {
		private final int PERMIT_AMOUNT = 3;
		private Semaphore semaphore = new Semaphore(PERMIT_AMOUNT);
		private ReentrantLock reentrantLock = new ReentrantLock();
		private Queue<String> resources;

		public SemaphoreClass() {
			resources = new LinkedList<>();
			for (int i = 0; i < PERMIT_AMOUNT; ++i) {
				resources.add("resource_" + i);
			}
		}

		public String acquire() throws InterruptedException {
			semaphore.acquire();
			try {
				reentrantLock.lock();
				return resources.poll();
			} finally {
				reentrantLock.unlock();
			}
		}

		public void release(String resource) {
			try {
				reentrantLock.lock();
				resources.offer(resource);
				semaphore.release();
			} finally {
				reentrantLock.unlock();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		SemaphoreClass obj = new SemaphoreClass();
		for (int i = 0; i < THREAD_SIZE; ++i) {
			Thread thread = new Thread(new SemaphoreExample("thread_" + i, obj));
			thread.setDaemon(true);
			thread.start();
		}
		Thread.sleep(FIVE_SECOND);
		System.err.println("done !!!");
	}
}
