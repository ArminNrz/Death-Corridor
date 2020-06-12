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
    public void setId(int id) {
        this.id = id;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) { this.health = health; }

    public String getType() { return type; }

    public void setType(String type) {
        this.type = type;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public abstract String showSoldier();

    public abstract void getShot(int damage);






}
