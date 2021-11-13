package CSCE210.Document_Scanner;

public class MyNode {

	private String nodeData;	//node's data
	private MyNode next;	//node's next pointer

	public MyNode(String data) { 
		nodeData = data;     //initialize node data
		next = null;		 //initialize next to null
	}

	public String getData() {
		return nodeData;	//return node's data
	}

	public void setData(String data) {
		nodeData = data;	//set node's data
	}
	
	public MyNode getNext() {
		return next;	//return node's next pointer
	}

	public void setNext(MyNode newnode) {
		next = newnode;	//set node's next pointer
	}
}