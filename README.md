# TMPS_lab№2
##### java version "1.8.0_201"
##### Java(TM) SE Runtime Environment (build 1.8.0_201-b09)
##### Java HotSpot(TM) 64-Bit Server VM (build 25.201-b09, mixed mode)
*Adapter, Bridge, Facade, Flyweight, Proxy.*


In this laboratory work I have used 5 templates which responds to structural patterns. Namely, I used Adapter, Bridge, Facade, Flyweight, Proxy. 

So we have a protoype of simplified game and its structure corresponds to understanding the patterns. 

For saving resources we used Flyweight pattern for WorldObjects. To keep the promtness of application we need to take care of destributing resources.

We create a type of Diamond , and after it we create a Diamond with parameters where one of them is reference to out Diamond type.

    Flyweight.ObjectType Diamond = new Flyweight.ObjectType("Diamond", "Blue");
    Flyweight.WorldObj WorldObj = new Flyweight.WorldObj(33, 55, -2, 11, 3, 1, Diamond); WorldObj.check();

Example:
         Flyweight.ObjectType Drop = new Flyweight.ObjectType("Drop", "Gold");

        Flyweight.WorldObj worldObj = new Flyweight.WorldObj(54, 24, 16, 1, 4, 6, Drop);
        worldObj.check();

        System.out.println();

The best pattern for NPCs in any project is Bridge becouse we will have posibilities to extend it the way we need and in the same time keep the compatibility between them and components in project which works with NPCs data type. So we will not unterrupt the well-worked system and just adding something new.

We have Npc data type which has name, hp, and 3D position (x,y,z), method attack which does 0 dmg and checkHP method.

Also we create 2 new type of classes:  Horible Splider and Hungry Bee extended from class Npc.
       ![alt text](https://pp.userapi.com/c846321/v846321088/1e7008/Tfk7HUAM_DA.jpg "So we have specific Hungry Bee and Horible Spider")
```
 Bridge.Spider Spider = new Bridge.Spider("Horrible Spider", "Spiders", 15, 15, 0, 100, 14, 3);
  Spider.checkHPstatus();
  ```


        Bridge.Bee Bee = new Bridge.Bee("Hungry Bee", "Bees", 55, 155, 0, 350, 45, 2);
        Bee.checkHPstatus();

They have methods for cheking their HP status and attack which can get NPC type or WorldObj. For Npc variant - damage to the chosen Npc, for WorldObj its getting status "destroyed"
```
npc.checkHPstatus();
npc.attack(tree);
npc.attack(npc);

```


We have a method printNPCInfo, but it gets String List, but its too uncomfortable to create a variable a put there data every time manualy, so for this problem Adapter pattern has been chosed.

Method getData gets params from Npc and returns String List so we could use it in printNPCInfo.
```
    Adapter.NPCInfo.printNPCInfo( Adapter.getData( Bee ));
```

For Facade pattern in program were created a lot of classes with parameters which forms a Save System. For creating Save object we need send World, NPCs, WorldObj, History object, which has their own needs for creation (time, map, data for example , in other words params). But user dont have access to this part of program, and we can use only 2 methods, createSaveFile and loadFromSaveFile.
```
Save save = Facade.SaveGame.createSaveFile();
LoadGame.loadFromSaveFile(save);
```
Also program has an "implementation" for Cloud save upload/download by Proxy pattern. Program has 2 classes: Server and ProxyMod. We have access only to proxyMod which gives possibility to ask Proxy to load or download save from/to Server. Proxy  gets Save object and trying to access server. If operation succeeded Server tells it to Proxy, and ProxyMod does the same to the user.
```
ProxyMod.loadToServerSave(save);
```
