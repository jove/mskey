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
        def result=lib.executeXQuery('for $p in YourKey/Product_Key return $p/@Name')
        def products=[]
        result.each{
            products<<(''+it)
        }
        //log.error result.toString()
        return products
    }
}
