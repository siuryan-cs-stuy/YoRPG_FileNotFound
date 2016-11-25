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

    public static final int MAX_INVENTORY_SIZE = 5;
    
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
	_inventory = new InventoryItems[MAX_INVENTORY_SIZE];
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

    
    /*=============================================
      int posEmptyIndex() -- returns first index in _inventory that is null
      pre:  _inventory has been initialized
      post: pos is returned, or returns -1 if no index is null
      =============================================*/
    private int posEmptyIndex() {
	for (int i = 0; i < _inventory.length; i++) {
	    if (_inventory[i] == null) {
		return i;
	    }
	}
	return -1;
    }

    /*=============================================
      boolean isEmpty() -- returns true if _inventory contains only null indicies
      pre:  _inventory has been initialized
      post: returns a boolean
      =============================================*/
    private boolean isEmpty() {
	for (int i = 0; i < _inventory.length; i++) {
	    if (_inventory[i] != null) {
		return false;
	    }
	}
	return true;
    }

    
    /*=============================================
      InventoryItems addItem() -- if _inventory has an empty index, put a InventoryItems                                  instance to _inventory in that index
      pre:  _inventory has been initialized
      post: InventoryItems instance is added, instance is returned
      =============================================*/
    public InventoryItems addItem() {
	InventoryItems item;
	if (posEmptyIndex() != -1) {
	    item = new InventoryItems();
	    if (!item.equals("none")) {
		_inventory[ posEmptyIndex() ] = item;
	    }
	} else {
	    item = new InventoryItems(true);
	}
	return item;
    }

    
    /*=============================================
      InventoryItems getItem() -- returns a InventoryItems inside _inventory
      pre:  _inventory has been initialized
      post: InventoryItems instance is returned
      =============================================*/
    public InventoryItems getItem() {
	int pos = (int)(Math.random() * MAX_INVENTORY_SIZE);
	while (_inventory[pos] == null && !isEmpty()) {
	    pos = (int)(Math.random() * MAX_INVENTORY_SIZE);
	}
        return _inventory[pos];
    }

    
    /*=============================================
      boolean removeItem() -- replaces InventoryItems item from _inventory with null
      pre:  _inventory has been initialized, item is a InventoryItems instance in _inventory
      post: item is replaced with null, success of operation is returned as a boolean
      =============================================*/
    public boolean removeItem( InventoryItems item ) {
	for (int i = 0; i < MAX_INVENTORY_SIZE; i++) {
	    if (_inventory[i] != null && _inventory[i].equals(item)) {
		_inventory[i] = null;
		return true;
	    }
	}
	return false;
    }
	
	/*==========================
	String heroSpecial()
	pre:
	post: executes a character's special move, for example, a priest would heal itself, and
			returns a string summarizing what happened.
	========================*/
	public abstract String heroSpecial();

}//end class Character
