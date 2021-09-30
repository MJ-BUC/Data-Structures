package CSCE210.PEZ_Dispenser;

public class MyNode {

	private int nodeData;	//node's data
	private MyNode next;	//node's next pointer
	private MyNode prev;	//node's prev pointer

	public MyNode(int data) { 
		nodeData = data;     //initialize node data
		next = null;		 //initialize next to null
		prev = null;		 //initialize prev to null
	}

	public int getData() {
		return nodeData;	//return node's data
	}

	public void setData(int data) {
		nodeData = data;	//set node's data
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