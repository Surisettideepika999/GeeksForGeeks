//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        while (t-- > 0) {
            // First array input
            String input = scanner.nextLine();
            String[] inputArray1 = input.split(" ");
            int[] arr1 = new int[inputArray1.length];
            for (int i = 0; i < inputArray1.length; i++) {
                arr1[i] = Integer.parseInt(inputArray1[i]);
            }

            // Second array input
            input = scanner.nextLine();
            String[] inputArray2 = input.split(" ");
            int[] arr2 = new int[inputArray2.length];
            for (int i = 0; i < inputArray2.length; i++) {
                arr2[i] = Integer.parseInt(inputArray2[i]);
            }

            // k input
            int k = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            Solution solution = new Solution();
            int result = solution.findKthMissing(arr1, arr2, k);
            System.out.println(result);
        }

        scanner.close();
    }
}

// } Driver Code Ends


class Solution {
    public int findKthMissing(int[] arr1, int[] arr2, int k) {
        // code her
       HashSet<Integer>set = new HashSet<>();
        for(Integer n : arr2){
            set.add(n);
            
        }
        for(int i=0; i<arr1.length; i++){
            if(!set.contains(arr1[i])){
                k--;
                if(k==0) return arr1[i];
            }
        }
        return -1;
    }
}
