//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            
            String S = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.findMinInsertions(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int findMinInsertions(String s){
        // code here
         int[][] dp=new int[s.length()][s.length()];
      for(int i=1;i<s.length();i++){
          for(int j=i,l=0;j<s.length();j++,l++){
              if(s.charAt(j)==s.charAt(l))
              dp[l][j]=dp[l+1][j-1];
              else{
                  dp[l][j]=Math.min(dp[l][j-1],dp[l+1][j])+1;
              }
          }
      }
      return (dp[0][s.length()-1]);
    }
}