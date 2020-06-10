package models.game;

import main.directors.SoldierDirector;
import models.acounts.User;
import models.soldier.Soldier;

import java.util.List;
import java.util.Scanner;

public class Upgrade {
    private User user;

    public Upgrade(User user){
        this.user = user;
    }

    public void upgradeMenu(){
        System.out.println("1.Health Full");
        System.out.println("2.Have a new team");
        System.out.println("3.Add a new team member");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        if(input == 1){
            System.out.println(healthFull());
        }else if (input == 2){
            System.out.println(makeNewTeam());
        }else if (input == 3){
            System.out.println(addNewTeamMember());
        }else {
            System.out.println("Unkown command");
        }
    }

    private String healthFull(){
        if(user.getPoint() >= 2)
        {
            if(user.getTeam().size() > 0){
                user.setPoint( user.getPoint() - 2 );
                for(Soldier soldier : user.getTeam()){
                    if(soldier.getType().equals("Comando")){
                        soldier.setHealth(200);
                    }else {
                        soldier.setHealth(100);
                    }
                }
                return "Health is Full";
            }else {
                return "You Have not team";
            }
        }else {
            return "Have not enogh point";
        }
    }

    private String makeNewTeam(){
        if(user.getPoint() >= 5){
            user.setPoint(user.getPoint() -5);
            user.getTeam().removeAll(user.getTeam());
            user.teamMaker(5);
            return "Maked a new Team";
        }else {
            return "Have not enogh point";
        }
    }

    private String addNewTeamMember(){
        if(user.getPoint() >= 4){
            user.setPoint(user.getPoint() - 4);
            SoldierDirector soldierDirector = new SoldierDirector();
            Soldier soldier = soldierDirector.getSoldier();
            user.getTeam().add(soldier);
            return "Add new Team member";
        }else {
            return "Have not enogh point";
        }
    }
}
