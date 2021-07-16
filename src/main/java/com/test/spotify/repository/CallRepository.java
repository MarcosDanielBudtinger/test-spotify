package com.test.spotify.repository;

import com.test.spotify.model.Call;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CallRepository extends JpaRepository<Call, Long>{
    
}
