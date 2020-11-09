public class ArrayStack {

    private String[] items;

    private int capacity;

    private int count;


    public ArrayStack(int capacity) {
        this.capacity = capacity;
        items = new String[capacity];
    }


    public boolean push(String item) {
        if (count == capacity) {
            return false;
        }
        items[count] = item;
        count++;
        return true;
    }

    public String pop() {
        if (count == 0) {
            return null;
        }
        String item = items[count-1];
        count--;
        return item;
    }

}
