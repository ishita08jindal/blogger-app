package com.bloggerdemoapp.repository;

import com.bloggerdemoapp.entity.TrainJourney;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainJourneyRepository extends JpaRepository<TrainJourney, Long> {
}