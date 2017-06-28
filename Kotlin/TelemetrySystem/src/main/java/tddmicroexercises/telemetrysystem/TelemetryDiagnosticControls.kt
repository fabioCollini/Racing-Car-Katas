package tddmicroexercises.telemetrysystem

class TelemetryDiagnosticControls {
    private val DiagnosticChannelConnectionString = "*111#"

    private val telemetryClient = TelemetryClient()

    var diagnosticInfo = ""

    fun checkTransmission() {
        diagnosticInfo = ""

        telemetryClient.disconnect()

        var retryLeft = 3
        while (!telemetryClient.onlineStatus && retryLeft > 0) {
            telemetryClient.connect(DiagnosticChannelConnectionString)
            retryLeft -= 1
        }

        if (!telemetryClient.onlineStatus) {
            throw Exception("Unable to connect.")
        }

        telemetryClient.send(TelemetryClient.DIAGNOSTIC_MESSAGE)
        diagnosticInfo = telemetryClient.receive()
    }
}
