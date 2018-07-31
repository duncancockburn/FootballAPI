package football.Model.model;

public class Results {
    int idheadtohead;
    String match_id;
    String country_id;
    String country_name;
    String league_id;
    String league_name;
    String match_date;
    String match_status;
    String match_time;
    String match_hometeam_name;
    String match_hometeam_score;
    String match_awayteam_name;
    String match_awayteam_score;
    String match_hometeam_halftime_score;
    String match_awayteam_halftime_score;
    String match_live;

    public Results(int idheadtohead, String match_id, String country_id, String country_name, String league_id, String league_name, String match_date, String match_status, String match_time, String match_hometeam_name, String match_hometeam_score, String match_awayteam_name, String match_awayteam_score, String match_hometeam_halftime_score, String match_awayteam_halftime_score, String match_live) {
        this.idheadtohead = idheadtohead;
        this.match_id = match_id;
        this.country_id = country_id;
        this.country_name = country_name;
        this.league_id = league_id;
        this.league_name = league_name;
        this.match_date = match_date;
        this.match_status = match_status;
        this.match_time = match_time;
        this.match_hometeam_name = match_hometeam_name;
        this.match_hometeam_score = match_hometeam_score;
        this.match_awayteam_name = match_awayteam_name;
        this.match_awayteam_score = match_awayteam_score;
        this.match_hometeam_halftime_score = match_hometeam_halftime_score;
        this.match_awayteam_halftime_score = match_awayteam_halftime_score;
        this.match_live = match_live;
    }

    public int getIdheadtohead() {
        return idheadtohead;
    }

    public void setIdheadtohead(int idheadtohead) {
        this.idheadtohead = idheadtohead;
    }

    public String getMatch_id() {
        return match_id;
    }

    public void setMatch_id(String match_id) {
        this.match_id = match_id;
    }

    public String getCountry_id() {
        return country_id;
    }

    public void setCountry_id(String country_id) {
        this.country_id = country_id;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public String getLeague_id() {
        return league_id;
    }

    public void setLeague_id(String league_id) {
        this.league_id = league_id;
    }

    public String getLeague_name() {
        return league_name;
    }

    public void setLeague_name(String league_name) {
        this.league_name = league_name;
    }

    public String getMatch_date() {
        return match_date;
    }

    public void setMatch_date(String match_date) {
        this.match_date = match_date;
    }

    public String getMatch_status() {
        return match_status;
    }

    public void setMatch_status(String match_status) {
        this.match_status = match_status;
    }

    public String getMatch_time() {
        return match_time;
    }

    public void setMatch_time(String match_time) {
        this.match_time = match_time;
    }

    public String getMatch_hometeam_name() {
        return match_hometeam_name;
    }

    public void setMatch_hometeam_name(String match_hometeam_name) {
        this.match_hometeam_name = match_hometeam_name;
    }

    public String getMatch_hometeam_score() {
        return match_hometeam_score;
    }

    public void setMatch_hometeam_score(String match_hometeam_score) {
        this.match_hometeam_score = match_hometeam_score;
    }

    public String getMatch_awayteam_name() {
        return match_awayteam_name;
    }

    public void setMatch_awayteam_name(String match_awayteam_name) {
        this.match_awayteam_name = match_awayteam_name;
    }

    public String getMatch_awayteam_score() {
        return match_awayteam_score;
    }

    public void setMatch_awayteam_score(String match_awayteam_score) {
        this.match_awayteam_score = match_awayteam_score;
    }

    public String getMatch_hometeam_halftime_score() {
        return match_hometeam_halftime_score;
    }

    public void setMatch_hometeam_halftime_score(String match_hometeam_halftime_score) {
        this.match_hometeam_halftime_score = match_hometeam_halftime_score;
    }

    public String getMatch_awayteam_halftime_score() {
        return match_awayteam_halftime_score;
    }

    public void setMatch_awayteam_halftime_score(String match_awayteam_halftime_score) {
        this.match_awayteam_halftime_score = match_awayteam_halftime_score;
    }

    public String getMatch_live() {
        return match_live;
    }

    public void setMatch_live(String match_live) {
        this.match_live = match_live;
    }
}
