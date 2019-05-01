package com.digi.csvfileprocess.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ReadPreference;
import com.mongodb.ServerAddress;

@Configuration
public class MongoConnectionConfig {

	@Value("${spring.data.mongodb.host}")
	private String host;

	@Value("${spring.data.mongodb.port}")
	private Integer port;

	@Value("${spring.data.mongodb.database}")
	private String db;

	@Value("${spring.data.mongodb.authentication-database}")
	private String authDb;

	@Value("${spring.data.mongodb.username}")
	private String user;

	@Value("${spring.data.mongodb.password}")
	private String pass;

	@Primary
	@Bean(name = "mongoTemplate")
	public MongoTemplate primaryMongoTemplate() throws Exception {
		MongoTemplate template = new MongoTemplate(primaryFactory());
		template.setReadPreference(ReadPreference.secondary());
		return template;
	}

	@Bean
	@Primary
	public MongoDbFactory primaryFactory() throws Exception {
		if (user != null && !user.equalsIgnoreCase("")) {
			List<ServerAddress> seeds = new ArrayList<ServerAddress>();
			seeds.add(new ServerAddress(host, port));
			seeds.add(new ServerAddress("10.31.6.41", port));
			seeds.add(new ServerAddress("10.31.6.42", port));
			MongoCredential credentials = MongoCredential.createScramSha1Credential(user, authDb, pass.toCharArray());
			MongoClient mongoClient = new MongoClient(seeds, Arrays.asList(credentials));
			return new SimpleMongoDbFactory(mongoClient, db);
		} else {
			List<ServerAddress> seeds = new ArrayList<ServerAddress>();
			seeds.add(new ServerAddress(host, port));
			//seeds.add(new ServerAddress("10.31.6.41", port));
			//seeds.add(new ServerAddress("10.31.6.42", port));
			MongoClient mongoClient = new MongoClient(seeds);
			return new SimpleMongoDbFactory(mongoClient, db);
		}
	}

}