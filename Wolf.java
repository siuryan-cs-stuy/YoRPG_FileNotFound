/*=============================================
  class Wolf -- a pet of the protagonist.
  =============================================*/

public class Wolf extends Character {

    // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~
    // inherited from superclass
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    /*=============================================
      default constructor
      pre:  instance vars are declared
      post: initializes instance vars.
      =============================================*/
    public Wolf() {
	super();
	_strength = 40 + (int)( Math.random() * 11 );
	_attack = 0.75;
    }

    /*=============================================
      overloaded constructor
      pre:  instance vars are declared
      post: initializes instance vars. _name is set to input String.
      =============================================*/
    public Wolf( String name ) {
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
	return "Wolves are well-rounded in both attack and speed.";
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
	


}//end class Wolf
