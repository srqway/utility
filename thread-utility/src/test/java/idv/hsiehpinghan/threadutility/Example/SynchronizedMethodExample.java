package idv.hsiehpinghan.threadutility.Example;

public class SynchronizedMethodExample implements Runnable {
	private static final long ONE_SECOND = 1000;
	private static final long TEN_SECOND = 10000;
	private String name;
	private SynchronizedMethodClass obj;

	public SynchronizedMethodExample(String name, SynchronizedMethodClass obj) {
		this.name = name;
		this.obj = obj;
	}

	@Override
	public void run() {
		obj.print(name);
	}

	public static class SynchronizedMethodClass {
		public synchronized void print(String name) {
			for (int i = 0; i < 5; ++i) {
				try {
					System.err.println(name);
					Thread.sleep(ONE_SECOND);
				} catch (InterruptedException e) {
					System.err.println("interrupted !!!");
				}
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		SynchronizedMethodClass obj = new SynchronizedMethodClass();
		Thread thread_0 = new Thread(new SynchronizedMethodExample("thread_0", obj));
		Thread thread_1 = new Thread(new SynchronizedMethodExample("thread_1", obj));
		thread_0.setDaemon(true);
		thread_1.setDaemon(true);
		thread_0.start();
		thread_1.start();
		Thread.sleep(TEN_SECOND);
		System.err.println("done !!!");
	}
}
