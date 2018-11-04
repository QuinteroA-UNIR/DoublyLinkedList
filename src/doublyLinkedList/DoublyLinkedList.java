package doublyLinkedList;

/**
 * Class that implements a Double Linked List.
 * Created for the Activity Number 1: "Implementacion
 * de una lista doblemente enlazada". UNIR.
 * @author Arnaldo Quintero Segura.
 *
 */
public class DoublyLinkedList {
	
	/**
	 * Variable that holds the amount of elements
	 * present in the DoublyLinkedList.
	 */
	private int count;
	/**
	 * Pointer to the first element (head) of the DoublyLinkedList.
	 */
	private Node head;
	/**
	 * Pointer to the last element (tail) of the DoublyLinkedList
	 */
	private Node tail;

	/**
	 * Initializes a new LinkedList with the head ant tail set to null
	 * and count set to zero.
	 */
	public DoublyLinkedList() {
		this.setCount(0);
	}
	
	/**
	 * @return the amount of elements present in the DoublyLinkedList.
	 */
	public int getCount() {
		return count;
	}
	
	/**
	 * @return the first element of the DoublyLinkedList as a String.
	 */
	public String getHead() {
		if (this.head  == null) return null;
		return head.getValue();
	}
	
	/**
	 * @return the last element of the DoublyLinkedList as a String.
	 */
	public String getTail() {
		if (this.tail == null) return null;
		return this.tail.getValue();
	}

	
	/**
	 * Function that returns the element at a given position, if the position
	 * is invalid: less or equal than zero, or higher that the amount of elements
	 * present in the list, raises a IllegalArgumentException.
	 * @param position the position to look for.
	 * @return the element at the specified position.
	 */
	public String getElementAtPosition(int position) {
		return this.getNodeAtPosition(position).getValue();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String result = "[ ";
		boolean first = true;
		Node temp = this.head;
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
	
	/**
	 * Function that prints to the StdOut the representation
	 * of the list
	 */
	public void print() {
		System.out.println(this.toString());
	}
	
	/**
	 * Function that checks if a given element string is present inside
	 * of the DoublyLinkedList.
	 * @param element to look for.
	 * @return true if the element is found in the DoublyLinkedListm
	 * 			false otherwise.
	 */
	public boolean contains(String element) {
		for (int i = 0; i < this.getCount(); i++) {
			if (this.getElementAtPosition(i).equals(element)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Function that inserts a given string at the head of the DoublyLinkedList.
	 * @param element to insert.
	 */
	public void insert(String element) {
		Node newNode = new Node(element);

		this.setCount(this.getCount() + 1);
		newNode.setNext(head);

		if (this.head != null) {
			this.head.setPrev(newNode);
		}
		this.setHead(newNode);
		if (this.getCount() == 1) {
			this.setTail(newNode);
		}
	}
	
	/**
	 * Function that inserts a given element at a given position of the DoublyLinkedList.
	 * If the position is lower than zero, an IllegalArgumentException is raised.
	 * If the position is higher than the amount of elements in the DoublyLinkedList,
	 * the element is inserted at the end of the list.
	 * @param position to insert the element.
	 * @param element to insert.
	 */
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
				tempNode = this.head;
				for (int i = 0; i < position; i++) {
					tempNode = tempNode.getNext();
				}
				newNode.setPrev(tempNode.getPrev());
				newNode.getPrev().setNext(newNode);
				newNode.setNext(tempNode);
				tempNode.setPrev(newNode);
			} else {
				tempNode = this.tail;
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
	
	/**
	 * Function that inserts a given element at the end of the DoublyLinkedList.
	 * @param element to be inserted
	 */
	public void append(String element) {
		Node newNode = new Node(element);

		this.setCount(this.getCount() + 1);
		newNode.setPrev(tail);

		if (this.tail != null) {
			this.tail.setNext(newNode);
		}
		this.setTail(newNode);
		if (this.getCount() == 1) {
			this.setHead(newNode);
		}
	}

	/**
	 * Function that replaces the content of the element at a given position of the list,
	 * by a new element given.
	 * @param position to replace the element
	 * @param newElement to be set at the given position
	 */
	public void replaceAtPosition(int position, String newElement) {
		Node replaceNode = this.getNodeAtPosition(position);
		replaceNode.setValue(newElement);
	}
	
	/**
	 * Function that removes a given element from the DoublyLinkedList. If not present,
	 * then nothing is deleted.
	 * @param element to remove
	 */
	public void remove(String element) {
		Node removeNode = this.getNodeByValue(element);
		if (removeNode == null) return;
		this.removeNode(removeNode);
	}
	
	/**
	 * Function that removes an element at a given position. If the position is invalid,
	 * raises a IllegalArgumentException. 
	 * @param position of the element to delete
	 * @return the element deleted
	 */
	public String removeAtPosition(int position) {
		Node removeNode = this.getNodeAtPosition(position);
		this.removeNode(removeNode);
		return removeNode.getValue();
	}
	
	/**
	 * Function that joins a given DoublyLinkedList at the end of the current DoublyLinkedList
	 * @param list to be merged.
	 */
	public void concat(DoublyLinkedList list) {
		if (this.tail != null) {			
			this.tail.setNext(list.head);
		} else {
			this.setHead(list.head);
		}
		
		if (list.getCount() > 0) {
			list.head.setPrev(this.tail);
			this.setTail(list.tail);
		}
		this.setCount(this.getCount() + list.getCount());
	}
	
	/**
	 * Function that sets the head node of the DoublyLinkedList to a given Node.
	 * @param head node to set as head.
	 */
	private void setHead(Node head) {
		this.head = head;
	}

	/**
	 * Function that sets the tail node of the DoublyLinkedList to a given Node.
	 * @param tail node to set as tail
	 */
	private void setTail(Node tail) {
		this.tail = tail;
	}
	
	/**
	 * Function that sets the amount of elements of the DoublyLinkedList.
	 * @param count amount of elements present in the DoublyLinkedList.
	 */
	private void setCount(int count) {
		this.count = count;
	}
	
	/**
	 * Function that removes a given node from the DoublyLinkedList.
	 * @param removeNode node to be removed.
	 */
	private void removeNode(Node removeNode) {
		if (removeNode == null) return;

		this.setCount(this.getCount() - 1);
		Node prevNode = removeNode.getPrev();
		Node nextNode = removeNode.getNext();
		
		if (this.head == removeNode) this.setHead(nextNode);
		if (this.tail == removeNode) this.setTail(prevNode);
		if (prevNode != null) removeNode.getPrev().setNext(nextNode);
		if (nextNode != null) nextNode.setPrev(prevNode);
	}
	
	/**
	 * Function that gets the Node that contains a given value.
	 * Returns null if there is no Node present with the given value.
	 * @param value that should contain the Node to search
	 * @return the node that contains the given value inside the DoublyLinkedList.
	 */
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
	
	/**
	 * Function that gets the Node at a given position of the DoublyLinkedList.
	 * If the position is invalid. Raises an IllegalArgumentException.
	 * @param position to find the element
	 * @return Node at the given position of the DoublyLinkedList.
	 */
	private Node getNodeAtPosition(int position) {
		if ( position < 0 || position >= this.getCount() ){
			throw new IllegalArgumentException("Invalid position.");
		} else if (position == 0) {
			return this.head;
		} else if (position == this.getCount() - 1) {
			return this.tail;
		} else {
			Node tempNode;
			int positionsFromTheEnd = this.getCount() - position - 1;
			if (position <= positionsFromTheEnd) {
				tempNode = this.head;
				for (int i = 0; i < position; i++) {
					tempNode = tempNode.getNext();
				}
			} else {
				tempNode = this.tail;
				for (int i = 0; i < positionsFromTheEnd; i++) {
					tempNode = tempNode.getPrev();
				}
			}
			return tempNode;
		}
	}
}
