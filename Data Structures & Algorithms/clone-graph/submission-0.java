/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Node, Node> map = new HashMap<>();
    private Node dfs(Node node){
        if(node==null)
            return null;

        Node cloned = new Node();
        cloned.val = node.val;
        cloned.neighbors = new ArrayList<>();
        map.put(node, cloned);

        for(Node n : node.neighbors){
            if(map.containsKey(n))
                cloned.neighbors.add(map.get(n));
            else {
                Node temp = dfs(n);
                cloned.neighbors.add(temp);
            }
        }

        return cloned;
    }

    public Node cloneGraph(Node node) {
        return dfs(node); 
    }
}