package models.weapons;

import models.bollet.Bollet;

public class AssaultRife extends Weapon {
    public AssaultRife(Bollet bollet) {
        super(bollet);
        hitRate = 50;
        damage = 10;
        type = "AssaultRife";
    }

    @Override
    public String showWeapon() {
        String result = "[Weapon: AssaultRife, " + "Bollet Size: " + this.bollet + "]";
        return result;
    }
}
