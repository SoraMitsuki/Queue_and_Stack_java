package hw4;
/**
 * Name: Jiaqi Fan
 * ID: A12584051
 * Login: cs12sju
 * Date: 4/18/2016
 */

/**
 * The location class that return location in the position
 * @author Jiaqi Fan
 * @version 1.0
 * @since 4/18/2016
 */
public class Location {

  protected int row; //number of row
  protected int column; // number of collumn
/**
 * ctor that create a location object that contain row and col
 * @param currRow the current row
 * @param currCol the current column
 * 
 */
  public Location(int currRow, int currCol) {
    row = currRow; //set the para value to instant
    column = currCol;
  }
/**
 * getter for the row
 * @return the row that we are in
 */
  public int getRow() {
    return row; //return the row
  }
  /**
   * getter for the column
   * @return the column that we are in
   */
  public int getColumn() {
    return column; //return the column
  }


  /* LEFT, UP, RIGHT, DOWN */
/**
 * method that return the left location of current
 * @return the left position of the current
 */
  public Location left() {
    return new Location(row,column-1); //return current row but previous column
  }
/**
 * method that return the upper location of current
 * @return the upper position of the current 
 */
  public Location up() {
    return new Location(row-1,column);//return previous row current column
  }
/**
 * method that return the right location of current
 * @return the right position of the current
 */
  public Location right() {
    return new Location(row,column+1);//return current row next column
  }
/**
 * method that return the lower location of current
 * @return the lower position of the current
 */
  public Location down() {
    return new Location(row+1,column);//return next row current column
  }



}
