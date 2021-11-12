package CSCE210.Document_Scanner;

import javax.lang.model.type.NullType;

public class BinarySearchTree {

    private BinarySearchTreeNode rightChild;
    private BinarySearchTreeNode leftChild;
    private BinarySearchTreeNode root;
    private BinarySearchTreeNode cursor;
    private BinarySearchTreeNode cursor2;

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
                System.out.println("Setting " + parentNode.getValue() + "'s right child to " + newnode.getValue());
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
        // if (root == null) {
        //     return null;
        // }
        // else if (HashGenerator(key) == HashGenerator(cursor.getValue()) && cursor.getLeftNode() != null && HashGenerator(key) == HashGenerator(cursor.getLeftNode().getValue())) {
        //     // BinarySearchTreeNode node = cursor;
        //     // cursor = root;
        //     // return node;
        //     cursor = cursor.getLeftNode();
        //     return FindParent(key);
        // }
        // //does not return the left child parent on left side of tree
        // //for keys that are the same coming off theroot on left side of the tree #########
        // else if (HashGenerator(key) < HashGenerator(cursor.getValue()) && cursor.getLeftNode() != null) {
        //     if (HashGenerator(key) == HashGenerator(cursor.getLeftNode().getValue())) {
        //         if (cursor.getLeftNode().getLeftNode() != null && HashGenerator(cursor.getLeftNode().getLeftNode().getValue()) == HashGenerator(key)) {
        //             cursor = cursor.getLeftNode();
        //             return FindParent(key);
        //         }
        //         return cursor.getLeftNode();
        //     }
        //     else {
        //         cursor = cursor.getLeftNode();
        //         return FindParent(key);
        //     }            
        // }
        // //does not return the left child parent on right side of tree
        // //for keys that are the same coming off the root on right side of the tree #########
        // else if (HashGenerator(key) > HashGenerator(cursor.getValue()) && cursor.getRightNode() != null) {
        //     if (HashGenerator(key) == HashGenerator(cursor.getRightNode().getValue())) {
        //         if (cursor.getRightNode().getLeftNode() != null && HashGenerator(cursor.getRightNode().getLeftNode().getValue()) == HashGenerator(key)) {
        //             cursor = cursor.getRightNode();
        //             return FindParent(key);
        //         }
        //         return cursor;
        //     }
        //     else {
        //         cursor = cursor.getRightNode();
        //         return FindParent(key);
        //     }            
        // }
        // else {
        //     System.out.println("checking right child = null" + key + cursor.getRightNode());
        //     System.out.println(cursor.getValue());
        //     return cursor;
        // }
        if (root == null) {
            return null;
        }
        else if (root.getLeftNode() != null && HashGenerator(key) == HashGenerator(root.getLeftNode().getValue())) {
            return root;
        }
        else if (root.getRightNode() != null && HashGenerator(key) == HashGenerator(root.getRightNode().getValue())) {
            return root;
        }
        else if (cursor.getLeftNode() != null && HashGenerator(key) < HashGenerator(root.getValue())) {
            // if (cursor.getLeftNode() != null && cursor.getLeftNode().getLeftNode() != null && cursor.getLeftNode() == Search(key)) {
            //     cursor = cursor.getLeftNode();
            //     FindParent(key);
            // }

            // else if (cursor.getLeftNode() != null && cursor.getLeftNode()!= null && cursor.getLeftNode() == Search(key)) {
            //     cursor = cursor.getLeftNode();
            //     FindParent(key);
            // }
            
            if (cursor.getLeftNode() != null && cursor.getLeftNode() != Search(key)) {
                cursor = cursor.getLeftNode();
                FindParent(key);
            }
            else if (cursor.getRightNode() != null && cursor.getRightNode() != Search(key)) {
                cursor = cursor.getLeftNode();
                FindParent(key);
            }
            else {
                return cursor;
            }
        }

        else if (cursor.getRightNode() != null && HashGenerator(key) > HashGenerator(root.getValue())) {
            // if (cursor.getRightNode() != null && cursor.getRightNode().getLeftNode() != null && cursor.getLeftNode() == Search(key)) {
            //     cursor = cursor.getLeftNode();
            //     FindParent(key);
            // }

            // else if (cursor.getRightNode() != null && cursor.getRightNode()!= null && cursor.getRightNode() == Search(key)) {
            //     cursor = cursor.getRightNode();
            //     FindParent(key);
            // }
            
            if (cursor.getRightNode() != null && cursor.getRightNode() != Search(key)) {
                cursor = cursor.getRightNode();
                FindParent(key);
            }
            else if (cursor.getLeftNode() != null && cursor.getLeftNode() != Search(key)) {
                cursor = cursor.getLeftNode();
                FindParent(key);
            }
            else {
                return cursor;
            }
        }
        else {
            return cursor;
        }
        return cursor;
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
        cursor2 = root;
        int h = HashGenerator(key);
        if (root == null) {
            BinarySearchTreeNode node = cursor2;
            return node;
        }
        else if (h == HashGenerator(cursor2.getValue())) {          //if h == hash of root
            return cursor2;
        }
        else {
            while (cursor2 != null && !(cursor2.getValue().equals(key)))
            {
                if (h < HashGenerator(cursor2.getValue()))
                    cursor2 = cursor2.getLeftNode();
                else if (h > HashGenerator(cursor2.getValue()))
                    cursor2 = cursor2.getRightNode();
                // System.out.println(cursor2.getValue() == key);
            }

            return cursor2;
        }
    }

    //helper function for dealing with a node that has 1 child
    public void splice(String key) {
        cursor = root;
        System.out.println("Deleting key:" + key);
        BinarySearchTreeNode node = Search(key);
        BinarySearchTreeNode parentOfNode = FindParent(key);
        System.out.println(parentOfNode.getValue());

        if (parentOfNode.getRightNode() == node) {
            if (node.getLeftNode() != null && node.GetNumberOfChildren() == 1) {
                parentOfNode.setRightNode(node.getLeftNode());
            }
            else if (node.getRightNode() != null && node.GetNumberOfChildren() == 1) {
                parentOfNode.setRightNode(node.getRightNode());
            }
            
            else if (node.GetNumberOfChildren() == 0) {
                parentOfNode.setRightNode(null);
            }
        }
        else if (parentOfNode.getLeftNode() == node) {
            if (node.getLeftNode() != null && node.GetNumberOfChildren() == 1) {
                parentOfNode.setLeftNode(node.getLeftNode());
            }
            else if (node.getRightNode() != null && node.GetNumberOfChildren() == 1) {
                parentOfNode.setLeftNode(node.getRightNode());
            }
            
            else if (node.GetNumberOfChildren() == 0) {
                System.out.println(parentOfNode.getLeftNode().getValue());
                parentOfNode.setLeftNode(null);
            }
        }
    }

    public void Delete(String key) {
        cursor = root;
        BinarySearchTreeNode node = Search(key);
        System.out.println("searching for she: " + node.getValue());
        BinarySearchTreeNode p = FindParent(key);
        //deleting the root node of BST
        if (root == null) {
            System.out.println("Trying to delete nothing!!");
        }
        else if (p == null) {
            System.out.println("parent is null");
        }
        else if (root == Search(key) && root.GetNumberOfChildren() == 0) {
            root = null;
        }
        else if (root.GetNumberOfChildren() == 1 && root.getValue().equals(key)) {
            splice(key);
        }
        else if (root.GetNumberOfChildren() == 2 && root.getValue().equals(key)) {
            BinarySearchTreeNode rootSmallestRight = root.getRightNode();
            while (rootSmallestRight.getLeftNode() != null) {
                rootSmallestRight = rootSmallestRight.getLeftNode();
            }
            root.setValue(rootSmallestRight.getValue());
            splice(rootSmallestRight.getValue());
        }
        
        //deleting when node has 1 child else deletes when node has 2 children
        else if (node.getLeftNode() == null || node.getRightNode() == null) {
            splice(key);
        }
        else {
            BinarySearchTreeNode smallestRight = node.getRightNode();
            while (smallestRight.getLeftNode() != null) {
                smallestRight = smallestRight.getLeftNode();
            }
            node.setValue(smallestRight.getValue());
            splice(smallestRight.getValue());
        }

        // BinarySearchTreeNode foundParent = FindParent(key);
    }

    //--HELPER FUNCTIONS--
    public BinarySearchTreeNode FindSmallestRightChild(BinarySearchTreeNode subtreeroot) {
        // if (subtreeroot.getRightNode() != null) {
        //     subtreeroot = subtreeroot.getRightNode();
        //     if (subtreeroot.getLeftNode() != null) {
        //         FindSmallestRightChild(subtreeroot.getLeftNode());
        //     }
        // }
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
            System.out.println("Root is null, BST is empty!");
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
