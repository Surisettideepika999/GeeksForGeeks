//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {

    public int[] countFreq(int arr[]) {

        // complete the function
    TreeMap<Integer,Integer> hm=new TreeMap<>();
    for(Integer x: arr){
        hm.put(x,hm.getOrDefault(x,0)+1);
    }
    ArrayList<Integer> a=new ArrayList<>();
    // System.out.println(hm);
    for(Integer x: hm.keySet()){
        a.add(hm.get(x));
    }
    int[] ans=new int[a.size()];
    ans[0]=a.get(0);
    for(int i=1;i<a.size();i++){
        ans[i]=ans[i-1]+a.get(i);
    }
    return ans;
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            // int k = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution obj = new Solution();
            int answer[] = obj.countFreq(arr);
            int sz = answer.length;

            StringBuilder output = new StringBuilder();
            for (int i = 0; i < sz; i++) output.append(answer[i] + " ");
            System.out.println(output);
        }
    }
}
// } Driver Code Ends