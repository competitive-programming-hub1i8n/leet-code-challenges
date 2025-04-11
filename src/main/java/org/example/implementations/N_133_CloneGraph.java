package org.example.implementations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class N_133_CloneGraph {

    static void dfs(Node node, HashMap<Node, Node> map){
        if (!map.containsKey(node)){
            map.put(node, new Node(node.val));
            for(Node current : node.neighbors){
                dfs(current, map);
                map.get(node).neighbors.add(map.get(current));
            }
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null){
            return null;
        }
        HashMap<Node, Node> map = new HashMap<>();
        Node head = new Node(node.val);
        dfs(node, map);
        return map.get(node);
    }

    static class Node {
        public int val;
        public boolean visited;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
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

    public static void main(String[] args) {
        Node node = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        node.neighbors.add(node1);
        node.neighbors.add(node3);
        node1.neighbors.add(node);
        node1.neighbors.add(node3);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node);
        node3.neighbors.add(node2);
        Node node4 = new N_133_CloneGraph().cloneGraph(node);
        printGraph(node, node.neighbors);
        System.out.println("**********");
        printGraph(node4, node4.neighbors);

    }

    public static void printGraph(Node node, List<Node> neighbors){
        if (node == null){
            return;
        }
        System.out.println(node.val + " neighbors are: ");
        neighbors.forEach((item) -> {
            System.out.print(item.val + "--> ");
        });
        System.out.println("\n<------->");
        node.visited = true;
        for (Node current : node.neighbors) {
            if (!current.visited) {
                printGraph(current, current.neighbors);
            }
        }
    }
}
