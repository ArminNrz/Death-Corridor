package persistance.soldiers;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import models.soldier.Comando;
import models.soldier.Sergeant;
import models.soldier.Soldier;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;

public class SoldierDao {
    MongoClient mc = MongoClients.create("mongodb://localhost:27017");
    MongoDatabase md = mc.getDatabase("DeathCollider");
    MongoCollection<Document> mcol = md.getCollection("soldier");

    public void addSoldier(Soldier soldier){
        Document findSoldier = mcol.find(eq("id", soldier.getId())).first();
        if(findSoldier == null) {
            mcol.insertOne(soldier.getBsonDocument());
        }
    }

    public Soldier loadSoldier(int id){
        Document findSoldier = mcol.find(eq("id", id)).first();
        if(findSoldier == null){
            return null;
        }else if (findSoldier.getString("type").equals("Comando")){
            Comando comando = new Comando(findSoldier);
            return comando;
        }else if (findSoldier.getString("type").equals("Sergeant")){
            Sergeant sergeant = new Sergeant(findSoldier);
            return sergeant;
        }else {
            return null;
        }
    }

}
