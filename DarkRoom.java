package hw4;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Name: Jiaqi Fan
 * ID: A12584051
 * Login: cs12sju
 * Date: 4/18/2016
 */
/**
 * the DarkRoom class that take the input of some room txt and
 * try find door to exit the room
 * @author Jiaqi Fan
 * @version 1.0
 * @since 4/18/2016
 */
public class DarkRoom implements DarkRoomInterface {

  protected char [][] darkRoom;
  protected int numRows=0;
  protected int numCols;
  protected char visited = '.'; //initialize the marked no magic value
  protected char START = 'S';//initialize the START no magic value
  protected char DOOR = 'D';//initialize the DOOR no magic value


  public void readFromFile(String fname) {

    String line; // the current line
    BufferedReader inputStrem; //the reader to read file
    StringTokenizer st; //tokenizing the lines


    try {
      int currentRow = 0; // initialize the current row

      inputStrem = new BufferedReader(new FileReader(fname)); //initialize reader

      while ((line = inputStrem.readLine()) != null) { //read until the last line
        if (numRows == 0) { //check how many rows and column are there
          st = new StringTokenizer(line); 
          //set up the row first char is the first in row
          numRows = Integer.parseInt(st.nextToken()); 
          //set up column
          numCols = Integer.parseInt(st.nextToken());
          darkRoom = new char[numRows][numCols]; //create a 2d array based on the size
        } else if (line.length() == 1) //if line is empty break the loop
          break;
        else {
          for (int c = 0; c < numCols; c++) { //copy the chars to darkroom
            darkRoom[currentRow][c] = line.charAt(c);
          }
          currentRow ++;
        }
      }
    }
    catch (IOException e) { //catch the Io exception
      System.out.println (e.toString()); //print out the error
      System.out.println("Could not find file " + fname); //error file not found
    }

  }


  //Helper methods:
  /**
   * Method that returns the Location of "start"
   * @return return the location of start 
   */
  public Location findStart()
  {
	  Location start = null;
	  for(int i = 1; i < numRows; i++){//loop through every row and col
		  for(int j = 1; j < numCols; j++){ //except the wall layer
			  if(darkRoom[i][j] == START){ //find the start point
				  start = new Location(i,j);
			  }
		  }
	  } 
	  return start;
  }

  /**
   * Method that checks if the goal was found
   * @return true for found door otherwise false
   */
  public boolean isDoor (Location loc)
  {
	  if(locationValue(loc) == DOOR) //if the value at this location is door
	  {
		  return true;  //return true
	  }
	  else
		  return false;
  }
  /**
   * Method that checks if you can move
   * @return true can move other wise false
   */
  public boolean canMove(Location loc)
  {
	  if(locationValue(loc) == ' ' || locationValue(loc) == DOOR ||
		 locationValue(loc) == START){
		  return true;
	  }
	  else
	  return false;
  }
  /**
   * method that Marks explored (visited) positions
   */
  public void markVisited (Location loc)
  {
    darkRoom[loc.getRow()][loc.getColumn()] = visited;
  }

  /**
   * method that counts the number of visited positions
   * @return return the number of visited
   */
  public int countVisited()
  {
	  int countVisit = 0;
	  for(int i = 1; i < numRows; i++){//loop through every row and col
		  for(int j = 1; j < numCols; j++){ //except the wall layer
			  if(darkRoom[i][j] == visited){
				  countVisit++;
			  }
		  }
	  } 
    return countVisit;
  }
  /**
   * method that  removes marks from visiting (removes '.')
   */
  public void clear()
  {
	  for(int i = 1; i < numRows; i++){//loop through every row and col
		  for(int j = 1; j < numCols; j++){ //except the wall layer
			  if(darkRoom[i][j] == visited){
				  darkRoom[i][j] = ' ';
			  }
		  }
	  } 
  }
  /**
   * method that prints your array that represents a room
   */
  public void printRoom()
  {
	  for(int i = 0; i < numRows; i++){ //loop through every row and col
		  for(int j = 0; j < numCols; j++){
			  System.out.print(darkRoom[i][j]);//print out every element
		  }
		  System.out.println();
	  }
  }
  /**
   * method that return the char at location
   * @return the char at that location
   */
  private char locationValue(Location loc){
	  return darkRoom[loc.getRow()][loc.getColumn()];
  }
  /**
   * helper method to find door
   * @return true door is found otherwise false
   */
  private boolean findDoor(Location loc){
	  //check all directions. up down left right
	  if(isDoor(loc.up()) == true ||isDoor(loc.down()) == true ||
		 isDoor(loc.left()) == true ||isDoor(loc.right()) == true){
		  return true;
	  }
	  else
		  return false;
  }
  /**
   * method that check the surrounding and store the value
   * @return return true can add otherwise false 
   */
  private boolean checkSurrounding(Location loc){
	  //check the surrounding that could move to
	  if(canMove(loc) == true && (locationValue(loc) == START
		 || locationValue(loc) == visited) == false){
		  return true;
	  }
	  else
		  return false;
  }
  /**
   * method that store the surrounding of the current location
   * @param stack or queue
   * @param current location
   */
  private void storeSurrounding(Stack_QueueInterface<Location> storage, Location loc){
	  //check for the surroundings
	  if(checkSurrounding(loc.left()) == true){
		  storage.addElement(loc.left()); //add the value at that position
	  }
	  if(checkSurrounding(loc.up()) == true){
		  storage.addElement(loc.up());
	  }
	  if(checkSurrounding(loc.right()) == true){
		  storage.addElement(loc.right());
	  }
	  if(checkSurrounding(loc.down()) == true){
		  storage.addElement(loc.down());
	  }
  }
  /**
   * method that Search for ESCAPE!!!
   * @param choice is the method that we want to use to find the door
   * either stack or queue 
   */
  public void escapeDarkRoom(String choice){
	  Stack_QueueInterface<Location> storage;
	  if("Stack".equals(choice)){
		  storage = new MyStack<Location>(); //choice of stack or queue
	  }
	  else{
		  storage = new MyQueue<Location>();
	  }
	  
	  Location startPoint = findStart(); //find the start and start search
	  Location currentloc; //variable that store current location
	  Boolean canFindDoor = findDoor(startPoint); //check the surroundings of the start point
	  int steps = 0; //the step take to find the door
	  if(canFindDoor == false){ //if the door is not find in the beginning
		  storeSurrounding(storage, startPoint); //store the surroundings 
		  while(storage.isEmpty() == false){ //while there is move avaliable keep search
			  currentloc = storage.removeElement(); //start with the left posiiton
			  while(canMove(currentloc) == true){
				  steps++;
				  markVisited(currentloc); //mark the position
				  canFindDoor = findDoor(currentloc);
				  if(canFindDoor == true){ //check the door for the new position
					  break;
				  }
				  storeSurrounding(storage, currentloc);
			  }
			  if(canFindDoor == true){ //check the door for the new position
				  break; //break the outer while loop
			  }
		  }
		  
	  }
	  if(canFindDoor == true){ //if we found the door then printGoal
		  printGoal(choice, steps, storage.size());
	  }
	  else{
		  System.out.println("There is No Door");
	  }
	  printRoom();
  }

  public void printGoal(String choice, int stepsTaken, int positionsLeft)
  {
    System.out.println("Goal found (with " + choice + "): It took "
        + stepsTaken + " explored positions");
    System.out.println("There is (are) " + positionsLeft
        + " position(s) left to explore in " + choice);

  }

}
