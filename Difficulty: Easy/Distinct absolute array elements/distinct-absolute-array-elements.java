//{ Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().distinctCount(arr, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java




class Solution {
    int distinctCount(int[] arr, int n) {
        // code here
	int l=0,r=n-1,ans=n;
        while(l<r){
            while(l<r && arr[l]==arr[l+1]){
                l++;ans--;
            }
            while(r>l && arr[r]==arr[r-1]){
                r--;ans--;
            }
            if(l<r){
                int sum=arr[l]+arr[r];
            if(sum==0){
                l++;r--;ans--;
            }
            else if(sum>0)
            r--;
            else l++;
        }
        }
        return ans;
    }
}
