package idv.hsiehpinghan.threadutility.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 資料來源：JAVA 我的程式比你的快10倍 從概念到工具的極度優化 
 * 
 * Executors.newFixedThreadPool()：
 * 該方法傳回一個固定執行緒數量的執行緒池，
 * 該執行緒池中的執行緒數量不變。
 * 當有一個新的工作傳送時，
 * 執行緒池中若有空閒執行緒，
 * 則立即執行。
 * 若沒有，
 * 則新的工作會被暫存在一個工作佇列中，
 * 待有執行緒空閒時，
 * 便處理在工作佇列中的工作。
 * 
 * Executors.newSingleThreadExecutor()方法：
 * 該方法傳回一個只有一個執行緒的執行緒池。
 * 若多餘一個工作被傳送到該執行緒池，
 * 工作會被儲存在一個工作佇列中，
 * 待執行緒空閒，
 * 按先入先出的循序執行佇列中的工作。
 * 
 * Executors.newCachedThreadPool()方法：
 * 該方法傳回一個可根據實際情況調整執行緒數量的執行緒池。
 * 執行緒池的執行緒數量不確定，
 * 但若有空閒執行緒可以多工，
 * 則會優先使用可多工的執行緒。
 * 若所有執行緒均在工作，
 * 又有新的工作傳送，
 * 則會建立新的執行緒工作。
 * 所有執行緒在目前工作執行完畢後，
 * 將傳回執行緒池進行多工。
 * 
 * Executors.newSingleThreadScheduledExecutor()方法：
 * 該方法傳回一個ScheduledExecutorService物件，
 * 執行緒池大小為1。
 * ScheduledExecutorService介面在ExecutorService介面上擴充了在指定時間執行某工作的功能，
 * 如在某個固定的延遲時間之後執行，
 * 或週期性執行某個工作。
 * 
 * Executors.newScheduledThreadPool()方法：
 * 該方法也傳回一個ScheduledExecutorService物件，
 * 但該執行緒池可以指定執行緒數量。
 * @author thank
 *
 */
public class ExecutorServiceExample implements Runnable {
	private static final int SIZE = 3;
	private static final long ONE_SECOND = 1000;
	private int id;

	public ExecutorServiceExample(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; ++i) {
			try {
				Thread.sleep(ONE_SECOND);
				System.err.printf("ExecutorServiceExample %d %d.%n", id, i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = null;
		try {
			executorService = Executors.newFixedThreadPool(SIZE);
			for (int i = 0; i < 5; ++i) {
				Runnable runnable = new ExecutorServiceExample(i);
				executorService.submit(runnable);
			}
		} finally {
			if (executorService != null) {
				executorService.shutdown();
			}
		}
	}
}
