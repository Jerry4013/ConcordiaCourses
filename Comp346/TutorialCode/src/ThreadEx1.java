class ThreadEx1 extends Thread //implement Runnable
{
    private String name;
    private static final Object obj1=new Object();
    ThreadEx1(String name)
    {
        this.name = name;
    }
    //////synchronized method did not work but other method work
    public void run()
    {
        for (int i = 0; i < 10; i++)
        {
            //            this  did not work
            synchronized (obj1) //only work in this way
            {
                System.out.println("I am " + name);
                //got interrupted here
                System.out.println("I am " + name + name);
            }
        }
    }


    public static void main(String args[])
    {
        Thread tr1=new Thread(new ThreadEx1("A"));
        Thread tr2=new Thread(new ThreadEx1("B"));
        Thread tr3=new Thread(new ThreadEx1("C"));

        tr1.start();
        tr2.start();
        tr3.start();


        try {
            tr1.join();
            tr2.join();
            tr3.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("finish");
    }

}
