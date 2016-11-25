/*=============================================
  class Warrior -- protagonist of Ye Olde RPG
                          (_)           
  __      ____ _ _ __ _ __ _  ___  _ __ 
  \ \ /\ / / _` | '__| '__| |/ _ \| '__|
   \ V  V / (_| | |  | |  | | (_) | |   
    \_/\_/ \__,_|_|  |_|  |_|\___/|_|   
  =============================================*/
 
public class Warrior extends Character {

    // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~
    // inherited from superclass
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    /*=============================================
      default constructor
      pre:  instance vars are declared
      post: initializes instance vars.
      =============================================*/
    public Warrior() {
	super();
	_hitPts = 125;
	_strength = 100;
	_defense = 40;
	_attack = .4;
    }


    /*=============================================
      overloaded constructor
      pre:  instance vars are declared
      post: initializes instance vars. _name is set to input String.
      =============================================*/
    public Warrior( String name ) {
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
	_attack = .75;
	_defense = 20;
    }

    /*=============================================
      void normalize() -- revert stats back to normal
      pre:  
      post: Attack and defense of character is de-specialized
      =============================================*/
    public void normalize() {
	_attack = .45;
	_defense = 40;
    }

    /*=============================================
      String about() -- returns descriptions character type
      pre:  
      post: Info is returned
      =============================================*/
    public String about() {
	return "Warriors are fierce and strong fighters, but are slow.";
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
	


}//end class Warrior
