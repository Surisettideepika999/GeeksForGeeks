//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine()); 
        while(t-->0)
        {
            int n = Integer.parseInt(read.readLine()); 
            int a[] = new int[n];
            
            String line = read.readLine(); // to read multiple integers line
            String[] strs = line.trim().split("\\s+");
            
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(strs[i]);
            }
            
            Compute obj = new Compute();
            System.out.println( obj.findEqualPoint(a, n) );
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java

class Compute 
{
    static int findEqualPoint(int arr[], int n) 
	{
	    // Your code goes here
	    Arrays.sort(arr);
	    int l[]=new int[n];
	    int []r=new int[n];
	    l[0]=0;r[n-1]=0;
	    for(int i=1;i<n;i++){
	        if(arr[i]>arr[i-1])
	        l[i]=l[i-1]+1;
	        else if(arr[i]==arr[i-1])
	        l[i]=l[i-1];
	    }
	    for(int i=n-2;i>=0;i--){
	        if(arr[i]<arr[i+1])
	        r[i]=r[i+1]+1;
	        else if(arr[i]==arr[i+1])
	        r[i]=r[i+1];
	    }
	   // for(Integer x:r)
	   // System.out.print(x+" ");
	    for(int i=0;i<n;i++){
	        if(l[i]==r[i])
	        return i;
	    }
	    return -1;
	}
} 
