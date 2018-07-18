package football.Mapper;

import football.Model.db.FutbolRoot;
import football.Model.model.Results;
import org.apache.ibatis.annotations.*;


@Mapper
public interface HeadtoHeadMapper {

    String INSERT_RESULTS = "INSERT INTO `football`.allresults ( match_id, country_id, country_name, league_id, " +
            "league_name, match_date, match_status, match_time, match_hometeam_name, match_hometeam_score, " +
            "match_awayteam_name, match_awayteam_score, match_hometeam_halftime_score, " +
            "match_awayteam_halftime_score, match_live) VALUES (#{match_id}, #{country_id}, #{country_name}," +
            " #{league_id}, #{league_name}, #{match_date}, #{match_status}, #{match_time}, #{match_hometeam_name}," +
            " #{match_hometeam_score}, #{match_awayteam_name}, #{match_awayteam_score}, " +
            "#{match_hometeam_halftime_score}, #{match_awayteam_halftime_score}, #{match_live})";


    String INSERT_MATCH = "INSERT INTO `football`.allresults ( match_id, country_id, country_name, league_id, " +
            "league_name, match_date, match_status, match_time, match_hometeam_name, match_hometeam_score, " +
            "match_awayteam_name, match_awayteam_score, match_hometeam_halftime_score, " +
            "match_awayteam_halftime_score, match_live) VALUES (#{match_id}, #{country_id}, #{country_name}," +
            " #{league_id}, #{league_name}, #{match_date}, #{match_status}, #{match_time}, #{match_hometeam_name}," +
            " #{match_hometeam_score}, #{match_awayteam_name}, #{match_awayteam_score}, " +
            "#{match_hometeam_halftime_score}, #{match_awayteam_halftime_score}, #{match_live})";

    String UPDATE_MATCH = "UPDATE `football`.allresults SET match_id = #{match_id}, country_id = #{country_id} " +
            "WHERE id = #{id})";

    String DELETE_MATCH = "DELETE FROM `football`.allresults WHERE match_id = #{match_id}";

    String CHECK_SECTION_EXISTS = "" +
            "select * from `football`.allresults " +
            "where match_id = #{match_id} " +
            "limit 1";

    String SELECT_ALL_RESULTS = "" +
            "select * from `football`.allresults ";

    String NUMBER_OF_WINS = "SELECT COUNT(MATCH_HOMETEAM_NAME) " +
            "FROM `football`.allresults " +
            "WHERE MATCH_HOMETEAM_NAME= #{team1} " +
            "AND MATCH_HOMETEAM_SCORE = MATCH_AWAYTEAM_SCORE";


    @Insert(INSERT_RESULTS)
    public int insertResult(Results firstTeam_lastResults);

    @Select(CHECK_SECTION_EXISTS)
    public Results checkIfExists(Results a);

    @Select(NUMBER_OF_WINS)
    public int numberOfWins1(String team1);

    @Select(SELECT_ALL_RESULTS)
    public Results selectAllResults();

    @Select(NUMBER_OF_WINS)
    public int numberOfWins2(String team2);

    @Insert(INSERT_MATCH)
    public int addNewResult(Results results);

    @Update(UPDATE_MATCH)
    int updateByScore(Results results);

    @Delete(DELETE_MATCH)
    int deleteByScore(String match_id);
}

