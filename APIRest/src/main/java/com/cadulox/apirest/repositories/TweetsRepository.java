package com.cadulox.apirest.repositories;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.cadulox.apirest.models.Tweets;

public interface TweetsRepository extends CassandraRepository<Tweets, UUID> {

}
