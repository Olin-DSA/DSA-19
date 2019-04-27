import java.util.LinkedList;

public class Problems {

    static void sortNumsBetween100s(int[] A) {
        for (int i = 0; i < A.length; i++)
            A[i] += 100;
        CountingSort.countingSort(A);
        for (int i = 0; i < A.length; i++)
            A[i] -= 100;
    }

    /**
     * @param n the character number, 0 is the rightmost character
     * @return
     */
    private static int getNthCharacter(String s, int n) {
        return s.charAt(s.length() - 1 - n) - 'a';
    }

    /**
     * Use counting sort to sort the String array according to a character
     *
     * @param n The digit number (where 0 is the least significant digit)
     */
    static void countingSortByCharacter(String[] A, int n) {
        int b = 26;
        LinkedList<String>[] counts = new LinkedList[b];
        for (int i = 0; i < b; i++)
            counts[i] = new LinkedList<>();
        for (String s : A) {
            int nthDigit = getNthCharacter(s, n);
            counts[nthDigit].add(s);
        }
        int m = 0;
        for (LinkedList<String> list : counts)
            while (!list.isEmpty())
                A[m++] = list.removeFirst();
    }

    /**
     * @param stringLength The length of each of the strings in S
     */
    static void sortStrings(String[] S, int stringLength) {
        for (int i = 0; i < stringLength; i++)
            countingSortByCharacter(S, i);
    }





    static int countSwaps(int[] A) {
        return mergeSort(A, 0, A.length - 1);
    }
      
    
    static int mergeSort(int A[], int left, int right) {
      int mid = 0;
      int count = 0;

      if (right > left) {
        
        mid = (right + left)/2;

        count  = mergeSort(A, left, mid);
        count += mergeSort(A, mid+1, right);
        count += merge(A, left, mid+1, right);
      }
      return count;
    }
      
    static int merge(int A[], int left, int mid, int right) {
      int lPoint, rPoint, ind;
      int count = 0;
      int[] temp = new int[A.length];
      
      lPoint = left;
      rPoint = mid;
      ind = left;

      
      while ((lPoint <= mid - 1) && (rPoint <= right)) {
        //Move pointers
        if (A[lPoint] <= A[rPoint]) {
          temp[ind] = A[lPoint];
          lPoint++;
          ind++;
        }
        //Count swaps
        else {
          temp[ind] = A[rPoint];
          rPoint++;
          ind++;
          count = count + mid - lPoint;
        }
      }
      
      //Finish off
      while (lPoint <= mid - 1){
        temp[ind] = A[lPoint];
        lPoint++;
        ind++;
      }
      while (rPoint <= right){
        temp[ind] = A[rPoint];
        rPoint++;
        ind++;
      }
      for (lPoint=left; lPoint <= right; lPoint++){
        A[lPoint] = temp[lPoint];
      }
      return count;
    }

}
