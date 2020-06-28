package pl.com.sda.rafal.zientara.apps.samples.fly;

public class ConfigInfo {

    public String getConfig(String type) {
        switch (type) {
            case "screen_size":
                //ctrl + alt + M = opakowywanie w metode
                simulateWork(400);
                return "800x600";
            case "is_secured":
                simulateWork(120);
                return "true";
            case "language":
                simulateWork(500);
                return "pl";
        }
        return null;
    }

    private void simulateWork() {
        simulateWork(20);
    }

    private void simulateWork(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
