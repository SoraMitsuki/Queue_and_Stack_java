package hw4;
/**
 * Name: Jiaqi Fan
 * ID: A12584051
 * Login: cs12sju
 * Date: 4/18/2016
 */
import org.junit.*;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;
/**
 * MyStack tester
 * @author Jiaqi Fan
 * @version 1.0
 * @since 4/18/2016
 */
public class MyStackTester {
	private MyStack<Integer> testMS;
	
	@Before
	public void SetUp(){
		testMS = new MyStack<Integer>();
	}
	
	/**
	 * test is empty
	 * return true my stack is empty
	 * false otherwise
	 */
	@Test
	public void testisEmptyMS(){
		assertTrue(testMS.isEmpty()); // in the beginning list is empty
		testMS.addElement(0); //add a element list should not be empty
		assertFalse(testMS.isEmpty()); // test again
		testMS.removeElement();
	}
	/**
	 * test size
	 * return the current list size
	 */
	@Test
	public void testsizeMS(){
		assertTrue(testMS.isEmpty()); //list is empty
		testMS.addElement(0); //add a element
		assertFalse(testMS.isEmpty()); //list is not empty
		assertEquals(1, testMS.size()); //size should be 1
		testMS.removeElement();
	}
	/**
	 * test addElement
	 * list should return 1 if i added a 1 into list
	 */
	@Test
	public void testaddElement(){
		testMS.addElement(0); // first add 0
		Integer test = testMS.removeElement(); //let test = the removed element
		assertEquals(new Integer(0), test);
	}
	/**
	 * test add first with null pointer exception
	 */
	@Test(expected = NullPointerException.class)
	public void testaddElementNPE(){
		testMS.addElement(null); //add a null item
		//test should fail
		fail("add null item to my stack should throw a null pointer exception");
	}
	/**
	 * test remove element
	 * add few elements and remove it
	 */
	@Test
	public void testremoveElement(){
		testMS.addElement(1);
		testMS.addElement(0); //add 3 elements to the list
		for(int i = 0; i < 2; i++){
			Integer first = testMS.removeElement(); //remove the from list
			assertEquals(new Integer(i), first);// check every time
		}
	}
	/**
	 * test remove first with no such elements
	 */
	@Test(expected = NoSuchElementException.class)
	public void testremoveElementNSEE(){
		assertTrue(testMS.isEmpty()); //see the list is empty or not
		testMS.removeElement(); //remove stuff from empty list
		fail("list was empty can not remove null"); //test should fail
	}
}
