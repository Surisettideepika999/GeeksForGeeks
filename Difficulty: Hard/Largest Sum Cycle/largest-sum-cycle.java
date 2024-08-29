//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.lang.*;
import java.io.*;


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

        Integer nextInt(){
            return Integer.parseInt(next());
        }

        Long nextLong(){
            return Long.parseLong(next());
        }
    }

    public static void main(String[] args) throws IOException
    {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while(t-- > 0){
            int N = sc.nextInt();
            int Edge[] = new int[N];
            for(int i = 0; i < N; i++)
                Edge[i] = sc.nextInt();
            Solution ob = new Solution();
            long ans = ob.largesSumCycle(N, Edge);
            out.println(ans);            
        }
        out.flush();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    long ans=-1;
    public void dfs(int[] edg,boolean[] v,int i,int n,boolean[] p){
        v[i]=true;
        p[i]=true;
        long s=-1;
        if(edg[i]!=-1){
            if(!v[edg[i]]){
            dfs(edg,v,edg[i],n,p);
            }
             else if(p[edg[i]])
           {
                s=i;
               int j=edg[i];
               while(j!=i && edg[j]!=-1){
                   s+=j;
                   j=edg[j];
               }
              ans=Math.max(ans,s);
        }
        }
        p[i]=false;
    }
    public long largesSumCycle(int N, int Edge[]){
        boolean v[]=new boolean[N];
        boolean[] p=new boolean[N];
        for(int i=0;i<N;i++){
            if(!v[i] && Edge[i]!=-1){
                dfs(Edge,v,i,N,p);
            }
        }
        return ans;
    }
}