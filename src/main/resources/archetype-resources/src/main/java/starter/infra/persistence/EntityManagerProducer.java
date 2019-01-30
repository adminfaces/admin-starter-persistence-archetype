#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.starter.infra.persistence;


import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@ApplicationScoped
public class EntityManagerProducer {

    @PersistenceContext
    EntityManager em;

    @Produces
    public EntityManager produce() {
        return em;
    }
}
