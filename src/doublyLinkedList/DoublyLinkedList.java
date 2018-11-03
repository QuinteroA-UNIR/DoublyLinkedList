package doublyLinkedList;

public class DoublyLinkedList {
	
	private int count;
	private Node head;
	private Node tail;


	public DoublyLinkedList() {
		this.setCount(0);
		this.setHead(null);
	}
	
	public void insert(String element) {
		Node newNode = new Node(element);
		Node head = this.getHead();

		this.setCount(this.getCount() + 1);
		newNode.setNext(head);

		if (head != null) {
			head.setPrev(newNode);
		}
		this.setHead(newNode);
		if (this.getCount() == 1) {
			this.setTail(newNode);
		}

	}
	
	public void append(String element) {
		Node newNode = new Node(element);
		Node tail = this.getTail();

		this.setCount(this.getCount() + 1);
		newNode.setPrev(tail);

		if (tail != null) {
			tail.setNext(newNode);
		}
		this.setTail(newNode);
		if (this.getCount() == 1) {
			this.setHead(newNode);
		}

	}

	public void insertAtPosition(int position, String element) {
		if ( position < 0 ){
			throw new IllegalArgumentException("No negative positions allowed.");
		} else if (position == 0) {
			this.insert(element);
		} else if (position > this.getCount() - 1) {
			this.append(element);
		} else {
			this.setCount(this.getCount() + 1);
			Node tempNode;
			Node newNode = new Node(element);
			int positionsFromTheEnd = this.getCount() - position - 1;

			if (position <= positionsFromTheEnd) {
				tempNode = this.getHead();
				for (int i = 0; i < position; i++) {
					tempNode = tempNode.getNext();
				}
				newNode.setPrev(tempNode.getPrev());
				newNode.getPrev().setNext(newNode);
				newNode.setNext(tempNode);
				tempNode.setPrev(newNode);
			} else {
				tempNode = this.getTail();
				for (int i = 0; i < positionsFromTheEnd; i++) {
					tempNode = tempNode.getPrev();
				}
				newNode.setNext(tempNode.getNext());
				newNode.getNext().setPrev(newNode);
				newNode.setPrev(tempNode);
				tempNode.setNext(newNode);
			}
			
			
		}
	}
	
	public void replaceAtPosition(int position, String newElement) {
		Node replaceNode = this.getNodeAtPosition(position);
		replaceNode.setValue(newElement);
	}
	
	public String getElementAtPosition(int position) {
		return this.getNodeAtPosition(position).getValue();
	}
	
	public boolean contains(String element) {
		for (int i = 0; i < this.getCount(); i++) {
			if (this.getElementAtPosition(i).equals(element)) {
				return true;
			}
		}
		return false;
	}
	
	public void remove(String element) {
		Node removeNode = this.getNodeByValue(element);
		if (removeNode == null) return;

		this.setCount(this.getCount() - 1);
		Node prevNode = removeNode.getPrev();
		Node nextNode = removeNode.getNext();
		
		if (this.getHead() == removeNode) this.setHead(nextNode);
		if (this.getTail() == removeNode) this.setTail(prevNode);
		if (prevNode != null) removeNode.getPrev().setNext(nextNode);
		if (nextNode != null) nextNode.setPrev(prevNode);
	}
	
	private Node getNodeByValue(String value) {
		Node tempNode;
		for (int i = 0; i < this.getCount(); i++) {
			tempNode = this.getNodeAtPosition(i);
			if (tempNode.getValue().equals(value)) {
				return tempNode;
			}
		}
		return null;
	}
	
	private Node getNodeAtPosition(int position) {
		if ( position < 0 || position >= this.getCount() ){
			throw new IllegalArgumentException("No negative positions allowed.");
		} else if (position == 0) {
			return this.getHead();
		} else if (position == this.getCount() - 1) {
			return this.getTail();
		} else {
			Node tempNode;
			int positionsFromTheEnd = this.getCount() - position - 1;
			if (position <= positionsFromTheEnd) {
				tempNode = this.getHead();
				for (int i = 0; i < position; i++) {
					tempNode = tempNode.getNext();
				}
			} else {
				tempNode = this.getTail();
				for (int i = 0; i < positionsFromTheEnd; i++) {
					tempNode = tempNode.getPrev();
				}
			}
			return tempNode;
		}
	}
	
	@Override
	public String toString() {
		String result = "[ ";
		boolean first = true;
		Node temp = this.getHead();
		if (temp == null) {
			return "Empty List";
		}

		do {
			if (first) {
				first = false;
			}else{
				result += ", ";	
			}
			
			result += temp.getValue();
			temp = temp.getNext();
		} while (temp != null);
		result += " ]";

		return result;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public Node getHead() {
		return head;
	}


	public void setHead(Node head) {
		this.head = head;
	}


	public Node getTail() {
		return tail;
	}


	public void setTail(Node tail) {
		this.tail = tail;
	}

}
