package tddmicroexercises.turnticketdispenser

class TicketDispenser {
    val turnTicket: TurnTicket
        get() {
            val newTurnNumber = TurnNumberSequence.nextTurnNumber
            val newTurnTicket = TurnTicket(newTurnNumber)

            return newTurnTicket
        }
}
