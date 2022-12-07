import java.util.*;

public class Monster {
    public int health;
    public int attackPower, physicalDefense;
    public int magicPower, magicDefense;
    public int damageIncoming, damageGiven;
    public int armor;
    public String name;
    Random rand = new Random();

    /**
     * Physical attack for monsters
     * @return Damage value for hit
     */
    public int attackPhysical() {
        int damageVal = (int)(rand.nextDouble() + 0.5) * attackPower;
        System.out.println(this.name + " hits you! Took " + damageVal + " damage.");
        return damageVal;
    }

}

class Goblin extends Monster {
    public Goblin() {
        this.name = "Goblin";
        this.armor = rand.nextInt(8);
        this.health = rand.nextInt(21) + 20;
        this.attackPower = rand.nextInt(5) + 8;
        this.magicPower = rand.nextInt(5);
        this.physicalDefense = rand.nextInt(6) + 10;
        this.magicDefense = rand.nextInt(4);
    }

}

class Spider extends Monster {
    public Spider() {
        this.name = "Spider";
        this.armor = rand.nextInt(10);
        this.attackPower = rand.nextInt(11) + 6;
        this.magicPower = rand.nextInt(4) + 5;
        this.physicalDefense = rand.nextInt(3) + 6;
        this.magicDefense = rand.nextInt(3) + 10;
    }

}

class Slime extends Monster {
    public Slime() {
        this.name = "Slime";
        this.armor = 0;
        this.attackPower = rand.nextInt(5) + 4;
        this.magicPower = rand.nextInt(5) + 5;
        this.physicalDefense = rand.nextInt(6) + 15;
        this.magicDefense = rand.nextInt(5) + 8;
    }

}