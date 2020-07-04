package pl.com.sda.rafal.zientara.apps.lesson2.Thread;

public class DownloadsThread implements Runnable {
    private final Listener listener;

    public DownloadsThread(Listener listener) {
        this.listener = listener;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        for(int i=10; i<=100; i+=10){
            int progress = i;
            //System.out.print(threadName+ "   ");
            //System.out.println(progress);
            listener.onProgress(progress, this);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Complete");
        listener.onSuccess();
    }
    public interface Listener{
        void onProgress(int progress, DownloadsThread thread);
        void onSuccess();
    }
}

