package Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import application.Item;
import application.Project;

public class ProjectTest {
	
	private Project testPro;

	@Before
	public void setUp() throws Exception {
		testPro = new Project("Test");
		
	}

	@Test
	public void testGetters() {
		ArrayList<Item> list = new ArrayList<Item>();
		assertEquals("Wrong Name!", "Test", testPro.getName());
		assertEquals("Incorrect Items List!", list, testPro.getItemsList());
	}
	
	@Test
	public void testSetters() {
		testPro.setName("NewName");
		assertEquals("Wrong Name!", "NewName", testPro.getName());
	}
	
	@Test //!!!!!!!!!!!!!!!!!!!!NOT WORKING!!!!!!!!!!!!!!!!!!!!!!!
	public void testAdd_GetItem() {
		Item item = new Item("Doc", "New doc", "new.doc");
		testPro.addItem(item);
		assertEquals("Item Not Added!", item, testPro.getItem(item));
	}
	
	@Test //!!!!!!!!!!!!!!!!!!!!NOT WORKING!!!!!!!!!!!!!!!!!!!!!!!
	public void testRemoveItem_GetItemsList() {
		Item item = new Item("Doc", "New doc", "new.doc");
		testPro.addItem(item);
		assertEquals("Item Not Added!", 1, testPro.getItemsList().size());
		testPro.removeItem(item);
		assertEquals("Item not removed!", 0, testPro.getItemsList().size());
	}
	

}
