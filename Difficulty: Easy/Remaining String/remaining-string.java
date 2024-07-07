//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            char ch = read.readLine().charAt(0);
            int count = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            String result = ob.printString(s, ch, count);

            System.out.println(result);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    String printString(String s, char ch, int count) {
        // code here
        if(count==0)
        return s;
        if(!s.contains(Character.toString(ch)))
        return "Empty string";
        int i=0,n=s.length(),t=0;
        for(i=0;i<n;i++){
            char c=s.charAt(i);
            if(c==ch)
            t++;
            if(t==count)
            break;
        }
        if(i>=n-1)
        return "Empty string";
        else
        return s.substring(i+1,n);
    }
}