
public class SortAlgorithms {
    private int[] array = new int[10];

    private void initializeRandomArray(){
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100) + 1;
        }
    }

    private void bubbleSort() {
        for (int i = 0; i < array.length-1; i++) {
            for (int j = array.length-1; j > i; j--) {
                if (array[j] < array[j-1])
                    swap(j, j-1);
            }
        }
    }
    
    private void bubbleSortAsInVideo(){
        for (int i = array.length - 1; i > 1; i--) {
            for (int j = 0; j < i; j++) {
                if(array[j] > array[j+1])
                    swap(j, j+1);
            }
        }
    }

    private int binarySearchForValue(int value) {
        int lowIndex = 0;
        int highIndex = array.length-1;
        int result = -1;

        while (lowIndex <= highIndex) {
            int middleIndex = (lowIndex + highIndex) / 2;

            if (array[middleIndex] > value) {
                highIndex = middleIndex - 1;
            } else if (array[middleIndex] < value) {
                lowIndex = middleIndex + 1;
            } else {
                result = middleIndex;
                lowIndex = highIndex+1;
            }
        }
        return result;
    }

    private void selectionSort() {
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i; j < array.length; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }
            swap(i, min);
        }
    }

    private void insertionSort() {
        for (int i = 1; i < array.length; i++) {
            int j = i;
            int toInsert = array[i];

            while ((j > 0) && (array[j-1]) > toInsert) {
                array[j] = array[j-1];
                j--;
            }
            array[j] = toInsert;
        }
    }

    private void swap(int indexOne, int indexTwo) {
        int temp;
        temp = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = temp;
    }

    private void printArray() {
        StringBuilder header = new StringBuilder();
        StringBuilder sbArray = new StringBuilder();
        StringBuilder bottomBorder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            header.append("------");
            sbArray.append("| " + array[i] + " |");
            bottomBorder.append("------");
        }
        System.out.println(header);
        System.out.println(sbArray);
        System.out.println(bottomBorder);
    }

    public static void main(String[] args) {
        SortAlgorithms array = new SortAlgorithms();
        array.initializeRandomArray();
        System.out.println("---New random array---");
        array.printArray();

        array.bubbleSort();
        System.out.println("Result of bubble sort:");
        array.printArray();
        System.out.println();
        array.initializeRandomArray(); // create new random array for new sorting
        System.out.println("---New random array---");
        array.printArray();
        System.out.println("Result of bubble sort, method has been written as in video:");
        array.bubbleSortAsInVideo();
        array.printArray();

        System.out.println("\nResult of binary search for value 99: " + array.binarySearchForValue(99) + "\n");

        array.initializeRandomArray(); //create new random array for new sorting
        System.out.println("---New random array---");
        array.printArray();
        array.selectionSort();
        System.out.println("Result of selection sort: ");
        array.printArray();
        System.out.println("");

        array.initializeRandomArray(); //create new random array for new sorting
        System.out.println("---New random array---");
        array.printArray();
        array.insertionSort();
        System.out.println("Result of inserting sort: ");
        array.printArray();
    }
}
