//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            int[] cost = new int[N];
            
            for(int i=0 ; i<N ; i++)
                cost[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.minCostClimbingStairs(cost,N));
        }
    }
}
// } Driver Code Ends


//Back-end complete function Template for Java

class Solution {
    static int minCostClimbingStairs(int[] a , int n) {
        //Write your code here
        int[] dp=new int[n];
       dp[0]=a[0];dp[1]=a[1];
       for(int i=2;i<n;i++){
           dp[i]=a[i]+Math.min(dp[i-1],dp[i-2]);
       }
       return Math.min(dp[n-1],dp[n-2]);
    }
};