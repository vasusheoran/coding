// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class ReverseWordsWithoutSplit {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            System.out.println(obj.reverseWordsWithoutSplit(s));
            t--;
        }
    }
}
// } Driver Code Ends


class Solution {
    // 0.59
    String reverseWords(String S) {
        // code here 
        String result = "";
        String []split= S.split("\\.");
        result += split[split.length -1];
        for(int i = split.length - 2; i>=0;i--){
            result += "." + split[i];
        }
        return result;
    }

    // 0.67
    String reverseWordsWithoutSplit(String S){
        String result = "";

        int startIndex = 0;
        int endIndex = 0;

        List<String> list = new ArrayList<>();

        for(int i = 0;i<S.length();i++){
            if(S.charAt(i) == '.' || S.charAt(i) == '\n'){
                list.add(addSubString(S, startIndex, endIndex)); 
                startIndex = i + 1;
                endIndex = i;
            }
            endIndex++;
        }

        list.add(addSubString(S, startIndex, endIndex)); 

        int count = list.size() - 1;
        result = list.get(count);
        
        for(int i = count-1; i >= 0; i--){
            result += "." + list.get(i);
        }
        

        return result;
    }

    String addSubString(String S, int start, int end){
        String result = S.substring(start,end);
        return result;
    }
}