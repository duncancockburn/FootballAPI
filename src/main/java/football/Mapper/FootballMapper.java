package football.Mapper;

import football.Model.model.Country;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FootballMapper {

    String INSERT_COUNTRIES = "INSERT INTO `football`.country_data ( country_id, country_name ) " +
            "VALUES (#{country_id}, #{country_name})";

    @Insert(INSERT_COUNTRIES)
    public int insertCountries(Country countries);

}




