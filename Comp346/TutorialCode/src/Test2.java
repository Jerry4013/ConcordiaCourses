public class Test2 {
    public static void main(String[] args) {
        Thread tr1 = new Thread(new ThreadEx2("alpha"));
        Thread tr2 = new Thread(new ThreadEx2("beta"));
        tr1.start();
        tr2.start();

        try{
            System.out.println("lsdkjfaosijf");
            tr1.join();
            System.out.println("lsakdjfasif");
            tr2.join();
        } catch (InterruptedException e) {
            System.out.println("main finished");
        }
    }
}
