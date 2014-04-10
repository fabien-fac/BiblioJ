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
        dateReservation: new Date()-1)
        assert !reservationInvalide1.validate()

        def reservationValide = new Reservation(codeReservation: "code2",
                dateReservation: new Date()+2)
        assert reservationValide.validate()

        /* eventuellement tester la contrainte unique avec un mock */
    }
}
