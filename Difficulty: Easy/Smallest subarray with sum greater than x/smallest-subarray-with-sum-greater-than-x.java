//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(stt.nextToken());
            int m = Integer.parseInt(stt.nextToken());
            // int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.smallestSubWithSum(a, n, m));
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution {

    public static int smallestSubWithSum(int arr[], int n, int x) {
        // Your code goes here 
        int l=0,r=0,s=0,min=Integer.MAX_VALUE;
      while(r<n){
          while(s<=x && r<n){
              s+=arr[r];
              r++;
          }
          if(s>x)
          min=Math.min(min,r-l+1);
          while(s>x && l<n){
              s-=arr[l++];
              min=Math.min(min,r-l+1);
          }
      }
      if(min==Integer.MAX_VALUE)
      min=0;
      return min;
    }
}

