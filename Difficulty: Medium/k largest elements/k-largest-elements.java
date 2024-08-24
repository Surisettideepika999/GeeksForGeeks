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
    void quickSort(int[] arr,int l,int r,int k,ArrayList<Integer> a){
         if(l==r && l>=arr.length-k){
                a.add(arr[l]);
                if(a.size()==k)
                return;
            }
        if(l<r){
            int t=partition(arr,l,r);
            if(t>=arr.length-k){
                a.add(arr[t]);
                if(a.size()==k)
                return;
            }
            quickSort(arr,l,t-1,k,a);
            quickSort(arr,t+1,r,k,a);
        }
    }
    int partition(int[] arr,int l,int u){
        int p=l;
        int i=l,j=u;
        while(i<j){
        while(arr[i]<=arr[l] && i<u){
            i++;
        }
        while(arr[j]>=arr[l] && j>l){
            j--;
        }
        if(i<j){
            int t=arr[i];
            arr[i]=arr[j];
            arr[j]=t;
        }
        }
        int t=arr[l];
        arr[l]=arr[j];
        arr[j]=t;
        return j;
    }
    int[] kLargest(int[] arr, int n, int k) {
        // code here
        ArrayList<Integer> a=new ArrayList<>();
        quickSort(arr,0,n-1,k,a);
          Collections.sort(a,Collections.reverseOrder());
         int[] ar=new int[a.size()];
        for(int i=0;i<a.size();i++){
            ar[i]=a.get(i);
        }
        return ar;
    }
}