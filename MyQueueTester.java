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
 * MyQueue tester
 * @author Jiaqi Fan
 * @version 1.0
 * @since 4/18/2016
 */
public class MyQueueTester {
	private MyQueue<Integer> testMQ;
	private int largeSize;
	
	@Before
	public void setUp(){
		testMQ = new MyQueue<Integer>();
		largeSize = 100;
	}
	
	/**
	 * test is empty
	 * return true my queue is empty
	 * false otherwise
	 */
	@Test
	public void testisEmptyMQ(){
		assertTrue(testMQ.isEmpty()); // in the beginning list is empty
		testMQ.addElement(0); //add a element list should not be empty
		assertFalse(testMQ.isEmpty()); // test again
		testMQ.removeElement();
	}
	/**
	 * test size
	 * return the current list size
	 */
	@Test
	public void testsizeMS(){
		assertTrue(testMQ.isEmpty()); //list is empty
		testMQ.addElement(0); //add a element
		assertFalse(testMQ.isEmpty()); //list is not empty
		assertEquals(1, testMQ.size()); //size should be 1
		testMQ.removeElement();
	}
	/**
	 * test addElement
	 * list should return 1 if i added a 1 into list
	 */
	@Test
	public void testaddElement(){
		testMQ.addElement(0); // first add 0
		Integer test = testMQ.removeElement(); //let test = the removed element
		assertEquals(new Integer(0), test);
	}
	/**
	 * test add element over size
	 * Myqueue initialize size is 10, trying to add 100 element
	 */
	@Test
	public void testaddElementOverSize(){
		for(int i = 0; i < largeSize; i++){
			testMQ.addElement(i);
		}
		assertEquals(largeSize,testMQ.size());
	}
	/**
	 * test add first with null pointer exception
	 */
	@Test(expected = NullPointerException.class)
	public void testaddElementNPE(){
		testMQ.addElement(null); //add a null item
		//test should fail
		fail("add null item to my stack should throw a null pointer exception");
	}
	
	/**
	 * test remove element
	 * add few elements and remove it
	 */
	@Test
	public void testremoveElement(){
		testMQ.addElement(0);
		testMQ.addElement(1); //add 3 elements to the list
		for(int i = 0; i < 2; i++){
			Integer first = testMQ.removeElement(); //remove the from list
			assertEquals(new Integer(i), first);// check every time
		}
	}
	/**
	 * test remove first with no such elements
	 */
	@Test(expected = NoSuchElementException.class)
	public void testremoveElementNSEE(){
		assertTrue(testMQ.isEmpty()); //see the list is empty or not
		testMQ.removeElement(); //remove stuff from empty list
		fail("list was empty can not remove null"); //test should fail
	}
}
