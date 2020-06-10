package models.acounts;

import java.util.ArrayList;
import java.util.List;

public class User extends Acount {
    private int point;
    private List<WarStatus> warStatusList;

    public User(){
        teamMaker(5);
        this.point = 10;
        warStatusList = new ArrayList<>();
    }

    public List<WarStatus> getWarStatusList() {
        return warStatusList;
    }

    public int getPoint(){
        return this.point;
    }

    public void setPoint(int point){
        this.point = point;
    }

    public void setWarStatusList(List<WarStatus> warStatusList) {
        this.warStatusList = warStatusList;
    }

}
