package biblioj

class Reservation {

    def String codeReservation
    def Date dateReservation

    static hasMany = [livres:Livre]

    static fetchMode = [livres: 'eager']

    static constraints = {
        codeReservation unique : true, nullable : false, blank : false
        dateReservation min : new Date()
    }
}
