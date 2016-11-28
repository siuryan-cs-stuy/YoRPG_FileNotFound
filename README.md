# YoRPG by Team FileNotFound
YoRPG game created by Ryan Siu, Jonathan Quang, and Rihui Zheng

##Instructions:
Compile and run the YoRPG.java file.
```
javac YoRPG.java
java YoRPG
```
Follow the prompts as you are guided through the world of YoRPG, choosing your character class, a difficulty, and your very own hero name. You will encounter five rounds of adventure, battle, or perhaps, nothing at all. Will you survive?

##Feature Additions:
###v4
- Items and inventory
  - Healing items: Restores HP.
  - Attacking items: Does damage to the Monster.
- Added element of randomness to attack damage for all Characters
- Modifications to UI 
  - Added helpful information between turns
- More choices between turns
  - Use items
  - Special hero moves can affect your stats either positively or negatively
- Pets (cause who doesn't want their own dragon)
  - Deal additional damage to opponent when attacking
- Secret Easter Egg character and pet classes! ;)

##Architecture Modifications:
- Added a new class called InventoryItems for implementing inventories
  - Each Character has an inventory (array of InventoryItems objects) as an instance variable
- New classes for pets

##Gameplay Tips:
- Not all Character classes are created equal. Which one is the best?
- Items are useful. Use them, don't stockpile.
- Monster strength does <b>not</b> change depending on difficulty. The chance of a monster encounter does.
