package doublyLinkedList;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Test Methods for the Node class.
 * @author Arnaldo Quintero Segura
 *
 */
class NodeTest {

	@Test
	void nodeCreationTest() {
		Node node = new Node("node");
		assertEquals("node",node.getValue());
		assertEquals(null,node.getPrev());
		assertEquals(null,node.getNext());
	}
	
	@Test
	void nodeSetPreviousNodeTest() {
		Node node1 = new Node("node 1");
		Node node2 = new Node("node 2");
		node1.setPrev(node2);
		assertEquals(node2, node1.getPrev());
	}
	
	@Test
	void nodeSetNextNodeTest() {
		Node node1 = new Node("node 1");
		Node node2 = new Node("node 2");
		node1.setNext(node2);
		assertEquals(node2, node1.getNext());
	}

}
