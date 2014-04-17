package biblioj

import java.sql.Timestamp

class TypeDocument {

    def String intitule

    Timestamp version

    static constraints = {
        intitule nullable : false, blank: false
    }
}
