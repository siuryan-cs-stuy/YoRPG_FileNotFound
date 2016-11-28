/*=============================================
  class Priest -- protagonist of Ye Olde RPG  
  =============================================*/
 
public class Priest extends Character {

    // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~
    // inherited from superclass
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    /*=============================================
      default constructor
      pre:  instance vars are declared
      post: initializes instance vars.
      =============================================*/
    public Priest() {
	super();
	_hitPts = 150;
	_strength = 50;
	_defense = 35;
	_attack = .5;
    }


    /*=============================================
      overloaded constructor
      pre:  instance vars are declared
      post: initializes instance vars. _name is set to input String.
      =============================================*/
    public Priest( String name ) {
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
	_attack = .85;
	_defense = 15;
    }

    /*=============================================
      void normalize() -- revert stats back to normal
      pre:  
      post: Attack and defense of character is de-specialized
      =============================================*/
    public void normalize() {
	_attack = .5;
	_defense = 35;
    }

    /*=============================================
      String about() -- returns descriptions character type
      pre:  
      post: Info is returned
      =============================================*/
    public String about() {
	return "Priests are capable healers, but aren't very strong attack-wise.";
    }
	
    /*==========================
      String heroSpecial()
      pre:
      post: executes a character's special move, for example, a priest would heal itself, and
      returns a string summarizing what happened.
      ========================*/
    public String heroSpecial(){
	if (((int) (Math.random()*99)) >= 50){
	    this._hitPts+=10;
	    return "your priest heals itself to " + this._hitPts;
	}
	else {
	    if (this._strength > 0){
		this._strength-=5;
	    }
	    return "your priest misheals a muscle, decreasing strength to " + this._strength;
	}
		
    }
	


}//end class Priest
