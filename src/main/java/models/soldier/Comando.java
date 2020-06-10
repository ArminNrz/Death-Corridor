package models.soldier;

import models.weapons.Weapon;

public class Comando extends Soldier {


    public Comando(Weapon weapon) {
        super(weapon);
        this.weapon.comandoWeapon();
        type = "Comando";
        health = 200;
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
        health += 5;
    }
}
