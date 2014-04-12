package biblioj

import org.hibernate.Criteria

class LivreService {

    def serviceGetLivres(Map params, Reservation reservation) {

        String titreLivre = params.titre
        String auteurLivre = params.auteur
        String typeDoc = params.type
        int max = params.int('max') ?: 0

        if(titreLivre != null && (titreLivre.length()>0 || auteurLivre.length()>0 || typeDoc.length()>1)){
            def listeTotal = getLivresAvecCriteres(params)
            def listeRes = []
            int min = Math.min(listeTotal.size()-1, max-1)
            if(min < 0){
                listeRes = listeTotal
            }
            else{
                listeTotal[0..min].each { listeRes << it}
            }
            [ livreInstanceList:listeTotal, livreInstanceTotal:listeTotal.size(), reservationInstance:reservation  ]
        }
        else{
            [livreInstanceList: Livre.list(params), livreInstanceTotal: Livre.count(), reservationInstance:reservation ]
        }
    }

    def getLivresAvecCriteres(Map params){
        String titreLivre = params.titre
        String typeDoc = params.type
        String auteurLivre = params.auteur
        int offsetP = params.int('offset') ?: 0
        int maxRes = params.int('max')

        def c = Livre.createCriteria()
        def results = c.listDistinct (){
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
            //maxResults maxRes
            firstResult offsetP
        }

        return results
    }

    def getLivresAvecCriteresHQL(Map params){

        String titreLivre = "%"+params.titre+"%"
        String typeDoc = params.type
        String auteurLivre = "%"+params.auteur+"%"
        int offset = params.int('offset') ?: 0
        int maxRes = params.int('max')

        //Livre.findAll("from Livre as l where l.titre like :titre and l.auteurs.nom", [max: maxRes, offset: offset, titre: titreLivre])
    }
}
