// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class SubarraySum{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int s = sc.nextInt();

            int[] m = new int[n];
            for (int j = 0; j < n; j++) {
                m[j] = sc.nextInt();
            }
            
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.subarraySum(m, n, s);
            for(int ii = 0;ii<res.size();ii++)
                System.out.print(res.get(ii) + " ");
            System.out.println();
        }
    }

}// } Driver Code Ends




class Solution{
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        // Your code here

        int startIndex = 0;
        int endIndex = 0;
        int curSum = 0;
        

        ArrayList<Integer> result = new ArrayList<Integer>(); 
        for(int i=0; i< n; i++){
            if(curSum == s){
                result.add(startIndex + 1);
                result.add(endIndex);
                return result;
            }

            curSum += arr[endIndex];
            endIndex++;

            if (curSum > s) {
                while(curSum > s){
                    curSum -= arr[startIndex];
                    startIndex++;
                    if(curSum == s){
                        result.add(startIndex + 1);
                        result.add(endIndex);
                        return result;
                    }
                }

                
            }
        }

        if (curSum == s){
            result.add(startIndex+1);
            result.add(endIndex);
        }else{
            result.add(-1);
        }
        return result;
    }
}