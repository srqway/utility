package idv.hsiehpinghan.threadutility.example;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class ReentrantReadWriteLockExample implements Runnable {
	private static final long ONE_SECOND = 1000;
	private static final long TEN_SECOND = 10000;
	private static final int THREAD_SIZE = 5;
	private String name;
	private ReentrantReadWriteLockClass obj;

	public ReentrantReadWriteLockExample(String name, ReentrantReadWriteLockClass obj) {
		this.name = name;
		this.obj = obj;
	}

	@Override
	public void run() {
		obj.write(name);
		obj.read();
	}

	public static class ReentrantReadWriteLockClass {
		private ReadLock readLock;
		private WriteLock writeLock;
		private List<String> list = new LinkedList<>();

		public ReentrantReadWriteLockClass() {
			ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
			readLock = reentrantReadWriteLock.readLock();
			writeLock = reentrantReadWriteLock.writeLock();
		}

		public void read() {
			try {
				readLock.lock();
				System.err.println(list);
				Thread.sleep(ONE_SECOND);
			} catch (InterruptedException e) {
				System.err.println("interrupted !!!");
			} finally {
				readLock.unlock();
			}
		}

		public void write(String name) {
			try {
				writeLock.lock();
				list.add(name);
				System.err.println("name(" + name + ") added to list.");
				Thread.sleep(ONE_SECOND);
			} catch (InterruptedException e) {
				System.err.println("interrupted !!!");
			} finally {
				writeLock.unlock();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ReentrantReadWriteLockClass obj = new ReentrantReadWriteLockClass();
		for (int i = 0; i < THREAD_SIZE; ++i) {
			Thread thread = new Thread(new ReentrantReadWriteLockExample("thread_" + i, obj));
			thread.setDaemon(true);
			thread.start();
		}
		Thread.sleep(TEN_SECOND);
		System.err.println("done !!!");
	}
}
