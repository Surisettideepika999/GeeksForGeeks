//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            String S = sc.next();

            Solution obj = new Solution();

            System.out.println(obj.CountPS(S, N));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int CountPS(String S, int n) {
        // code here
        boolean [][]dp=new boolean[n][n];
        for(int i=0;i<n;i++)
        dp[i][i]=true;
        int count=0;
        for(int i=0;i<n-1;i++)
        if(S.charAt(i)==S.charAt(i+1)){
            dp[i][i+1]=true;
            count++;
        }
        for(int i=3;i<=n;i++){
            for(int j=0;j<=n-i;j++){
                int k=i+j-1;
                if(dp[j+1][k-1]){
                    if(S.charAt(j)==S.charAt(k)){
                        dp[j][k]=true;
                         count++;
                    }
                }
            }
        }
        return  count;
    }
}