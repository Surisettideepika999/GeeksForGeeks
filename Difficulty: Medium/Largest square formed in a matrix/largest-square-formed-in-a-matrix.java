//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int mat[][] = new int[n][m];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<m;j++)
                {
                    mat[i][j]=sc.nextInt();
                }
            }
            Solution ob = new Solution();
            System.out.println(ob.maxSquare(n, m, mat));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maxSquare(int m, int n, int a[][]){
        // code here
         int[][]dp=new int[m][n];
         int max=0;
        for(int i=0;i<m;i++){
            dp[i][0]=a[i][0];
             max=Math.max(max,dp[i][0]);
        }
        for(int i=0;i<n;i++){
            dp[0][i]=a[0][i];
             max=Math.max(max,dp[0][i]);
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(a[i][j]==1){
                    dp[i][j]=1+Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]));
                    max=Math.max(max,dp[i][j]);
                }
            }
        }
        return max;
    }
}