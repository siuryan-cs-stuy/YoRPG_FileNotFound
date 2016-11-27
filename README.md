# YoRPG_FileNotFound
YoRPG game created by Ryan Siu, Jonathan Quang, and Rihui Zheng

##Instructions:

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
