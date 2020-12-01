class Node{
    int value;
    List<Node> neighbors;
}

class CloneDirectedGraph{
    public Node cloneGraph(Node node){
        if(node==null){
            return null;
        }
        HashMap<Integer, Node> map = new HashMap<Integer,Node>();
        //Lets use DFS to clone a graph
     return dfs(node, map);   
    }
    
    public Node dfs(Node node, HashMap<Integer,Node> map){
        if(node==null || map.size()==0){
            return null;
        }
        if(map.containsKey(node.value)){
            return map.get(node.value);
        }
        Node clonedNode = new Node(node.val);
        map.put(node.val, clonedNode);
        
        for(Node neighbor : node.neighbors){
            clone.neighbors.add(dfs(neighbor,map));
        }
        return  clonedNode;
    }
}
