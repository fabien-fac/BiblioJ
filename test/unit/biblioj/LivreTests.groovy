package biblioj

import static org.junit.Assert.*

import grails.test.mixin.*
import grails.test.mixin.support.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestFor(Livre)
class LivreTests {

    void testLivreContraintes() {
        def livreInvalide1 = new Livre(
                titre: "Misery",
                nombreExemplaires: -3,
                nombreExemplairesDisponibles: 12)
        assert !livreInvalide1.validate()

        def livreInvalide2 = new Livre(
                titre: "Misery",
                nombreExemplaires: 15,
                nombreExemplairesDisponibles: -12)
        assert !livreInvalide2.validate()

        def livreInvalide3 = new Livre(
                titre: "Misery",
                nombreExemplaires: 15,
                nombreExemplairesDisponibles: 18)
        assert !livreInvalide3.validate()


        def livreValide = new Livre(
                titre: "Misery",
                nombreExemplaires: 15,
                nombreExemplairesDisponibles: 12)
        assert livreValide.validate()
    }

    void testRetirerExemplaireDisponible(){
        def livre = new Livre(
                nombreExemplaires: 4,
                nombreExemplairesDisponibles: 4)
        livre.retirerUnExemplaireDisponible()
        assertEquals(3, livre.nombreExemplairesDisponibles)
    }

    void testRetirerExemplaireDisponibleLimite(){
        def livre = new Livre(
                nombreExemplaires: 4,
                nombreExemplairesDisponibles: 0)
        livre.retirerUnExemplaireDisponible()
        assertEquals(0, livre.nombreExemplairesDisponibles)
    }

    void testAjouterExemplaireDisponible(){
        def livre = new Livre(
                nombreExemplaires: 4,
                nombreExemplairesDisponibles: 2)
        livre.ajouterUnExemplaireDisponible()
        assertEquals(3, livre.nombreExemplairesDisponibles)
    }

    void testAjouterExemplaireDisponibleLimite(){
        def livre = new Livre(
                nombreExemplaires: 4,
                nombreExemplairesDisponibles: 4)
        livre.ajouterUnExemplaireDisponible()
        assertEquals(4, livre.nombreExemplairesDisponibles)
    }
}