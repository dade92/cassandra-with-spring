package webapp;

import com.datastax.oss.driver.api.core.CqlSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.SessionFactory;
import org.springframework.data.cassandra.config.CqlSessionFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.config.SessionFactoryFactoryBean;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.core.convert.CassandraConverter;
import org.springframework.data.cassandra.core.convert.MappingCassandraConverter;
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.core.mapping.SimpleUserTypeResolver;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
public class CassandraConfig {

    @Bean
    public CqlSessionFactoryBean session() {
        CqlSessionFactoryBean session = new CqlSessionFactoryBean();
        session.setContactPoints("localhost");
        session.setLocalDatacenter("datacenter1");
        session.setKeyspaceName("spring_cassandra");

        return session;
    }

    @Bean
    public SessionFactoryFactoryBean sessionFactory(CqlSession session, CassandraConverter converter) {
        SessionFactoryFactoryBean sessionFactory = new SessionFactoryFactoryBean();
        sessionFactory.setSession(session);
        sessionFactory.setConverter(converter);
        sessionFactory.setSchemaAction(SchemaAction.NONE);

        return sessionFactory;
    }

    @Bean
    public CassandraMappingContext mappingContext() {
        return new CassandraMappingContext();
    }

    @Bean
    public CassandraConverter converter(CqlSession cqlSession, CassandraMappingContext mappingContext) {
        MappingCassandraConverter cassandraConverter = new MappingCassandraConverter(mappingContext);
        cassandraConverter.setUserTypeResolver(new SimpleUserTypeResolver(cqlSession));

        return cassandraConverter;
    }

    @Bean
    public CassandraTemplate cassandraTemplate(SessionFactory sessionFactory, CassandraConverter converter) {
        return new CassandraTemplate(sessionFactory, converter);
    }
}
