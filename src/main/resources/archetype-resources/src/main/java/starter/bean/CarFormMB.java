#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ${package}.starter.bean;

import com.github.adminfaces.persistence.bean.BeanService;
import com.github.adminfaces.persistence.bean.CrudMB;
import ${package}.starter.model.Car;
import ${package}.starter.service.CarService;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Faces;

import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;

/**
 * @author rmpestano
 */
@Named
@ViewScoped
@BeanService(CarService.class)//use annotation instead of setter
public class CarFormMB extends CrudMB<Car> implements Serializable {


    public void afterRemove() {
        try {
            addDetailMsg("Car " + entity.getModel()
                    + " removed successfully");
            Faces.redirect("car-list.xhtml");
            clear(); 
            sessionFilter.clear(CarListMB.class.getName());//removes filter saved in session for CarListMB.
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void afterInsert() {
         addDetailMsg("Car " + entity.getModel() + " created successfully");
    }

    @Override
    public void afterUpdate() {
        addDetailMsg("Car " + entity.getModel() + " updated successfully");
    }
    

}
