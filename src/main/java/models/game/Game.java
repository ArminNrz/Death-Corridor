package models.game;

import main.math.MakeRandom;
import models.acounts.*;
import models.soldier.Soldier;
import org.bson.types.ObjectId;

public class Game {
    private User user;
    private WarResult warResult;

    public Game(){
        user = new User();
    }

    public User getUser(){
        return user;
    }

    public void setUser(User user){
        this.user = user;
    }

    public void StartGame(){
        System.out.println("----Game is start----");
        Rival rival = new Rival();
        int counter = 1;
        int userTeamCount = user.getTeam().size();

        while (judgeWar(rival)) {
            System.out.println("----Round " + counter + "----");
            soldierFight(rival);
            counter++;
        }

        WarStatus warStatus = new WarStatus();
        int deadUnit = userTeamCount - user.getTeam().size();
        int liveUnit = user.getTeam().size();

        warStatus.setDeadUnit(deadUnit);
        warStatus.setLiveUnit(liveUnit);
        warStatus.setWarResult(warResult);
        warStatus.setWarRound(counter);
        ObjectId id = new ObjectId();
        warStatus.setId(id);

        this.user.getWarStatusList().add(warStatus);
    }

    private Soldier selectSoldier(Acount acount){
        Soldier soldier;
        int teamLemght = acount.getTeam().size();
        soldier = acount.getTeam().get(MakeRandom.randomInt(teamLemght));

        return soldier;
    }

    private void soldierFight(Rival rival){
        Soldier userSoldier = selectSoldier(this.user);
        Soldier rivalSoldier = selectSoldier(rival);

        if(MakeRandom.randomBoolean()){
            if(shotting(userSoldier, rivalSoldier, rival)){
                shotting(rivalSoldier, userSoldier, this.user);
            }
        }else {
            if(shotting(rivalSoldier, userSoldier, this.user)){
                shotting(userSoldier, rivalSoldier, rival);
            }
        }

        System.out.println(userSoldier.showSoldier());
        System.out.println(rivalSoldier.showSoldier());
    }

    private Boolean shotting(Soldier soldierAttacker, Soldier soldierDefencer,
                             Acount defenceAcount){
        Boolean result = true;
        int hitrate = soldierAttacker.getWeapon().getHitRate();

        int random = MakeRandom.randomInt(100);
        if(random < hitrate){
            soldierDefencer.getShot(soldierAttacker.getWeapon().getDamage());
        }

        if(soldierDefencer.getHealth() <= 0){
            kill(soldierDefencer.getId(), defenceAcount);
            result = false;
        }

        return result;
    }

    private void kill(ObjectId soldierId, Acount acount){

        for(Soldier soldier : acount.getTeam()){
            if(soldier.getId() == soldierId){
                acount.getTeam().remove(soldier);
                System.out.println(soldier.showSoldier() + " Is Killed");
                break;
            }
        }
    }

    private Boolean judgeWar(Rival rival){
        if(this.user.getTeam().size() == 0) {
            lose();
            return false;
        }
        else if(rival.getTeam().size() == 0){
            win();
            return false;
        }else {
            return true;
        }
    }

    private void lose(){
        System.out.println("---Lose the match---");
        this.warResult = warResult.Lose;
    }

    private void win(){
        this.user.setPoint(this.user.getPoint() + 2);
        this.warResult = warResult.Win;
        System.out.println("---You Win---");
    }
}
