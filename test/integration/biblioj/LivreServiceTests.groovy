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
    void testServiceGetLivresTitre() {
        def params = [titre: "hun"]
        reservation = new Reservation(codeReservation: "test1", dateReservation: new Date().plus(1))
        assertEquals(1, livreService.serviceGetLivres(params, reservation).livreInstanceTotal)
    }

    @Test
    void testServiceGetLivresNom() {
        def params = [auteur: "col"]
        reservation = new Reservation(codeReservation: "test1", dateReservation: new Date().plus(1))
        assertEquals(3, livreService.serviceGetLivres(params, reservation).livreInstanceTotal)
    }

    @Test
    void testServiceGetLivresPrenom() {
        def params = [auteur: "suz"]
        reservation = new Reservation(codeReservation: "test1", dateReservation: new Date().plus(1))
        assertEquals(3, livreService.serviceGetLivres(params, reservation).livreInstanceTotal)
    }

    @Test
    void testServiceGetLivresNomPrenom() {
        def params = [auteur: "n"]
        reservation = new Reservation(codeReservation: "test1", dateReservation: new Date().plus(1))
        assertEquals(8, livreService.serviceGetLivres(params, reservation).livreInstanceTotal)
    }

    @Test
    void testServiceGetLivresNomPrenomAucun() {
        def params = [auteur: "aaazzzz"]
        reservation = new Reservation(codeReservation: "test1", dateReservation: new Date().plus(1))
        assertEquals(0, livreService.serviceGetLivres(params, reservation).livreInstanceTotal)
    }

    @Test
    void testServiceGetLivresType() {
        def params = [type: "Nouveauté"]
        reservation = new Reservation(codeReservation: "test1", dateReservation: new Date().plus(1))
        assertEquals(6, livreService.serviceGetLivres(params, reservation).livreInstanceTotal)
    }

    @Test
    void testServiceGetLivresOffset() {
        def params = [type: "Nouveauté", offset: "5"]
        reservation = new Reservation(codeReservation: "test1", dateReservation: new Date().plus(1))
        assertEquals(6, livreService.serviceGetLivres(params, reservation).livreInstanceTotal)
    }

    @Test
    void testServiceGetLivresOrder() {
        def params = [order: "asc"]
        reservation = new Reservation(codeReservation: "test1", dateReservation: new Date().plus(1))
        assertNotNull(livreService.serviceGetLivres(params, reservation))
    }

    @Test
    void testServiceGetLivresSort() {
        def params = [sort: "titre"]
        reservation = new Reservation(codeReservation: "test1", dateReservation: new Date().plus(1))
        assertNotNull(livreService.serviceGetLivres(params, reservation))
    }

    @Test
    void testServiceGetLivresOrderSort() {
        def params = [sort: "titre", order: "asc"]
        reservation = new Reservation(codeReservation: "test1", dateReservation: new Date().plus(1))
        assertNotNull(livreService.serviceGetLivres(params, reservation))
    }


}
