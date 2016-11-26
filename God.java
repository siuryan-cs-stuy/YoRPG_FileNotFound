/*=============================================
  class God -- cuz why not

    _______     ______     ______
   /  _____|   / ____ \   |  ___ \
  /  /  ___   | |    | |  | |   | |
 |  |  |_  |  | |    | |  | |   / |
  \  \___| |  | |____| |  | |__/ /
   \_____|_|   \______/   |_____/
  =============================================*/
 
public class God extends Character {

    // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~
    // inherited from superclass
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    /*=============================================
      default constructor
      pre:  instance vars are declared
      post: initializes instance vars.
      =============================================*/
    public God() {
	super();
	_hitPts = 9000;
	_strength = 9000;
	_defense = 9000;
	_attack = 9.0;
    }


    /*=============================================
      overloaded constructor
      pre:  instance vars are declared
      post: initializes instance vars. _name is set to input String.
      =============================================*/
    public God( String name ) {
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
	_attack = 9.9;
	_defense = 9999;
    }

    /*=============================================
      void normalize() -- revert stats back to normal
      pre:  
      post: Attack and defense of character is de-specialized
      =============================================*/
    public void normalize() {
	_attack = 9.0;
	_defense = 9000;
    }

    /*=============================================
      String about() -- returns descriptions character type
      pre:  
      post: Info is returned
      =============================================*/
    public String about() {
	return "Gods are immortal. Therefore, you will always win.";
    }
	
		/*==========================
	String heroSpecial()
	pre:
	post: executes a character's special move, for example, a priest would heal itself, and
			returns a string summarizing what happened.
	========================*/
		public String heroSpecial(){
		if (((int) Math.random()*100) >= 1){
		this._hitPts+=1000;
		this._strength+=1000;
		return "your character's HP and strength have increased to " + this._hitPts + " " + this._strength;
		}
		else {
		return "your special move has failed";
		}
	}
	


}//end class God
