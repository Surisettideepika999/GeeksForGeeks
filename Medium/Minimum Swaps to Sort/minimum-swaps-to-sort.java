//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minSwaps(nums);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends




class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        // Code here
        HashMap<Integer,Integer> h=new HashMap<>();
        int[] a=new int[nums.length];
        int c=0;
        for(int i=0;i<nums.length;i++)
        a[i]=nums[i];
        Arrays.sort(a);
        for(int i=0;i<nums.length;i++){
            h.put(a[i],i);
        }
        int i=0;
       while(i<nums.length){
           if(i!=h.get(nums[i])){
               int b=h.get(nums[i]);
               int t=nums[i];
               nums[i]=nums[b];
               nums[b]=t;
               c++;
           }
           else
           i++;
       }
       return c;
    }
}