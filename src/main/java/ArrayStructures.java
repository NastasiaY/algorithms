/**
 * Created by Anastasia on 05/01/16.
 */
public class ArrayStructures {

    private int[] array = new int[50];
    private int arraySize = 10;

    private void generateRandomArray() {
        for (int i = 0; i < arraySize; i++) {
            array[i] = (int) (Math.random() * 10) + 1;
        }
    }

    private void printArray() {
        StringBuilder header = new StringBuilder();
        StringBuilder sbArray = new StringBuilder();
        StringBuilder bottomBorder = new StringBuilder();
        for (int i = 0; i < arraySize; i++) {
            header.append("-----");
            sbArray.append("| " + array[i] + " |");
            bottomBorder.append("-----");
        }
        System.out.println(header);
        System.out.println(sbArray);
        System.out.println(bottomBorder);
    }

    private int getValueAtIndex(int index) {
        if (index < arraySize) return array[index];
        return -1;
    }

    private boolean doesArrayContainsValue(int value) {
        boolean valueInArray = false;
        for (int i = 0; i < arraySize; i++) {
            if (array[i] == value) {
                valueInArray = true;
            }
        }
        return valueInArray;
    }

    private void deleteIndex(int index) {
        if (arraySize > index) {
            for (int i = index; i < arraySize - 1; i++) {
                array[i] = array[i+1];
            }
            arraySize--;

        }
    }

    private void insertValue(int value) {
        if (arraySize < 50){
            array[arraySize] = value;
            arraySize++;
        }
    }

    private boolean linearSearchForValue(int value){ //метод нарушает SRP - возвращает boolean, и выводит индексы на консоль
        boolean valueInArray = false;
        String indexesInArray = "";
        System.out.println("The value was found in follows: " );
        for (int i = 0; i < arraySize; i++) {
            if (array[i] == value) {
                valueInArray = true;
                System.out.print(i + " ");
                indexesInArray += i + " ";
            }
        }

        if(!valueInArray) {
            indexesInArray = "None";
            System.out.println(indexesInArray);
        }
        System.out.println();
        return  valueInArray;
    }

    public static void main(String[] args) {
        ArrayStructures newArray = new ArrayStructures();
        newArray.generateRandomArray();
        newArray.printArray();
        System.out.println("Value at index, result for 0: " + newArray.getValueAtIndex(0));
        System.out.println("Does array contains this value, result for 1: " + newArray.doesArrayContainsValue(1));
        newArray.deleteIndex(0);
        System.out.println("Result of deleteIndex method:");
        newArray.printArray();
        newArray.insertValue(100);
        System.out.println("Result of insertValue method:");
        newArray.printArray();
        System.out.println("Result of linearSearch method for value 1:");
        newArray.linearSearchForValue(1);
    }
}
