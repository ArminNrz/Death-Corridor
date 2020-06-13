package models.soldier;

import models.weapons.Weapon;
import org.bson.Document;

public class Sergeant extends Soldier {

    public Sergeant(Document document){
        super(document);
    }

    public Sergeant(Weapon weapon) {
        super(weapon);
        health = 100;
        type = "Sergeant";
    }

    @Override
    public String showSoldier() {
        String result = "[Soldier Type: " + this.type + ", Health: "
                + this.health + ", " + this.weapon.showWeapon() + "\n";
        return result;
    }

    @Override
    public void getShot(int damage) {
        health -= damage;
    }

    @Override
    public Document getBsonDocument(){
        return super.getBsonDocument();
    }
}
