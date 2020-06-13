package models.soldier;
import main.directors.WeaponDirector;
import main.math.MakeRandom;
import models.weapons.Weapon;
import org.bson.Document;
import org.bson.types.ObjectId;

public abstract class Soldier {
    private final String HEALTH = "health";
    private final String TYPE = "type";
    private final String ID = "id";
    private final String WEAPON = "weapon";

    protected Weapon weapon;
    protected int health;
    protected String type;
    protected int id;

    public Soldier(Weapon weapon) {
        id = MakeRandom.randomInt(10000);
        this.weapon = weapon;
    }

    public Soldier(Document doc){
        WeaponDirector weaponDirector = new WeaponDirector();

        this.id = doc.getInteger(ID);
        this.type = doc.getString(TYPE);
        this.health = doc.getInteger(HEALTH);
        Document weaponDoc = doc.get(WEAPON, Document.class);
        this.weapon = weaponDirector.loadWeaponByBsonDocument(weaponDoc);
    }

    public int getId(){
        return id;
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

    public abstract String showSoldier();

    public abstract void getShot(int damage);

    public Document getBsonDocument(){
        Document document = new Document();
        document.append(ID, id);
        document.append(TYPE, type);
        document.append(HEALTH, health);
        document.append(WEAPON, weapon.getBsonDocument());
        return document;
    }
}
