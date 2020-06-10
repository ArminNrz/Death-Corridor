package models.weapons;

import models.bollet.Bollet;

import java.util.Random;

public class SniperRife extends Weapon {
    private Boolean zoom;

    public SniperRife(Bollet bollet, Boolean zoom) {
        super(bollet);
        this.zoom = zoom;
        hitRate = 60;
        damage = 20;
        if (this.zoom){
            hitRate += makeRandomZoom();
        }
        type = "SniperRife";
    }

    private int makeRandomZoom(){
        Random r = new Random();
        int low = 5;
        int high = 15;
        return r.nextInt(high-low) + low;
    }

    @Override
    public String showWeapon() {
        String result = "[Weapon: SniperRife, " + "Bollet Size: " + this.bollet + "]";
        return result;
    }

    public Boolean getZoom(){
        return this.zoom;
    }
}
