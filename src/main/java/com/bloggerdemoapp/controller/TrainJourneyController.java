package com.bloggerdemoapp.controller;

import com.bloggerdemoapp.entity.Station;
import com.bloggerdemoapp.entity.Train;
import com.bloggerdemoapp.entity.TrainJourney;
import com.bloggerdemoapp.repository.StationRepository;
import com.bloggerdemoapp.repository.TrainJourneyRepository;
import com.bloggerdemoapp.repository.TrainRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/trainJourney")
public class TrainJourneyController {
    private TrainJourneyRepository trainJourneyRepository;
   private TrainRepository trainRepository;;
   private StationRepository  stationRepository;
    public TrainJourneyController(TrainJourneyRepository trainJourneyRepository, TrainRepository trainRepository, StationRepository  stationRepository) {
        this.trainJourneyRepository = trainJourneyRepository;
        this.trainRepository=trainRepository;
        this.stationRepository=stationRepository;
    }

    @PostMapping
    public TrainJourney saveJourney(
            @RequestParam long trainId,
            @RequestParam long stationId,
            @RequestBody TrainJourney trainJourney
    ){
        Train train = trainRepository.findById(trainId).get();
        Station station = stationRepository.findById(stationId).get();
        // remember when setting foreign key do not give id number directly give object there
        trainJourney.setTrain(train);
        trainJourney.setStation(station);
        return trainJourneyRepository.save(trainJourney);
    }
}
