package persistance.weapons;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import models.weapons.AssaultRife;
import models.weapons.Weapon;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;

public class WeponDao {

    MongoClient mc = MongoClients.create("mongodb://localhost:27017");
    MongoDatabase md = mc.getDatabase("DeathCollider");
    MongoCollection<Document> mcol = md.getCollection("weapon");

    public String addWepon(Weapon weapon){
        mcol.insertOne(weapon.getBsonDocument());
        return "Add Weapon";
    }

    public Weapon loadWeapon(){
        Document weaponDocument = mcol.find(eq("type", "AssaultRife")).first();
        Weapon weapon = new AssaultRife(weaponDocument);
        return weapon;
    }
}
