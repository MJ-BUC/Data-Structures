package CSCE210.Document_Scanner;

public class BinarySearchTreeNode {

	private String nodeData;	//node's data
	private String nodeKey;
	private BinarySearchTreeNode next;	//node's next pointer
	private BinarySearchTreeNode prev;	//node's prev pointer

	public BinarySearchTreeNode(String key) { 
		nodeKey = key;
		// nodeData = value;     //initialize node data
		next = null;		 //initialize next to null
		prev = null;		 //initialize prev to null
	}

	public String getKey() {	//gets the key from the linked list
		return nodeKey;
	}

	public String getValue() {
		return nodeData;	//return node's data
	}

	public void setValue(String key) {
		nodeData = key;	//set node's data
	}

	// public void setKey(String key) {	//sets the key in the linked list
	// 	nodeKey = key;
	// }
	
	public BinarySearchTreeNode getRightNode() {
		return next;	//return node's next pointer
	}

	public void setRightNode(BinarySearchTreeNode newnode) {
		next = newnode;	//set node's next pointer
	}

	public BinarySearchTreeNode getLeftNode() {
		return prev;	//return node's next pointer
	}

	public void setLeftNode(BinarySearchTreeNode newnode) {
		prev = newnode; //set node's next pointer
	}
}
