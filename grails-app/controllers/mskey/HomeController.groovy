package mskey

import com.xhive.query.interfaces.XhiveXQueryValueIf
import com.xhive.spring.XhiveSessionAccess
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.transaction.annotation.Transactional

class HomeController {
    private static final String DEFAULT_XQUERY = "document { <result>Hello there. " +
            " It is now { current-dateTime() }</result> }";

    @Autowired
    private XhiveSessionAccess acc


    @Transactional(readOnly = true)
    def index() {
        def query=DEFAULT_XQUERY
        XhiveXQueryValueIf result = acc.query(query, Collections.<String, Object> emptyMap()).next()
        render result.asString()
        return
    }
}