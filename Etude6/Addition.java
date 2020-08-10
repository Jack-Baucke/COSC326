import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math;

public class Addition {
    private static int remainder;
    private static int[] sum;
    private static int[] quo;

    public static void add_numbers(int[] a, int[] b, int base){
        int c, n, i;
        remainder = 0;
        
        for(i = 1; i <= sum.length; i++){

            //add the two last numbers together with any remainder
            c = a[a.length-i] + b[b.length-i] + remainder;

            //check to see if the numbers overflow
            if(c >= base){
                n = c - base;
                remainder = 1;
            }else{
                n = c;
                remainder = 0;
            }

            //add the number to the final sum
            sum[sum.length - i] = n;
        }

    }

    public static void divide_by_2(int base){
        int[] divide_array = new int[base];
        int[] result = new int[sum.length];
        int n; // number in divide array / digit in sum
        int digit; //digit in sum. usually sum[i] but sometimes not
        String digitStr;

        // creating divide array using base and * 2
        for(int i =0; i<base; i++){
            n = i * 2;
            if(n >= base){
                n = n - base + 10;
            }
            divide_array[i] = n;
        }


        // iterate along each digit
        for (int i = 0; i < sum.length; i++) {
            for (int j = 0; j < divide_array.length; j++) {
                if (sum[i] < divide_array[j]) {
                    if (remainder == 0) {

                        digit = sum[i];

                    } else {

                        digitStr = "1" + Integer.toString(digit);
                        digit = Intger.parseInt(digitStr);
                        
                    }

                    result[i] = j - 1;
                    remainder = sum[i] - divide_array[j];

                }
            }
        }



    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] a, b;
        int aLen, bLen;
        String aStr, bStr;
        int base;

        base = scanner.nextInt();
        scanner.nextLine();
        aStr = scanner.nextLine();
        bStr = scanner.nextLine();
        
        aLen = aStr.length();
        bLen = bStr.length();

        //set length of sum array to the longer number 
        if(aLen > bLen){
            sum = new int[aLen + 1];
        }else if(bLen > aLen){
            sum = new int[bLen + 1];
        }else{
            sum = new int[aLen + 1]; //they are equal, need to think about what will happen with overflow
        }

        a = new int[sum.length];
        b = new int[sum.length];
        
        //make number arrays from strings
        for (int i = 1; i < sum.length; i++) {
            if (i <= aLen){
                a[sum.length - i] = Character.getNumericValue(aStr.charAt(aLen - i));
            }
            if (i <= bLen){
                b[sum.length - i] = Character.getNumericValue(bStr.charAt(bLen - i));
            }
        }
        
        add_numbers(a, b, base);

        //printing out numbers
        System.out.println("Base: " + base); 

        System.out.print("First number: ");
        for (int num : a) {            
            System.out.print(num);
        }
        System.out.print("\nSecond number: ");
        for (int num : b) {
            System.out.print(num);
        }

        System.out.print("\nSum: ");
        if(sum[0] == 0){
            sum = Arrays.copyOfRange(sum, 1, sum.length);
        }
        for (int i = 0; i < sum.length; i++) {
            System.out.print(sum[i]);
        }
        System.out.println();
        divide_by_2(base);
        
    }
}