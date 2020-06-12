package models.acounts;

import main.math.MakeRandom;

public class Rival extends Acount {

    public Rival(){
        super();
        teamMaker(MakeRandom.randomInt(8));
    }
}
