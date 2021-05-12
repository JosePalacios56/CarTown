package com.proyecto.cartown.repository;

import com.mongodb.client.MongoDatabase;
import com.proyecto.cartown.modelo.Coche;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface CocheRepository extends MongoRepository<Coche, Serializable> {
}
