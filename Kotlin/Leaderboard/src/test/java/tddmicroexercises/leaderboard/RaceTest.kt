package tddmicroexercises.leaderboard

import org.junit.Assert
import org.junit.Test

class RaceTest {

    @Test fun isShouldCalculateDriverPoints() {
        // setup

        // act

        // verify
        Assert.assertEquals(25, TestData.race1.getPoints(TestData.driver1).toLong())
        Assert.assertEquals(18, TestData.race1.getPoints(TestData.driver2).toLong())
        Assert.assertEquals(15, TestData.race1.getPoints(TestData.driver3).toLong())
    }
}
