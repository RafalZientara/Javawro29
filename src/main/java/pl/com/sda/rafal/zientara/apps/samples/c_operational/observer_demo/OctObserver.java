package pl.com.sda.rafal.zientara.apps.samples.c_operational.observer_demo;

class OctObserver extends Observer {
    OctObserver(Subject subject) {
        this.subject = subject;
        this.subject.add( this );
    }

    public void update() {
        System.out.print(" " + Integer.toOctalString(subject.getState()));
    }
}
