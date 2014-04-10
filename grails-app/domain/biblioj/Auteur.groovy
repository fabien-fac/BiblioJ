package biblioj

class Auteur {

    def String nom
    def String prenom

    static hasMany = [oeuvres:Livre]

    static fetchMode = [oeuvres: 'eager']

    static constraints = {
    }

}
