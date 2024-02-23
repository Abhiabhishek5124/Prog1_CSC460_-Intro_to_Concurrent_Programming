class progState {
    protected int totalObjects;
    protected int Acount;
    protected int Bcount;
    protected int Ccount;
    protected int Dcount;

    public progState() {
        totalObjects = 0;
        Acount = 0;
        Bcount = 0;
        Ccount = 0;
        Dcount = 0;
    }

    public synchronized void incA() {
        Acount++;
        totalObjects++;
    }

    public synchronized void decA() {
        Acount--;
        totalObjects--;
    }

    public synchronized void incB() {
        Bcount++;
        totalObjects++;
    }

    public synchronized void decB() {
        Bcount--;
        totalObjects--;
    }

    public synchronized void incC() {
        Ccount++;
        totalObjects++;
    }

    public synchronized void decC() {
        Ccount--;
        totalObjects--;
    }

    public synchronized void incD() {
        Dcount++;
        totalObjects++;
    }

    public synchronized void decD() {
        Dcount--;
        totalObjects--;
    }

    public synchronized void printTotal() {
        int total = Acount + Bcount + Ccount + Dcount;
        synchronized (System.out) {

            System.out.println("Total is " + total);
            System.out.println("***************");
            System.out.println();
            System.out.println(Acount + " classA objects");
            System.out.println(Bcount + " classB objects");
            System.out.println(Ccount + " classC objects");
            System.out.println(Dcount + " classD objects");
            System.out.flush();
        }
    }
}
