package idv.hsiehpinghan.threadutility.Example;

public class RunnableExample implements Runnable {
	private static final long ONE_SECOND = 1000;
	private static final long FIVE_SECONDs = 5000;

	private boolean active = true;

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
		Thread.sleep(FIVE_SECONDs);
		runnable.setActive(false);
		System.err.println("done !!!");
	}
}
