package biblioj


import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Reservation)
class ReservationTests {

    void testReservationContraintes() {
        def reservationInvalide1 = new Reservation(codeReservation: "code1",
        dateReservation: new Date())
        assert !reservationInvalide1.validate()

        def reservationValide = new Reservation(codeReservation: "code2",
                dateReservation: new Date().plus(1))
        assert reservationValide.validate()

        /* eventuellement tester la contrainte unique avec un mock */
    }

    void testReservationContainsIdLivre(){
        def reservation = new Reservation(codeReservation: "code1",
                dateReservation: new Date().plus(1))
        long id = "1".toLong();

        def livre = new Livre(
                nombreExemplaires: 4,
                nombreExemplairesDisponibles: 4)
        livre.setId(id)

        reservation.livres.add(livre)

        assertTrue(reservation.isContainsLivre(id))
    }

    void testReservationNotContainsIdLivre(){
        def reservation = new Reservation(codeReservation: "code1",
                dateReservation: new Date())
        long id = "1".toLong();

        assertFalse(reservation.isContainsLivre(id))
    }

    void testSupprimerReservation(){
        def reservation = new Reservation(codeReservation: "code1",
                dateReservation: new Date().plus(1))
        long id = "1".toLong();

        def livre = new Livre(
                nombreExemplaires: 4,
                nombreExemplairesDisponibles: 4)
        livre.setId(id)

        reservation.livres.add(livre)
        assertTrue(reservation.supprimerReservation(livre.getId()))
    }

    void testSupprimerReservationInexistante(){
        def reservation = new Reservation(codeReservation: "code1",
                dateReservation: new Date().plus(1))
        long id = "1".toLong();

        def livre = new Livre(
                nombreExemplaires: 4,
                nombreExemplairesDisponibles: 4)
        livre.setId(id)

        reservation.supprimerReservation(livre.getId())
        assertFalse(reservation.supprimerReservation(livre.getId()))
    }

}
