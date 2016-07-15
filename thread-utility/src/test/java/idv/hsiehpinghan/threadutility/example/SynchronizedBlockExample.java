package idv.hsiehpinghan.threadutility.example;

import java.util.ArrayList;
import java.util.List;

public class SynchronizedBlockExample implements Runnable {
	private static final long FIVE_SECONDS = 5000;
	private String name;
	private SynchronizedBlockClass obj;

	public SynchronizedBlockExample(String name, SynchronizedBlockClass obj) {
		this.name = name;
		this.obj = obj;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; ++i) {
			System.err.printf("%s add %d%n", name, i);
			obj.add(i);
		}
	}

	public static class SynchronizedBlockClass {
		private List<Integer> integerList = new ArrayList<>();

		public void add(Integer integer) {
			synchronized (integerList) {
				integerList.add(integer);
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		SynchronizedBlockClass obj = new SynchronizedBlockClass();
		Thread thread_0 = new Thread(new SynchronizedBlockExample("thread_0", obj));
		Thread thread_1 = new Thread(new SynchronizedBlockExample("thread_1", obj));
		thread_0.setDaemon(true);
		thread_1.setDaemon(true);
		thread_0.start();
		thread_1.start();
		Thread.sleep(FIVE_SECONDS);
		System.err.println("done !!!");
	}
}
