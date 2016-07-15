package idv.hsiehpinghan.threadutility.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SynchronizedListExample implements Runnable {
	private static final long FIVE_SECONDS = 5000;
	private String name;
	private SynchronizedBlockClass obj;

	public SynchronizedListExample(String name, SynchronizedBlockClass obj) {
		this.name = name;
		this.obj = obj;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; ++i) {
			System.err.printf("%s add %d%n", name, i);
			obj.add(i);
		}
		obj.printIntegerList();
	}

	public static class SynchronizedBlockClass {
		List<Integer> integerList = Collections.synchronizedList(new ArrayList<Integer>());

		public void add(Integer integer) {
			integerList.add(integer);
		}

		public void printIntegerList() {
			synchronized (integerList) {
				Iterator<Integer> iter = integerList.iterator();
				while (iter.hasNext()) {
					System.err.printf("%d%n", iter.next());
				}
				System.err.println();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		SynchronizedBlockClass obj = new SynchronizedBlockClass();
		Thread thread_0 = new Thread(new SynchronizedListExample("thread_0", obj));
		Thread thread_1 = new Thread(new SynchronizedListExample("thread_1", obj));
		thread_0.setDaemon(true);
		thread_1.setDaemon(true);
		thread_0.start();
		thread_1.start();
		Thread.sleep(FIVE_SECONDS);
		System.err.println("done !!!");
	}
}
