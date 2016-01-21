/*
 Перестановка элементов массива в обратном порядке
 Инициализация двумерного массива
 Проверка, просто ли число
 Квадратный корень, метод Ньютона
 Гармоничное число
 Рекурсивная реализация бинарного поиска
 Вывод n случайных значений из диапазона
 isPolindrome
 */


public class Test { //for test from Algorithms on Java book
    public int[] array = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    public int max(int[] array){
        int max = array[0];
        for (int i = 0; i <array.length; i++) {
            if (array[i] > max) max = array[i];
        }
        return max;
    }

    public float average(int[] array) {
        int sum = 0;
        float average;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        average = sum / array.length;
        return average;
    }

    public int[] copyToAnotherArray(int[] array) {
        int[] newArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }

    public void arrayReverseOrder(int[] array) {

    }


    public int lgForPositiveNumbers(int n) { // для двоичных логарфмов, log2(n) = x; 2X = n;
        if (n > 0) {
            if (n == 1) return 0;
            if (n == 2) return 1; //if 2 - основание
            int base = 2;
            int count = 1;
            while (base < n) {
                base = base * 2;
                count++;
            }
            return count;
        }
        return -1;
    }

    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.lgForPositiveNumbers(10));
        System.out.println("Average for array: " + test.average(test.array));
        System.out.println("Max for array: " + test.max(test.array));
    }
}
