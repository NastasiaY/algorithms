
public class Test { //for test from Algorithms on Java book

    public static int lgForPositiveNumbers(int n) { // для двоичных логарфмов, log2(n) = x; 2X = n;
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
        System.out.println(test.lgForPositiveNumbers(0));
    }
}
