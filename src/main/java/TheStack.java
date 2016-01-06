import java.util.Arrays;

public class TheStack {
    private String[] stackArray;
    private int stackSize;
    private int topOfStack = -1;

    public TheStack(int size) {
        this.stackSize = size;
        stackArray = new String[size];
        Arrays.fill(stackArray, "-1");
    }

    private void push(String input) {
        if ((topOfStack + 1) <= stackSize) {
            topOfStack++;
            stackArray[topOfStack] = input;
        } else {
            System.out.println("Sorry, but the stack is full");
        }
    }

    private void pop(){
        if(topOfStack >= 0) {
            topOfStack--;
        } else {
            System.out.println("Sorry, the stack is empty");
        }
    }

    private String peek() {
        return stackArray[topOfStack];
    }

    private void pushMany(String multipleValues) {
        String[] temp = multipleValues.split("\\, ");

        for (int i = 0; i < temp.length; i++) {
            push(temp[i]);
        }
    }

    private void displayTheStack(){
        StringBuilder sbStack = new StringBuilder();
        for (int i = 0; i < topOfStack + 1; i++) { // topOfStack + 1 is because of initial -1;
            sbStack.append("| " + stackArray[i] + " |");
        }
        System.out.println(sbStack);
    }

    public static void main(String[] args) {
        TheStack stack = new TheStack(10);
        System.out.println("Result of push & pushMany methods:");
        stack.push("Test 1");
        stack.pushMany("Test 2, Test 3, Test 4");
        stack.push("Test 5");
        stack.pushMany("Test 6, Test 7, Test 8");
        stack.displayTheStack();

        System.out.println("\nResult of peek method: " + stack.peek() + "\n");

        stack.pop();
        System.out.println("Stack after pop method: ");
        stack.displayTheStack();
    }
}
