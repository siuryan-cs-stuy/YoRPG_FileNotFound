/*=============================================
  class doG -- a pet of the protagonist
  =============================================*/

public class doG extends Character {

    // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~
    // inherited from superclass
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    /*=============================================
      default constructor
      pre:  instance vars are declared
      post: initializes instance vars.
      =============================================*/
    public doG() {
	super();
	_strength = 9000;
	_attack = 9.0;
    }

    /*=============================================
      overloaded constructor
      pre:  instance vars are declared
      post: initializes instance vars. _name is set to input String.
      =============================================*/
    public doG( String name ) {
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
	return "doGs are the pets of Gods. Which is why the name is God backwards.";
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
	


}//end class doG
