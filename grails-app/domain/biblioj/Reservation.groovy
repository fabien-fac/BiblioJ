package biblioj

class Reservation {

    def String codeReservation
    def Date dateReservation

    static hasMany = [livres:Livre]

    static constraints = {
    }
}
