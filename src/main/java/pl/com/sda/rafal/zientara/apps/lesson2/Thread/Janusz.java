package pl.com.sda.rafal.zientara.apps.lesson2.Thread;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Janusz implements DownloadsThread.Listener {
    int processCount;
    int completedProcesses;//todo atomicInteger
    private Map<DownloadsThread,Integer> threadsProgress= new HashMap<DownloadsThread,Integer>();

    public void startWork(int processCount) {
        this.processCount = processCount;
        for (int i = 0; i < processCount; i++) {
            DownloadsThread runable = new DownloadsThread(this);
            Thread thread = new Thread(runable);
            thread.start();
            threadsProgress.put(runable, 0);
        }
    }

    @Override
    public void onSuccess() {
        completedProcesses++;
        if(processCount==completedProcesses){
            System.out.println("Wszystkie procesy skonczone!!");
        }
    }

    @Override
    public void onProgress(int progress, DownloadsThread thread) {
        threadsProgress.put(thread, progress);
        //todo
        Collection<Integer> values = threadsProgress.values();
        Optional<Integer> sum = values.stream()
                .reduce((acc,x) -> acc+x);
        if(sum.isPresent()){
            double k = sum.get()/(double)threadsProgress.size();
            System.out.println(k);
        }

//
//        int avg=0;
//        int iloscElementow=0;
//        for(Integer e:values){
//            avg+= e;
//            iloscElementow++;
//        }
//        avg/=iloscElementow;
//        System.out.println(avg);

    }
}
