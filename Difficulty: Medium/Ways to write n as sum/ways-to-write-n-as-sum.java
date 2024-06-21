//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{

  public static void main (String[] args)  {
     Scanner s=new Scanner(System.in);
     int t=s.nextInt();
     while(t-->0){
         int n=s.nextInt();
         Solution obj = new Solution();
         System.out.println(obj.countWays(n));
     }

   }
}

// } Driver Code Ends




class Solution
{
    // function to count ways in which n can be
    // expressed as the sum of two or more integers
    int countWays(int N)
    {
    
         // your code here
      int[] arr=new int[N-1];
      int[] dp=new int[N+1];
      dp[0]=1;
      for(int i=0;i<N-1;i++)
      arr[i]=i+1;
      for(Integer x:arr){
      for(int i=1;i<=N;i++){
              if(i>=x)
              dp[i]=(dp[i]+dp[i-x])%1000000007;
          }
      }
      return dp[N];
    }
}
