//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        //Reading total number of testcases
        int t= sc.nextInt();
        
        while(t-- >0)
        {
            //reading the string
            String st = sc.next();
            
            //calling ispar method of Paranthesis class 
            //and printing "balanced" if it returns true
            //else printing "not balanced"
            if(new Solution().ispar(st) == true)
                System.out.println("balanced");
            else
                System.out.println("not balanced");
        
        }
    }
}
// } Driver Code Ends



class Solution
{
    //Function to check if brackets are balanced or not.
    static boolean ispar(String s)
    {
        // add your code here
        char[] ch= s.toCharArray();
        Stack<Character> st=new Stack<>();
        String open="({[";
        for(Character c:ch){
            if(open.contains(Character.toString(c))){
                st.push(c);
            }
            else if(!st.isEmpty()){
                char t=st.pop();
                if((c==')' && t!='(') || (c=='}' && t!='{') || (c==']' && t!='['))
                return false;
            }
            else
            return false;
        }
        return st.isEmpty();
    }
}
