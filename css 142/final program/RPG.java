import java.util.*;
public class RPG {
    public static void main(String[] args) {
        Player player = new Player();
        Scanner kb = new Scanner(System.in);
        
    }
}

class Player {
    public int health = 50;
    public int attackPower = 10;
    public int magicPower = 10;
    public int defense = 10;
    public int damageIncoming = 0, damageGiven = 0;
    public int armor = 0;
    public int exp = 0;
    public int lvl = 1;

    /**
     * Calculates new player health based on attack damage values for monster attack
     * @param health    Player health value
     * @param monsterDMG    Monster attack damage value
     * @return New player health
     */
    public int calcDamageTaken(int health, int monsterDMG) {
        int dmgSponge = armor + defense;
        damageIncoming = monsterDMG - dmgSponge;
        health -= damageIncoming;
        return health;
    }

    /**
     * Player makes physical attack
     * @return Damage value for attack
     */
    public int attack() {
        Random rand = new Random();
        damageGiven = (int)(rand.nextDouble() + 0.5) * attackPower;
        return damageGiven;
    }

    /**
     * Calculates experience gained from battles
     * @param exp
     * @return New experience value
     */
    public int calcEXP(int exp) {
        
        
        return exp;
    } 

    /**
     * Takes updated exp value post-battle and increases level if needed
     * @param level
     * @return New level
     */
    public int calcLvl(int level) {
        
        
        return level;
    }
}