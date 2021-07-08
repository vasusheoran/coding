// { Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class DFS
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<ArrayList<Integer>>();
            for(int i = 0; i < V; i++)
                adj.add(new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer>ans = obj.dfsOfGraph(V, adj);
            for (int i =0 ;i < ans.size (); i++) 
                System.out.print (ans.get (i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends





class Solution
{
    //Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        int visited[] = new int[adj.size()];
        ArrayList<Integer> result = new ArrayList<Integer>();

        for ( int i= 0; i<visited.length; i++){
            visited[i] = 0;
        }

        result.add(0);
        visited[0] = 1;
        
        return dfs(adj, visited, 0, result);

    }

    public ArrayList<Integer>  dfs(ArrayList<ArrayList<Integer>> adj, int visited[], int index,  ArrayList<Integer> result ){
        // if (visited[index] == 1) {
        //     return result;
        // }

        for ( int i=0; i < adj.get(index).size(); i++){
            int node = adj.get(index).get(i);
            if (visited[node] == 0) {
                visited[node] = 1;
                result.add(node);
                dfs(adj, visited, node, result);
            }
        }
        return result;
    }
}