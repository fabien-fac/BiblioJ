package biblioj

import org.springframework.dao.DataIntegrityViolationException

import java.sql.Timestamp
import java.sql.DriverManager

class ReservationController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [reservationInstanceList: Reservation.list(params), reservationInstanceTotal: Reservation.count()]
    }

    /*def main() {
        Reservation reservation = Reservation.get(session.getAttribute("idReservation"))
        [reservationInstance:reservation]

    }*/

    def create() {
        [reservationInstance: new Reservation(params)]
    }

    def save() {
        def reservationInstance = new Reservation(params)
        if (!reservationInstance.save(flush: true)) {
            render(view: "create", model: [reservationInstance: reservationInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'reservation.label', default: 'Reservation'), reservationInstance.id])
        redirect(action: "show", id: reservationInstance.id)
    }

    def show(Long id) {
        def reservationInstance = Reservation.get(id)
        if (!reservationInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'reservation.label', default: 'Reservation'), id])
            redirect(action: "list")
            return
        }

        int nbLivreDispo = 0

        for(livre in reservationInstance.getLivres()){
            if(livre.nombreExemplairesDisponibles > 0){
                nbLivreDispo++
            }
        }

        [reservationInstance: reservationInstance, nbLivreDispo: nbLivreDispo, hideButton: true]
    }

    def edit(Long id) {
        def reservationInstance = Reservation.get(id)
        if (!reservationInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'reservation.label', default: 'Reservation'), id])
            redirect(action: "list")
            return
        }

        [reservationInstance: reservationInstance]
    }

    def update(Long id, Timestamp version) {
        def reservationInstance = Reservation.get(id)
        if (!reservationInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'reservation.label', default: 'Reservation'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (reservationInstance.version > version) {
                reservationInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'reservation.label', default: 'Reservation')] as Object[],
                        "Another user has updated this Reservation while you were editing")
                render(view: "edit", model: [reservationInstance: reservationInstance])
                return
            }
        }

        reservationInstance.properties = params

        if (!reservationInstance.save(flush: true)) {
            render(view: "edit", model: [reservationInstance: reservationInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'reservation.label', default: 'Reservation'), reservationInstance.id])
        redirect(action: "show", id: reservationInstance.id)
    }

    def delete(Long id) {
        def reservationInstance = Reservation.get(id)
        if (!reservationInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'reservation.label', default: 'Reservation'), id])
            redirect(action: "list")
            return
        }

        try {
            reservationInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'reservation.label', default: 'Reservation'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'reservation.label', default: 'Reservation'), id])
            redirect(action: "show", id: id)
        }
    }

    def ajoutLivre(Long idReservation, Long idLivre){
        def reservationInstance = Reservation.get(idReservation)
        def livreInstance = Livre.get(idLivre)
        reservationInstance.addToLivres(livreInstance).save()
        redirect(uri: request.getHeader('referer') )
    }

    def supressionLivre(Long idReservation, Long idLivre){
        def reservationInstance = Reservation.get(idReservation)
        def livreInstance = Livre.get(idLivre)
        reservationInstance.supprimerReservation(livreInstance.getId())
        reservationInstance.save()
        redirect(uri: request.getHeader('referer') )
    }

    def validerPanier(Long idReservation){
        def reservationInstance = Reservation.get(idReservation)
        List <Livre> listeASuppr = new ArrayList<Livre>()

        for(livre in reservationInstance.getLivres()){
            livre.retirerUnExemplaireDisponible()
            livre.save()
            listeASuppr.add(livre)
        }

        for(livreASuppr in listeASuppr){
            reservationInstance.removeFromLivres(livreASuppr)
        }

        reservationInstance.save()

        redirect(action: "list", controller: "livre")
    }
}
