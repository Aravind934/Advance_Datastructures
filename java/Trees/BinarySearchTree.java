class Node {
    int val;
    Node left;
    Node right;
    Node(int val) {
        this.val = val;
    }
    public String toString() {
        return this.val + "->" + this.left + "->" + this.right;
    }
}

class BST {
    Node root;
    private int size = 0;
    public boolean add(int val) {
        Node node = new Node(val);
        if (root == null) {
            this.root = node;
            this.size++;
            return true;
        } else {
            Node temp = root;
            while (temp != null) {
                if (val < temp.val) {
                    if (temp.left == null) {
                        temp.left = node;
                        this.size++;
                        return true;
                    }
                    temp = temp.left;
                }
                if (val >= temp.val) {
                    if (temp.right == null) {
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
    public int size() {
        return this.size;
    }
    public void PreOrderTraverse() {
        if (this.size > 0) {
            preOrder(this.root);
        }
    }
    public void inOrderTraverse() {
        if (this.size > 0) {
            inOrder(this.root);
        }

    }
    public void postOrderTraverse() {
        if (this.root == null) {
            postOrder(this.root);
        }
    }
    public boolean remove(int val) {
        Node res = this.removeNode(this.root, val);
        this.root = res;
        return true;
    }
    public Node removeNode(Node node, int val) {
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
                int minVal = this.getMin(node.right);
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
    public int getMin(Node node) {
        Node temp = node;
        while (temp.left != null) {
            temp = temp.left;
        }
        return temp.val;
    }
    private void preOrder(Node node) {
        System.out.print(node.val + "\n");
        if (node.left != null) {
            preOrder(node.left);
        }
        if (node.right != null) {
            preOrder(node.right);
        }
    }
    private void inOrder(Node node) {
        if (node.left != null) {
            inOrder(node.left);
        }
        System.out.print(node.val + "\n");
        if (node.right != null) {
            inOrder(node.right);
        }
    }
    private void postOrder(Node node) {
        if (node.left != null) {
            postOrder(node.left);
        }
        if (node.right != null) {
            postOrder(node.right);
        }
        System.out.print(node.val + "\n");

    }
    public String toString() {
        return this.root + " ";
    }
}