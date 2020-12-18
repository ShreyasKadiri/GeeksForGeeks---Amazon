class ProducerConsumer{
    private static List<Integer> numbers = new ArrayList<Integer>();
    private static int UPPER_LIMIT = 10;
    private static int LOWER_LIMIT = 0;
    private static final Object lock = new Object();
    private int value =0;
    
    public static void produce() throws InterruptedException{
        synchronized(lock){
            while (true){
                if(numbers.size()==UPPER_LIMIT){
                    System.out.println("Waiting to remove elements");
                    lock.wait();
                }else{
                    System.out.println("Adding value" + value);
                    numbers.add(value);
                    value+=1;
                    lock.notify();
                }
                Thread.sleep(1000);
            } 
        }
    }
    
    public static void consume() throws InterruptedException{
        synchronized(lock){
            while(true){
                if(numbers.size()==LOWER_LIMIT){
                    System.out.println("Waiting to add elements");
                    value = 0;
                    lock.wait();
                }
                else {
                    System.out.println("Element removed" + numbers.remove(numbers.size()-1));
                    lock.notify();
                }
                Thread.sleep(1000);
            }
        }
        
    }
}


public class Solution{
    public static void main (String args[]){
   ProducerConsumer producerConsumer = new ProducerConsumer();
    Thread t1 = new Thread(new Runnable(){
        @Override
        public void run(){
            try{
                producerConsumer.produce();
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    });
    
    
    Thread t2 = new Thread(new Runnable(){
        @Override
        public void run(){
            try{
                producerConsumer.consume();
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    });
        t1.start();
        t2.start();
    }
}
