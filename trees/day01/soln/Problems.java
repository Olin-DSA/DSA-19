public class Problems {

    public static int leastSum(int[] A) {
        //Count sort the array then build the two numbers up
        //iterating through the frequencies, alternating which number gets the digit
        int[] counts = new int[10];
        int num1 = 0;
        int num2 = 0;

        for (int i = 0; i < A.length; i++) {
            counts[A[i]]++;
        }

        //Distribute digits
        int digit = 0; //10^digit
        int evenOdd = 0; //Which number to add to
        int counter = 0; //Increment digit every two
        //Each number gets one in that digit before upping digit
        for (int i = counts.length - 1; i > 0; i--) {
            while (counts[i] > 0) {
                if ((evenOdd == 0) && counts[i] > 0) {
                    num1 += Math.pow(10, digit) * i;
                    counts[i]--;
                    evenOdd = 1;
                    counter++;

                    if (counter == 2) {
                        counter = 0;
                        digit++;
                    }
                }
                if ((evenOdd == 1) && counts[i] > 0) {
                    num1 += Math.pow(10, digit) * i;
                    ;
                    counts[i]--;
                    evenOdd = 0;
                    counter++;

                    if (counter == 2) {
                        counter = 0;
                        digit++;
                    }
                }
            }
        }

        return num1 + num2;

    }

}
