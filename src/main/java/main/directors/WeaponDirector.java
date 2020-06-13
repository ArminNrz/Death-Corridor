package main.directors;

import main.math.MakeRandom;
import models.bollet.Bollet;
import models.weapons.AssaultRife;
import models.weapons.SniperRife;
import models.weapons.Weapon;
import org.bson.Document;

public class WeaponDirector {
    private Weapon weapon;

    public Weapon chooseWeapon(){
        Bollet bollet = chooseBollet();
        Boolean zoom;

        if(MakeRandom.randomBoolean()){
            this.weapon = new AssaultRife(bollet);
        }else {
            zoom = chooseZoom();
            this.weapon = new SniperRife(bollet, zoom);
        }

        weapon.bolletResult();
        return weapon;
    }

    private Bollet chooseBollet(){
        if(MakeRandom.randomBoolean()){
            return Bollet.CALIBER5MM;
        }else {
            return Bollet.CALIBER7MM;
        }
    }

    private Boolean chooseZoom(){
        if(MakeRandom.randomBoolean()){
            return false;
        }
        else {
            return true;
        }
    }

    public Weapon loadWeaponByBsonDocument(Document doc){
        if(doc.getString("type").equals("AssaultRife")){
            AssaultRife assaultRife = new AssaultRife(doc);
            return assaultRife;
        }else if (doc.getString("type").equals("SniperRife")){
            SniperRife sniperRife = new SniperRife(doc);
            return sniperRife;
        }else {
            return null;
        }
    }
}
