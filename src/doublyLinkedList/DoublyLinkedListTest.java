package doublyLinkedList;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import doublyLinkedList.DoublyLinkedList;

class DoublyLinkedListTest {

	@Test
	void listCreationTest() {
		DoublyLinkedList list = getList();
		assertEquals(0, list.getCount());
		assertEquals(null, list.getHead());
		System.out.println(list);
	}
	
	@Test
	void addElementToEmptyListTest() {

		DoublyLinkedList list = getList();
		list.insert("1");
		Node listHead = list.getHead();
		Node listTail = list.getTail();

		assertEquals(1,list.getCount());
		assertEquals("1", listHead.getValue());
		assertEquals(null, listHead.getNext());
		assertEquals(null, listHead.getPrev());
		assertEquals(listHead, listTail);
		System.out.println(list);
	}
	
	@Test
	void appendElementToEmptyListTest() {

		DoublyLinkedList list = getList();
		list.append("1");
		Node listHead = list.getHead();
		Node listTail = list.getTail();

		assertEquals(1,list.getCount());
		assertEquals("1", listTail.getValue());
		assertEquals(null, listHead.getNext());
		assertEquals(null, listHead.getPrev());
		assertEquals(listHead, listTail);
		System.out.println(list);
	}		
	
	@Test
	void addElementToListWithOneExistingItemTest() {

		DoublyLinkedList list = getList(1);
		list.insert("2");
		Node listHead = list.getHead();
		Node listTail = list.getTail();

		assertEquals(2,list.getCount());
		assertEquals("2", listHead.getValue());
		assertEquals("1", listTail.getValue());
		assertEquals(listTail, listHead.getNext());
		assertEquals(null, listHead.getPrev());
		assertEquals(null, listTail.getNext());
		assertEquals(listHead, listTail.getPrev());
		System.out.println(list);
		
	}
	
	@Test
	void appendElementToListWithOneExistingItemTest() {

		DoublyLinkedList list = getList(1);
		list.append("2");
		Node listHead = list.getHead();
		Node listTail = list.getTail();

		assertEquals(2,list.getCount());
		assertEquals("1", listHead.getValue());
		assertEquals("2", listTail.getValue());
		assertEquals(listTail, listHead.getNext());
		assertEquals(null, listHead.getPrev());
		assertEquals(null, listTail.getNext());
		assertEquals(listHead, listTail.getPrev());
		System.out.println(list);
		
	}
	
	@Test
	void addElementToListWithExistingItemsTest() {

		DoublyLinkedList list = getList(2);
		list.insert("3");
		Node listHead = list.getHead();
		Node listTail = list.getTail();

		assertEquals(3,list.getCount());
		assertEquals("3", listHead.getValue());
		assertEquals("2", listTail.getValue());
		assertEquals(listHead.getNext(),listTail.getPrev());
		System.out.println(list);
		
	}
	
	@Test
	void appendElementToListWitExistingItemsTest() {

		DoublyLinkedList list = getList(2);
		list.append("3");
		Node listHead = list.getHead();
		Node listTail = list.getTail();

		assertEquals(3,list.getCount());
		assertEquals("1", listHead.getValue());
		assertEquals("3", listTail.getValue());
		assertEquals(listHead.getNext(),listTail.getPrev());
		System.out.println(list);
		
	}
	
	@Test
	void insertElementAtPositionFirstToEmptyListTest() {
		DoublyLinkedList list = getList();
		list.insertAtPosition(0, "1");
		Node listHead = list.getHead();
		Node listTail = list.getTail();

		assertEquals(1,list.getCount());
		assertEquals("1", listHead.getValue());
		assertEquals(null, listHead.getNext());
		assertEquals(null, listHead.getPrev());
		assertEquals(listHead, listTail);
		System.out.println(list);
	}
	
	@Test
	void insertElementAtPositionFirstToListWithExistingItemsTest() {
		DoublyLinkedList list = getList(2);
		list.insertAtPosition(0, "0");
		Node listHead = list.getHead();
		Node listTail = list.getTail();

		assertEquals(3,list.getCount());
		assertEquals("0", listHead.getValue());
		assertEquals(listHead.getNext(), listTail.getPrev());
		System.out.println(list);
	}
	
	@Test
	void insertElementAtPositionLastToEmptyListTest() {
		DoublyLinkedList list = getList();
		list.insertAtPosition(1, "1");
		Node listHead = list.getHead();
		Node listTail = list.getTail();

		assertEquals(1,list.getCount());
		assertEquals("1", listHead.getValue());
		assertEquals(null, listHead.getNext());
		assertEquals(null, listHead.getPrev());
		assertEquals(listHead, listTail);
		System.out.println(list);
		
	}
	
	@Test
	void insertElementAtPositionLastToListWithExistingItemsTest() {
		DoublyLinkedList list = getList(2);
		list.insertAtPosition(3, "3");
		Node listHead = list.getHead();
		Node listTail = list.getTail();

		assertEquals(3,list.getCount());
		assertEquals("3", listTail.getValue());
		assertEquals(listHead.getNext(), listTail.getPrev());
		System.out.println(list);
	}
	
	@Test
	void insertElementAtPositionInvalidToListWithExistingItemsTest() {
		DoublyLinkedList list = getList(2);
		assertThrows(IllegalArgumentException.class, () -> list.insertAtPosition(-1, "-1"), "No negative positions allowed.");
		System.out.println(list);
	}
	
	@Test
	void insertElementAtPositionCloserToTheFrontToListWithExistingItemsTest() {
		DoublyLinkedList list = getList(2);
		list.insertAtPosition(1, "0");
		Node listHead = list.getHead();
		Node listTail = list.getTail();
		
		assertEquals(list.getCount(),3);
		assertEquals(listHead.getNext(), listTail.getPrev());
		assertEquals(listHead.getNext().getValue(), "0");
		System.out.println(list);
	}
	
	@Test
	void insertElementAtPositionCloserToTheEndToListWithExistingItemsTest() {
		DoublyLinkedList list = getList(4);
		list.insertAtPosition(3, "0");
		Node listTail = list.getTail();
		
		assertEquals(list.getCount(),5);
		assertEquals(listTail.getPrev().getValue(), "0");
		System.out.println(list);
	}

	@Test
	void getElementAtEachPositionTest() {
		DoublyLinkedList list = getList(4);
		System.out.println("List = "+list);
		
		for (int i = 0; i < 4; i++) {
			String elementAtPosition = list.getElementAtPosition(i);	
			assertEquals(Integer.toString(i+1), elementAtPosition);
			System.out.println("List[" + i + "] = " + elementAtPosition);
			
		}
	}

	@Test
	void replaceElementAtEachPositionTest() {
		DoublyLinkedList list = getList(4);
		System.out.println("List = "+list);
		
		for (int i = 0; i < 4; i++) {
			String elementAtPosition = list.getElementAtPosition(i);	
			assertEquals(Integer.toString(i+1), elementAtPosition);
			System.out.println("List[" + i + "] = " + elementAtPosition);

			list.replaceAtPosition(i, "Replaced: " + Integer.toString(i));
			elementAtPosition = list.getElementAtPosition(i);
			System.out.println("ReplacedList[" + i + "] = " + elementAtPosition);
			assertEquals("Replaced: " + Integer.toString(i),elementAtPosition);
		}
		
		System.out.println("ReplacedList = " + list);
	}
	
	@Test
	void checkIfExistingElementIsInListTest() {
		DoublyLinkedList list = getList(4);
		for (int i = 0; i < list.getCount(); i++) {	
			assertEquals(true, list.contains(Integer.toString(i+1)));
		}
		System.out.println(list);
	}
	
	@Test
	void checkIfNonExistingElementIsInListTest() {
		DoublyLinkedList list = getList(4);
		for (int i = 0; i < list.getCount(); i++) {			
			assertEquals(false, list.contains("false string"));
		}
		System.out.println(list);
	}
	
	@Test
	void removeExistingElementAtPositionFirstFromListTest() {
		DoublyLinkedList list = getList(1);
		list.remove("1");
		
		assertEquals(2, list.getCount());
		assertEquals(false, list.contains("1"));
		System.out.println(list);
		
	}
	
	@Test
	void removeExistingElementAtPositionLastFromListTest() {
		DoublyLinkedList list = getList(3);
		list.remove("3");
		
		assertEquals(2, list.getCount());
		assertEquals(false, list.contains("3"));
		System.out.println(list);
		
	}
	
	@Test
	void removeExistingElementAtPositionMiddleFromListTest() {
		DoublyLinkedList list = getList(3);
		list.remove("2");
		
		assertEquals(2, list.getCount());
		assertEquals(false, list.contains("2"));
		System.out.println(list);
		
	}
	
	@Test
	void removeNonExistingElementFromListTest() {
		DoublyLinkedList list = getList(3);
		list.remove("non existing");
		
		assertEquals(3, list.getCount());
		assertEquals(false, list.contains("non existing"));
		System.out.println(list);
		
	}
	
	private DoublyLinkedList getList() {
		return new DoublyLinkedList();
	}
	
	private DoublyLinkedList getList(int ammountOfElements) {
		DoublyLinkedList list = this.getList();
		for (int i = ammountOfElements; i > 0; i--) {
			list.insert(Integer.toString(i));
		}
		return list;
	}
}
