package models.weapons;

import models.bollet.Bollet;
import org.bson.Document;

public abstract class Weapon {
    private final String DAMAGE = "damage";
    private final String HITRATE = "hitRate";
    private final String TYPE = "type";
    private final String BOLLET = "Bollet";

    protected String type;
    protected int hitRate;
    protected int damage;
    protected Bollet bollet;

    public Weapon(Bollet bollet) {
        this.bollet = bollet;
    }

    public Weapon(Document doc){
        this.hitRate = doc.getInteger(HITRATE);
        this.damage = doc.getInteger(DAMAGE);
        this.type = doc.getString(TYPE);
        String bollet = doc.getString(BOLLET);
        if(bollet.equals("CALIBER5MM"))
            this.bollet = Bollet.CALIBER5MM;
        else
            this.bollet = Bollet.CALIBER7MM;
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

    public Document getBsonDocument(){
        Document document = new Document();
        document.append(HITRATE, hitRate);
        document.append(DAMAGE, damage);
        document.append(TYPE, type);
        document.append(BOLLET, bollet.toString());
        return document;
    }

    public abstract String showWeapon();
}
