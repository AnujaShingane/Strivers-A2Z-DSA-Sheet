/*
    Topological Sort Algorithm | DFS: G-21
    Problem Statement: Given a Directed Acyclic Graph (DAG) with V vertices and E edges, Find any Topological Sorting of that Graph.
    
    Note: In topological sorting, node u will always appear before node v if there is a directed edge from node u towards node v(u -> v).
    
    Example 1:
    
    Input: V = 6, E = 6
    5 ---> 0 <-- 4
    │            │
    │            │ 
    ↓            ↓
    2 ---> 3 <-- 1

    Output: 5, 4, 2, 3, 1, 0

    Explanation: A graph may have multiple topological sortings. 
    The result is one of them. The necessary conditions 
    for the ordering are:
    According to edge 5 -> 0, node 5 must appear before node 0 in the ordering.
    According to edge 4 -> 0, node 4 must appear before node 0 in the ordering.
    According to edge 5 -> 2, node 5 must appear before node 2 in the ordering.
    According to edge 2 -> 3, node 2 must appear before node 3 in the ordering.
    According to edge 3 -> 1, node 3 must appear before node 1 in the ordering.
    According to edge 4 -> 1, node 4 must appear before node 1 in the ordering.
    
    The above result satisfies all the necessary conditions. 
    [4, 5, 2, 3, 1, 0] is also one such topological sorting 
    that satisfies all the conditions.

    Example 2:
    
    Input: V = 4, E = 3
    Result: 3, 2, 1, 0

    Explanation: The necessary conditions for the ordering are:
    For edge 1 -> 0 node 1 must appear before node 0.
    For edge 2 -> 0 node 1 must appear before node 0.
    For edge 3 -> 0 node 1 must appear before node 0.
    
    [2, 3, 1, 0] is also another topological sorting for the graph.
*/


class Solution {
     /*
     * Time Complexity: O(N + E)
     * Space Complexity: O(N)
     */
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[V];
        
        ArrayList<ArrayList<Integer>> adj = adj(V,edges);
        
        for(int i = 0 ; i < V ; i++){
            if(!vis[i]){
                dfs(i,vis,adj,st);
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        while(!st.isEmpty()){
            ans.add(st.pop());
        }
        return ans;
    }
    
    public ArrayList<ArrayList<Integer>> adj(int V,int[][] edges){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0 ; i < V ; i++)adj.add(new ArrayList<>());
        
        for(int[] arr : edges){
            adj.get(arr[0]).add(arr[1]);
        }
        return adj;
    }
    
    public void dfs(int node,boolean[] vis,ArrayList<ArrayList<Integer>> adj,Stack<Integer> st){
        vis[node]=true;
        for(int ele : adj.get(node)){
            if(!vis[ele]){
                dfs(ele,vis,adj,st);
                vis[ele]=true;
            }
        }
        st.push(node);//backtracking
    } 
}
