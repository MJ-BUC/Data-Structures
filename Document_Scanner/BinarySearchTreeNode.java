package CSCE210.Document_Scanner;

public class BinarySearchTreeNode {

	// private String nodeData;	//node's data
	private String nodeKey;
	private BinarySearchTreeNode rightChild;	//node's next pointer
	private BinarySearchTreeNode leftChlld;	//node's prev pointer

	public BinarySearchTreeNode(String key) { 
		nodeKey = key;
		// nodeData = value;     //initialize node data
		rightChild = null;		 //initialize next to null
		leftChlld = null;		 //initialize prev to null
	}

	public String getValue() {
		return nodeKey;	//return node's data
	}

	public void setValue(String key) {
		nodeKey = key;	//set node's data
	}
	
	public BinarySearchTreeNode getRightNode() {
		return rightChild;	//return node's next pointer
	}

	public void setRightNode(BinarySearchTreeNode newnode) {
		rightChild = newnode;	//set node's next pointer
	}

	public BinarySearchTreeNode getLeftNode() {
		return leftChlld;	//return node's next pointer
	}

	public void setLeftNode(BinarySearchTreeNode newnode) {
		leftChlld = newnode; //set node's next pointer
	}

	public int GetNumberOfChildren() {								//returns the number of children a node has in the BST
		if (getLeftNode() == null && getLeftNode() == null) {
			return 0;
		}
		else if (getLeftNode() == null && getRightNode() != null) {
			return 1;
		}
		else if (getLeftNode() != null && getRightNode() == null) {
			return 1;
		}
		else {
			return 2;
		}
	}
}
