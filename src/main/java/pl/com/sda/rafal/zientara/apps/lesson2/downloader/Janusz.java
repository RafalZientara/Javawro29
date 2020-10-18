package pl.com.sda.rafal.zientara.apps.lesson2.downloader;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Janusz implements DownloadThread.Listener {

    private int processCount;
    private int compleatedProcesses; //todo AtomicInteger
    private final Map<DownloadThread, Integer> threadsProgress = new HashMap<>();

    public void startWork(int processCount) {
        this.processCount = processCount;
        for (int i = 0; i < processCount; i++) {
            DownloadThread runnable = new DownloadThread(this);
            synchronized (threadsProgress) {
                threadsProgress.put(runnable, 0);
            }
            Thread thread = new Thread(runnable);
            thread.start();
        }
    }

    @Override
    public void onProgress(int progress, DownloadThread thread) {
        synchronized (threadsProgress) {
            threadsProgress.put(thread, progress);
            Collection<Integer> values = threadsProgress.values();
            Optional<Integer> sum = values.stream()
                    .reduce((acc, v) -> acc + v);
            if (sum.isPresent()) {
                double allProgress = sum.get() / (double) threadsProgress.size();
                System.out.printf("Całkowity progress %.2f\n", allProgress);
            }
        }
//        drugi sposób
//        if (!values.isEmpty()) {
//            int sum2 = 0;
//            for (Integer integer : values) {
//                sum2 += integer;
//            }
//            int output = sum2 /values.size();
//        }
    }

    @Override
    public void onSuccess() {
        compleatedProcesses++;
        if (isEverythingCompleated()) {
            System.out.println("Skończyłem!");
        }
    }

    private boolean isEverythingCompleated() {
        return compleatedProcesses == processCount;
    }

}
