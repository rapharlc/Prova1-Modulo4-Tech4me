package com.tech4me.prova1.repository;

import com.tech4me.prova1.model.Musica;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MusicaRepository extends MongoRepository<Musica, String> {
    
}
