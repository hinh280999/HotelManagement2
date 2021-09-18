package DAL;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static com.mongodb.client.model.Filters.eq;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import java.util.ArrayList;

import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.*;

import Constant.MongoDbContant;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.*;

import Entity.SampleEntity;

public class MongoUtils {

	public static void main(String[] args) {
		ping();
		System.out.println(" Get Sample Document from MongoDB : " +MongoDbContant.DATABASENAME);
		testDB();
	}

	private static MongoClient getMongoClientDefault() {
		CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
		CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));

		MongoClientSettings settings = MongoClientSettings.builder().codecRegistry(pojoCodecRegistry).build();

		MongoClient mongoClient = MongoClients.create(settings);
		return mongoClient;
	}

	public static MongoClient getMongoClient() {
		return getMongoClientDefault();
	}

	private static void ping() {
		MongoClient mongoClient = getMongoClient();

		System.out.println("List all DB:");

		MongoIterable<String> listDbNames = mongoClient.listDatabaseNames();
		for (String DbName : listDbNames) {
			System.out.println("DBName: " + DbName);
		}

		System.out.println("Done!");

	}

	private static void testDB() {
		MongoClient mongoClient = getMongoClient();
		MongoDatabase database = mongoClient.getDatabase(MongoDbContant.DATABASENAME);
		
		MongoCollection<SampleEntity> collection = database.getCollection(MongoDbContant.SAMPLESUPPLERCOLLECTION, SampleEntity.class);
		
		//InsertOne
//		SampleEntity temp = new SampleEntity(1, "Giuong", 4);
//		collection.insertOne(SampleEntity);
		
		// Insert Many
//		ArrayList<SampleEntity> listTb = new ArrayList<SampleEntity>();
//		listTb.add(new SampleEntity(2, "Chieu", 3));
//		listTb.add(new SampleEntity(2, "Than", 3));
//		listTb.add(new SampleEntity(2, "Ban", 3));
//		collection.insertMany(listTb);
		
		// Update 
//		collection.updateOne(eq("maTB", 1), combine(set("tenTB", "Giuong Update")));
		collection.find().forEach( document -> {System.out.println(document);});
	}

}
