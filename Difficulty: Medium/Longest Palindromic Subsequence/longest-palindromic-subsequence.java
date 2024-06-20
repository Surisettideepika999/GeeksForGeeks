//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.longestPalinSubseq(s));
                }
                
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int longestPalinSubseq(String S)
    {
        //code here
        StringBuilder sb=new StringBuilder(S);
        String r=sb.reverse().toString();
        int[][] dp=new int[S.length()+1][S.length()+1];
        int n=S.length();
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(r.charAt(j-1)==S.charAt(i-1))
                dp[i][j]=dp[i-1][j-1]+1;
                else
                dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[n][n];
    }
}