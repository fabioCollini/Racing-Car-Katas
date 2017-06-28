package tddmicroexercises.leaderboard

import java.util.Arrays
import java.util.HashMap

class Race(private val name: String, vararg drivers: Driver) {
    val results: List<Driver> = listOf(*drivers)

    private val driverNames: MutableMap<Driver, String>

    init {
        this.driverNames = HashMap<Driver, String>()
        for (driver in results) {
            var driverName = driver.name
            if (driver is SelfDrivingCar) {
                driverName = "Self Driving Car - " + driver.country + " (" + driver.algorithmVersion + ")"
            }
            this.driverNames.put(driver, driverName)
        }
    }

    fun position(driver: Driver): Int {
        return this.results.indexOf(driver)
    }

    fun getPoints(driver: Driver): Int {
        return Race.POINTS[position(driver)]
    }

    fun getDriverName(driver: Driver): String {
        return this.driverNames[driver]!!
    }

    override fun toString(): String {
        return name
    }

    companion object {

        private val POINTS = arrayOf(25, 18, 15)
    }
}
