class Node {
    constructor(val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class BST {
    root = null;
    size = 0;
    add(val) {
        let node = new Node(val);
        if (this.root === null) {
            this.root = node;
            this.size++;
            return true;
        } else {
            let temp = this.root;
            while (temp !== null) {
                if (val < temp.val) {
                    if (temp.left === null) {
                        temp.left = node;
                        this.size++;
                        return true;
                    }
                    temp = temp.left;
                }
                if (val >= temp.val) {
                    if (temp.right === null) {
                        temp.right = node;
                        this.size++;
                        return true;
                    }
                    temp = temp.right;
                }
            }
        }
        return false;
    }
    len() {
        return this.size;
    }
    PreOrderTraverse() {
        function preOrder(node) {
            console.log(node.val);
            if (node.left != null) {
                preOrder(node.left);
            }
            if (node.right != null) {
                preOrder(node.right);
            }
        }
        if (this.size > 0) {
            preOrder(this.root);
        }
    }
    inOrderTraverse() {
        function inOrder(node) {
            if (node.left != null) {
                inOrder(node.left);
            }
            console.log(node.val);
            if (node.right != null) {
                inOrder(node.right);
            }
        }
        if (this.size > 0) {
            inOrder(this.root);
        }
    }
    postOrderTraverse() {
        function postOrder(node) {
            if (node.left != null) {
                postOrder(node.left);
            }
            if (node.right != null) {
                postOrder(node.right);
            }
            console.log(node.val);
        }
        if (this.size > 0) {
            postOrder(this.root);
        }
    }
    remove(val) {
        let res = this.removeNode(this.root, val);
        this.root = res;
        return true;
    }
    removeNode(node, val) {
        if (node == null) {
            return null;
        }
        if (val == node.val) {
            if (node.left == null && node.right == null) {
                this.size--;
                return null;
            }
            if (node.left == null) {
                this.size--;
                return node.right;
            }
            if (node.right == null) {
                this.size--;
                return node.left;
            } else {
                let minVal = this.getMin(node.right);
                node.val = minVal;
                node.right = this.removeNode(node.right, minVal);
                return node;
            }
        }
        if (val < node.val) {
            node.left = this.removeNode(node.left, val);
            return node;
        } else {
            node.right = this.removeNode(node.right, val);
            return node;
        }
    }
    getMin(node) {
        let temp = node;
        while (temp.left != null) {
            temp = temp.left;
        }
        return temp.val;
    }
}
