package doublyLinkedList;

public class Node {

	private Node prev;
	private Node next;
	private String value;
	
	public Node(String value) {
		this.setValue(value);
		this.prev = null;
		this.next = null;
	}
	
	public Node getPrev() {
		return prev;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}
	
	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
