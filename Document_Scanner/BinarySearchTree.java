package CSCE210.Document_Scanner;

public class BinarySearchTree {

    private BinarySearchTreeNode rightChild;
    private BinarySearchTreeNode leftChild;
    private BinarySearchTreeNode root;
    private BinarySearchTreeNode cursor;

    public BinarySearchTree(String key) {
        BinarySearchTreeNode newnode = BinarySearchTreeNode(key);
        root = newnode;
    }

    public BinarySearchTree() {
        
    }

    public int HashGenerator(String key) {
        double hash = 0.0;
        int base;
        int power;
        for (int i=0; i<key.length(); i++) {
        base = (int)key.charAt(i)-96;
        power = (i==0)?3:2;
        hash += Math.pow(base, power)*Math.PI/(i+1);
        }
        return (int)(hash*Math.E*5/key.length());
    }

    public void Insert(BinarySearchTreeNode parentNode, BinarySearchTreeNode newnode) {

        if (root == null) {
            root = newnode;
        }
        else {
            int hash = HashGenerator(parentNode.getValue());
            if (HashGenerator(newnode.getValue()) < hash) {
                parentNode.setLeftNode(newnode);
            }
            else if (HashGenerator(newnode.getValue()) > hash) {
                parentNode.setRightNode(newnode);
            }
            else {
                parentNode.setLeftNode(newnode);
            }
        }
    }

    public void Insert(String key) {
        cursor = root;
        BinarySearchTreeNode newnode = new BinarySearchTreeNode(key);
        BinarySearchTreeNode parentNode = FindParent(key);
        Insert(parentNode, newnode);
    }

    //fix problem with recursion and not traversing with cursor correctly. EX line 68 there is no left node and hits null.
    public BinarySearchTreeNode FindParent(String key) {
        if (root == null) {
            BinarySearchTreeNode node = cursor;
            return node;
        }
        else if (HashGenerator(key) == HashGenerator(cursor.getValue())) {
            BinarySearchTreeNode node = cursor;
            // cursor = root;
            return node;
        }
        else if (HashGenerator(key) < HashGenerator(cursor.getValue())) {
            cursor = cursor.getLeftNode();
            return FindParent(key);
        }
        else {
            cursor = cursor.getRightNode();
            return FindParent(key);
        }
    }

    public BinarySearchTreeNode Search(String key) {
        if (key == root) {
            return key.getValue();
        }
        else if (HashGenerator(key) < HashGenerator(root)) {
            return null; //--do not use null-- recursive statement for left side of tree
        }
        else {
            return null; // --do not use null-- recursive statement for right side of tree
        }
    }

    public void Delete(String key) {

    }

    //--HELPER FUNCTIONS--
    public BinarySearchTreeNode FindSmallestRightChild(BinarySearchTreeNode subtreeroot) {
        return subtreeroot;

    }

    public BinarySearchTreeNode PruneSmallestRightChild(BinarySearchTreeNode subtreeroot) {
        return subtreeroot;

    }
    //--HELPER FUNCTIONS--

    public void Print_Preorder() {

    }

    public void Print_Inorder() {

    }

    public void Print_Postorder() {

    }
}
