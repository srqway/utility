package idv.hsiehpinghan.threadutility.example;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionExample implements Runnable {
	private static final long FIVE_SECOND = 3000;
	private static final int THREAD_SIZE = 5;
	private int id;
	private ConditionClass obj;

	public ConditionExample(int id, ConditionClass obj) {
		this.id = id;
		this.obj = obj;
	}

	@Override
	public void run() {
		if (id % 2 == 0) {
			String result = obj.poll();
			System.err.println(result);
		} else {
			obj.offer("name_" + id);
		}
	}

	public static class ConditionClass {
		private final int MAX_SIZE = 3;
		private Queue<String> queue = new LinkedList<String>();
		private ReentrantLock reentrantLock;
		private Condition notFullCondition;
		private Condition notEmptyCondition;

		public ConditionClass() {
			reentrantLock = new ReentrantLock(true);
			notFullCondition = reentrantLock.newCondition();
			notEmptyCondition = reentrantLock.newCondition();
		}

		public String poll() {
			try {
				reentrantLock.lock();
				if (queue.isEmpty()) {
					notEmptyCondition.await();
				}
				String result = queue.poll();
				notFullCondition.signal();
				return result;
			} catch (InterruptedException e) {
				System.err.println("interrupted !!!");
			} finally {
				reentrantLock.unlock();
			}
			return null;
		}

		public void offer(String name) {
			try {
				reentrantLock.lock();
				if (queue.size() >= MAX_SIZE) {
					notFullCondition.await();
				}
				queue.offer(name);
				notEmptyCondition.signal();
			} catch (InterruptedException e) {
				System.err.println("interrupted !!!");
			} finally {
				reentrantLock.unlock();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ConditionClass obj = new ConditionClass();
		for (int i = 0; i < THREAD_SIZE; ++i) {
			Thread thread = new Thread(new ConditionExample(i, obj));
			thread.setDaemon(true);
			thread.start();
		}
		Thread.sleep(FIVE_SECOND);
		System.err.println("done !!!");
	}
}
