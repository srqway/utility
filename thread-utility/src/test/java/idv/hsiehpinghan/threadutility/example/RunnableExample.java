package idv.hsiehpinghan.threadutility.example;

public class RunnableExample implements Runnable {
	private static final long ONE_SECOND = 1000;
	private static final long FIVE_SECONDS = 5000;
	private volatile boolean active = true;

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public void run() {
		while (active) {
			try {
				Thread.sleep(ONE_SECOND);
				System.err.println("RunnableExample.");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		RunnableExample runnable = new RunnableExample();
		Thread thread = new Thread(runnable);
		thread.start();
		Thread.sleep(FIVE_SECONDS);
		runnable.setActive(false);
		System.err.println("done !!!");
	}
}
