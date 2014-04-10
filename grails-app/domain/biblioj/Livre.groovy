package biblioj

class Livre {

    def String titre
    def int nombreExemplaires
    def int nombreExemplairesDisponibles

    def TypeDocument typeDocument

    static hasMany = [
            auteurs:Auteur,
            reservations:Reservation
    ]

    static fetchMode = [auteurs: 'eager',
                        reservations: 'eager']

    static belongsTo = [Reservation, Auteur]

    static constraints = {
        typeDocument nullable: true
        nombreExemplaires min : 0
        nombreExemplairesDisponibles min : 0
    }
}
