import biblioj.Auteur
import biblioj.Livre
import biblioj.TypeDocument

class BootStrap {

    def init = { servletContext ->

        def Auteur vigan = new Auteur(nom: "Vigan", prenom: "Delphine de")
        def Auteur collins = new Auteur(nom: "Collins", prenom: "Suzanne")
        def Auteur stockett = new Auteur(nom: "Stockett", prenom: "Kathryn")
        def Auteur carrere = new Auteur(nom: "Carrére", prenom: "Emmanuel")
        def Auteur murakami = new Auteur(nom: "Murakami", prenom: "Haruki")
        def Auteur delacourt = new Auteur(nom: "Delacourt", prenom: "Grégoire")
        def Auteur larsson = new Auteur(nom: "Larsson", prenom: " Stieg")

        def TypeDocument nouveaute = new TypeDocument(intitule: "Nouveauté")
        def TypeDocument livreAdo = new TypeDocument(intitule: "Livre ado")
        def TypeDocument livreAdulte = new TypeDocument(intitule: "Livre adulte")


        def Livre livre1 = new Livre(titre: "Rien ne s'oppose à la nuit", nombreExemplaires: 10, nombreExemplairesDisponibles: 5)
        livre1.addToAuteurs(vigan)
        livre1.typeDocument = nouveaute

        def Livre livre2 = new Livre(titre: "Hunger games", nombreExemplaires: 20, nombreExemplairesDisponibles: 3)
        livre2.addToAuteurs(collins)
        livre2.typeDocument = livreAdo

        def Livre livre3 = new Livre(titre: "La couleur des sentiments", nombreExemplaires: 10, nombreExemplairesDisponibles: 8)
        livre3.addToAuteurs(stockett)
        livre3.typeDocument = nouveaute

        def Livre livre4 = new Livre(titre: "L'embrasement", nombreExemplaires: 20, nombreExemplairesDisponibles: 8)
        livre4.addToAuteurs(collins)
        livre4.typeDocument = livreAdo

        def Livre livre5 = new Livre(titre: "Limonov", nombreExemplaires: 8, nombreExemplairesDisponibles: 8)
        livre5.addToAuteurs(carrere)
        livre5.typeDocument = nouveaute

        def Livre livre6 = new Livre(titre: "1Q84. 1. Avril-juin", nombreExemplaires: 5, nombreExemplairesDisponibles: 4)
        livre6.addToAuteurs(murakami)
        livre6.typeDocument = nouveaute

        def Livre livre7 = new Livre(titre: "1Q84. 3. Octobre-décembre", nombreExemplaires: 5, nombreExemplairesDisponibles: 1)
        livre7.addToAuteurs(murakami)
        livre7.typeDocument = nouveaute

        def Livre livre8 = new Livre(titre: "La révolte", nombreExemplaires: 20, nombreExemplairesDisponibles: 0)
        livre8.addToAuteurs(collins)
        livre8.typeDocument = livreAdo

        def Livre livre9 = new Livre(titre: "La liste de mes envies", nombreExemplaires: 12, nombreExemplairesDisponibles: 10)
        livre9.addToAuteurs(delacourt)
        livre9.typeDocument = livreAdulte

        def Livre livre10 = new Livre(titre: "1Q84. 2. Juillet-septembre", nombreExemplaires: 5, nombreExemplairesDisponibles: 1)
        livre10.addToAuteurs(murakami)
        livre10.typeDocument = nouveaute

        def Livre livre11 = new Livre(titre: "La reine dans le palais des courants d'air", nombreExemplaires: 8, nombreExemplairesDisponibles: 6)
        livre11.addToAuteurs(murakami)
        livre11.typeDocument = livreAdulte


        vigan.save()
        collins.save()
        stockett.save()
        carrere.save()
        murakami.save()
        delacourt.save()
        larsson.save()

        nouveaute.save()
        livreAdo.save()
        livreAdulte.save()


        livre1.save()
        livre2.save()
        livre3.save()
        livre4.save()
        livre5.save()
        livre6.save()
        livre7.save()
        livre8.save()
        livre9.save()
        livre10.save()
        livre11.save()

    }
    def destroy = {
    }
}
