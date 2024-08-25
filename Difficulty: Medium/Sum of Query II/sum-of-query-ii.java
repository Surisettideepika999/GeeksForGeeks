//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    static class FastReader{ 
		BufferedReader br; 
		StringTokenizer st; 
  
		public FastReader(){ 
			br = new BufferedReader(new InputStreamReader(System.in)); 
		} 
  
		String next(){ 
			while (st == null || !st.hasMoreElements()){ 
				try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
			} 
			return st.nextToken(); 
		} 
  
		String nextLine(){ 
			String str = ""; 
			try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
			return str; 
		} 
		
		int nextInt(){
		    return Integer.parseInt(next());
		}
	}
	
    public static void main(String args[])throws IOException
    {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int i = 0;i < n;i++)
                arr[i] = sc.nextInt();
            int q = sc.nextInt();
            int queries[] = new int[2*q];
            for(int i = 0;i < 2*q;i++)
                queries[i] = sc.nextInt();
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.querySum(n, arr, q, queries);
            StringBuilder out = new StringBuilder();
            for(int i = 0;i < ans.size();i++)
                out.append(ans.get(i) + " ");
            System.out.println(out);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    void segmentTree(int ind,int i,int j,int[] tree,int[] a){
        if(i==j){
        tree[ind]=a[i];
        return ;
        }
        int mid=(i+j)/2;
        segmentTree(2*ind+1,i,mid,tree,a);
        segmentTree(2*ind+2,mid+1,j,tree,a);
        tree[ind]=tree[2*ind+1]+tree[2*ind+2];
    }
    int find(int l,int r,int i,int j,int ind,int[] tree){
        if(i>r || j<l)
        return 0;
        if(i<=l && r<=j)
        return tree[ind];
        int mid=(l+r)/2;
        int left=find(l,mid,i,j,2*ind+1,tree);
        int right=find(mid+1,r,i,j,2*ind+2,tree);
        return left+right;
        
    }
    List<Integer> querySum(int n, int arr[], int q, int queries[])
    {
        // code here
       int[] tree=new int[4*n];
       segmentTree(0,0,n-1,tree,arr);
       List<Integer> ls=new ArrayList<>();
       for(int i=0;i<queries.length;i=i+2){
           int l=queries[i];
           int r=queries[i+1];
           ls.add(find(0,n-1,l-1,r-1,0,tree));
       }
       return ls;
    }
}