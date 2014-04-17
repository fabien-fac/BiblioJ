package biblioj

import grails.test.mixin.Mock

import static org.junit.Assert.*
import org.junit.*

class LivreServiceTests {

    LivreService livreService
    Reservation reservation

    @Before
    void setUp() {

    }

    @After
    void tearDown() {
        // Tear down logic here
    }

    @Test
    void testServiceGetLivres() {
        def params = [titre: "hun"]
        reservation = new Reservation(codeReservation: "test1", dateReservation: new Date().plus(1))
        println livreService.serviceGetLivres(params, reservation)
        assertEquals(1, livreService.serviceGetLivres(params, reservation).livreInstanceTotal)
    }

    /*@Test
    void testServiceGetLivresTitre() {
        def params = [tire:"Misery"]
        Reservation reservation = new Reservation(codeReservation: "test1", dateReservation: new Date().plus(1))
        assertEquals([], livreService.serviceGetLivres(params, reservation).livreInstanceList)
    }

    @Test
    void testServiceGetLivresTypeDoc() {
        def params = [tire:"Misery"]
        Reservation reservation = new Reservation(codeReservation: "test1", dateReservation: new Date().plus(1))
        assertEquals([], livreService.serviceGetLivres(params, reservation).livreInstanceList)
    }

    @Test
    void testServiceGetLivresAuteur() {
        def params = [tire:"Misery"]
        Reservation reservation = new Reservation(codeReservation: "test1", dateReservation: new Date().plus(1))
        assertEquals([], livreService.serviceGetLivres(params, reservation).livreInstanceList)
    }*/
}
