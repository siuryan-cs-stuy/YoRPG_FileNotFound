public class InventoryItems {

    public static final int NUM_ITEM_TYPES = 2;
    
    public static final String[] HP_ITEMS = {
	"apple", "medicine", "medkit"
    };
    public static final String[] ATT_ITEMS = {
	"teddy bear", "throwing knife", "grenade"
    };

    // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~
    private String _name;
    private String _type;
    private int _effect;
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    /*=============================================
      default constructor
      pre:  instance vars are declared
      post: initializes instance vars.
      =============================================*/
    public InventoryItems() {
	int rand = (int)(Math.random() * (NUM_ITEM_TYPES+1));
	if (rand == 0) {
	    _type = "hp";
	    _name = getHpItem();
	    _effect = 20;
	} else if (rand == 1) {
	    _type = "att";
	    _name = getAttItem();
	    _effect = 10;
	} else {
	    _name = "none";
	}
    }

    
    /*=============================================
      overloaded constructor
      pre:  instance vars are declared
      post: initializes instance vars. if none is true, then set _name to "none"
      =============================================*/
    public InventoryItems( boolean none ) {
	this();
	if (none) {
	    _name = "none";
	}
    }

    // ~~~~~~~~~~~~~~ ACCESSORS ~~~~~~~~~~~~~~~~~
    public String getType() { return _type; }
    public String getName() { return _name; }
    public int getEffect() { return _effect; }
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    /*=============================================
      String getHpItem() -- returns a randomly chosen String from HP_ITEMS array
      pre:  
      post: String is returned
      =============================================*/
    private static String getHpItem() {
        int pos = (int)(Math.random() * HP_ITEMS.length);
        return HP_ITEMS[pos];
    }

    /*=============================================
      String getAttItem() -- returns a randomly chosen String from ATT_ITEMS array
      pre:  
      post: String is returned
      =============================================*/
    private static String getAttItem() {
        int pos = (int)(Math.random() * ATT_ITEMS.length);
        return ATT_ITEMS[pos];
    }

    /*=============================================
      boolean equals() -- overridden .equals() method, checks for equality in _name
      pre:  
      post: returns whether _name attribute of this instance is equal to input name
      =============================================*/
    public boolean equals( String name ) {
	return this._name.equals(name);
    }
    
}
