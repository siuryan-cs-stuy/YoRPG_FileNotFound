/*=============================================
  class Monster -- Represents random incarnations of 
  the adventurer's natural enemy in Ye Olde RPG
  =============================================*/

public class Monster extends Character {

    // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~
    // inherited from superclass
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    /*=============================================
      default constructor
      pre:  instance vars are declared
      post: initializes instance vars.
      =============================================*/
    public Monster() {
	super();
	_hitPts = 150;
	_strength = 20 + (int)( Math.random() * 45 ); // [20,65)
	_defense = 20;
	_attack = 1;
	_name = "Monster";
    }

    // Does nothing for Monsters
    public void specialize() { }
    public void normalize() { }
    
    /*=============================================
      String about() -- returns descriptions character type
      pre:  
      post: Info is returned
      =============================================*/
    public String about() {
	return "The antagnoists of the game, Monsters are out to kill you!";
    }
	
    /*==========================
      String heroSpecial()
      pre:
      post: executes a character's special move, for example, a priest would heal itself, and
      returns a string summarizing what happened.
      ========================*/
    public String heroSpecial(){
	return "test";
    }
	


}//end class Monster
