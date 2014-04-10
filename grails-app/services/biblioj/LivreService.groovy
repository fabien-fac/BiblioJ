package biblioj

class LivreService {

    def serviceGetLivres(Map params) {

        String titreLivre = params.titre
        String auteurLivre = params.auteur
        String typeDoc = params.type

        if(titreLivre != null && (titreLivre.length()>0 || auteurLivre.length()>0 || !typeDoc.equals(" "))){
            def liste = getLivresAvecCriteres(params).unique()

            [ livreInstanceList:liste, livreInstanceTotal:liste.size()  ]
        }
        else{
            [livreInstanceList: Livre.list(params), livreInstanceTotal: Livre.count()]
        }
    }

    def getLivresAvecCriteres(Map params){
        String titreLivre = params.titre
        String typeDoc = params.type
        String auteurLivre = params.auteur
        int offset = params.int('offset') ?: 0
        int maxRes = params.int('max')

        def c = Livre.createCriteria()
        def results = c{
            createAlias ('typeDocument', 'td')
            and{
                ilike("td.intitule", '%' + typeDoc + '%')
                ilike('titre', '%' + titreLivre + '%')
                auteurs {
                    or {
                        ilike("nom", '%' + auteurLivre + '%')
                        ilike("prenom", '%' + auteurLivre + '%')
                    }
                }
            }
            firstResult offset
        }

        return results
    }
}
