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

    public static void main(String[] args) {

    }
}
