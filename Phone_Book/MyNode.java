package CSCE210.Phone_Book;

public class MyNode {

	private int nodeData;	//node's data
	private String nodeKey;
	private MyNode next;	//node's next pointer
	private MyNode prev;	//node's prev pointer

	public MyNode(String key, int value) { 
		nodeKey = key;
		nodeData = value;     //initialize node data
		next = null;		 //initialize next to null
		prev = null;		 //initialize prev to null
	}

	public String getKey() {	//gets the key from the linked list
		return nodeKey;
	}

	public int getValue() {
		return nodeData;	//return node's data
	}

	public void setValue(int value) {
		nodeData = value;	//set node's data
	}

	public void setKey(String key) {	//sets the key in the linked list
		nodeKey = key;
	}
	
	public MyNode getNext() {
		return next;	//return node's next pointer
	}

	public void setNext(MyNode newnode) {
		next = newnode;	//set node's next pointer
	}

	public MyNode getPrev() {
		return prev;	//return node's next pointer
	}

	public void setPrev(MyNode newnode) {
		prev = newnode; //set node's next pointer
	}
}