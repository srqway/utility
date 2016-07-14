package idv.hsiehpinghan.threadutility.Example;

public class ThreadExample extends Thread {
	private static final long ONE_SECOND = 1000;
	private static final long FIVE_SECONDS = 5000;
	private boolean active = true;

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public void run() {
		while (active) {
			try {
				Thread.sleep(ONE_SECOND);
				System.err.println("ThreadExample.");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ThreadExample thread = new ThreadExample();
		thread.start();
		Thread.sleep(FIVE_SECONDS);
		thread.setActive(false);
		System.err.println("done !!!");
	}
}
