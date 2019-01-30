#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.starter.service;

import ${package}.starter.model.Car;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.QueryParam;
import org.apache.deltaspike.data.api.Repository;

import java.math.BigDecimal;

@Repository
public interface CarRepository extends EntityRepository<Car,Integer> {


    @Query("SELECT SUM(c.price) FROM Car c WHERE upper(c.model) like :model")
    Double getTotalPriceByModel(@QueryParam("model") String model);


}
