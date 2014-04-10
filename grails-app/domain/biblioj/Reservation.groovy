package biblioj

class Reservation {

    def String codeReservation
    def Date dateReservation

    static hasMany = [livres:Livre]

    static fetchMode = [livres: 'eager']

    static constraints = {
    }
}
