//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            
            String a = sc.next();
            String b = sc.next();
            Solution ob = new Solution();
            if(ob.isSubSequence(a,b))
            System.out.println(1);
            else
            System.out.println(0);
 		
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution{
     public boolean isSub(String s1,String s2,int m,int n){
        if(m<0)
        return true;
        if(n<0)
        return false;
        if(s1.charAt(m)==s2.charAt(n))
        return isSub(s1,s2,m-1,n-1);
        else
        return isSub(s1,s2,m,n-1);
    }
    boolean isSubSequence(String A, String B){
        return isSub(A,B,A.length()-1,B.length()-1);
    }
}