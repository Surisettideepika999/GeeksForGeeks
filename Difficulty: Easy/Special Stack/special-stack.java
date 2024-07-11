//{ Driver Code Starts
import java.util.Scanner;
import java.util.Stack;
class SpeStack{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			Stack<Integer> s=new Stack<>();
			GfG g=new GfG();
			while(!g.isEmpty(s)){
			    g.pop(s);
			}
			while(!g.isFull(s,n)){
				g.push(sc.nextInt(),s);
			}
		System.out.println(g.min(s));
		}
	}
}
// } Driver Code Ends


/*Complete the function(s) below*/
class GfG{
    int min=Integer.MAX_VALUE;
	public void push(int a,Stack<Integer> s)
	{
	    //add code here.
	    if(s.isEmpty()){
	    s.push(a);min=a;
	    }
	    else{
	        if(a>min)
	        s.push(a);
	        else{
	            int y=2*a-min;
	            s.push(y);
	            min=a;
	        }
	    }
	}
	public int pop(Stack<Integer> s)
        {
            //add code here.
            if(s.isEmpty())
            return -1;
            else{
                if(s.peek()>min)
                return s.pop();
                else{
                    int t=min;
                    min=2*min-s.peek();
                    return t;
                }
            }
	}
	public int min(Stack<Integer> s)
        {
           //add code here.
           return min;
	}
	public boolean isFull(Stack<Integer>s, int n)
        {
           //add code here.
           return s.size()==n;
	}
	public boolean isEmpty(Stack<Integer>s)
        {
           //add code here.
           return s.isEmpty();
	}
}