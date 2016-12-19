package cn.lcf.common;

import org.junit.Test;

public class TestNormal {
	@Test
	public void testThead(){
		for (int i = 0; i < 2; i++) {
			final int k = i;
			new Thread(new Runnable() {

				@Override
				public void run() {
					createGroup("I" + k + "I");

				}
			}).start();
		}
	}

	public static void createGroup(final String groupName) {
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				@SuppressWarnings("static-access")
				@Override
				public void run() {
					byte[] lock2 = new byte[0];
					while (true) {
						synchronized (lock2) {
							System.out.println("groupName:" + groupName + " "
									+ Thread.currentThread().getName()
									+ "   get " + groupName);
							try {
								Thread.currentThread().sleep(3000);
							} catch (InterruptedException e) {
							}
						}
					}
				}
			}).start();
		}
	}
}
