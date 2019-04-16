
public class Main {

    public static void main(String[] args) {
        System.out.println("Game started!");
        // Flyweight
        Flyweight.ObjectType Diamond = new Flyweight.ObjectType("Diamond", "Blue");

        Flyweight.WorldObj WorldObj = new Flyweight.WorldObj(33, 55, -2, 11, 3, 1, Diamond);
        WorldObj.check();

        System.out.println();

        Flyweight.ObjectType Drop = new Flyweight.ObjectType("Drop", "Gold");

        Flyweight.WorldObj worldObj = new Flyweight.WorldObj(54, 24, 16, 1, 4, 6, Drop);
        worldObj.check();

        System.out.println();

        Bridge.Spider Spider = new Bridge.Spider("Horrible Spider", "Spiders", 15, 15, 0, 100, 14, 3);
        Spider.checkHPstatus();


        Bridge.Bee Bee = new Bridge.Bee("Hungry Bee", "Bees", 55, 155, 0, 350, 45, 2);
        Bee.checkHPstatus();

        Bee.attack(WorldObj);


        if (WorldObj.isDestroyed)
            System.out.println("WorldObj is destroyed");

        Spider.attack(Bee);
        Bee.checkHPstatus();


        Adapter.NPCInfo.printNPCInfo( Adapter.getData( Bee ));

        Facade.Save save = Facade.SaveGame.createSaveFile();

        Facade.LoadGame.loadFromSaveFile(save);

        System.out.println("______( E N D )_______\n");

        Proxy.ProxyMod.loadToServerSave(save);
        Proxy.ProxyMod.turnOnOffServer();

        Proxy.ProxyMod.loadToServerSave(save);

    }

}