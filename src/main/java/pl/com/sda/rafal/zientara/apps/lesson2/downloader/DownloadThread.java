package pl.com.sda.rafal.zientara.apps.lesson2.downloader;

public class DownloadThread implements Runnable {

    private final Listener listener;

    public DownloadThread(Listener listener) {
        this.listener = listener;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        for (int i = 0; i <= 100; i+=10){
            System.out.println(name + " " + i);
            this.listener.onProgress(i, this);
            pretendToWork();
        }
        System.out.println(name + " COMPLETED!");
        this.listener.onSuccess();
    }

    private void pretendToWork() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public interface Listener {
        void onProgress(int progress, DownloadThread thread);
        void onSuccess();
    }
}
