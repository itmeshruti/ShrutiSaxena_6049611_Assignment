package com.example.TraineeAPI.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TraineeAPI.entities.Trainee;

@Repository
public interface ITraineeRepository extends JpaRepository<Trainee, Integer> {
}
