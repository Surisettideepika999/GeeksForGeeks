//{ Driver Code Starts
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int k = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int[] ans = new Solution().kLargest(arr, n, k);
            for (int x : ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public void quicksort(int[] arr,int l,int h,int k,ArrayList<Integer> a){
        if(l==h){
            if(l>=arr.length-k)
            a.add(arr[l]);
            if(a.size()==k)
            return;
        }
        if(l<h){
            int p=partition(arr,l,h);
            if(p>=arr.length-k)
            a.add(arr[p]);
            if(a.size()==k)
            return;
            quicksort(arr,l,p-1,k,a);
            quicksort(arr,p+1,h,k,a);
        }
    }
    public int partition(int[] arr,int low,int high){
         int p=arr[low],i=low,j=high;
        while(i<j){
            while(arr[i]<=p && i<=high-1)
            i++;
            while(arr[j]>p && j>=low+1)
            j--;
            if(i<j){
                int t=arr[i];
                arr[i]=arr[j];
                arr[j]=t;
            }
        }
        int t=arr[j];
        arr[j]=arr[low];
        arr[low]=t;
        // System.out.println(arr[j]);
        return j;
    }
    int[] kLargest(int[] arr, int n, int k) {
        // code here
        ArrayList<Integer> a=new ArrayList<>();
        quicksort(arr,0,n-1,k,a);
        int[] ans=new int[a.size()];
        int i=0;
        Collections.sort(a,Collections.reverseOrder());
        for(Integer x:a)
        ans[i++]=x;
        return ans;
    }
}