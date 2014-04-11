package biblioj

class Reservation {

    def String codeReservation
    def Date dateReservation

    Set livres = new HashSet()
    static hasMany = [livres:Livre]


    static fetchMode = [livres: 'eager']

    static constraints = {
        codeReservation unique : true, nullable : false, blank : false
        dateReservation min : new Date()
    }

    def boolean isContainsLivre(Long id){
        boolean res = false

        for(livre in livres){
            if(livre.id == id){
                return true
            }
        }

        return res
    }
}
