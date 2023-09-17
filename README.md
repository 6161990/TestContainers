# TestContainers



IntelliJ DataSource 에서 접속하는 방법

https://plugins.jetbrains.com/plugin/17116-testcontainers-port-updater 에서 plugin 설치 후
`With 'testcontainers=true' parameter` 선택 후 아래 데이터 소스를 붙여넣어서 실행 하면됨

```
#DataSourceSettings#
#LocalDataSource: test@localhost
#BEGIN#
<data-source source="LOCAL" name="test@localhost" uuid="165224d9-0beb-4dac-97d8-e16fd0758cf8"><database-info product="PostgreSQL" version="14.6 (Debian 14.6-1.pgdg110+1)" jdbc-version="4.2" driver-name="PostgreSQL JDBC Driver" driver-version="42.6.0" dbms="POSTGRES" exact-version="14.6" exact-driver-version="42.6"><identifier-quote-string>&quot;</identifier-quote-string></database-info><case-sensitivity plain-identifiers="lower" quoted-identifiers="exact"/><driver-ref>postgresql</driver-ref><synchronize>true</synchronize><jdbc-driver>org.postgresql.Driver</jdbc-driver><jdbc-url>jdbc:postgresql://localhost:49600/test?testcontainers=true</jdbc-url><secret-storage>master_key</secret-storage><user-name>test</user-name><schema-mapping><introspection-scope><node kind="database" qname="test"><node kind="schema" qname="public"/></node></introspection-scope></schema-mapping><working-dir>$ProjectFileDir$</working-dir></data-source>
#END#
```
비밀번호 test를 넣어서 접속
