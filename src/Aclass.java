public class Aclass extends Thread{
    protected long time_to_sleep;
    protected progState count;

    public Aclass(progState count, long time_to_sleep) {
        this.count = count;
        this.time_to_sleep = time_to_sleep;
    }

    public void run() {
        count.incA();
        System.out.println("Class A " + getName() + " is INCrementing");
        System.out.println("Class A " + getName() + "  Preparing to sleep for " + time_to_sleep + " milliseconds");
        try {
            Thread.sleep(time_to_sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Class A " + getName() + " is now AWAKE");
        count.decA();
        System.out.println("Class A " + getName() + " is DECrementing");
        System.out.println("Class A " + getName() + " EXITING!!!");
    }
}
