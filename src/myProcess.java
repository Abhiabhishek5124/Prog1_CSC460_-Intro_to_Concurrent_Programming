import java.util.concurrent.Semaphore;
import java.util.Random;

class myProcess extends Thread {
    protected long time_to_sleep;
    protected static Semaphore mutex = new Semaphore(1);
    protected myCounter counter;

    public myProcess(myCounter counter, long time_to_sleep) {
        this.counter = counter;
        this.time_to_sleep = time_to_sleep;
    }

    public void run() {
        System.out.println("Process " + Thread.currentThread().getName() + " is starting.");
        try {
            Thread.sleep(time_to_sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Random rand = new Random();
        int randomNumber = rand.nextInt(401) - 200;
        System.out.println("Process " + Thread.currentThread().getName() + " has value of " + randomNumber);

        try {
            mutex.acquire();
            System.out.println("Process " + Thread.currentThread().getName() + " is obtaining Mutual Exclusion");
            int currentTotal = counter.getTotal();
            currentTotal += randomNumber;
            counter.setTotal(currentTotal);
            System.out.println("Process " + Thread.currentThread().getName() + " is releasing Mutual Exclusion");
            mutex.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Process " + Thread.currentThread().getName() + " COMPLETE");
    }
}
