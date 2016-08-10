/* COMP 1406 Summer 2016
 * Assignment 5
 * Problem 5 Chaser
 * Zachary Stroud-Taylor
 * 100955368
 * August 9, 2016
 *
 * Player chases after one other player then continues to follow
 * 
 */

// Player extends Entity
public class Chaser extends Player{
  
  // Play overriden from Entity extended to Player extened to this
  @Override
  public void play(Field field){
    
    // Allocate memory for otherX and otherY
    double otherX = 0;
    double otherY = 0;
    
    // Set otherX and otherY dependent on team  
    Player firstTeam = (Player) field.getTeam1().get(0);
    Player secondTeam = (Player) field.getTeam2().get(0);
    if (this.getTeam().equals(firstTeam.getTeam())){
      otherX = field.getTeam2().get(0).getX();
      otherY = field.getTeam2().get(0).getY(); 
    }
    if (this.getTeam().equals(secondTeam.getTeam())){
      otherX = field.getTeam1().get(0).getX();
      otherY = field.getTeam1().get(0).getY();
    }
    
      // Allocate memory and calculate new speeds
      double newSpeedX = (otherX - this.x);
      double newSpeedY = (otherY - this.y);
      

      // Modify speedX and speedY at the same rate 
      // until speeds are in a reasonable range
      while (newSpeedX > 3 || newSpeedY > 3 ||newSpeedX < -3 || newSpeedY < -3){
        if( newSpeedX > 3 ){newSpeedX *= .5;}
        if( newSpeedY > 3 ){newSpeedY *= .5;}
        if( newSpeedX < -3 ){newSpeedX *= .5;}
        if( newSpeedY < -3 ){newSpeedY *= .5;} 
      }
            
      // Update speedX and speedY
      this.speedX = newSpeedX; 
      this.speedY = newSpeedY;          
    }
  
   
  // Update overriden from Entity extended to Player extened to this
  @Override
  public void update(Field field){}
  
  
 // Chaser constructor everything passed to super classes Player and Entity
   /* @param f is the field the player will be playing on
    * @param side is the side of the field the player will play on
    * @param name is this player's name 
    * @param number is this player's number
    * @param team is this player's team's name
    * @param symbol is a character representation of this player
    * @param x is the initial x position of this player
    * @param y is the initial y position of this player
    */
  public Chaser(Field field, int side, String name, int number, String team, char symbol, double x, double y){
    super(field, side, name, number, team, symbol, x, y);
  }
  

}