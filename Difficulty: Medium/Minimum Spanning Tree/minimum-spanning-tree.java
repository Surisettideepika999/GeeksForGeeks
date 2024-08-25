//{ Driver Code Starts


import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            List<List<int[]>> list = new ArrayList<>();
            for (int i = 0; i < V; i++) list.add(new ArrayList<>());
            for (int i = 0; i < E; i++) {
                s = br.readLine().trim().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                int c = Integer.parseInt(s[2]);
                list.get(a).add(new int[] {b, c});
                list.get(b).add(new int[] {a, c});
            }
            ot.println(new Solution().spanningTree(V, E, list));
        }
        ot.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int find(int i,int[] p){
        if(p[i]==i)
        return i;
        p[i]=find(p[i],p);
        return p[i];
    }
    static void union(int x,int y,int[] p){
        int rx=find(x,p);
        int ry=find(y,p);
        p[ry]=p[rx];
    } 
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        int[] p=new int[V];
           for(int i=0;i<V;i++){
            p[i]=i;
        }
       ArrayList<int[]> a=new ArrayList<>();
       for(int i=0;i<V;i++){
           for(int[] ar:adj.get(i)){
               a.add(new int[]{ar[1],i,ar[0]});
           }
       }
       Collections.sort(a,(x,y) -> x[0]-y[0]);
       int sum=0;
       for(int[] arr:a){
           if(find(arr[1],p)!=find(arr[2],p)){
               sum=sum+arr[0];
               union(arr[1],arr[2],p);
           }
       }
       return sum;
    }
}