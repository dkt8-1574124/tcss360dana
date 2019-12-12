package Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import application.Item;
import application.Project;
 
/**
 * Tests the methods of the Project class.
 * @author Amelia
 */
public class ProjectTest {
	
	/** The Proejct object to be used in testing. */
	private Project testPro;

	/**
	 * Constructs the Project object to be used for testing.
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		testPro = new Project("Test");
		
	}

	/**
	 * Tests getName and getItemList methods for the Project object.
	 */
	@Test
	public void testGetters() {
		ArrayList<Item> list = new ArrayList<Item>();
		assertEquals("Wrong Name!", "Test", testPro.getName());
		assertEquals("Incorrect Items List!", list, testPro.getItemsList());
	}
	
	/**
	 * Tests setName method for the Project object.
	 */
	@Test
	public void testSetters() {
		testPro.setName("NewName");
		assertEquals("Wrong Name!", "NewName", testPro.getName());
	}
	
	/**
	 * Tests the addItem and getItem methods for the Project object.
	 */
	@Test 
	public void testAdd_GetItem() {
		Item item = new Item("Doc", "New doc", "new.doc");
		testPro.addItem(item);
		assertEquals("Item Not Added!", item, testPro.getItem("Doc"));
	}
	
	/**
	 * Tests the removeItem and getItemsList and getSize methods for the Project object.
	 */
	@Test 
	public void testRemoveItem_GetItemsList() {
		Item item = new Item("Doc", "New doc", "new.doc");
		testPro.addItem(item);
		assertEquals("Item Not Added!", 1, testPro.getSize());
		testPro.removeItem(item);
		assertEquals("Item not removed!", 0, testPro.getSize());
	}
	
	/**
	 * Tests the getItem method for the Project object.
	 */
	@Test
	public void testFindItem() {
		assertEquals("Found Item!", null, testPro.getItem("Pic"));
		Item item = new Item("Pic", "New pic", "new.jpg");
		testPro.addItem(item);
		assertEquals("Didnt Find Item!", item, testPro.getItem("Pic"));
	}
}
