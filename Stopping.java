/* COMP 1406 Summer 2016
 * Assignment 5
 * Problem 2 Stopping
 * Zachary Stroud-Taylor
 * 100955368
 * August 9, 2016
 *
 * Player stops when they get to close to the boundary
 * 
 */

// Player extends Entity
public class Stopping extends Player{
  
  // Play overriden from Entity extended to Player extened to this
  @Override
  public void play(Field field){
    
    // Stop player if they get too close to the boundary
    if (this.x < field.minX+1){this.x = field.minX+1; this.speedX = 0; this.speedY = 0;}
    else if (this.x > field.maxX-16){this.x = field.maxX-16; this.speedX = 0; this.speedY = 0;}
    else if (this.y < field.minY+1){this.y = field.minY+1; this.speedX = 0; this.speedY = 0;}
    else if (this.y > field.maxY-16){this.y = field.maxY-16; this.speedX = 0; this.speedY = 0;}
    
   // Invert speed randomly
    else{
      if( Math.random() < 0.0005){
        this.speedX *= -1;
      }
      else if( Math.random() < 0.0005){
        this.speedY *= -1;
      }
    }
  }
  
  
  // Update overriden from Entity extended to Player extened to this
  @Override
  public void update(Field field){}
  

  
  // Stopping constructor everything but speedX and speedY passed to super classes Player and Entity
   /* @param f is the field the player will be playing on
    * @param side is the side of the field the player will play on
    * @param name is this player's name 
    * @param number is this player's number
    * @param team is this player's team's name
    * @param symbol is a character representation of this player
    * @param x is the initial x position of this player
    * @param y is the initial y position of this player
    */
  public Stopping(Field field, int side, String name, int number, String team, char symbol, double x, double y){
    super(field, side, name, number, team, symbol, x, y);
    this.speedX = Math.random()*3;
    this.speedY = Math.random()*3;
  }
  
  
}