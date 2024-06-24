package com.caps.hackaton_JO_BE;

import com.caps.hackaton_JO_BE.Athlete;
import com.caps.hackaton_JO_BE.AthleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AthleteController {

    @Autowired
    private final AthleteService athleteService;

    public AthleteController(AthleteService athleteService) {
        this.athleteService = athleteService;
    }

    @GetMapping("/athletes")
    public List<Athlete> getAthletes() throws Exception {
        return athleteService.getAthletes();
    }


    @GetMapping("/allAthletes")
    public List<AthleteHisto> getAllAthletes() throws Exception {
        return athleteService.getAthletesFromCsv();
    }

    // get athletes that have a gold medal
    @GetMapping("/goldAthletes")
    public List<AthleteHisto> getGoldAthletes() throws Exception {
        return athleteService.getGoldAthletes();
    }

    // get list of competitions
    @GetMapping("/competitions")
    public List<String> getCompetitions() throws Exception {
        return athleteService.getCompetitions();
    }

}
