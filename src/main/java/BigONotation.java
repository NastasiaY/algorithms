
public class BigONotation {

    private int[] array;
    private int arraySize;
    private int itemsInArray = 0;
    private long startTime;
    private long endTime;

    public BigONotation(int arraySize) {
        this.arraySize = arraySize;
        array = new int[arraySize];
    }

    private void generateRandomNumbers() {
        for (int i = 0; i < arraySize; i++) {
            array[i] = (int) (Math.random() * 1000 ) + 10;
        }
        itemsInArray = arraySize - 1;
    }

    private void addIntToEndOfArray(int item) { // 0(1), in case of adding to the end without extending the array
        array[itemsInArray++] = item;
    }

    private int linearSearchForValue(int value) { // O(n) in worth case
        int index = -1;
        for (int i = 0; i < arraySize; i++) {
            if(array[i] == value) index = i;
        }
        return index;
    }

    public static void main(String[] args) {
        BigONotation testArray1 = new BigONotation(1000000);
        testArray1.generateRandomNumbers();
        testArray1.addIntToEndOfArray(1);

        testArray1.startTime = System.currentTimeMillis();
        testArray1.linearSearchForValue(1);
        testArray1.endTime = System.currentTimeMillis();

        System.out.println("Time in ms in case of 1m values: " + (testArray1.endTime - testArray1.startTime));

        BigONotation testArray2 = new BigONotation(100000000);
        testArray2.generateRandomNumbers();
        testArray2.addIntToEndOfArray(1);

        testArray2.startTime = System.currentTimeMillis();
        testArray2.linearSearchForValue(1);
        testArray2.endTime = System.currentTimeMillis();

        System.out.println("Time in ms in case of 100m values: " + (testArray2.endTime - testArray2.startTime));
    }

}
