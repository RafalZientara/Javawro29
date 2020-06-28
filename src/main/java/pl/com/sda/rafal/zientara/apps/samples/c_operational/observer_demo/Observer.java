package pl.com.sda.rafal.zientara.apps.samples.c_operational.observer_demo;

abstract class Observer {
    Subject subject;
    public abstract void update();
}
