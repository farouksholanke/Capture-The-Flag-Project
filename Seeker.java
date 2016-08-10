/* COMP 1406 Summer 2016
 * Assignment 5
 * Problem 3 Seeker
 * Zachary Stroud-Taylor
 * 100955368
 * August 9, 2016
 *
 * Player heads towards flag and stops when it arrives
 * 
 */

// Player extends Entity 
public class Seeker extends Player{
  
  
  // Play overriden from Entity extended to Player extened to this
  @Override
  public void play(Field field){
    
    // Call function to make sure player is not out of bounds
    // Function similar to Stopping player (implemented at bottom)
    this.stopping(field);
    
    // Allocate space for flagX and flagY
    double flagX = 0;
    double flagY = 0;
    
    // Set flagX and flagY to appropriate
    // coordinates depedent on team 
    Player firstTeam = (Player) field.getTeam1().get(0);
    Player secondTeam = (Player) field.getTeam2().get(0);
    if (this.getTeam().equals(firstTeam.getTeam())){
      flagX = field.getFlag2Position()[0];
      flagY = field.getFlag2Position()[1];
    }
    if (this.getTeam().equals(secondTeam.getTeam())){
      flagX = field.getFlag1Position()[0];
      flagY = field.getFlag1Position()[1];
    }
    
    // Get slope of player relative the flag (X2 - X1 / Y2 - Y1)
    double slopeRatio = (flagX - this.x)/(flagY - this.y);
    
    // Apply ratio to speed
    this.speedX = this.speedY * slopeRatio;
    
    // Check if x or y coordinate needs to be 
    // inverted but only if not already inverted
    if (this.x > flagX && this.speedX > 0){
      this.speedX = this.speedX * -1.0;
    }
    if (this.y > flagY && this.speedY > 0){
      this.speedY = this.speedY * -1.0;
    }
    
    // Check if player has arrived at flag if so, then stop
    if (this.pickUpFlag(field)){
      this.speedX = 0; 
      this.speedY = 0;  
      field.pickUpFlag(this);
    }
    
  }
  
  
  // Update overriden from Entity extended to Player extened to this
  @Override
  public void update(Field field){}
  

  // Seeker constructor everything but speedX and speedY passed to super classes Player and Entity
   /* @param f is the field the player will be playing on
    * @param side is the side of the field the player will play on
    * @param name is this player's name 
    * @param number is this player's number
    * @param team is this player's team's name
    * @param symbol is a character representation of this player
    * @param x is the initial x position of this player
    * @param y is the initial y position of this player
    */
  public Seeker(Field field, int side, String name, int number, String team, char symbol, double x, double y){
    super(field, side, name, number, team, symbol, x, y);
    this.speedX = Math.random()*3;
    this.speedY = Math.random()*3;
  }
  
  
  // Checks if player is going out of bounds and stops them if they are
  private void stopping(Field field){
    if (this.x < field.minX+1){this.x = field.minX+1; this.speedX = 0; this.speedY = 0;}
    else if (this.x > field.maxX-16){this.x = field.maxX-16; this.speedX = 0; this.speedY = 0;}
    else if (this.y < field.minY+1){this.y = field.minY+1; this.speedX = 0; this.speedY = 0;}
    else if (this.y > field.maxY-16){this.y = field.maxY-16; this.speedX = 0; this.speedY = 0;}
  }
   
  
}