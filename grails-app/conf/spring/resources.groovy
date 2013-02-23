
// Place your Spring DSL code here
beans = {
    xmlns context:"http://www.springframework.org/schema/context"
    context.'property-placeholder'('location':'/WEB-INF/connection.properties')

    xDBSessionAccess(com.xhive.spring.XhiveSessionAccess)
    dataSource(com.xhive.spring.XhiveDataSource,
            'xhive://localhost:1235',
            'cfx',
            'Administrator',
            'emc'

           /*
            'xhive://${cloud.services.xdb.connection.host}:${cloud.services.xdb.connection.port}',
            '${cloud.services.xdb.connection.database}',
            '${cloud.services.xdb.connection.user}',
            '${cloud.services.xdb.connection.password}'
            */
    )
    transactionManager(com.xhive.spring.XhiveTransactionManager,dataSource)

    xmlns tx:"http://www.springframework.org/schema/tx"
    tx.'annotation-driven'('transaction-manager':'transactionManager')
}