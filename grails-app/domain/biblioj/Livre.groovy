package biblioj
import java.sql.Timestamp

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

    Timestamp version

    static belongsTo = [Reservation, Auteur]

    static constraints = {
        typeDocument nullable: true
        nombreExemplaires min : 0
        nombreExemplairesDisponibles min : 0, validator: { val, obj -> obj.nombreExemplairesDisponibles <= obj.nombreExemplaires}
        }

    def void retirerUnExemplaireDisponible(){
        if(nombreExemplairesDisponibles > 0){
            nombreExemplairesDisponibles --;
        }
    }

    def void ajouterUnExemplaireDisponible(){
        if (nombreExemplairesDisponibles < nombreExemplaires){
            nombreExemplairesDisponibles ++;
        }
    }
}
