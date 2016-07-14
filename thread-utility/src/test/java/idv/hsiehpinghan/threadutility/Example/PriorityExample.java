package idv.hsiehpinghan.threadutility.Example;

public class PriorityExample extends Thread {
	private static final long ONE_SECOND = 1000;
	private static final long FIVE_SECONDS = 5000;

	public PriorityExample(int priority) {
		this.setPriority(priority);
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(ONE_SECOND);
				System.err.println("priority : " + getPriority());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		PriorityExample priority_1 = new PriorityExample(Thread.MIN_PRIORITY);
		priority_1.setDaemon(true);
		priority_1.start();
		Thread.sleep(FIVE_SECONDS);
		PriorityExample priority_5 = new PriorityExample(Thread.NORM_PRIORITY);
		priority_5.setDaemon(true);
		priority_5.start();
		Thread.sleep(FIVE_SECONDS);
		PriorityExample priority_10 = new PriorityExample(Thread.MAX_PRIORITY);
		priority_10.setDaemon(true);
		priority_10.start();
		Thread.sleep(FIVE_SECONDS);
	}
}
