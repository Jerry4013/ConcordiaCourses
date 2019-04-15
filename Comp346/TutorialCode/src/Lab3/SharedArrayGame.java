package Lab3;

public class SharedArrayGame extends Thread {
    private static final Object obj11 = new Object();
    private static final int NI = 1000000;
    private static int a[] = new int[2*NI];
    private static int index= 0;
    private int tid;
    public SharedArrayGame(int tid){
        this.tid= tid;
    }
    public synchronized void run() {
        for(int i=0; i < NI; i++) {
//            synchronized (obj11) {
                a[index] = tid;
                index = index + 1;
//            }
        }
    }

    public static void main(String[] args) {
        System.out.println("SharedArrayGame starts");
        SharedArrayGame t1 = new SharedArrayGame(1);
        SharedArrayGame t2 = new SharedArrayGame(2);
        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
        } catch(InterruptedException e){}
        System.out.println("SharedArrayGamedone");
        for(int i=0;i<2*NI;i++){
            if(a[i]==1) System.out.println("000");
            else if(a[i]==2) System.out.println("-----");
            else System.out.println("EEEEEEEE");
        }
    }
}

