package models.acounts;

import main.directors.SoldierDirector;
import main.math.MakeRandom;
import models.soldier.Soldier;

import java.util.ArrayList;
import java.util.List;

public abstract class Acount {
    protected List<Soldier> team;

    public Acount(){
        team = new ArrayList<>();
    }

    public String teamMaker(int teamLenght){
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

    public void setTeam(List<Soldier> team) {
        this.team = team;
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
