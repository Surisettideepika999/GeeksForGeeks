//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s, patt;
            s = sc.next();
            patt = sc.next();
            
            Solution ob = new Solution();
            
            ArrayList<Integer> res = ob.search(patt, s);
            if(res.size()==0)
                System.out.print(-1);
            else {
                for(int i = 0;i<res.size();i++)
                    System.out.print(res.get(i) + " ");
            }
            System.out.println();    
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    void computeLPS(int[] lps,String p,int m){
        int i=1,j=0;
        while(i<m){
            if(p.charAt(i)==p.charAt(j)){
                j++;
                lps[i]=j;
                i++;
            }
            else{
                if(j==0){
                    lps[i]=0;i++;
                }
                else
                j=lps[j-1];
            }
        }
    }
    ArrayList<Integer> search(String pat, String txt)
    {
        // your code here
        int n=txt.length(),m=pat.length();
        int[] lps=new int[pat.length()];
        computeLPS(lps,pat,m);
        int i=0,j=0;
        ArrayList<Integer> a=new ArrayList<>();
        while(n-i>=m-j){
            if(txt.charAt(i)==pat.charAt(j)){
                i++;j++;
            }   
            if(j==m){
                a.add(i-m+1);
                j=lps[j-1];
            }
            else if(i<n && txt.charAt(i)!=pat.charAt(j)){
                if(j!=0){
                    j=lps[j-1];
                }
                else
                i++;
            }
        }
        return a;
    }
}