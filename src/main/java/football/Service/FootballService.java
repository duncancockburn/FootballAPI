package football.Service;


import football.Mapper.FootballMapper;
import football.Model.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FootballService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    FootballMapper footballMapper;

    private final String API_KEY = "c1294129f08c11ae0d1273bd460b00239c4892337afb90d3e55c8738fe5a40c1";

    //METHOD TO PUT ALL OF THE DATA ONTO AN OBJECT

    public Country[] loadAllCountries(String persist) {
        String url = "https://apifootball.com/api/?action=get_countries&APIkey=" + API_KEY;
        //DataRes object = restTemplate.getForObject(url, DataRes.class);
        Country[] response = restTemplate.getForObject(url, Country[].class);   //takes in the compiled java code- map the response to the class

        if (persist.equalsIgnoreCase("true")) {
            insertCountryData(response);
        }
        return response;
    }


    public void insertCountryData(Country[] cdas) {
        for (Country country : cdas) {

            footballMapper.insertCountries(country);
        }
    }
}


