
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
        for (int i = array.length - 1; i < 0; i--) {
            for (int j = 0; j < i; j++) {
                if(array[j] > array[j+1])
                    swap(j, j+1);
            }
        }
    }

    private void swap(int indexOne, int indexTwo) {
        int temp;
        temp = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = temp;
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
        System.out.println("Initial array:");
        array.printArray();

        array.bubbleSort();
        System.out.println("Result of bubble sort:");
        array.printArray();
        System.out.println("Result of bubble sort, method has been written as in video:");
        array.bubbleSortAsInVideo();
        array.printArray();

        System.out.print("Result of binary search for value 99: " + array.binarySearchForValue(99));
    }
}
