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
public class MyStack<E> implements Stack_QueueInterface<E> {
	private DoubleEndedLL<E> myDELL;
	private int index;
	/**
	 * ctor that create a new MyStack
	 */
	public MyStack(){
		myDELL = new DoubleEndedLL<E>();
		index = 0;
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
	 * add the element to the stack
	 * @param newItem the item to ass
	 */
	@Override
	public void addElement(E newItem) {
		if(newItem == null){
			throw new NullPointerException();
		}
		myDELL.addFirst(newItem); //map to the add first item
		index++; //because stacking
	}

	/**
	 * method that remove the first element
	 * @return the element that been removed
	 * @throws No Such Element Exception
	 */
	@Override
	public E removeElement()  throws NoSuchElementException{
		if(myDELL.isEmpty() == true){ //check for the list is empty
			throw new NoSuchElementException();//if is empty can not remove
		}
		E removeE = myDELL.removeFirst(); //set the remove element
		index--; //decrease the size
		return removeE;//return the element
	}

	/**
	 * return the size of the list
	 * @return the size which is int
	 */
	@Override
	public int size() {
		return index; //return the index
	}

}
