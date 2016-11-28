/*=============================================
  class Serpent -- a pet of the protagonist.
  =============================================*/

public class Serpent extends Character {

    // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~
    // inherited from superclass
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    /*=============================================
      default constructor
      pre:  instance vars are declared
      post: initializes instance vars.
      =============================================*/
    public Serpent() {
	super();
	_strength = 30 + (int)( Math.random() * 11 );
	_attack = 1;
    }

    /*=============================================
      overloaded constructor
      pre:  instance vars are declared
      post: initializes instance vars. _name is set to input String.
      =============================================*/
    public Serpent( String name ) {
	this();
	if (!name.equals("")) {
	    _name = name;
	}
    }

    // Does nothing for Pets
    public void specialize() { }
    public void normalize() { }
    
    /*=============================================
      String about() -- returns descriptions character type
      pre:  
      post: Info is returned
      =============================================*/
    public String about() {
	return "Serpents are weak but can strike its target at an insane speed.";
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
	


}//end class Serpent
