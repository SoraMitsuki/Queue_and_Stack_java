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
 * DoubleEndedLL tester
 * @author Jiaqi Fan
 * @version 1.0
 * @since 4/18/2016
 */
public class DoubleEndedLLTester {
	private DoubleEndedLL<Integer> testList;
	
	@Before
	public void setUp(){
		testList = new DoubleEndedLL<Integer>();
	}
	/**
	 * test isEmpty()
	 * return true when list is empty
	 * else return false
	 */
	@Test
	public void testisEmpty(){
		assertTrue(testList.isEmpty()); // in the beginning list is empty
		testList.addFirst(0); //add a element list should not be empty
		assertFalse(testList.isEmpty()); // test again
		testList.removeFirst();
	}
	/**
	 * test size
	 * return the current list size
	 */
	@Test
	public void testsize(){
		assertTrue(testList.isEmpty()); //list is empty
		testList.addFirst(0); //add a element
		assertFalse(testList.isEmpty()); //list is not empty
		assertEquals(1, testList.size()); //size should be 1
		testList.removeFirst();
	}
	/**
	 * test addFirst
	 * list should return 1 if i added a 1 into list
	 */
	@Test
	public void testaddFirst(){
		testList.addFirst(0); // first add 0
		testList.addFirst(1); // then add 1 now 1 is the new head
		Integer test = testList.removeFirst(); //let test = the removed element
		assertEquals(new Integer(1), test);
		Integer test2 = testList.removeFirst(); //remove again
		assertEquals(new Integer(0), test2); // removed element should be 0
	}
	/**
	 * test add first with null pointer exception
	 */
	@Test(expected = NullPointerException.class)
	public void testaddFirstNPE(){
		testList.addFirst(null); //add a null item
		//test should fail
		fail("add null item to list should throw a null pointer exception");
	}
	/**
	 * test addLast
	 * list should return the element that added to the list
	 */
	@Test
	public void testaddLast(){
		testList.addLast(0); //first add 0 
		testList.addLast(1);// then add 1, now 1 is the new tail 
		Integer test = testList.removeLast(); //remove the last
		assertEquals(new Integer(1), test); // it should be 0 the last element
		Integer test2 = testList.removeLast();//remove again
		assertEquals(new Integer(0), test2); //then it should be 1
	}
	/**
	 * test add last with null pointer exception
	 */
	@Test(expected = NullPointerException.class)
	public void testaddLastNPE(){
		testList.addLast(null); //add null to list
		//test fails
		fail("add a null item to the list should throw a null pointer exception");
	}	
	/**
	 * test remove first
	 * add few elements and remove it
	 */
	@Test
	public void testremoveFirst(){
		testList.addFirst(2);
		testList.addFirst(1);
		testList.addFirst(0); //add 3 elements to the list
		for(int i = 0; i < 3; i++){
			Integer first = testList.removeFirst(); //remove the from list
			assertEquals(new Integer(i), first);// check every time
		}
	}
	/**
	 * test remove first with no such elements
	 */
	@Test(expected = NoSuchElementException.class)
	public void testremoveFirstNSEE(){
		assertTrue(testList.isEmpty()); //see the list is empty or not
		testList.removeFirst(); //remove stuff from empty list
		fail("list was empty can not remove null"); //test should fail
	}
	
	/**
	 * test remove last
	 * add few elements and remove it
	 */
	@Test
	public void testremoveLast(){
		assertTrue(testList.isEmpty());
		testList.addLast(2);
		testList.addLast(1);
		testList.addLast(0); //add 3 elements to the list
		for(int i = 0; i < 3; i++)
		{
			Integer last = testList.removeLast();//remove the element
			assertEquals(new Integer(i), last); //check every time
		}
	}
	/**
	 * test remove last with no such elements
	 */
	@Test(expected = NoSuchElementException.class)
	public void testremovelastNSEE(){
		assertTrue(testList.isEmpty());
		testList.removeLast();
		fail("list was empty can not remove null");
	}
}
