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
            System.out.println(ob.longestPalindrome(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    String longestPalindrome(String S){
        // code here
        int n=S.length();
        boolean [][]dp=new boolean[n][n];
        for(int i=0;i<n;i++)
        dp[i][i]=true;
        int max=1,start=0;
        for(int i=0;i<n-1;i++)
        if(S.charAt(i)==S.charAt(i+1)){
            dp[i][i+1]=true;
            if(max<2){
            max=2;
            start=i;
            }
        }
        for(int i=3;i<=n;i++){
            for(int j=0;j<=n-i;j++){
                int k=i+j-1;
                if(dp[j+1][k-1]){
                    if(S.charAt(j)==S.charAt(k)){
                        dp[j][k]=true;
                        if(max<i){
                            max=i;
                            start=j;
                        }
                    }
                }
            }
        }
        return S.substring(start,max+start);
    }
}