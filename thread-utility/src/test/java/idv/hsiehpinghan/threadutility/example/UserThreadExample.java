package idv.hsiehpinghan.threadutility.example;

public class UserThreadExample extends Thread {
	private static final long ONE_SECOND = 1000;
	private static final long FIVE_SECONDS = 5000;

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(ONE_SECOND);
				System.err.println("UserThreadExample.");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		UserThreadExample thread = new UserThreadExample();
		thread.start();
		Thread.sleep(FIVE_SECONDS);
		System.err.println("done !!!");
	}
}
