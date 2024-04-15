package com.buddy.socialbuddy.scheduler;

import com.mongodb.client.MongoClient;
import net.javacrumbs.shedlock.core.LockProvider;
import net.javacrumbs.shedlock.provider.mongo.MongoLockProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SchedulerConfig {

  @Bean
  public LockProvider lockProvider(
      MongoClient mongo, @Value("${spring.data.mongodb.database}") String databaseName) {
    return new MongoLockProvider(mongo.getDatabase(databaseName));
  }
}
