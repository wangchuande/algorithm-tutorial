public class CircularQueue {

    private String[] items;

    private int capacity;

    private int head;

    private int tail;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        items = new String[capacity];
        head = tail = 0;
    }


    public boolean enqueue(String item) {

        if ((tail + 1) % capacity == head) {
            return false;
        }
        items[tail] = item;
        tail = (tail + 1) % capacity;
        return true;
    }

    public String dequeue() {
        if (tail == head) {
            return null;
        }

        String item = items[head];

        head = (head + 1) % capacity;

        return item;

    }

}

