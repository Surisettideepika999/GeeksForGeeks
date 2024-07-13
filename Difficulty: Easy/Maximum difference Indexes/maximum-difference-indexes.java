//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GfG{
	public static void main(String[] args) throws IOException{
		BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
			int n = Integer.parseInt(br.readLine().trim());
			int a[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                a[i] = Integer.parseInt(inputLine[i]);
			
			Solution ob = new Solution();
			System.out.println(ob.maxDiffIndex(a, n));
		}
	}
	
}
// } Driver Code Ends




class Solution
{
	public int maxDiffIndex(int A[], int N)
	{
	    HashMap<Integer,Integer> h1=new HashMap<>();
	    HashMap<Integer,Integer> h2=new HashMap<>();
	    for(int i=0;i<N;i++){
	        if(!h1.containsKey(A[i])){
	        h1.put(A[i],i);
	        h2.put(A[i],i);
	        }
	        else
	        h2.put(A[i],i);
	    }
	    int max=0;
	    for(Integer i:h1.keySet()){
	        max=Math.max(max,Math.abs(h1.get(i)-h2.get(i)));
	    }
	    return max;
	}
}