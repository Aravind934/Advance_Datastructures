import java.util.*;

class Node {
    String val;
    Integer weight;
    Node(String val, Integer weight) {
        this.val = val;
        this.weight = weight;
    }
    public String toString() {
        return "{" + this.val + "=" + this.weight + "}";
    }
}

class Graph {
    Map < String, List < Node >> graph = new HashMap < > ();
    public boolean addVertex(String val) {
        if (graph.get(val) == null) {
            graph.put(val, new LinkedList < > ());
            return true;
        }
        return false;
    }
    public boolean addEdge(String vertex1, String vertex2, int weight) {
        if (graph.get(vertex1) == null || graph.get(vertex2) == null || weight < 0) {
            return false;
        }
        Node node2 = new Node(vertex2, weight);
        graph.get(vertex1).add(node2);
        Node node1 = new Node(vertex1, weight);
        graph.get(vertex2).add(node1);
        return true;
    }
    public boolean removeVertex(String val) {
        List < Node > res = graph.remove(val);
        if (res != null) {
            for (Node node: res) {
                Iterator < Node > iterator = graph.get(node.val).iterator();
                while (iterator.hasNext()) {
                    Node item = iterator.next();
                    if (item.val.equals(val)) {
                        iterator.remove();
                    }
                }
            }
        }
        return res != null;
    }
    public boolean removeEdge(String v1, String v2) {
        if (graph.get(v1) == null || graph.get(v2) == null) {
            return false;
        }
        Iterator < Node > iterator;
        iterator = graph.get(v1).iterator();
        while (iterator.hasNext()) {
            Node item = iterator.next();
            if (item.val.equals(v2)) {
                iterator.remove();
            }
        }
        iterator = graph.get(v2).iterator();
        while (iterator.hasNext()) {
            Node item = iterator.next();
            if (item.val.equals(v1)) {
                iterator.remove();
            }
        }
        return true;
    }
    public void bfs(String from) {
        List < Node > list;
        String temp;
        Map < String, Boolean > map = new HashMap < > ();
        Queue < String > queue = new LinkedList < > ();
        queue.add(from);
        while (queue.size() > 0) {
            temp = queue.poll();
            list = graph.get(temp);
            if (map.get(temp) == null) {
                map.put(temp, true);
                System.out.print(temp + "\n");
            }
            for (Node item: list) {
                if (map.get(item.val) == null) {
                    queue.add(item.val);
                }
            }
        }
    }
    public void dfs(String from) {
        List < Node > list;
        String temp;
        Map < String, Boolean > map = new HashMap < > ();
        Stack < String > stack = new Stack < > ();
        stack.push(from);
        while (stack.size() > 0) {
            temp = stack.pop();
            list = graph.get(temp);
            if (map.get(temp) == null) {
                map.put(temp, true);
                System.out.print(temp + "\n");
            }
            for (Node item: list) {
                if (map.get(item.val) == null) {
                    stack.push(item.val);
                }
            }
        }
    }
    public String toString() {
        return this.graph + "";
    }
}

/*
Examples to use thosee methods
       graph.addVertex("Chennai");
       graph.addVertex("Madurai");
       graph.addVertex("Trichy");
       graph.addVertex("Sivagangai");
       graph.addVertex("Madurai");
       graph.addEdge("Chennai","Madurai",500);
       graph.addEdge("Chennai","Trichy",300);
       graph.addEdge("Trichy","Madurai",200);
       graph.addEdge("Sivagangai","Madurai",20);
       graph.bfs("Chennai");
       graph.dfs("Chennai");
*/