package models.weapons;

import models.bollet.Bollet;
import org.bson.Document;

import java.util.Random;

public class SniperRife extends Weapon {
    private final String ZOOM = "zoom";

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

    public SniperRife(Document doc){
        super(doc);
        this.zoom = doc.getBoolean(ZOOM);
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

    @Override
    public Document getBsonDocument(){
        Document document = super.getBsonDocument();
        document.append(ZOOM, zoom);
        return document;
    }
}
