package com.caps.hackaton_JO_BE;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AthleteService {

    //athletesHisto attribute is used to store the athletes from the csv file
    private List<AthleteHisto> athletesHisto = getAthletesFromCsv();

    public List<Athlete> getAthletes() throws Exception {
        try (Reader reader = Files.newBufferedReader(Paths.get("/Users/P003059/Downloads/NATATION_Finales_CM_2019_2024.csv"))) {
            CsvToBean<Athlete> csvToBean = new CsvToBeanBuilder<Athlete>(reader)
                    .withType(Athlete.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<Athlete> athletes = csvToBean.parse();

            // Sort by year and note
            athletes.sort(Comparator.comparing(Athlete::getYear).thenComparing(Athlete::getNote));

            // Classify by position
            return athletes.stream()
                    .peek(athlete -> {
                        if (athlete.getPosition() == 1.0) {
                            athlete.setNote("Gold");
                        } else if (athlete.getPosition() == 2.0) {
                            athlete.setNote("Silver");
                        } else if (athlete.getPosition() == 3.0) {
                            athlete.setNote("Bronze");
                        }
                    })
                    .collect(Collectors.toList());
        }
    }

    public List<AthleteHisto> getAthletesFromCsv()  {
        try (Reader reader = Files.newBufferedReader(Paths.get("/Users/P003059/Downloads/ATHLE_Finales_CM_JO_1983_2022_.csv"))) {
            CsvToBean<AthleteHisto> csvToBean = new CsvToBeanBuilder<AthleteHisto>(reader)
                    .withType(AthleteHisto.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<AthleteHisto> athletes = csvToBean.parse();

            // Set medal based on place
            for (AthleteHisto athlete : athletes) {
                switch (athlete.getPlace()) {
                    case "1.":
                        athlete.setMedal("Gold");
                        break;
                    case "2.":
                        athlete.setMedal("Silver");
                        break;
                    case "3.":
                        athlete.setMedal("Bronze");
                        break;
                    default:
                        athlete.setMedal("No Medal");
                        break;
                }
            }

            // Sort by competition, race, and name
            athletes.sort(Comparator.comparing(AthleteHisto::getCompetition)
                    .thenComparing(AthleteHisto::getRace)
                    .thenComparing(AthleteHisto::getName));

            athletesHisto = athletes;
            return athletes;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

        // method to get the athletesHisto that have a gold medal sorted by how many gold medals they have and render it's count
        public List<AthleteHisto> getGoldAthletes() {
            return athletesHisto.stream()
                    .filter(athlete -> athlete.getMedal().equals("Gold"))
                    .sorted(Comparator.comparing(AthleteHisto::getMedal).reversed())
                    .collect(Collectors.toList());
        }

        //get the list of competitions
        public List<String> getCompetitions() {
            return athletesHisto.stream()
                    .map(AthleteHisto::getCompetition)
                    .distinct()
                    .collect(Collectors.toList());
        }

}