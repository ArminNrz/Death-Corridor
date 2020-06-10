package models.acounts;

public class User extends Acount {
    private int point;

    public User(){
        teamMaker(5);
        this.point = 10;
    }

    public int getPoint(){
        return this.point;
    }

    public void setPoint(int point){
        this.point = point;
    }
}
