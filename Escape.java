package hw4;

/**
 * Name: Jiaqi Fan
 * ID: A12584051
 * Login: cs12sju
 * Date: 4/18/2016
 */

/**
 * the Escape class actually play the game designed in
 * darkroom class
 * @author Jiaqi Fan
 * @version 1.0
 * @since 4/18/2016
 */
public class Escape {
	public static void main(String[] args){
		String roomFile = args[0];
		String choice = "Stack";
		DarkRoom newGame = new DarkRoom();
		newGame.readFromFile(roomFile);
		newGame.escapeDarkRoom(choice);
		newGame.clear();
		choice = "Queue";
		newGame.escapeDarkRoom(choice);
	}

}
