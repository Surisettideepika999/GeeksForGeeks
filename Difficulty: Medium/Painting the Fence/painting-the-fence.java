//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class Solution
{
    long countWays(int n,int k)
    {
        //code here.
        if (n==1) 
        return k;
        if (n==2) 
        return (long)k*k%1000000007;
        long[] dp=new long[n];
        dp[0]=k;dp[1]=(long)k*k%1000000007;
        for(int i=2;i<n;i++){
            dp[i]=((dp[i-1]+dp[i-2])%1000000007*(k-1)%1000000007)%1000000007;
        }
        return dp[n-1]%1000000007;
    }
}




//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main (String[] args) throws IOException{
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while(testcases-- > 0){
            //int n=Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] a2 = line.trim().split("\\s+");
            int n =Integer.parseInt(a2[0]);
            int k =Integer.parseInt(a2[1]);

            Solution ob=new Solution();
            //ArrayList<Long> ans=ob.smallestDifferenceTriplet(a,b,c,n);
            long ans=ob.countWays(n,k);
            System.out.println(ans);
        }
    }
}



// } Driver Code Ends