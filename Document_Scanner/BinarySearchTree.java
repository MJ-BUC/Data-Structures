package CSCE210.Document_Scanner;

public class BinarySearchTree {

    private BinarySearchTreeNode rightChild;
    private BinarySearchTreeNode leftChild;
    private BinarySearchTreeNode root;

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
        int hash = HashGenerator(parentNode.getValue());
    }

    public void Insert(String key) {
        BinarySearchTreeNode newnode = new BinarySearchTreeNode(key);
        BinarySearchTreeNode parentNode = FindParent(key);
        Insert(parentNode, newnode);
    }

    public BinarySearchTreeNode FindParent(String key) {
        return null;
        
    }

    public BinarySearchTreeNode Search(String key) {
        return null;
        
    }

    public void Delete(String key) {

    }

    public BinarySearchTreeNode FindSmallestRightChild(BinarySearchTreeNode subtreeroot) {
        return subtreeroot;

    }

    public BinarySearchTreeNode PruneSmallestRightChild(BinarySearchTreeNode subtreeroot) {
        return subtreeroot;

    }

    public void Print_Preorder() {

    }

    public void Print_Inorder() {

    }

    public void Print_Postorder() {

    }
}
