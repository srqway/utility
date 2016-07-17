package idv.hsiehpinghan.threadutility.example;

public class TwoPhaseTerminationExample extends Thread {
	private static final long ONE_SECOND = 1000;
	private volatile boolean isTerminated = false;

	public void terminate() {
		isTerminated = true;
		interrupt();
	}

	public boolean isTerminated() {
		return isTerminated;
	}

	@Override
	public void run() {
		try {
			while (isTerminated != true) {
				Thread.sleep(ONE_SECOND);
				System.err.println("TwoPhaseTerminationExample.");
			}
		} catch (InterruptedException e) {
			System.err.println("catch InterruptedException !!!");
		} finally {
			close();
		}
	}

	private void close() {
		System.err.println("close.");
	}

	public static void main(String[] args) throws InterruptedException {
		TwoPhaseTerminationExample thread = new TwoPhaseTerminationExample();
		thread.setDaemon(true);
		thread.start();
		for (int i = 0; i < 5; ++i) {
			System.err.println("main");
			Thread.sleep(ONE_SECOND);
		}
		thread.terminate();
		for (int i = 0; i < 5; ++i) {
			System.err.println("main");
			Thread.sleep(ONE_SECOND);
		}
		System.err.println("done !!!");
	}
}
