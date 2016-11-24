/*=============================================
  class Archer -- protagonist of Ye Olde RPG  
  =============================================*/
 
public class Archer extends Character {

    // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~
    // inherited from superclass
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    /*=============================================
      default constructor
      pre:  instance vars are declared
      post: initializes instance vars.
      =============================================*/
    public Archer() {
	super();
	_hitPts = 75;
	_strength = 60;
	_defense = 25;
	_attack = .7;
    }


    /*=============================================
      overloaded constructor
      pre:  instance vars are declared
      post: initializes instance vars. _name is set to input String.
      =============================================*/
    public Archer( String name ) {
	this();
	if (!name.equals("")) {
	    _name = name;
	}
    }

    /*=============================================
      void specialize() -- prepares character for special attack
      pre:  
      post: Attack of character is increased, defense is decreased
      =============================================*/
    public void specialize() {
	_attack = 1;
	_defense = 10;
    }

    /*=============================================
      void normalize() -- revert stats back to normal
      pre:  
      post: Attack and defense of character is de-specialized
      =============================================*/
    public void normalize() {
	_attack = .7;
	_defense = 25;
    }

     /*=============================================
      String about() -- returns descriptions character type
      pre:  
      post: Info is returned
      =============================================*/
    public String about() {
	return "Archers are strong ranged fighters, but have low defense.";
    }


}//end class Archer
