package football.Service;

import football.Mapper.HeadtoHeadMapper;
import football.Model.db.FutbolRoot;
import football.Model.model.Results;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;


@Service
public class LiveScoreService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    HeadtoHeadMapper headtoHeadMapper;

    @Autowired
    AuthService authService;

    private final Logger logger = LoggerFactory.getLogger(getClass());




    private final String API_KEY = "c1294129f08c11ae0d1273bd460b00239c4892337afb90d3e55c8738fe5a40c1";

    //METHOD TO PUT ALL OF THE DATA ONTO AN OBJECT



    public FutbolRoot firstTeam_lastResults(String keyword1, String keyword2, String apiKey, String persist) {
        String url = "https://apifootball.com/api/?action=get_H2H&firstTeam=" + keyword1 + "&secondTeam=" +
                keyword2 + "&APIkey=" + API_KEY;
        //DataRes object = restTemplate.getForObject(url, DataRes.class);

        FutbolRoot response = restTemplate.getForObject(url, FutbolRoot.class);


        if (authService.security(apiKey) == true && persist.equalsIgnoreCase("true")) {
            insertGameData(response);
        }
        return response;
    }


    public void insertGameData(FutbolRoot game) {
        Results[] firstTeamResults = game.getFirstTeam_lastResults();
        Results[] keyscores = game.getFirstTeam_VS_secondTeam();
        Results[] secondTeamResults = game.getSecondTeam_lastResults();

        for (Results results : keyscores) {

            if (headtoHeadMapper.checkIfExists(results) == null ) {
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




    @Cacheable(value = "football", key = "#team1")
    public int numberOfWins(String team1) {
        logger.info("Retrieving tasks");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return headtoHeadMapper.numberOfWins1(team1);
    }

    @CacheEvict(value = "football", allEntries = true)
    public void clearCache() {
        logger.info("Cache cleared");
    }




    public int addNew(Results results) {
        return headtoHeadMapper.addNewResult(results);
   //     return headtoHeadMapper.selectAllResults() ;
    }




    @CachePut(value = "football", key = "#team1")
    public Results updateByScore(Results result) {
        logger.info("<!----------Entering update ------------------->");
        headtoHeadMapper.updateByScore(result);
        return headtoHeadMapper.selectAllResults();
    }


    @Cacheable(value = "delete", key = "#match_id")
    @CacheEvict(value = "delete", key = "#match_id")
    public String deleteByScore(String match_id) {
        headtoHeadMapper.deleteByScore(match_id);
        return "deleted";
    }
}
