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
        else if (HashGenerator(key) == HashGenerator(cursor.getValue()) && cursor.getLeftNode() != null) {
            // BinarySearchTreeNode node = cursor;
            // cursor = root;
            // return node;
            cursor = cursor.getLeftNode();
            return FindParent(key);
        }
        else if (HashGenerator(key) < HashGenerator(cursor.getValue()) && cursor.getLeftNode() != null) {
            cursor = cursor.getLeftNode();
            return FindParent(key);
        }
        else if (HashGenerator(key) > HashGenerator(cursor.getValue()) && cursor.getRightNode() != null) {
            cursor = cursor.getRightNode();
            return FindParent(key);
        }
        else {
            return cursor;
        }
    }

    public BinarySearchTreeNode Search(String key) {
        // if (key == root) {
        //     return key.getValue();
        // }
        // else if (HashGenerator(key) < HashGenerator(root)) {
        //     return null; //--do not use null-- recursive statement for left side of tree
        // }
        // else {
        //     return null; // --do not use null-- recursive statement for right side of tree
        // }
        if (root == null) {
            BinarySearchTreeNode node = cursor;
            return node;
        }
        else if (HashGenerator(key) == HashGenerator(cursor.getValue()) && cursor.getLeftNode() != null) {
            // BinarySearchTreeNode node = cursor;
            // cursor = root;
            // return node;
            cursor = cursor.getLeftNode();
            return FindParent(key);
        }
        else if (HashGenerator(key) < HashGenerator(cursor.getValue()) && cursor.getLeftNode() != null) {
            cursor = cursor.getLeftNode();
            return FindParent(key);
        }
        else if (HashGenerator(key) > HashGenerator(cursor.getValue()) && cursor.getRightNode() != null) {
            cursor = cursor.getRightNode();
            return FindParent(key);
        }
        else {
            return cursor;
        }
    }

    public void Delete(String key) {
        BinarySearchTreeNode node = Search(key);

        if (root == null) {
            System.out.println("Trying to delete nothing!!");
        }
        if (FindParent(key) == null) {
            System.out.println("parent is null");
        }
        if (root == key && GetNumberOfChildren() == 0) {
            root = null;
        }
        BinarySearchTreeNode foundParent = FindParent(key);

        //deleting if there are 0 children
        if (node.GetNumberOfChildren() == 0) {
            if (foundParent.getLeftNode() == node) {
                foundParent.setLeftNode(null);
            }
            else {
                foundParent.setRightNode(null);
            }
        }
        else if (node.GetNumberOfChildren() == 1) {
            
        }
    }

    //--HELPER FUNCTIONS--
    public BinarySearchTreeNode FindSmallestRightChild(BinarySearchTreeNode subtreeroot) {
        return subtreeroot;

    }

    public BinarySearchTreeNode PruneSmallestRightChild(BinarySearchTreeNode subtreeroot) {
        return subtreeroot;

    }
    //--HELPER FUNCTIONS--

    public void Print_Preorder(BinarySearchTreeNode cursor) {
        System.out.print(cursor.getValue() + " ");
        if (cursor.getLeftNode() != null) 
            Print_Preorder(cursor.getLeftNode());
        if (cursor.getRightNode() != null) 
            Print_Preorder(cursor.getRightNode());
    }

    public void Preorder_Helper() {
        Print_Preorder(root);
    }

    public void Print_Inorder(BinarySearchTreeNode cursor) {
        if (root == null) 
            return;
        if (cursor.getLeftNode() != null)
            Print_Inorder(cursor.getLeftNode());
        System.out.print(cursor.getValue() + " ");
        if (cursor.getRightNode() != null)
            Print_Inorder(cursor.getRightNode());
    }

    public void Inorder_Helper() {
        Print_Inorder(root);
    }

    public void Print_Postorder(BinarySearchTreeNode cursor) {
        if (cursor.getLeftNode() != null)
            Print_Postorder(cursor.getLeftNode());
        if (cursor.getRightNode() != null)
            Print_Postorder(cursor.getRightNode());
        System.out.print(cursor.getValue() + " ");
    }

    public void Postorder_Helper() {
        Print_Postorder(root);
    }
}
