public class Team{
  
  public Team(Field theField, int numberOfPlayers){
  Player p; // initial Player for team 1
  Player q; // initial Player for team 2
  int getTeam1length = theField.getTeam1().size(); // this is the ammount of players in team one
  
  
  if (getTeam1length == 0){ // create the first team if team 1 is not created.
   for(int i=0; i<numberOfPlayers; i+=1){// for loop to create the players for team 1.
     
      p = new RandomWalker(theField, 1, "Cat van Kittenish", 12, "blues", 'b', Math.random()*400+10, Math.random()*500+10); // right now It's a randomwalker class ----> need to decide team composition. 
      
      // if you want to change the team composition ie. X chasers, Y defenders add a loop along the lines of 
      /* for (int j = 0+i; j < x+i; j ++){
         p = new chaser(theField, 1, "Cat van Kittenish", 12, "blues", 'b', Math.random()*400+10, Math.random()*500+10); // right now It's a randomwalker class ----> need to decide team composition. 
         
         for (int k =0+i; k < y+i j++){
         p = new defenders(theField, 1, "Cat van Kittenish", 12, "blues", 'b', Math.random()*400+10, Math.random()*500+10); // right now It's a randomwalker class ----> need to decide team composition. 
         */
      // the loop logic is kind of shit but it should work.
      
   }
  }
  
   if (getTeam1length > 0){// checks if team one is the right size
   for(int i=0; i<numberOfPlayers; i+=1){// for loop to create the players for team 2.
     
       q = new RandomWalker(theField, 2, "Bunny El-Amin", 7, "reds", 'r', Math.random()*400+410, Math.random()*500+10);
   }
   }
   }
   
   
  
   
   public  void play(Field field){
   
   
   
   }
   public void update(Field field){
   
   
