package football.Model.model;

public class ResultObect {

        String a = "The game results are as follows:";
        String match_hometeam_name;
        String match_hometeam_score;
        String match_awayteam_name;
        String match_awayteam_score;

    @Override
    public String toString() {
        return "ResultObect{" +
                "a='" + a + '\'' +
                ", match_hometeam_name='" + match_hometeam_name + '\'' +
                ", match_hometeam_score='" + match_hometeam_score + '\'' +
                ", match_awayteam_name='" + match_awayteam_name + '\'' +
                ", match_awayteam_score='" + match_awayteam_score + '\'' +
                '}';
    }
}


