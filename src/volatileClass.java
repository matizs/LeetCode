public class volatileClass {
    private int count = 0;
    public void run() throws InterruptedException {
        Thread t1 = new Thread(()-> {
           for(int i = 0 ; i < 100000; i++){
               count++;
           }
        });
        Thread t2 = new Thread(()-> {
            for(int i = 0 ; i < 100000; i++){
                count++;
            }
        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println(count);
    }
    public static void main(String...msg) throws InterruptedException {
        new volatileClass().run();
    }
}
