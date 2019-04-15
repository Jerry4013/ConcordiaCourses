public class Driver {

    private static Semaphore s1 = new Semaphore(0);

    private static Semaphore s2 = new Semaphore();

    private static Semaphore s3 = new Semaphore(0);

    private static Semaphore s4 = new Semaphore(0);

    private static Semaphore s14 = new Semaphore(-1);

    private static Semaphore s5 = new Semaphore();

    private static Semaphore s23 = new Semaphore(1);

    private static Semaphore sp2 = new Semaphore(0);

    private static int count = 4;

    public static void main(String[] args) {

        Thread p1 = new P1();
        Thread p2 = new P2();
        Thread p3 = new P3();
        Thread p4 = new P4();
//        Thread p5 = new P5();

        p1.start();
        p2.start();
        p3.start();
        p4.start();
//        p5.start();

        try {
            p1.join();
            p2.join();
            p3.join();
            p4.join();
//            p5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class P1 extends BaseThread{
        public void run(){
            s14.P();
            s14.V();
            phase1();
            sp2.V();
            s1.P();
            phase2();
            s3.V();
        }
    }

    static class P2 extends BaseThread{
        public void run(){
            s23.P();
            phase1();
            s23.V();
            s14.V();
            s4.P();
            phase2();
            s1.V();
        }
    }

    static class P3 extends BaseThread{
        public void run(){
            s23.P();
            phase1();
            s23.V();
            s14.V();
            s3.P();
            phase2();
        }
    }

    static class P4 extends BaseThread{
        public void run(){
            s14.P();
            s14.V();
            phase1();
            sp2.P();
            phase2();
            s4.V();
        }
    }

    static class P5 extends BaseThread{
        public void run(){

        }
    }


}
