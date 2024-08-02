//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            
            if(obj.leftRight(a, n)==true)
            System.out.println(1);
            else
            System.out.println(0);
            
        }
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution {

     // Function to check Left or Right Positioned
    // Array.
    // arr[] is array of n elements
    // visited[] is boolean array of size n
    public static boolean leftRight(int arr[],int n)
    {
        // Your code goes here
        int[] b=new int[n];
        Arrays.fill(b,-1);
        for(int i=0;i<n;i++){
            if(arr[i]>=n)
            return false;
            if(b[arr[i]]==-1)
              b[arr[i]]=arr[i];
             else if(b[n-arr[i]-1]==-1)
             b[n-arr[i]-1]=arr[i];
             else if(b[n-arr[i]-1]!=-1)
             return false;
        }
        return true;
    }
}
