import java.util.ArrayList;

public class LoopyNumbers {

    public static int firstNum;
    public static int count = 0;
    public static int terminate = 0;
    public static ArrayList<Integer> loopyNumbers = new ArrayList<Integer>();
    public static ArrayList<Integer> checking = new ArrayList<Integer>();

    int[] primes = [2, 3, 5, 7 ,11, 13, 17];

    public static void main(String[] args) {

        for (int i = 2; i < 300; i++) {
            firstNum = i;
            checkSum(firstNum);
            checking.clear();
        }
        System.out.println(loopyNumbers.toString());
    }

    public static void primeFactors

    public static void checkSum(int n) {
        int sum = 0;

        if (terminate++ > 28 || n == 1) {
            terminate = 0;
            return;
        }

        checking.add(n);

        for (int j = 1; j < Math.sqrt(n); j++) {
            if (n % j == 0) {
                sum += j;
                sum += n / j;
                System.out.println(j);
                System.out.println(Math.sqrt(n));
            }
        }

        if (sum == n || sum < firstNum) {
            return;
        }

        if (sum == firstNum) {
            //System.out.println(firstNum);
            loopyNumbers.addAll(checking);


        } else {
            checkSum(sum);
        }

    }
}