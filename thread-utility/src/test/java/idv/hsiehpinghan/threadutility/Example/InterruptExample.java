package idv.hsiehpinghan.threadutility.Example;

public class InterruptExample implements Runnable {
	private static final long FIVE_SECONDs = 5000;

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
		Thread.sleep(FIVE_SECONDs);
		thread.interrupt();
		Thread.sleep(FIVE_SECONDs);
		System.err.println("done !!!");
	}
}
