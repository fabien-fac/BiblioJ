package biblioj

import java.sql.Timestamp

class Auteur {

    def String nom
    def String prenom

    static hasMany = [oeuvres:Livre]

    static fetchMode = [oeuvres: 'eager']
    Timestamp version

    static constraints = {
        nom nullable : false, blank : false
        prenom nulle : false, blank : false
    }

    String toString(){
        return nom + " " + prenom
    }

}
