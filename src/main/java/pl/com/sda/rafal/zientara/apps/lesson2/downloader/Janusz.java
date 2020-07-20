package pl.com.sda.rafal.zientara.apps.lesson2.downloader;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class Janusz implements DownloadThread.Listener {
    private int processCount;
    private AtomicInteger completedProcesses = new AtomicInteger();
    private final Map<Long, Integer> threadsProgress = new HashMap<>();

    public void startWork(int processCount) {
        this.processCount = processCount;

        for (int i = 0; i < processCount; i++) {
            DownloadThread runnable = new DownloadThread(this);
            synchronized (threadsProgress) {
                threadsProgress.put(runnable.getId(), 0);
            }
            Thread thread = new Thread(runnable);
            thread.start();
        }
    }

    @Override
    public void onProgress(int progress, long threadId) {
        synchronized (threadsProgress) {
            threadsProgress.put(threadId, progress);
            Collection<Integer> values = threadsProgress.values();
            Optional<Integer> sum = values.stream()
                    .reduce(Integer::sum);
            if (sum.isPresent()) {
                double allProgress = sum.get() / (double) threadsProgress.size();
                System.out.printf("Calkowity progress %.2f\n", allProgress);

//            double a = 1/2;//0
//            double b = 1/2f;//0.5
            }

            //nastepny sposob
            /*if (!values.isEmpty()) {
                int sum2 = 0;
                for (Integer integer : values) {
                    sum2 += integer;
                }
                int output = sum2 / values.size();
            }*/
        }
    }

    @Override
    public void onSuccess() {
        completedProcesses.addAndGet(1);
        if (isEverythingCompleted()) {
            System.out.println("Skonczylem!");
        }
    }

    private boolean isEverythingCompleted() {
        return completedProcesses.get() == processCount;
    }
}
