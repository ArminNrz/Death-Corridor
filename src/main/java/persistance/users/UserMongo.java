package persistance.users;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import models.acounts.User;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.types.ObjectId;

import java.util.List;

import static com.mongodb.client.model.Filters.*;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class UserMongo implements UserDao {
    MongoClient mongoClient;
    MongoDatabase database;
    MongoCollection<User> collection;

    public UserMongo(){
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        MongoClientSettings settings = MongoClientSettings.builder()
                .codecRegistry(pojoCodecRegistry)
                .build();
        mongoClient = MongoClients.create(settings);
        database = mongoClient.getDatabase("DeathCollider");
        database = database.withCodecRegistry(pojoCodecRegistry);
        collection = database.getCollection("users", User.class);
    }

    @Override
    public User addUser(User user) {
        User finduser  = collection.find(eq("_id", user.getId())).first();
        if(finduser != null){
            collection.replaceOne(eq("_id", finduser.getId()), user);
        }else {
            collection.insertOne(user);
        }

        return user;
    }

    @Override
    public User loadUser(User user) {
        return user;
    }
}
