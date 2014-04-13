package biblioj


import grails.test.mixin.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Auteur)
class AuteurTests {

    void testAuteurContraintes() {
        def auteurInvalide1 = new Auteur(
                nom: "")
        assert !auteurInvalide1.validate()

        def auteurInvalide2 = new Auteur(
                prenom: "")
        assert !auteurInvalide2.validate()

        def auteurValide = new Auteur(
                nom: "King",
                prenom: "Stephen")
        assert auteurValide.validate()
    }

    void testToString() {
        def auteur = new Auteur(
                nom: "King",
                prenom: "Stephen")
        assertEquals("King Stephen", auteur.toString())
    }
}
