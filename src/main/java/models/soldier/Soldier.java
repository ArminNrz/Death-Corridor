package models.soldier;
import main.math.MakeRandom;
import models.weapons.Weapon;
import org.bson.types.ObjectId;

public abstract class Soldier {
    protected Weapon weapon;
    protected int health;
    protected String type;
    protected int id;

    public Soldier(Weapon weapon) {
        id = MakeRandom.randomInt(10000);
        this.weapon = weapon;
    }

    public Soldier(){}

    public int getId(){
        return id;
    }

    public int getHealth() {
        return health;
    }

    public String getType() { return type; }

    public void setHealth(int health) { this.health = health; }

    public Weapon getWeapon() {
        return weapon;
    }

    public abstract String showSoldier();

    public abstract void getShot(int damage);
}
