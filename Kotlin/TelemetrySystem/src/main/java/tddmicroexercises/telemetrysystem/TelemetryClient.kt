package tddmicroexercises.telemetrysystem

import java.util.Random

class TelemetryClient {

    var onlineStatus: Boolean = false
        private set
    private var diagnosticMessageResult: String? = ""

    private val connectionEventsSimulator = Random(42)

    fun connect(telemetryServerConnectionString: String?) {
        if (telemetryServerConnectionString == null || "" == telemetryServerConnectionString) {
            throw IllegalArgumentException()
        }

        // simulate the operation on a real modem
        val success = connectionEventsSimulator.nextInt(10) <= 8

        onlineStatus = success
    }

    fun disconnect() {
        onlineStatus = false
    }

    fun send(message: String?) {
        if (message == null || "" == message) {
            throw IllegalArgumentException()
        }

        if (message === DIAGNOSTIC_MESSAGE) {
            // simulate a status report
            diagnosticMessageResult = """LAST TX rate................ 100 MBPS
HIGHEST TX rate............. 100 MBPS
LAST RX rate................ 100 MBPS
HIGHEST RX rate............. 100 MBPS
BIT RATE.................... 100000000
WORD LEN.................... 16
WORD/FRAME.................. 511
BITS/FRAME.................. 8192
MODULATION TYPE............. PCM/FM
TX Digital Los.............. 0.75
RX Digital Los.............. 0.10
BEP Test.................... -5
Local Rtrn Count............ 00
Remote Rtrn Count........... 00"""

            return
        }

        // here should go the real Send operation (not needed for this exercise)
    }

    fun receive(): String {
        var message: String

        if (diagnosticMessageResult == null || "" == diagnosticMessageResult) {
            // simulate a received message (just for illustration - not needed for this exercise)
            message = ""
            val messageLength = connectionEventsSimulator.nextInt(50) + 60
            for (i in messageLength downTo 0) {
                message += connectionEventsSimulator.nextInt(40).toChar().toInt() + 86
            }

        } else {
            message = diagnosticMessageResult!!
            diagnosticMessageResult = ""
        }

        return message
    }

    companion object {
        val DIAGNOSTIC_MESSAGE = "AT#UD"
    }
}

