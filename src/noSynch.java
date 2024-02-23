class noSynch extends Thread{
    protected static int total=0;
    protected int value;

    public noSynch(int value){
        this.value=value;
    }

    public void run(){
        int local;
        local=total;
        local+=value;
        total=local;
    }
    public static int getTotal(){
        return total;
    }

}

