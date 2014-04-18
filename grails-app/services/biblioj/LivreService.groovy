package biblioj

import org.hibernate.Criteria

class LivreService {

    def serviceGetLivres(Map params, Reservation reservation) {

        String titreLivre = params.titre
        String auteurLivre = params.auteur
        String typeDoc = params.type
        if (!params.max) {
            params.max = 0
        }

        def listeTotal = getLivresAvecCriteres(params)
        [ livreInstanceList:listeTotal, livreInstanceTotal:listeTotal.totalCount, reservationInstance:reservation  ]

    }

    def getLivresAvecCriteres(Map params){
        String titreLivre = params.titre
        String typeDoc = params.type
        String auteurLivre = params.auteur
        int offsetP
        if (!params.offset) {
            offsetP = 0
        } else {
            offsetP = Integer.valueOf(params.offset)
        }

        int maxRes
        if (!params.max) {
            maxRes = 0
        } else {
            maxRes = Integer.valueOf(params.max)
        }

        def c = Livre.createCriteria()
        def results = c.list(offset: offsetP, max: maxRes){
                if(typeDoc){
                    typeDocument{
                        ilike("intitule", "%$typeDoc%")
                    }
                }
                if(titreLivre) {
                    ilike('titre', '%' + titreLivre + '%')
                }
                if(auteurLivre){
                    auteurs {
                        or {
                            ilike("nom", '%' + auteurLivre + '%')
                            ilike("prenom", '%' + auteurLivre + '%')
                        }
                    }
                }

            if(params.sort && params.order){
                order(params.sort, params.order)
            }
        }

        return results
    }

}
