
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

    private void bubbleSort() { // O(n2) in worth case
        for (int i = array.length - 1; i > 1; i--) {
            for (int j = 0; j < i; j++) {
                if(array[j] > array[j+1])
                    swap(j, j+1);
            }
        }
    }

    private void swap(int indexOne, int indexTwo) {
        int temp = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = temp;
    }

    private int binarySearch(int value) { // O(log n)
        int highIndex = array.length - 1;
        int lowIndex = 0;
        int index = -1;

        while (highIndex >= lowIndex) {
            int middleIndex = (lowIndex + highIndex) / 2;
            if (value > array[middleIndex]) {
                lowIndex = middleIndex + 1;
            } else if (value < array[middleIndex]) {
                highIndex = middleIndex  - 1;
            } else {
                index = middleIndex;
                lowIndex = highIndex + 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        BigONotation testArray1 = new BigONotation(10000);
        testArray1.generateRandomNumbers();
        testArray1.addIntToEndOfArray(1);
//
//        testArray1.startTime = System.currentTimeMillis();
//        testArray1.linearSearchForValue(1);
//        testArray1.endTime = System.currentTimeMillis();
//
//        System.out.println("Time in ms in case of 1m values: " + (testArray1.endTime - testArray1.startTime));

//        BigONotation testArray2 = new BigONotation(100000000);
//        testArray2.generateRandomNumbers();
//        testArray2.addIntToEndOfArray(1);
//
//        testArray2.startTime = System.currentTimeMillis();
//        testArray2.linearSearchForValue(1);
//        testArray2.endTime = System.currentTimeMillis();
//
//        System.out.println("Time in ms in case of 100m values: " + (testArray2.endTime - testArray2.startTime));

        testArray1.startTime = System.currentTimeMillis();
        testArray1.bubbleSort();
        testArray1.endTime = System.currentTimeMillis();

        System.out.println("Bubble Sort: " + (testArray1.endTime - testArray1.startTime) + " millis");

        testArray1.startTime = System.currentTimeMillis();
        testArray1.binarySearch(1);
        testArray1.endTime = System.currentTimeMillis();

        System.out.println("Bubble Sort: " + (testArray1.endTime - testArray1.startTime) + " millis");
    }
}
