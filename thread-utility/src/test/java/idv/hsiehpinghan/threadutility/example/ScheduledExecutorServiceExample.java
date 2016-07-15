package idv.hsiehpinghan.threadutility.example;

import java.util.Calendar;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceExample implements Runnable {
	private static final long INITIAL_DELAY = 1;
	private static final long PERIOD = 3;
	private static final long THIRTY_SECOND = 30000;

	@Override
	public void run() {
		System.err.printf("execution time %d.%n", Calendar.getInstance().getTimeInMillis());
	}

	public static void main(String[] args) throws InterruptedException {
		ScheduledExecutorService scheduledExecutorService = null;
		ScheduledFuture<?> scheduledFuture = null;
		try {
			Runnable runnable = new ScheduledExecutorServiceExample();
			scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
			scheduledFuture = scheduledExecutorService.scheduleAtFixedRate(runnable, INITIAL_DELAY, PERIOD,
					TimeUnit.SECONDS);
			Thread.sleep(THIRTY_SECOND);
			System.err.printf("done.%n");
		} finally {
			if (scheduledFuture != null) {
				scheduledFuture.cancel(false);
			}
			if (scheduledExecutorService != null) {
				scheduledExecutorService.shutdown();
			}
		}
	}
}
