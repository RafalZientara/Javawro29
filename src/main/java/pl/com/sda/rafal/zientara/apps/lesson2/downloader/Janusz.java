package pl.com.sda.rafal.zientara.apps.lesson2.downloader;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Janusz implements DownloadThread.Listener {
    private int processCount;
    private int completedProcesses; //todo AtomicInteger
    private final Map<DownloadThread, Integer> threadsProgress = new HashMap<>();

    public void startWork(int processCount) {
        this.processCount = processCount;
        for (int i = 0; i < processCount; i++) {
            DownloadThread runnable = new DownloadThread(this);
            synchronized (this.threadsProgress) {
                this.threadsProgress.put(runnable, 0);
                Thread thread = new Thread(runnable);
                thread.start();
            }
        }
    }

    @Override
    public void onProgress(int progress, DownloadThread thread) {
        synchronized (this.threadsProgress) {
            this.threadsProgress.put(thread, progress);
            Collection<Integer> values = this.threadsProgress.values();
            Optional<Integer> sum = values.stream()
                    .reduce((acc, v) -> acc + v);
            if (sum.isPresent()) {
                double allProgress = sum.get() / (double) threadsProgress.size();
                System.out.println("Całkowity progres: " + allProgress);
            }
        }
    }

    @Override
    public void onSuccess() {
        completedProcesses++;
        if (isEverythingCompleted()){
            System.out.println("DONE!");
        }
    }

    private boolean isEverythingCompleted() {
        return completedProcesses == processCount;
    }
}
