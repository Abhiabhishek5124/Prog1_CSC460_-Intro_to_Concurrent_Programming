class Bclass extends Thread {
    protected long time_to_sleep;
    protected progState count;

    public Bclass(progState count, long time_to_sleep) {
        this.count = count;
        this.time_to_sleep = time_to_sleep;
    }

    public void run() {
        count.incB();
        System.out.println("Class B " + getName() + " is INCrementing");
        System.out.println("Class B " + getName() + "  Preparing to sleep for " + time_to_sleep + " milliseconds");
        try {
            Thread.sleep(time_to_sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Class B " + getName() + " is now AWAKE");
        count.decB();
        System.out.println("Class B " + getName() + " is DECrementing");
        System.out.println("Class B " + getName() + " EXITING!!!");
    }
}