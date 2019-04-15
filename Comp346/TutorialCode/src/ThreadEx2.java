public class ThreadEx2 implements Runnable {
    private String name;

    public ThreadEx2(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            System.out.println("I am " + name);
        }
    }
}
