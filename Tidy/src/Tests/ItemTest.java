package Tests;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import application.Item;

/**
 * Tests the methods of the Item class.
 * @author Amelia
 */
public class ItemTest {

	/**
	 * The Item object to run tests with.
	 */
	private Item testItem;

	/**
	 * Constructs the Item object.
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		File f = new File("file.txt");
		testItem = new Item("Doc", "Desc", f);
	}

	/**
	 * Tests getName and setName methods for an Item object.
	 */
	@Test
	public void testSet_GetName() {
		testItem.setName("NewName");
		assertEquals("Wrong Name!", "NewName", testItem.getName());
	}
	
	/**
	 * Tests the getDescription and setDescription methods for an Item object.
	 */
	@Test
	public void testSet_GetDescription() {
		testItem.setDescription("NewDescription");
		assertEquals("Wrong Name!", "NewDescription", testItem.getDescription());
	}

}
