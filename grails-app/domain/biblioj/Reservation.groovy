package biblioj

import java.sql.Timestamp

class Reservation {

    def String codeReservation
    def Date dateReservation

    Set livres = new HashSet()
    static hasMany = [livres:Livre]


    static fetchMode = [livres: 'eager']

    Timestamp version

    static constraints = {
        codeReservation unique : true, nullable : false, blank : false
        dateReservation validator: { val, obj -> obj.dateReservation.getDate().equals(new Date().plus(1).getDate())}
    }

    def boolean isContainsLivre(Long id){

        for(livre in livres){
            if(livre.id == id){
                return true
            }
        }

        return false
    }

    def boolean supprimerReservation(Long id){

        for(livre in livres){
            if(livre.id == id){
                livres.remove(livre)
                return true
            }
        }

        return false
    }

}
