/* COMP 1406 Summer 2016
 * Assignment 5
 * Problem 6 Catcher
 * Zachary Stroud-Taylor
 * 100955368
 * August 9, 2016
 *
 * Player chases after one other player then continues movesonto the 
 * next player on the team (looping back to the first after the last)
 * 
 */

// Player extends 
public class Catcher extends Player{
  
  // Fields to keep track of players being chased
  protected static int counter = 0; 
  protected static int otherTeamSize = 0;
  
  
  // Play overriden from Entity extended to Player extened to this
  @Override
  public void play(Field field){
    
    // Checks if player catches opponent and chases new player if true
    if (this.catchOpponent(((Player)field.getTeam1().get(counter)), field)){
      counter +=1;
      // Reset who's being chased after whole team caught
      if (counter == otherTeamSize){
      counter = 0;
      }
    }
    
    // Allocate memory for otherX and otherY
    double otherX = 0;
    double otherY = 0;
    
    // Set otherX and otherY dependent on team  
    Player firstTeam = (Player) field.getTeam1().get(0);
    Player secondTeam = (Player) field.getTeam2().get(0);
    if (this.getTeam().equals(firstTeam.getTeam())){
      otherX = field.getTeam2().get(counter).getX();
      otherY = field.getTeam2().get(counter).getY(); 
    }
    if (this.getTeam().equals(secondTeam.getTeam())){
      otherX = field.getTeam1().get(counter).getX();
      otherY = field.getTeam1().get(counter).getY();
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
  
  
  // Play overriden from Entity extended to Player extened to this
  @Override
  public void update(Field field){}
  
  // Catcher constructor everything passed to super classes Player and Entity
   /* @param f is the field the player will be playing on
    * @param side is the side of the field the player will play on
    * @param name is this player's name 
    * @param number is this player's number
    * @param team is this player's team's name
    * @param symbol is a character representation of this player
    * @param x is the initial x position of this player
    * @param y is the initial y position of this player
    */
  public Catcher(Field field, int side, String name, int number, String team,char symbol, double x, double y){
    super(field, side, name, number, team, symbol, x, y);
    
    // Set otherTeamSize dependent on team  
    Player firstTeam = (Player) field.getTeam1().get(0);
    Player secondTeam = (Player) field.getTeam2().get(0);
    if (this.getTeam().equals(firstTeam.getTeam())){
      otherTeamSize = field.getTeam2().size();
    }
    if (this.getTeam().equals(secondTeam.getTeam())){
      otherTeamSize = field.getTeam1().size();
    }
  }
  
  
}