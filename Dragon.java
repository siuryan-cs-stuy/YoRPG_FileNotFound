/*=============================================
  class Dragon -- a pet of the protagonist.
  =============================================*/

public class Dragon extends Character {

    // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~
    // inherited from superclass
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    /*=============================================
      default constructor
      pre:  instance vars are declared
      post: initializes instance vars.
      =============================================*/
    public Dragon() {
	super();
	_strength = 60 + (int)( Math.random() * 11 );
	_attack = 0.5;
    }

    /*=============================================
      overloaded constructor
      pre:  instance vars are declared
      post: initializes instance vars. _name is set to input String.
      =============================================*/
    public Dragon( String name ) {
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
	return "Although dargons can dish out high damage, it is very slow.";
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
	


}//end class Dragon
