package main.directors;

import main.math.MakeRandom;
import models.soldier.Comando;
import models.soldier.Sergeant;
import models.soldier.Soldier;
import models.weapons.AssaultRife;
import org.bson.types.ObjectId;

public class SoldierDirector {
    private Soldier soldier;
    WeaponDirector weaponDirector;

    public SoldierDirector(){
        weaponDirector = new WeaponDirector();
    }

    public Soldier getSoldier(){

        if (MakeRandom.randomBoolean()){
            soldier = new Comando(weaponDirector.chooseWeapon());
        }else {
            soldier = new Sergeant(weaponDirector.chooseWeapon());
        }

        return soldier;
    }
}
