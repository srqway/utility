package idv.hsiehpinghan.threadutility.Example;

public class SynchronizedBlockExample implements Runnable {
	private static final long ONE_SECOND = 1000;
	private static final long TEN_SECOND = 10000;
	private String name;
	private SynchronizedBlockClass obj;

	public SynchronizedBlockExample(String name, SynchronizedBlockClass obj) {
		this.name = name;
		this.obj = obj;
	}

	@Override
	public void run() {
		obj.print(name);
	}

	public static class SynchronizedBlockClass {
		public void print(String name) {
			synchronized (this) {
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
	}

	public static void main(String[] args) throws InterruptedException {
		SynchronizedBlockClass obj = new SynchronizedBlockClass();
		Thread thread_0 = new Thread(new SynchronizedBlockExample("thread_0", obj));
		Thread thread_1 = new Thread(new SynchronizedBlockExample("thread_1", obj));
		thread_0.setDaemon(true);
		thread_1.setDaemon(true);
		thread_0.start();
		thread_1.start();
		Thread.sleep(TEN_SECOND);
		System.err.println("done !!!");
	}
}
