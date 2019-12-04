package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import application.Item;

public class ItemTest {

	private Item testItem;

	@Before
	public void setUp() throws Exception {
		testItem = new Item("Doc", "New doc", "new.doc");
		
	}

	@Test
	public void testSet_GetName() {
		testItem.setName("NewName");
		assertEquals("Wrong Name!", "NewName", testItem.getName());
	}
	
	@Test
	public void testSet_GetDescription() {
		testItem.setDescription("NewDescription");
		assertEquals("Wrong Name!", "NewDescription", testItem.getDescription());
	}

}
