//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();

        while (t-- > 0) {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];

            for (long i = 0; i < n; i++) arr[(int)i] = sc.nextLong();

            System.out.println(new Solution().inversionCount(arr, (int)n));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // arr[]: Input Array
    // N : Size of the Array arr[]
    // Function to count inversions in the array.
    static long mergeSort(long[] arr,int l,int r){
        long c=0;
        if(l<r){
            int mid=(l+r)/2;
            c+=mergeSort(arr,l,mid);
            c+=mergeSort(arr,mid+1,r);
            c+=merge(arr,l,mid,r);
        }
        return c;
    }
    static long merge(long[] arr,int l,int m,int r){
        ArrayList<Long> a=new ArrayList<>();
        long c=0;
        int i=l,j=m+1;
        while(i<=m && j<=r){
            if(arr[i]>arr[j]){
                a.add(arr[j++]);
                c+=m-i+1;
            }
            else{
                a.add(arr[i++]);
            }
        }
        while(i<=m){
            a.add(arr[i++]);
        }
        while(j<=r){
            a.add(arr[j++]);
        }
        int ind=0;
        for(int k=l;k<=r;k++){
            arr[k]=a.get(ind++);
        }
        return c;
    }
    static long inversionCount(long arr[], int n) {
        // Your Code Here
        long c=0;
        c=mergeSort(arr,0,n-1);
        return c;
    }
}