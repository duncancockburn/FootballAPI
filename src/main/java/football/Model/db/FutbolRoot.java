package football.Model.db;

import football.Model.model.Results;

public class FutbolRoot {

    Results[] firstTeam_VS_secondTeam;
    Results[] firstTeam_lastResults;
    Results[] secondTeam_lastResults;

    public Results[] getFirstTeam_VS_secondTeam() {
        return firstTeam_VS_secondTeam;
    }

    public void setFirstTeam_VS_secondTeam(Results[] firstTeam_VS_secondTeam) {
        this.firstTeam_VS_secondTeam = firstTeam_VS_secondTeam;
    }

    public Results[] getFirstTeam_lastResults() {
        return firstTeam_lastResults;
    }

    public void setFirstTeam_lastResults(Results[] firstTeam_lastResults) {
        this.firstTeam_lastResults = firstTeam_lastResults;
    }

    public Results[] getSecondTeam_lastResults() {
        return secondTeam_lastResults;
    }

    public void setSecondTeam_lastResults(Results[] secondTeam_lastResults) {
        this.secondTeam_lastResults = secondTeam_lastResults;
    }
}
