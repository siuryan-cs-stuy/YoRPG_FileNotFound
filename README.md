# YoRPG_FileNotFound
YoRPG game created by Ryan Siu, Jonathan Quang, and Rihui Zheng

##Instructions:
  To start: Compile and run the YoRPG.java file. 
  Follow the prompts as you are guided through the world of YoRPG, choosing your character class, a difficulty, and your very own hero name. You will encounter five rounds of adventure, battle, or perhaps, nothing at all. Will you survive?

##Feature Additions:
- Items and inventory
  - Healing items: Restores HP.
  - Attacking items: Does damage to the Monster.
- Added element of randomness to attack damage for all Characters
- Secret Easter Egg class! ;)
- Modifications to UI 
  - Changed intro/conclusion text
  - Added helpful information between turns
- More choices between turns (use item, use special hero move)

##Architecture Modifications:
- Added a new class called InventoryItems for implementing inventories
  - Each Character has an inventory (array of InventoryItems objects) as an instance variable
