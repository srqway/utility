package idv.hsiehpinghan.threadutility.example;

public class InterruptExample implements Runnable {
	private static final long FIVE_SECONDS = 5000;

	@Override
	public void run() {
		while (true) {
			try {
				System.err.println("InterruptExample sleeping ...");
				Thread.sleep(Long.MAX_VALUE);
			} catch (InterruptedException e) {
				System.err.println("interrupted !!!");
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(new InterruptExample());
		thread.setDaemon(true);
		thread.start();
		Thread.sleep(FIVE_SECONDS);
		thread.interrupt();
		Thread.sleep(FIVE_SECONDS);
		System.err.println("done !!!");
	}
}
