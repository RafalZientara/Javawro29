package pl.com.sda.rafal.zientara.apps;

import java.util.concurrent.atomic.AtomicInteger;

public class LikeRace {

    public static void main(String[] args) {
        AtomicInteger likes = new AtomicInteger();
        System.out.println(Thread.currentThread().getName());

        for (int i = 0; i < 100000; i++) {
            Runnable runnable = new Liker(likes);
            Thread thread = new Thread(runnable);
            thread.start();
        }
    }


    static class Liker implements Runnable {
        private final AtomicInteger likesReference;

        public Liker(AtomicInteger value) {
            this.likesReference = value;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
            //ile jest?
            synchronized (likesReference) {
                int currentLikes = likesReference.get();
                currentLikes++;//wincyj!
                likesReference.set(currentLikes);//zapisz
                System.out.println(likesReference.get());
            }
        }
    }

}
