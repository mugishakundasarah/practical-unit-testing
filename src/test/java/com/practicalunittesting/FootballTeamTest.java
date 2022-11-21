package com.practicalunittesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


@Test
public class FootballTeamTest {
    private static final int ANY_NUMBER = 123;
    @DataProvider
    public Object[][] nbOfGamesWon(){
        return new Object[][]{{0}, {1}, {2}};
    }

    @DataProvider
    public Object[][] illegalNbOfGamesWon(){
        return new Object[][]{{-10}, {-1}};
    }

    @Test(dataProvider = "illegalNbOfGamesWon", expectedExceptions = IllegalArgumentException.class)
    public void shouldThrowExceptionForIllegalGamesNb(int illegalNbOfGames){
        new FootballTeam(illegalNbOfGames);
    }

    @Test(dataProvider = "nbOfGamesWon")
    public void constructorShouldSetGamesWon(int nbOfGamesWon){
        FootballTeam team = new FootballTeam(nbOfGamesWon);
        assertEquals(team.getGamesWon(), nbOfGamesWon,  nbOfGamesWon + " games were passed to the contructor, but " + team.getGamesWon() + " were returned");
    }

    public  void shouldBePossibleToCompareTeams(){
        FootballTeam team = new FootballTeam(ANY_NUMBER);

        assertTrue(team instanceof Comparable, "Football team should implement Comparable");
    }

    public void teamsWithLessMatchesWonShouldBeLesser(){
        FootballTeam team_2 = new FootballTeam(2);
        FootballTeam team_3 = new FootballTeam(3);
        assertTrue(team_2.compareTo(team_3) < 0, "Team with " + team_3.getGamesWon() + " games won should be ranked after the team with " + team_3.getGamesWon());
    }

    public void teamsWithMoreMatchesWonShouldBeGreater(){
        FootballTeam team_2 = new FootballTeam(2);
        FootballTeam team_3 = new FootballTeam(3);
        assertTrue(team_3.compareTo(team_2) > 0, "Team with " + team_3.getGamesWon() + " games won should be ranked before the team with " + team_3.getGamesWon());
    }

    public void teamsWithMoreMatchesWonShouldBeEqual(){
        FootballTeam team_2 = new FootballTeam(2);
        FootballTeam team_3 = new FootballTeam(2);
        assertTrue(team_3.compareTo(team_2) == 0, "Both teams have won the same number of games: " + team_3.getGamesWon() + " vs " + team_3.getGamesWon() + " and should be ranked equal");
    }
}
