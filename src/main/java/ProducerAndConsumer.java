import java.util.LinkedList;

public class ProducerAndConsumer {
    public static void main(String[] args) throws InterruptedException {
        Channel ch = new Channel(3);
        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {

                while (true) {
                    try {
                        ch.produce(1);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });

        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        int res = ch.consumer();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();

    }

    static class Channel {

        private int capacity;
        private LinkedList<Integer> list = new LinkedList<>();

        public Channel(int capacity) {
            this.capacity = capacity;
        }

        public synchronized void produce(int item) throws InterruptedException {
            while (list.size() == capacity) {
                wait();
            }
            this.list.add(item);
            if (this.list.size() == 1) {
                notifyAll();
            }
        }


        public synchronized int consumer() throws InterruptedException {
            int res;
            while (this.list.size() == 0) {
                wait();
            }

            if (this.list.size() == capacity) {
                notifyAll();
            }

            res = this.list.remove();
            return res;
        }

    }
}

