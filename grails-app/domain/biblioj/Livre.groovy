package biblioj

class Livre {

    def String titre
    def int nombreExemplaires
    def int nombreExemplairesDisponibles

    static hasMany = [
            auteurs:Auteur,
            reservations:Reservation
    ]

    static fetchMode = [auteurs: 'eager',
                        reservations: 'eager']

    static belongsTo = [Reservation, Auteur]

    static constraints = {
    }
}
