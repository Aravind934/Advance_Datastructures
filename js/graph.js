class Node {
    constructor(val, weight) {
        this.val = val;
        this.weight = weight;
    }
}

class Graph {
    constructor() {
        this.graph = {};
    }
    addVertex(vertex) {
        if (!this.graph[vertex]) {
            this.graph[vertex] = [];
            return true;
        }
        return false;
    }
    addEdge(v1, v2, weight) {
        if (!this.graph[v1] || !this.graph[v2]) return false;
        let node1 = new Node(v2, weight);
        let node2 = new Node(v1, weight);
        this.graph[v1].push(node1);
        this.graph[v2].push(node2);
        return true;
    }
    removeVertex(v) {
        if (!this.graph[v]) return false;
        this.graph[v].forEach((vertex) => {
            this.graph[vertex.val] = this.graph[vertex.val].filter(
                (item) => item.val != v
            );
        });
        delete this.graph[v];
        return true;
    }
    removeEdge(v1, v2) {
        if (!this.graph[v1] || !this.graph[v2]) return false;
        this.graph[v1] = this.graph[v1].filter((item) => item.val != v2);
        this.graph[v2] = this.graph[v2].filter((item) => item.val != v1);
        return true;
    }

    bfs(from) {
        let map = {};
        let queue = [];
        queue.push(from);
        while (queue.length) {
            let temp = queue.shift();
            if (!map[temp]) {
                console.log(temp);
                map[temp] = true;
            }
            this.graph[temp].forEach((item) => {
                if (!map[item.val]) {
                    queue.push(item.val);
                }
            });
        }
    }
    dfs(from) {
        let map = {};
        let stack = [];
        stack.push(from);
        while (stack.length) {
            let temp = stack.pop();
            if (!map[temp]) {
                console.log(temp);
                map[temp] = true;
            }
            this.graph[temp].forEach((item) => {
                if (!map[item.val]) {
                    stack.push(item.val);
                }
            });
        }
    }
}

//Examples
// let g = new Graph();
// g.addVertex("Chennai");
// g.addVertex("Madurai");
// g.addVertex("Trichy");
// g.addEdge("Chennai", "Madurai", 500);
// g.addEdge("Chennai", "Trichy", 300);
// g.bfs("Chennai");
// g.dfs("Chennai");
