/**
 * Created by Anastasia on 06/01/16.
 */
public class TheQueue {
    private  String[] queueArray;
    private int queueSize;
    private  int front, rear, numberOfItems = 0;

    public TheQueue(int size) {
        this.queueSize = size;
        queueArray = new String[size];
    }

    private void insert(String input) {
        if(numberOfItems + 1 <= queueSize) {
            queueArray[rear] = input;
            rear++;
            numberOfItems++;
        } else {
            System.out.println("Sorry, but the queue is full");
        }
    }

    private void remove() {
        if(numberOfItems > 0) {
            front++;
            numberOfItems--;
        } else {
            System.out.println("Sorry, the queue is empty ");
        }
    }

    private void displayTheQueue(){
        StringBuilder sbStack = new StringBuilder();
        for (int i = front; i < rear; i++) {
            sbStack.append("| " + queueArray[i] + " |");
        }
        System.out.println(sbStack);
    }

    private String peek() {
        return queueArray[front];
    }
    public static void main(String[] args) {
        TheQueue queue = new TheQueue(10);
        queue.insert("1");
        System.out.println("Result of peek method: " + queue.peek());
        queue.insert("2");
        queue.insert("3");
        queue.displayTheQueue();

        queue.remove();
        System.out.println("Result after remove method: ");
        queue.displayTheQueue();

        System.out.println("Result of peek method: " + queue.peek());

    }
}
