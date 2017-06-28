package tddmicroexercises.leaderboard

import java.util.ArrayList
import java.util.Arrays
import java.util.Collections
import java.util.Comparator
import java.util.HashMap

class Leaderboard(vararg races: Race) {

    private val races = listOf(*races)

    fun driverResults(): Map<String, Int> {
        val results = HashMap<String, Int>()
        for (race in this.races) {
            for (driver in race.results) {
                val driverName = race.getDriverName(driver)
                val points = race.getPoints(driver)
                if (results.containsKey(driverName)) {
                    results.put(driverName, results[driverName]!! + points)
                } else {
                    results.put(driverName, 0 + points)
                }
            }
        }
        return results
    }

    fun driverRankings(): List<String> {
        val results = driverResults()
        val resultsList = results.keys.toMutableList()
        resultsList.sortByDescending { results[it] }
        return resultsList
    }
}
