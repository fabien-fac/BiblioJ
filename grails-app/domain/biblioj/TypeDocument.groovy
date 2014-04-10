package biblioj

class TypeDocument {

    def String intitule

    def belongsTo = [livre:Livre]

    static constraints = {
    }
}
