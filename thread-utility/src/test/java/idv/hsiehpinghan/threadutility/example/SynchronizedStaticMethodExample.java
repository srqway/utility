package idv.hsiehpinghan.threadutility.example;

public class SynchronizedStaticMethodExample implements Runnable {
	private static final long ONE_SECOND = 1000;
	private static final long TEN_SECOND = 10000;
	private String name;

	public SynchronizedStaticMethodExample(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		SynchronizedMethodClass.print(name);
	}

	public static class SynchronizedMethodClass {
		public synchronized static void print(String name) {
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
		Thread thread_0 = new Thread(new SynchronizedStaticMethodExample("thread_0"));
		Thread thread_1 = new Thread(new SynchronizedStaticMethodExample("thread_1"));
		thread_0.setDaemon(true);
		thread_1.setDaemon(true);
		thread_0.start();
		thread_1.start();
		Thread.sleep(TEN_SECOND);
		System.err.println("done !!!");
	}
}
