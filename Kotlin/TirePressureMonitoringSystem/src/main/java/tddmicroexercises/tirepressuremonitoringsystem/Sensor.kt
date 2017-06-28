package tddmicroexercises.tirepressuremonitoringsystem

import java.util.Random

// The reading of the pressure value from the sensor is simulated in this implementation.
// Because the focus of the exercise is on the other class.

class Sensor {

    fun popNextPressurePsiValue(): Double {
        val pressureTelemetryValue: Double = samplePressure()

        return OFFSET + pressureTelemetryValue
    }

    companion object {
        val OFFSET = 16.0

        private fun samplePressure(): Double {
            // placeholder implementation that simulate a real sensor in a real tire
            val basicRandomNumbersGenerator = Random()
            val pressureTelemetryValue = 6.0 * basicRandomNumbersGenerator.nextDouble() * basicRandomNumbersGenerator.nextDouble()
            return pressureTelemetryValue
        }
    }
}
