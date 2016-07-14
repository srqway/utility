package idv.hsiehpinghan.threadutility.Example;

public class JoinExample implements Runnable {
	private static final long ONE_SECOND = 1000;

	@Override
	public void run() {
		for (int i = 0; i < 10; ++i) {
			try {
				System.err.println("JoinExample");
				Thread.sleep(ONE_SECOND);
			} catch (InterruptedException e) {
				System.err.println("interrupted !!!");
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(new JoinExample());
		thread.setDaemon(true);
		thread.start();
		for (int i = 0; i < 5; ++i) {
			System.err.println("main");
			Thread.sleep(ONE_SECOND);
		}
		thread.join();
		for (int i = 0; i < 5; ++i) {
			System.err.println("main");
			Thread.sleep(ONE_SECOND);
		}
		System.err.println("done !!!");
	}
}
