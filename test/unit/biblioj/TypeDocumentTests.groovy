package biblioj


import grails.test.mixin.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(TypeDocument)
class TypeDocumentTests {

    void testTypeDocumentContraintes() {
        def typeDocumentInvalide1 = new TypeDocument(intitule: "")
        assert !typeDocumentInvalide1.validate()

        def typeDocumentInvalide2 = new TypeDocument()
        assert !typeDocumentInvalide2.validate()

        def typeDocumentValide = new TypeDocument(intitule: "Livre pour enfant")
        assert typeDocumentValide.validate()
    }
}