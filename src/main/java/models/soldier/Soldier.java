package models.soldier;
import models.weapons.Weapon;
import org.bson.types.ObjectId;

public abstract class Soldier {
    protected Weapon weapon;
    protected ObjectId id;
    protected int health;
    protected String type;

    public Soldier(Weapon weapon) {
        ObjectId id = new ObjectId();
        this.id = id;
        this.weapon = weapon;
    }

    public ObjectId getId() {
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
