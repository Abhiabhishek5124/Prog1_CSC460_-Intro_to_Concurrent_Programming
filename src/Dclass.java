class Dclass implements Runnable {
    protected long time_to_sleep;
    protected progState count;

    public Dclass(progState count, long time_to_sleep) {
        this.count = count;
        this.time_to_sleep = time_to_sleep;
    }

    public void run() {
        count.incD();
        System.out.println("Class D " + Thread.currentThread().getName() + " is INCrementing");
        System.out.println("Class D " + Thread.currentThread().getName() + "  Preparing to sleep for " + time_to_sleep + " milliseconds");
        try {
            Thread.sleep(time_to_sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Class D " + Thread.currentThread().getName() + " is now AWAKE");
        count.decD();
        System.out.println("Class D " + Thread.currentThread().getName() + " is DECrementing");
        System.out.println("Class D " + Thread.currentThread().getName() + " EXITING!!!");
    }
}