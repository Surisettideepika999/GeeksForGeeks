//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                out.print(ans.get(i)+" ");
            }
            out.println();
                        
        }
        out.close();
	}
}


// } Driver Code Ends


class Solution {
    public void swap(char[] c,int l,int r){
        char t=c[l];
        c[l]=c[r];
        c[r]=t;
    }
    public void permut(char[] c,HashSet<String> a,int l,int r){
        if(l==r){
            a.add(new String(c));
            // System.out.println(c.toString());
        }
        for(int i=l;i<r;i++){
            swap(c,l,i);
            permut(c,a,l+1,r);
            swap(c,l,i);
        }
    }
    public List<String> find_permutation(String S) {
        // Code here
        HashSet<String> l=new HashSet<>();
        List<String> a=new ArrayList<>();
        permut(S.toCharArray(),l,0,S.length());
        for(String x:l){
            a.add(x);
        }
        Collections.sort(a);
        return a;
    }
}