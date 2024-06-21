//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.MinSquares(n);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int MinSquares(int N)
    {
        // Code here
         int[] dp=new int[N+1];
      dp[1]=1;
      for(int i=2;i<=N;i++){
          int min=Integer.MAX_VALUE;
          for(int j=1;j*j<=i;j++){
              min=Math.min(min,dp[i-(j*j)]);
          }
          dp[i]=min+1;
      }
      return (dp[N]);
    }
}