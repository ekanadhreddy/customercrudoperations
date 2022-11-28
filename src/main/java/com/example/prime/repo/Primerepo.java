package com.example.prime.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.prime.entity.Prime;

public interface Primerepo extends JpaRepository<Prime, Long> {

}
