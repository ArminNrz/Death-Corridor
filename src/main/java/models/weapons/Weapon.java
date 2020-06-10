package models.weapons;

import models.bollet.Bollet;

public abstract class Weapon {
    protected String type;
    protected int hitRate;
    protected int damage;
    protected Bollet bollet;

    public Weapon(Bollet bollet) {
        this.bollet = bollet;
    }

    public void bolletResult(){
        if(bollet == Bollet.CALIBER5MM){
            hitRate += 15;
        }else {
            hitRate -= 10;
            damage += 10;
        }
    }

    public int getHitRate() {
        return hitRate;
    }

    public int getDamage() {
        return damage;
    }

    public String getType() {return type; }

    public Bollet getBollet() {
        return bollet;
    }

    public void comandoWeapon(){
        hitRate += 5;
    }

    public abstract String showWeapon();
}
