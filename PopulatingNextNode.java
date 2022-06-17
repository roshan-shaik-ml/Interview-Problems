/*
    Date: 17th June 2022
    Author: Shaik Faizan Roshan Ali
    Link: https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
    Description: Connect each level nodes to their next node in the same level using a pointer.
    Algorithm: Do BFS traversal for each level and connect the pointer from left to right node in same level. 
**/


/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        
                if(root == null)
            return root;
        
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        
        while(!queue.isEmpty()) {
        
            int size = queue.size();
            Node node = new Node();
            Node prev = new Node();
            for(int i = 0; i < size; i++) {
                
                prev = node;
                node = queue.poll();
                prev.next = node;
                System.out.println(node.val);
                
                if(node.left != null)
                   queue.offer(node.left);
                
                if(node.right != null)
                    queue.offer(node.right);  
            }
            node.next = null; /* Add NULL to the right most node */
        }
        return root;
        
    }
}
