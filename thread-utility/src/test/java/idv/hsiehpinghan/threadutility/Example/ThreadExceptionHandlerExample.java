package idv.hsiehpinghan.threadutility.Example;

public class ThreadExceptionHandlerExample implements Runnable {
	private static final long ONE_SECOND = 1000;
	private static final long FIVE_SECONDS = 5000;
	private String name;

	public ThreadExceptionHandlerExample(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		int i = 0;
		while (true) {
			try {
				if (i == 3) {
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

	public static class ThreadExceptionHandler implements Thread.UncaughtExceptionHandler {
		@Override
		public void uncaughtException(Thread t, Throwable e) {
			System.out.println(t.getName() + " : " + e.getMessage());
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ThreadExceptionHandler threadExceptionHandler = new ThreadExceptionHandlerExample.ThreadExceptionHandler();
		ThreadGroup threadGroup = new ThreadGroup("threadGroup");
		Thread thread_0 = new Thread(threadGroup, new ThreadExceptionHandlerExample("thread_0"));
		thread_0.setUncaughtExceptionHandler(threadExceptionHandler);
		thread_0.setDaemon(true);
		thread_0.start();
		Thread.sleep(FIVE_SECONDS);
		System.err.println("done !!!");
	}

}
