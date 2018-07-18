package football.Controller;

import football.Model.db.FutbolRoot;
import football.Model.model.Country;
import football.Model.model.Results;
import football.Service.FootballService;
import football.Service.LiveScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController

@RequestMapping("/football")

public class FootballController {

    @Autowired
    FootballService footballService;

    @Autowired
    LiveScoreService liveScoreService;


    @RequestMapping("/countryData/load")
    public Country[] loadAllInfo(
            @RequestParam("persist") String persist) {
        Country[] object = footballService.loadAllCountries("true");

        return object;

    }

    @RequestMapping("/gameData/load")
    public FutbolRoot firstTeam_lastResults(
        @RequestParam("keyword1") String keyword1,
        @RequestParam("keyword2") String keyword2,
        @RequestParam("persist") String persist) {

        FutbolRoot object = liveScoreService.firstTeam_lastResults(keyword1, keyword2, "true");
        return object;
    }

    @RequestMapping("/getTeam1Form")
    public int numberOfWinsT1(
            @RequestParam("team1") String team1) {
        return liveScoreService.numberOfWins(team1);
    }

    //Create
    @PostMapping("/")
    public int addNew(@RequestBody Results results) {
        return liveScoreService.addNew(results);
    }


    //Update
    @PutMapping("/")
    public Results updateByScore(@RequestBody Results results) {
        return liveScoreService.updateByScore(results);
    }


    //Delete
    @DeleteMapping("/")
    public Results deleteByMatchID(@RequestParam(value="match_id")String match_id){
        return liveScoreService.deleteByScore(match_id);
    }
}


