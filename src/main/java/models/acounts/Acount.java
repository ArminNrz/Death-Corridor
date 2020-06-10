package models.acounts;

import main.directors.SoldierDirector;
import main.math.MakeRandom;
import models.soldier.Soldier;

import java.util.ArrayList;
import java.util.List;

public abstract class Acount {
    private List<Soldier> team;

    public String teamMaker(int teamLenght){
        team = new ArrayList<>();
        String output = "Team is: ";

        for(int i = 0; i < teamLenght; i++){
            SoldierDirector soldierDirector = new SoldierDirector();
            Soldier soldier = soldierDirector.getSoldier();
            output += soldier.showSoldier();
            team.add(soldier);
        }

        return output;
    }

    public List<Soldier> getTeam(){
        return this.team;
    }

    public Soldier selectSoldier(){
        Soldier soldier;
        int teamlenght = this.team.size();
        soldier = this.team.get(MakeRandom.randomInt(teamlenght));

        return soldier;
    }

    public String showSoldier(){
        String output = "Team is: ";

        for(Soldier soldier : this.team){
            output += soldier.showSoldier();
        }

        return output;
    }
}
