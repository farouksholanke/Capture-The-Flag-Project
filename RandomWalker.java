/* COMP 1406 Summer 2016
 * Assignment 5
 * Problem 4 RandomWalker
 * Zachary Stroud-Taylor
 * 100955368
 * August 9, 2016
 *
 * Player moces randomly and bounces off walls
 * 
 */

// Player extends Entity
public class RandomWalker extends Player{
  
  // Play overriden from Entity extended to Player extened to this
  @Override
  public void play(Field field){
    if (this.x <= field.minX+1){this.x = field.minX+1; this.speedX *= -1; }
    if (this.x >= field.maxX-16){this.x = field.maxX-16; this.speedX *= -1;}
    if (this.y <= field.minY+1){this.y = field.minY+1; this.speedY *= -1;}
    if (this.y >= field.maxY-16){this.y = field.maxY-16; this.speedY *= -1;}
    
    if( Math.random() < 0.005){
      this.speedX *= -1;
    }
    if( Math.random() < 0.005){
      this.speedY *= -1;
    }
    
  }
  
  
  // Update overriden from Entity extended to Player extened to this
  @Override
  public void update(Field field){}
  
  
  // Random Walker constructor everything but speedX and speedY passed to super classes Player and Entity
   /* @param f is the field the player will be playing on
    * @param side is the side of the field the player will play on
    * @param name is this player's name 
    * @param number is this player's number
    * @param team is this player's team's name
    * @param symbol is a character representation of this player
    * @param x is the initial x position of this player
    * @param y is the initial y position of this player
    */
  public RandomWalker(Field field, int side, String name, int number, String team,char symbol, double x, double y){
    super(field, side, name, number, team, symbol, x, y);
    this.speedX = Math.random()*3;
    this.speedY = Math.random()*3;
  }

  
}