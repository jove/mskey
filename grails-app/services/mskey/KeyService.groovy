package mskey

import com.xhive.spring.XhiveSessionAccess
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.transaction.annotation.Transactional

class KeyService {
    @Autowired
    private XhiveSessionAccess xdb

    @Transactional(readOnly = true)
    def getProducts(String keyword) {
        def lib=xdb.session.database.root.getByPath("msdn")
        def result=lib.executeXQuery('distinct-values(for $p in YourKey/Product_Key order by $p/@Name return normalize-space(data($p/@Name)))')
        def products=[]
        result.each{products<<it}
        //log.error result.toString()
        return products
    }

    @Transactional(readOnly = true)
    def getKeysForProduct(String keyword) {
        def lib=xdb.session.database.root.getByPath("msdn")
        def result=lib.executeXQuery('for $p in YourKey/Product_Key where contains(data($p/@Name),\''+keyword+'\') return data($p/Key)')
        def rv=[]
        result.each{rv<<(it.toString())}
        return rv
    }
}
