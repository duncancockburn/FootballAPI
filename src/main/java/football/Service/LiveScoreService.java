package football.Service;

import football.Mapper.HeadtoHeadMapper;
import football.Model.db.FutbolRoot;
import football.Model.model.ResultObect;
import football.Model.model.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.xml.bind.DatatypeConverter;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;


@Service
public class LiveScoreService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    HeadtoHeadMapper headtoHeadMapper;

    private final String API_KEY = "c1294129f08c11ae0d1273bd460b00239c4892337afb90d3e55c8738fe5a40c1";

    //METHOD TO PUT ALL OF THE DATA ONTO AN OBJECT


    public FutbolRoot firstTeam_lastResults(String keyword1, String keyword2, String persist) {
        String url = "https://apifootball.com/api/?action=get_H2H&firstTeam=" + keyword1 + "&secondTeam=" +
                keyword2 + "&APIkey=" + API_KEY;
        //DataRes object = restTemplate.getForObject(url, DataRes.class);

        FutbolRoot response = restTemplate.getForObject(url, FutbolRoot.class);

        if (persist.equalsIgnoreCase("true")) {
            insertGameData(response);
        }
        return response;
    }


    public void insertGameData(FutbolRoot game) {
        Results[] firstTeamResults = game.getFirstTeam_lastResults();
        Results[] keyscores = game.getFirstTeam_VS_secondTeam();
        Results[] secondTeamResults = game.getSecondTeam_lastResults();

        for (Results results : keyscores) {
            if (headtoHeadMapper.checkIfExists(results) == null) {
                headtoHeadMapper.insertResult(results);
            }
        }
        for (Results results : firstTeamResults) {
            if (headtoHeadMapper.checkIfExists(results) == null) {
                headtoHeadMapper.insertResult(results);
            }
        }
        for (Results results : secondTeamResults) {
            if (headtoHeadMapper.checkIfExists(results) == null) {
                headtoHeadMapper.insertResult(results);
            }
        }
    }


    public int numberOfWins(String team1) {
        return headtoHeadMapper.numberOfWins1(team1);
    }


    public int addNew(Results results) {
        return headtoHeadMapper.addNewResult(results);
   //     return headtoHeadMapper.selectAllResults() ;
    }

    public Results updateByScore(Results results) {
        headtoHeadMapper.updateByScore(results);
        return headtoHeadMapper.selectAllResults();
    }

    public Results deleteByScore(String match_id) {
        headtoHeadMapper.deleteByScore(match_id);
        return headtoHeadMapper.selectAllResults();
    }

    //adding custom "roll your own" api key authentication - we need:


}
