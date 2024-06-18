//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.util.HashMap;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) 
                a[i] = sc.nextInt();
            Solution g = new Solution();
            
            ArrayList<Integer> ans = g.countDistinct(a, n, k);

            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
            t--;
        }
    }
}
// } Driver Code Ends


class Solution
{
    ArrayList<Integer> countDistinct(int arr[], int n, int k)
    {
        // code here 
        ArrayList<Integer> a=new ArrayList<>();
       HashMap<Integer,Integer> h=new HashMap<>();
       for(int i=0;i<k;i++){
           h.put(arr[i],h.getOrDefault(arr[i],0)+1);
       }
       a.add(h.size());
       for(int i=k;i<n;i++){
          h.put(arr[i],h.getOrDefault(arr[i],0)+1);
          h.put(arr[i-k],h.get(arr[i-k])-1);
          if(h.get(arr[i-k])==0)
          h.remove(arr[i-k]);
          a.add(h.size());
        }
        return a;
    }
}

