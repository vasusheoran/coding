// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class UndirectedGraph
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
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if(ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends





class Solution
{
    public boolean util(int v, ArrayList<ArrayList<Integer>> adj, boolean visited[], int parent){

        visited[v] = true;
        ListIterator<Integer> iter  = adj.get(v).listIterator();

        while(iter.hasNext()){
            int i = iter.next();

            // System.out.println("v: " + v + ", i: " + i + ", visited: " + visited[i] + ", parent: " + parent);
            if(!visited[i]){
                if (util(i, adj, visited, v)){
                    return true;
                }
            }

            else if(i != parent){
                return true;
            }
        }

        return false;
    }
    //Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here

        boolean visited[] = new boolean[adj.size()];

        for(int i = 0; i<V; i++){
            visited[i] = false;
        }

        for(int i = 0; i<V; i++){
            if(!visited[i]){
                if(util(i, adj, visited, -1)){
                    return true;
                }
            }
        }

        return false;
    }
}