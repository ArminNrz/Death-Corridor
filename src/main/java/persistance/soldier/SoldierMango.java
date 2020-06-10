package persistance.soldier;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import models.soldier.Comando;
import models.soldier.Sergeant;
import models.soldier.Soldier;
import models.weapons.Weapon;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class SoldierMango implements SoldierDao {
    MongoClient mongoClient;
    MongoDatabase database;
    MongoCollection<Soldier> collection;

    public SoldierMango(){
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        MongoClientSettings settings = MongoClientSettings.builder()
                .codecRegistry(pojoCodecRegistry)
                .build();
        mongoClient = MongoClients.create(settings);
        database = mongoClient.getDatabase("DeathCollider");
        database = database.withCodecRegistry(pojoCodecRegistry);
        collection = database.getCollection("soldier", Soldier.class);
    }

    @Override
    public Soldier addSoldier(Soldier soldier) {
        collection.insertOne(soldier);
        return soldier;
    }
}
