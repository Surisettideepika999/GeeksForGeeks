//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static void findAllPalin(String s,boolean[][] dp){
        int n=s.length();
        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                if(i==j)
                dp[i][j]=true;
                else if(s.charAt(i)==s.charAt(j)){
                    if(i+1==j){
                        dp[i][j]=true;
                    }
                    else
                    dp[i][j]=dp[i+1][j-1];
                }
                else
                dp[i][j]=false;
            }
        }
    }
    static int minCut(String s,boolean[][] dp){
        int n=s.length();
        int[] p=new int[n];
        for(int i=n-1;i>=0;i--){
            p[i]=Integer.MAX_VALUE;
            if(dp[i][n-1])
            p[i]=0;
            else{
                for(int j=n-2;j>=i;j--){
                    if(dp[i][j])
                    p[i]=Math.min(p[i],1+p[j+1]);
                }
            }
        }
        return p[0];
    } 
    static int palindromicPartition(String str)
    {
        // code here
        int n=str.length();
        boolean[][] dp=new boolean[n][n];
        findAllPalin(str,dp);
        return minCut(str,dp);
    }
}