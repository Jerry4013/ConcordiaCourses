package Lab3;

public class ThreadEx3 {
    public static void main(String[] args) {
        Table t1 = new Table();
        myThread1 th1 = new myThread1(t1);
        myThread2 th2 = new myThread2(t1);
        th1.start();
        th2.start();
        try{
            th1.join();
            th2.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread finished");
        }
    }
}

class Table{
    public void printTable(int n){
        synchronized (this) {
            System.out.print("My value is: ");
            System.out.println(n);
        }
        try{
            Thread.sleep(10);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
class myThread1 extends Thread{
    Table t;
    myThread1(Table t1){
        this.t = t1;
    }
    public void run(){
        for (int i = 0; i <= 100; i++) {
            t.printTable(i*5);
        }
    }
}

class myThread2 extends Thread{
    Table t;
    myThread2(Table t1){
        this.t = t1;
    }
    public void run(){
        for (int i = 0; i <= 100; i++) {
            t.printTable(i*10);
        }
    }
}