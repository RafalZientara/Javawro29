package pl.com.sda.rafal.zientara.apps.lesson2.downloader;

import java.util.Random;

public class DownloadThread implements Runnable {

    private static long currentId = 1;
    private final Listener listener;
    private final long id;

    public DownloadThread(Listener listener) {
        this.listener = listener;
        id = currentId;
        currentId++;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        for (int i = 0; i <= 10; i++) {
            int progress = i * 10;
//            System.out.println(name + " " + progress);
            listener.onProgress(progress, id);
            pretendToWork();
        }
//        System.out.println(name + " koniec!");
//        System.out.printf("%s koniec!\n", name);
        listener.onSuccess();
    }

    private void pretendToWork() {
        try {
            Thread.sleep(new Random().nextInt(300));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public long getId() {
        return id;
    }

    public interface Listener {
        void onProgress(int progress, long threadId);

        void onSuccess();
    }

}
