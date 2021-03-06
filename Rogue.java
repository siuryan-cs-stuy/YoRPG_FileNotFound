/*=============================================
  class Rogue -- protagonist of Ye Olde RPG  
  =============================================*/
 
public class Rogue extends Character {

    // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~
    // inherited from superclass
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    /*=============================================
      default constructor
      pre:  instance vars are declared
      post: initializes instance vars.
      =============================================*/
    public Rogue() {
	super();
	_hitPts = 50;
	_strength = 100;
	_defense = 30;
	_attack = 0.9;
    }


    /*=============================================
      overloaded constructor
      pre:  instance vars are declared
      post: initializes instance vars. _name is set to input String.
      =============================================*/
    public Rogue( String name ) {
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
	_defense = 25;
    }

    /*=============================================
      void normalize() -- revert stats back to normal
      pre:  
      post: Attack and defense of character is de-specialized
      =============================================*/
    public void normalize() {
	_attack = .9;
	_defense = 30;
    }

    /*=============================================
      String about() -- returns descriptions character type
      pre:  
      post: Info is returned
      =============================================*/
    public String about() {
	return "Rogues are sneaky, fast, and elusive, but aren't very sturdy.";
    }
	
    /*==========================
      String heroSpecial()
      pre:
      post: executes a character's special move, for example, a priest would heal itself, and
      returns a string summarizing what happened.
      ========================*/
    public String heroSpecial(){
	if (((int) (Math.random()*99)) >= 50){
	    this._hitPts -=5;
	    this._defense -=5;
	    this._strength +=20;
	    return "your rogue sacrifices HP and Defence for its strength to increase to " + this._strength + "but it now has " + this._hitPts + " HP " + this._defense + " defence";
	}
	else {
	    this._hitPts-=-15;
	    return "your rogue messes up the sacrifice, lowering HP by 15";
	}
		
    }
	
    

}//end class Rogue
