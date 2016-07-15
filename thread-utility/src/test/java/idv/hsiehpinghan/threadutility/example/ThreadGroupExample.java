package idv.hsiehpinghan.threadutility.example;

public class ThreadGroupExample implements Runnable {
	private static final long ONE_SECOND = 1000;
	private static final long FIVE_SECONDS = 5000;
	private static final String THREAD_0_1 = "thread_0_1";
	private String name;

	public ThreadGroupExample(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		int i = 0;
		while (true) {
			try {
				if (THREAD_0_1.equals(name) && i == 3) {
					throw new RuntimeException(name + " uncaughtException test !!!");
				}
				System.err.println(name);
				Thread.sleep(ONE_SECOND);
				++i;
			} catch (InterruptedException e) {
				System.err.println(name + " interrupted !!!");
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ThreadGroup threadGroup_0 = new ThreadGroup("threadGroup_0") {
			public void uncaughtException(Thread t, Throwable e) {
				System.err.println(t.getName() + " uncaughtException:" + e.getMessage());
			}
		};
		Thread thread_0_0 = new Thread(threadGroup_0, new ThreadGroupExample("thread_0_0"));
		Thread thread_0_1 = new Thread(threadGroup_0, new ThreadGroupExample(THREAD_0_1));
		ThreadGroup threadGroup_1 = new ThreadGroup("threadGroup_1");
		Thread thread_1_0 = new Thread(threadGroup_1, new ThreadGroupExample("thread_1_0"));
		Thread thread_1_1 = new Thread(threadGroup_1, new ThreadGroupExample("thread_1_1"));

		thread_0_0.setDaemon(true);
		thread_0_1.setDaemon(true);
		thread_1_0.setDaemon(true);
		thread_1_1.setDaemon(true);

		thread_0_0.start();
		thread_0_1.start();
		thread_1_0.start();
		thread_1_1.start();

		Thread.sleep(FIVE_SECONDS);
		threadGroup_1.interrupt();
		System.err.println("done !!!");
	}
}
