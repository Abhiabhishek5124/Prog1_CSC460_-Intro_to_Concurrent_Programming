class Cclass implements Runnable {
    protected long time_to_sleep;
    protected progState count;

    public Cclass(progState count, long time_to_sleep) {
        this.count = count;
        this.time_to_sleep = time_to_sleep;
    }

    public void run() {
        count.incC();
        System.out.println("Class C " + Thread.currentThread().getName() + " is INCrementing");
        System.out.println("Class C " + Thread.currentThread().getName() + " Preparing to sleep for " + time_to_sleep + " milliseconds");
        try {
            Thread.sleep(time_to_sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Class C " + Thread.currentThread().getName() + " is now AWAKE");
        count.decC();
        System.out.println("Class C " + Thread.currentThread().getName() + " is DECrementing");
        System.out.println("Class C " + Thread.currentThread().getName() + " EXITING!!!");
    }
}