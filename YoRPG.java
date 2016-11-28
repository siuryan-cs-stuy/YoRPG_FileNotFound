// Team FileNotFound -- Ryan Siu, Jonathan Quang, Rihui Zheng
// APCS1 pd5
// HW32 -- Ye Olde Role Playing Game, Expanded
// 2016-11-20

/*=============================================
  class YoRPG -- Driver file for Ye Olde Role Playing Game.
  Simulates monster encounters of a wandering adventurer.
  Required classes: Warrior, Monster
  =============================================*/

import java.io.*;
import java.util.*;

public class YoRPG 
{
    // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~

    //change this constant to set number of encounters in a game
    public final static int MAX_ENCOUNTERS = 5;

    //each round, a Warrior and a Monster will be instantiated...
    private Character pat;   //Is it man or woman?
    private Monster smaug; //Friendly generic monster name?
    private Pet wolf;   //Cuuuuuute!

    private int moveCount;
    private boolean gameOver;
    private int difficulty;

    private InputStreamReader isr;
    private BufferedReader in;
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    // ~~~~~~~~~~ DEFAULT CONSTRUCTOR ~~~~~~~~~~~
    public YoRPG() {
	moveCount = 0;
	gameOver = false;
	isr = new InputStreamReader( System.in );
	in = new BufferedReader( isr );
	newGame();
    }
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    
    // ~~~~~~~~~~~~~~ METHODS ~~~~~~~~~~~~~~~~~~~
    /*=============================================
      void newGame() -- facilitates info gathering to begin a new game
      pre:  
      post: according to user input, modifies instance var for difficulty 
      and instantiates a Warrior
      =============================================*/
    public void newGame() {

	String s;
	String name = "";
	String pName = "";
	s = "Welcome to Ye Olde RPG!\n";

	s += "\nChoose your difficulty: \n";
	s += "\t1: Easy\n";
	s += "\t2: Not so easy\n";
	s += "\t3: Beowulf hath nothing on me. Bring it on.\n";
	s += "Selection: ";
	System.out.print( s );

	while (difficulty == 0) {
	    int diff = 0;
	    try {
		diff = Integer.parseInt( in.readLine() );
	    }
	    catch ( IOException e ) { }
	    if (diff > 0 && diff < 4) {
		difficulty = diff;
	    }
	    else {
		System.out.println("Invalid Choice. Try Again.");
	    }
	}

	s = "Intrepid warrior, what doth thy call thyself? (State your name): ";
	System.out.print( s );

	try {
	    name = in.readLine();
	}
	catch ( IOException e ) { }

	s = "Choose a character class from the list:\n";
	s += "1) Warrior\n";
	s += "2) Mage\n";
	s += "3) Rogue\n";
	s += "4) Priest\n";
	s += "5) Archer\n";
	s += "Your input (as a number): ";
	System.out.print( s );

	while (pat == null) {
	    int character = 0;
	    try {
		character = Integer.parseInt( in.readLine() );
	    }
	    catch ( IOException e ) { }

	    //instantiate the player's character by checking the character int,
		//the return string shows an error choice if the # is not [1,5] or 9000
	    if ( character == 1 ) {
		pat = new Warrior( name );
		s = pat.about();
	    } else if ( character == 2 ) {
		pat = new Mage( name );
		s = pat.about();
	    } else if ( character == 3 ) {
		pat = new Rogue( name );
		s = pat.about();
	    } else if ( character == 4 ) {
		pat = new Priest( name );
		s = pat.about();
	    } else if ( character == 5 ) {
		pat = new Archer( name );
		s = pat.about();
            } else if (character == 9000) {
                pat = new God( name );
                s = pat.about();
	    } else {
		s = "Invalid choice. Choose a character class from the list: ";
	    }	

	System.out.print( s );
	}
	s = "\nThat is a nice pet you got there. What be it's name?";
	System.out.println(s);
	try {
	    pName = in.readLine();
	}
	catch ( IOException e ) { }
	wolf = new Pet(pName);
	
	System.out.println("\n\n~~~~~~ START OF GAME ~~~~~~");
	

    }//end newGame()


    /*=============================================
      boolean playTurn -- simulates a round of combat
      pre:  Warrior pat has been initialized
      post: Returns true if player wins (monster dies).
      Returns false if monster wins (player dies).
      =============================================*/
    public boolean playTurn() {

	int i = 1;
	int d1, d2, d3;

	if ( Math.random() >= ( difficulty / 3.0 ) )
	    System.out.println( "\nNothing to see here. Move along!" );
	else {
	    System.out.println( "\nLo, yonder monster approacheth!" );

	    smaug = new Monster();

	    while( smaug.isAlive() && pat.isAlive() ) {

		// Give user the option of using a special attack:
		// If you land a hit, you incur greater damage,
		// ...but if you get hit, you take more damage.
		System.out.println( "You have " + pat.getHitPts() + " HP." );
		System.out.println( "The monster has " + smaug.getHitPts() + " HP." );
		System.out.print( "Your inventory: ");

		for (InventoryItems item : pat.getInventory()) {
		    if (item != null) {
			System.out.print( item.getName() + "," );
		    }
		}

		System.out.println();
		
		try {
		    System.out.println( "\nDo you feel lucky?" );
		    System.out.println( "\t1: Nay.\n\t2: Aye!\n\t3: Huh?\n\t4: Time for Hero special?" );
		    i = Integer.parseInt( in.readLine() );
		}
		catch ( IOException e ) { }
		
		if (i == 4) {
			System.out.println(pat.heroSpecial());
		}

		// Use item
		if ( i == 3 ) {
		    try {
			InventoryItems item = pat.getItem();
			if (item.getType().equals("hp")) {
			    pat.gainHP( item.getEffect() );
			    System.out.println( "\n" + pat.getName() + " used a " +
						item.getName() + " and gained " +
						item.getEffect() + " HP.");
			} else if (item.getType().equals("att")) {
			    smaug.lowerHP( item.getEffect() );
			    System.out.println( "\n" + pat.getName() + " threw a " +
						item.getName() + " and dealt " + 
						item.getEffect() + " points of damage.");
			}
			pat.removeItem( item );
		    }
		    catch (NullPointerException e) {
			System.out.println("\nYou don't have any items!");
		    }
		}
		else {
		    // Use special attack
		    if (i == 2)
			pat.specialize();
		    // Use normal attack
		    else
			pat.normalize();
		    
		    d1 = pat.attack( smaug );
		    d2 = smaug.attack( pat );
		    d3 = wolf.attack( smaug );

		    System.out.println( "\n" + pat.getName() + " dealt " + d1 +
				    " points of damage.");

		    System.out.println( "\n" + "Ye Olde Monster smacked " + pat.getName() +
				    " for " + d2 + " points of damage.");

		    System.out.println( "\n" + wolf.getName() + " bit Ye Olde Monster for " +
		    			+ d3 + " points of damage.");

		    // Adds item to inventory, if item is not named "none"
		    InventoryItems item = pat.addItem();
		    if (!item.equals("none")) {
			System.out.println( "\nA " + item.getName() + " was added to " +
					    pat.getName() + "'s inventory.");
		    }
		}

		System.out.println();
		
	    }//end while

	    //option 1: you & the monster perish
	    if ( !smaug.isAlive() && !pat.isAlive() ) {
		System.out.println( "'Twas an epic battle, to be sure... " + 
				    "You cut ye olde monster down, but " +
				    "with its dying breath ye olde monster. " +
				    "laid a fatal blow upon thy skull." );
		return false;
	    }
	    //option 2: you slay the beast
	    else if ( !smaug.isAlive() ) {
		System.out.println( "HuzzaaH! Ye olde monster hath been slain!" );
		return true;
	    }
	    //option 3: the beast slays you
	    else if ( !pat.isAlive() ) {
		System.out.println( "Ye olde self hath expired. You got dead." );
		return false;
	    }
	}//end else

	return true;
    }//end playTurn()
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    public static void main( String[] args ) {

	//As usual, move the begin-comment bar down as you progressively 
	//test each new bit of functionality...

	//loading...
	YoRPG game = new YoRPG();

	int encounters = 0;

	while( encounters < MAX_ENCOUNTERS ) {
	    if ( !game.playTurn() )
		break;
	    encounters++;
	    System.out.println();
	}

	System.out.println();
	System.out.println( "Thy game doth be over." );
	/*================================================
	  ================================================*/
    }//end main

}//end class YoRPG




/*=============================================
  =============================================*/
