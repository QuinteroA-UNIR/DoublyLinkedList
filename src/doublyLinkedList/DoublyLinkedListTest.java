package doublyLinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

/**
 * Test Methods for the DoublyLinkedList class.
 * @author Arnaldo Quintero Segura
 *
 */
class DoublyLinkedListTest {

	@Test
	void listCreationTest() {
		DoublyLinkedList list = getList();
		assertEquals(0, list.getCount());
		assertEquals(null, list.getHead());
		System.out.println(list);
	}
	
	@Test
	void getListCountFromEmptyListTest() {
		DoublyLinkedList list = getList();
		assertEquals(0, list.getCount());
	}
	
	@Test
	void getListCountFromListWithOnlyOneElementTest() {
		DoublyLinkedList list = getList(1);
		assertEquals(1, list.getCount());
	}
	
	@Test
	void getListCountFromListWithSeveralElementsTest() {
		int numberOfElements = 4;
		DoublyLinkedList list = getList(numberOfElements);
		assertEquals(numberOfElements, list.getCount());
	}
	
	@Test
	void getHeadElementFromListWithOnlyOneElementTest() {
		DoublyLinkedList list = getList(1);
		String head = list.getHead();
		assertEquals("1", head);
	}
	
	@Test
	void getHeadElementFromListWithSeveralElementsTest() {
		DoublyLinkedList list = getList(4);
		String head = list.getHead();
		assertEquals("1", head);
	}
	
	@Test
	void getTailElementFromListWithOnlyOneElementTest() {
		DoublyLinkedList list = getList(1);
		String tail = list.getTail();
		assertEquals("1", tail);
	}
	
	@Test
	void getTailElementFromListWithSeveralElementsTest() {
		DoublyLinkedList list = getList(4);
		String tail = list.getTail();
		assertEquals("4", tail);
	}
	
	@Test
	void getExistingElementAtEachPositionFromListTest() {
		DoublyLinkedList list = getList(4);
		System.out.println("List = "+list);
		
		for (int i = 0; i < 4; i++) {
			String elementAtPosition = list.getElementAtPosition(i);	
			assertEquals(Integer.toString(i+1), elementAtPosition);
			System.out.println("List[" + i + "] = " + elementAtPosition);
			
		}
	}
	
	@Test
	void getNonExistingElementFromListTest() {
		DoublyLinkedList list = getList(4);
		System.out.println("List = "+list);
		assertThrows(IllegalArgumentException.class, () -> list.getElementAtPosition(10), "Invalid position.");
	}
	
	@Test
	void getNonExistingElementFromEmptyListTest() {
		DoublyLinkedList list = getList();
		System.out.println("List = "+list);
		assertThrows(IllegalArgumentException.class, () -> list.getElementAtPosition(10), "Invalid position.");
	}
	
	@Test
	void printEmptyListTest() {
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		 System.setOut(new PrintStream(outContent));
		 DoublyLinkedList list = getList();
		 list.print();
		 assertEquals("Empty List\n", outContent.toString());
	}
	
	@Test
	void printListWithOnlyOneElementTest() {
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		 System.setOut(new PrintStream(outContent));
		 DoublyLinkedList list = getList(1);
		 list.print();
		 assertEquals("[ 1 ]\n", outContent.toString());
	}
	
	@Test
	void printListWithMoreThanOneElementTest() {
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		 System.setOut(new PrintStream(outContent));
		 DoublyLinkedList list = getList(4);
		 list.print();
		 assertEquals("[ 1, 2, 3, 4 ]\n", outContent.toString());
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
	void insertElementToEmptyListTest() {

		DoublyLinkedList list = getList();
		list.insert("1");
		String listHead = list.getHead();
		String listTail = list.getTail();

		assertEquals(1,list.getCount());
		assertEquals("1", listHead);
		assertEquals(listHead, listTail);
		System.out.println(list);
	}
	
	@Test
	void insertElementToListWithOneExistingItemTest() {

		DoublyLinkedList list = getList(1);
		list.insert("2");
		String listHead = list.getHead();
		String listTail = list.getTail();

		assertEquals(2,list.getCount());
		assertEquals("2", listHead);
		assertEquals("1", listTail);
		System.out.println(list);
		
	}
	
	@Test
	void insertElementToListWithExistingItemsTest() {

		DoublyLinkedList list = getList(2);
		list.insert("3");
		String listHead = list.getHead();
		String listTail = list.getTail();

		assertEquals(3,list.getCount());
		assertEquals("3", listHead);
		assertEquals("2", listTail);
		System.out.println(list);
	}
	
	@Test
	void insertElementAtPositionFirstToEmptyListTest() {
		DoublyLinkedList list = getList();
		list.insertAtPosition(0, "1");
		String listHead = list.getHead();
		String listTail = list.getTail();

		assertEquals(1,list.getCount());
		assertEquals("1", listHead);
		assertEquals(listHead, listTail);
		System.out.println(list);
	}
	
	@Test
	void insertElementAtPositionFirstToListWithExistingItemsTest() {
		DoublyLinkedList list = getList(2);
		list.insertAtPosition(0, "0");
		String listHead = list.getHead();

		assertEquals(3,list.getCount());
		assertEquals("0", listHead);
		System.out.println(list);
	}
	
	@Test
	void insertElementAtPositionLastToEmptyListTest() {
		DoublyLinkedList list = getList();
		list.insertAtPosition(1, "1");
		String listHead = list.getHead();
		String listTail = list.getTail();

		assertEquals(1,list.getCount());
		assertEquals("1", listHead);
		assertEquals(listHead, listTail);
		System.out.println(list);
		
	}
	
	@Test
	void insertElementAtPositionLastToListWithExistingItemsTest() {
		DoublyLinkedList list = getList(2);
		list.insertAtPosition(3, "3");
		String listTail = list.getTail();

		assertEquals(3,list.getCount());
		assertEquals("3", listTail);
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
		
		assertEquals(3, list.getCount());
		assertEquals("0", list.getElementAtPosition(1));
		System.out.println(list);
	}
	
	@Test
	void insertElementAtPositionCloserToTheEndToListWithExistingItemsTest() {
		DoublyLinkedList list = getList(4);
		list.insertAtPosition(3, "0");
		
		assertEquals(5, list.getCount());
		assertEquals("0", list.getElementAtPosition(3));
		System.out.println(list);
	}
	
	@Test
	void appendElementToEmptyListTest() {

		DoublyLinkedList list = getList();
		list.append("1");
		String listHead = list.getHead();
		String listTail = list.getTail();

		assertEquals(1,list.getCount());
		assertEquals("1", listTail);
		assertEquals(listHead, listTail);
		System.out.println(list);
	}		
	
	@Test
	void appendElementToListWithOneExistingItemTest() {

		DoublyLinkedList list = getList(1);
		list.append("2");
		String listHead = list.getHead();
		String listTail = list.getTail();

		assertEquals(2,list.getCount());
		assertEquals("1", listHead);
		assertEquals("2", listTail);
		System.out.println(list);
		
	}
	
	@Test
	void appendElementToListWitExistingItemsTest() {

		DoublyLinkedList list = getList(2);
		list.append("3");
		String listHead = list.getHead();
		String listTail = list.getTail();

		assertEquals(3,list.getCount());
		assertEquals("1", listHead);
		assertEquals("3", listTail);
		System.out.println(list);
		
	}
	
	@Test
	void replaceElementAtEachPositionFromListTest() {
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
	void replaceNonExistingElementFromEmptyListTest() {
		DoublyLinkedList list = getList();
		System.out.println("List = "+list);
		assertThrows(IllegalArgumentException.class, () -> list.replaceAtPosition(10, "false replace"), "Invalid position.");
	}

	@Test
	void replaceNonExistingElementFromListTest() {
		DoublyLinkedList list = getList(4);
		System.out.println("List = "+list);
		assertThrows(IllegalArgumentException.class, () -> list.replaceAtPosition(10, "false replace"), "Invalid position.");
	}	
	
	@Test
	void removeExistingElementFromListWithOnlyOneElementTest() {
		DoublyLinkedList list = getList(1);
		list.remove("1");
		assertEquals(0, list.getCount());
		assertEquals(false, list.contains("1"));
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
	
	@Test
	void removeNonExistingElementFromListWithOnlyOneElementTest() {
		DoublyLinkedList list = getList();
		list.remove("1");
		assertEquals(0, list.getCount());
		assertEquals(false, list.contains("1"));
		System.out.println(list);
	}
	
	@Test
	void removeExistingElementAtPositionFirstFromListTest() {
		DoublyLinkedList list = getList(3);
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
	void removeFromPositionExistingElementAtPositionFirstFromListTest() {
		DoublyLinkedList list = getList(3);
		String removedElement = list.removeAtPosition(0);
		
		assertEquals("1", removedElement);
		assertEquals(2, list.getCount());
		assertEquals(false, list.contains(removedElement));
		System.out.println(list);
	}
	
	@Test
	void removeFromPositionExistingElementAtPositionLastFromListTest() {
		DoublyLinkedList list = getList(3);
		String removedElement = list.removeAtPosition(2);
		
		assertEquals("3", removedElement);
		assertEquals(2, list.getCount());
		assertEquals(false, list.contains(removedElement));
		System.out.println(list);
	}
	
	@Test
	void removeFromPositionExistingElementAtPositionMiddleFromListTest() {
		DoublyLinkedList list = getList(3);
		String removedElement = list.removeAtPosition(1);
		
		assertEquals("2", removedElement);
		assertEquals(2, list.getCount());
		assertEquals(false, list.contains(removedElement));
		System.out.println(list);
	}
	
	@Test
	void removeFromPositionNonExistingElementFromListTest() {
		DoublyLinkedList list = getList(3);
		assertThrows(IllegalArgumentException.class, () -> list.removeAtPosition(10), "Invalid position.");
		System.out.println(list);
	}
	
	@Test
	void removeFromPositionNonExistingElementFromListWithOnlyOneElementTest() {
		DoublyLinkedList list = getList(1);
		String removedElement = list.removeAtPosition(0);
		
		assertEquals("1", removedElement);
		assertEquals(0, list.getCount());
		assertEquals(false, list.contains(removedElement));
		System.out.println(list);
	}
	
	@Test
	void removeFromPositionNonExistingElementFromEmptyListTest() {
		DoublyLinkedList list = getList(0);
		assertThrows(IllegalArgumentException.class, () -> list.removeAtPosition(10), "Invalid position.");
		System.out.println(list);
	}
	
	@Test
	void concatTwoListsWithElementsTest() {
		DoublyLinkedList list = getList(2);
		DoublyLinkedList list2 = getList(3);
		
		list.concat(list2);
		assertEquals(5, list.getCount());
		assertEquals(list.getTail(), list2.getTail());
		System.out.println(list);
	}
	
	@Test
	void concatListsWithEmptyListTest() {
		DoublyLinkedList list = getList(1);
		DoublyLinkedList list2 = getList();
		
		list.concat(list2);
		assertEquals(1, list.getCount());
		System.out.println(list);
	}
	
	@Test
	void concatTwoEmptyListsTest() {
		DoublyLinkedList list = getList();
		DoublyLinkedList list2 = getList();
		
		list.concat(list2);
		assertEquals(0, list.getCount());
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
