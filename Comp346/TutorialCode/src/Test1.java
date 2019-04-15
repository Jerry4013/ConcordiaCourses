public class Test1 {
    public static void main(String[] args) {
        ThreadEx1 tr1 = new ThreadEx1("alpha");
        ThreadEx1 tr2 = new ThreadEx1("beta");
        tr1.start();
        tr2.start();
    }
}
