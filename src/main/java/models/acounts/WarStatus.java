package models.acounts;

import org.bson.types.ObjectId;

public class WarStatus {
    private ObjectId id;
    private int deadUnit;
    private int liveUnit;
    private int warRound;
    private WarResult warResult;

    public ObjectId getId() {
        return id;
    }

    public int getDeadUnit() {
        return deadUnit;
    }

    public void setDeadUnit(int deadUnit) {
        this.deadUnit = deadUnit;
    }

    public int getLiveUnit() {
        return liveUnit;
    }

    public void setLiveUnit(int liveUnit) {
        this.liveUnit = liveUnit;
    }

    public int getWarRound() {
        return warRound;
    }

    public void setWarRound(int warRound) {
        this.warRound = warRound;
    }

    public WarResult getWarResult() {
        return warResult;
    }

    public void setWarResult(WarResult warResult) {
        this.warResult = warResult;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

}
