package pl.com.sda.rafal.zientara.apps.lesson2.downloader;


public class DownloadThread implements Runnable {

    private final Listener listener;
//    druga wersja
//    private static long currentId = 1;
//    private final long id;

    public DownloadThread(Listener listener) {
        this.listener = listener;
//        druga wersja
//        id = currentId;
//        currentId++;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        for (int i = 1; i <= 10; i++) {
            int progress = i * 10;
            System.out.println(name + " " + progress);
            listener.onProgress(progress, this);
            pretendToWork();
        }
//        System.out.println(name + " koniec!");
//        System.out.printf("%s koniec!\n", name);            //lub tak jeśli chcemy formatować
        listener.onSuccess();
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
