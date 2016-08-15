package idv.hsiehpinghan.threadutility.example;

public class ThreadLocalExample implements Runnable {
	private static final long ONE_SECONDS = 1000;
	private static final long TEN_SECONDS = 10000;
	private String name;
	private ThreadLocalClass obj;

	public ThreadLocalExample(String name, ThreadLocalClass obj) {
		this.name = name;
		this.obj = obj;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; ++i) {
			obj.append(i);
			System.err.printf("%s append %d.%n", name, i);
			try {
				Thread.sleep(ONE_SECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.err.printf("%s : %s%n", name, obj.toString());
	}

	public static class ThreadLocalClass {
		private static ThreadLocal<StringBuilder> threadLocal = new ThreadLocal<StringBuilder>() {
			@Override
			protected StringBuilder initialValue() {
				return new StringBuilder();
			}
		};

		public void append(int i) {
			getStringBuilder().append(i);
		}

		@Override
		public String toString() {
			return getStringBuilder().toString();
		}

		private StringBuilder getStringBuilder() {
			return threadLocal.get();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ThreadLocalClass obj = new ThreadLocalClass();
		Thread thread_0 = new Thread(new ThreadLocalExample("thread_0", obj));
		Thread thread_1 = new Thread(new ThreadLocalExample("thread_1", obj));
		thread_0.setDaemon(true);
		thread_1.setDaemon(true);
		thread_0.start();
		thread_1.start();
		Thread.sleep(TEN_SECONDS);
		System.err.println("done !!!");
	}
}
