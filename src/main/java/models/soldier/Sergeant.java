package models.soldier;

import models.weapons.Weapon;

public class Sergeant extends Soldier {
    public Sergeant(){
        super();
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
}
