//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.countWays(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static Long countWays(int N) {
        // code here\\
        int[] a=new int[]{1,3,4};
         long[] dp=new long[N+1];
      dp[0]=1;
      for(int i=1;i<=N;i++){
          for(Integer x:a){
              if(i>=x)
              dp[i]=(dp[i]+dp[i-x])%1000000007;
          }
      }
      return dp[N];
    }
};