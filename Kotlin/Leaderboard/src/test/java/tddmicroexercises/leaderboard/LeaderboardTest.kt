package tddmicroexercises.leaderboard

import org.junit.Test

import java.util.Arrays

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import tddmicroexercises.leaderboard.TestData.driver1
import tddmicroexercises.leaderboard.TestData.driver2
import tddmicroexercises.leaderboard.TestData.driver3

class LeaderboardTest {

    @Test fun itShouldSumThePoints() {
        // setup

        // act
        val results = TestData.sampleLeaderboard1.driverResults()

        // verify
        assertTrue("results " + results, results.containsKey("Lewis Hamilton"))
        assertEquals((18 + 18 + 25).toLong(), (results["Lewis Hamilton"] as Int).toLong())
    }

    @Test fun isShouldFindTheWinner() {
        // setup

        // act
        val result = TestData.sampleLeaderboard1.driverRankings()

        // verify
        assertEquals("Lewis Hamilton", result[0])
    }

    @Test fun itShouldKeepAllDriversWhenSamePoints() {
        // setup
        // bug, drops drivers with same points
        val winDriver1 = Race("Australian Grand Prix", TestData.driver1, TestData.driver2, TestData.driver3)
        val winDriver2 = Race("Malaysian Grand Prix", TestData.driver2, TestData.driver1, TestData.driver3)
        val exEquoLeaderBoard = Leaderboard(winDriver1, winDriver2)

        // act
        val rankings = exEquoLeaderBoard.driverRankings()

        // verify
        assertEquals(Arrays.asList(TestData.driver1.name, TestData.driver2.name, TestData.driver3.name), rankings)
        // note: the order of driver1 and driver2 is JDK/platform dependent
    }

}
