/*=============================================
  class Character -- superclass for combatants in Ye Olde RPG
  =============================================*/

public abstract class Character {

    // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~
    protected int _hitPts;
    protected int _strength;
    protected int _defense;
    protected double _attack;
    protected String _name;
    protected InventoryItems[] _inventory;
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    /*=============================================
      default constructor
      pre:  instance vars are declared
      post: initializes instance vars.
      =============================================*/
    public Character() {
	_hitPts = 125;
	_strength = 100;
	_defense = 40;
	_attack = .4;
	_name = "John Adams";
	_inventory = new InventoryItems[YoRPG.MAX_ENCOUNTERS];
    }

     /*=============================================
      overloaded constructor
      pre:  instance vars are declared
      post: initializes instance vars. _name is set to input String.
      =============================================*/
    public Character ( String name ) {
	this();
	if (!name.equals("")) {
	    _name = name;
	}
    }


    // ~~~~~~~~~~~~~~ ACCESSORS ~~~~~~~~~~~~~~~~~
    public int getDefense() { return _defense; }
    public String getName() { return _name; }
    public int getHitPts() { return _hitPts; }
    public InventoryItems[] getInventory() { return _inventory; }
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    
    /*=============================================
      boolean isAlive() -- tell whether I am alive
      post: returns boolean indicated alive or dead
      =============================================*/
    public boolean isAlive() {
	return _hitPts > 0;
    }


    /*=============================================
      int attack(Character) -- simulates attack on a Monster
      pre:  Input not null
      post: Calculates damage to be inflicted, flooring at 0. 
            Calls opponent's lowerHP() method to inflict damage. 
	    Returns damage dealt.
      =============================================*/
    public int attack( Character opponent ) {

	int damage = (int)( (_strength * _attack) - opponent.getDefense() );
	int damModifier = (int)((Math.random() * 10) - 5);
	damage += damModifier;
	//System.out.println( "\t\t**DIAG** damage: " + damage );

	if ( damage < 0 )
	    damage = 0;

	opponent.lowerHP( damage );

	return damage;
    }//end attack


    /*=============================================
      void lowerHP(int) -- lowers life by input value
      pre:  Input >= 0
      post: Life instance var is lowered by input amount.
      =============================================*/
    public void lowerHP( int damageInflicted ) {
	_hitPts = _hitPts - damageInflicted;
    }

    /*=============================================
      void gainHP(int) -- adds life by input value
      pre:  Input >= 0
      post: Life instance var is increased by input amount.
      =============================================*/
    public void gainHP( int pointsHealed ) {
	_hitPts = _hitPts + pointsHealed;
    }

    /*=============================================
      void specialize() -- prepares character for special attack
      pre:  
      post: Attack of character is increased, defence is decreased
      =============================================*/
    public abstract void specialize();

    /*=============================================
      void normalize() -- revert stats back to normal
      pre:  
      post: Attack and defence of character is de-specialized
      =============================================*/
    public abstract void normalize();

    /*=============================================
      String about() -- returns descriptions character type
      pre:  
      post: Info is returned
      =============================================*/
    public abstract String about();

    private int posEmptyIndex() {
	for (int i = 0; i < _inventory.length; i++) {
	    if (_inventory[i] == null) {
		return i;
	    }
	}
	return -1;
    }

    public InventoryItems addItem() {
	InventoryItems item = new InventoryItems();
	if (!item.equals("none")) {
	    _inventory[ posEmptyIndex() ] = item;
	}
	return item;
    }

    public InventoryItems getItem() {
	int pos = (int)(Math.random() * (posEmptyIndex()-1));
        return _inventory[pos];
    }

    public boolean removeItem( InventoryItems item ) {
	for (int i = 0; i < _inventory.length; i++) {
	    if (_inventory[i].equals(item)) {
		_inventory[i] = null;
		return true;
	    }
	}
	return false;
    }

}//end class Character
