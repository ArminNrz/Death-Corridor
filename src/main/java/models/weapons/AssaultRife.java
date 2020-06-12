package models.weapons;

import models.bollet.Bollet;
import org.bson.Document;

public class AssaultRife extends Weapon {
    public AssaultRife(Bollet bollet) {
        super(bollet);
        hitRate = 50;
        damage = 10;
        type = "AssaultRife";
    }

    public AssaultRife(Document doc){
        super(doc);
    }

    @Override
    public String showWeapon() {
        String result = "[Weapon: AssaultRife, " + "Bollet Size: " + this.bollet + "]";
        return result;
    }

    @Override
    public Document getBsonDocument(){
        return super.getBsonDocument();
    }
}
