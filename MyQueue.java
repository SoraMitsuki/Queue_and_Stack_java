package hw4;
/**
 * Name: Jiaqi Fan
 * ID: A12584051
 * Login: cs12sju
 * Date: 4/18/2016
 */
import java.util.NoSuchElementException;
/**
 * @author Jiaqi Fan
 * @version 1.0
 * @since 4/18/2016
 * @param <E> the element that can be replaces
 */
public class MyQueue<E> implements Stack_QueueInterface<E> {

	private int index;
	private E[] myArray;
	private int size, front, back;
	/**
	 * ctor to create a new MyQueue object
	 * @supresswarning when cast array to E
	 */
	@SuppressWarnings("unchecked")
	public MyQueue(){
		size = 10;
		index = 0;
		front = 0;
		back = 0;
		myArray = (E[]) new Object[size];
	}
	
	/**
	 * check the stack is empty or not
	 * @return true for empty
	 * @return false for not empty
	 */
	@Override
	public boolean isEmpty() {
		if(index == 0){
			return true;
		}
		else{
			return false;
		}
	}

	/**
	 * add the element to the queue
	 * @param E the newItem that need added
	 * @suppresswarning when cast array to E
	 */
	@SuppressWarnings({"unchecked"})
	@Override
	public void addElement(E newItem){
		if(newItem == null){
			throw new NullPointerException();
		}
		if((index > 0 && front == back) == true){ //when back is catch up with front
			back = size; //the list is considered full
			size = size*2; // new size is the double of the old
			E[] newMyArray = (E[]) new Object[size];
			System.arraycopy(myArray, 0, newMyArray, 0, myArray.length); //copy array
			myArray = newMyArray; 
		}
		myArray[back] = newItem; //add element
		index++; //increase list size
		back = (back + 1) % myArray.length; //calculate the new back
	}

	/**
	 * method that remove the last element
	 * @return return the element that been removed
	 * @throws no such element exception
	 */
	@Override
	public E removeElement() throws NoSuchElementException{
		if(isEmpty() == true){ //check for the list is empty or not
			throw new NoSuchElementException();
		}
		E rmElement = myArray[front]; //the element that need returned
		front = (front + 1) % myArray.length; //calculate  new front
		index--; //size decrease
		return rmElement;
	}

	/**
	 * method return the current size
	 * @return the size which is int
	 */
	@Override
	public int size() {
		return index;
	}
	

}
