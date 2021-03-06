package biblioj

import org.springframework.dao.DataIntegrityViolationException

import java.sql.Timestamp

class AuteurController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        Reservation reservation = Reservation.get(session.getAttribute("idReservation"))
        params.max = Math.min(max ?: 10, 100)
        [auteurInstanceList: Auteur.list(params), auteurInstanceTotal: Auteur.count(), reservationInstance:reservation]
    }

    def create() {
        [auteurInstance: new Auteur(params)]
    }

    def save() {
        def auteurInstance = new Auteur(params)
        if (!auteurInstance.save(flush: true)) {
            render(view: "create", model: [auteurInstance: auteurInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'auteur.label', default: 'Auteur'), auteurInstance.id])
        redirect(action: "show", id: auteurInstance.id)
    }

    def show(Long id) {
        def auteurInstance = Auteur.get(id)
        Reservation reservation = Reservation.get(session.getAttribute("idReservation"))
        if (!auteurInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'auteur.label', default: 'Auteur'), id])
            redirect(action: "list")
            return
        }

        [auteurInstance: auteurInstance,reservationInstance:reservation]
    }

    def edit(Long id) {
        def auteurInstance = Auteur.get(id)
        if (!auteurInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'auteur.label', default: 'Auteur'), id])
            redirect(action: "list")
            return
        }

        [auteurInstance: auteurInstance]
    }

    def update(Long id, Timestamp version) {
        def auteurInstance = Auteur.get(id)
        if (!auteurInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'auteur.label', default: 'Auteur'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (auteurInstance.version > version) {
                auteurInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'auteur.label', default: 'Auteur')] as Object[],
                        "Another user has updated this Auteur while you were editing")
                render(view: "edit", model: [auteurInstance: auteurInstance])
                return
            }
        }

        auteurInstance.properties = params

        if (!auteurInstance.save(flush: true)) {
            render(view: "edit", model: [auteurInstance: auteurInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'auteur.label', default: 'Auteur'), auteurInstance.id])
        redirect(action: "show", id: auteurInstance.id)
    }

    def delete(Long id) {
        def auteurInstance = Auteur.get(id)
        if (!auteurInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'auteur.label', default: 'Auteur'), id])
            redirect(action: "list")
            return
        }

        try {
            auteurInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'auteur.label', default: 'Auteur'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'auteur.label', default: 'Auteur'), id])
            redirect(action: "show", id: id)
        }
    }
}
