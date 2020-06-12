package main.menu;

import models.game.Game;
import models.game.Upgrade;

import java.util.Scanner;

public class Menu {
    private static Scanner sc = new Scanner(System.in);

    public static void mainMenu(){
        Game game;
        System.out.println("----Game Start----");
        String input = "";

        game = showMainMenu(null);

        System.out.println("---Exite (y/n)");
        input = sc.next();

        while (!input.equals("y")){
            if(game.getUser().getTeam().size() == 0){
                if(game.getUser().getPoint() < 2){
                    System.out.println("---Game Over---");
                    break;
                }else {
                    System.out.println("Point: " + game.getUser().getPoint());
                    System.out.println("Team Size: " + game.getUser().getTeam().size());
                    Upgrade upgrade = new Upgrade(game.getUser());
                    upgrade.upgradeMenu();
                }
            }else {
                game = showMainMenu(game);
            }

            System.out.println("---Exite (y/n)");
            input = sc.next();
        }

    }

    public static Game showMainMenu(Game game){
        Boolean flag = false;
        int point = 10;
        int teamNumber = 5;
        if(game != null){
            point = game.getUser().getPoint();
            teamNumber = game.getUser().getTeam().size();
            flag = true;
        }
        System.out.println("--Point is: " + point);
        System.out.println("Team Member count is: " + teamNumber);
        System.out.println("Menu----");
        if(!flag) {
            System.out.println("1.Start New Game");
            System.out.println("2.Load Game");
        }else {
            System.out.println("3.Start War");
            System.out.println("4.Upgrade Team");
            System.out.println("5.Show Team Member");
            System.out.println("6.Save Game");
        }
        int input = sc.nextInt();

        if(input == 1){
            game = new Game();
            game.StartGame();
        }else if (input == 2){
            //load game
        }else if (input == 3){
            game.StartGame();
        }else if (input == 4){
            Upgrade upgrade = new Upgrade(game.getUser());
            upgrade.upgradeMenu();
        }else if (input == 5){
            System.out.println(game.getUser().showSoldier());
        } else if (input == 6){
        }else {
            System.out.println("---Unknown Input---");
        }

        return game;
    }
}
