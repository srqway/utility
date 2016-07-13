package idv.hsiehpinghan.threadutility.Example;

public class YieldExample extends Thread {
	private static final long FIVE_SECONDs = 5000;
	private String name;

	public YieldExample(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		int i = 1;
		while (true) {
			if (i % 10 == 0) {
				System.err.println("yield !!!");
				yield();
			}
			System.err.println(name);
			++i;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		YieldExample yielder = new YieldExample("yielder");
		yielder.setDaemon(true);
		YieldExample yielded = new YieldExample("yielded");
		yielded.setDaemon(true);
		yielder.start();
		yielded.start();
		Thread.sleep(FIVE_SECONDs);
	}
}
