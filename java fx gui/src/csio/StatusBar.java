/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csio;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Label;
import javafx.beans.InvalidationListener;

/**
 *
 * @author user
 */
public class StatusBar extends Label{
    private final String PREMANENT_TEXT = "Status: ";
    private StringProperty status;
    private InvalidationListener listener = e -> super.setText(PREMANENT_TEXT+getStatus());
  
    public StatusBar() {
    statusProperty().addListener(listener);
   
    setText(PREMANENT_TEXT);
    }
    
    final public StringProperty statusProperty() {
    if(status == null) 
        status = new SimpleStringProperty(PREMANENT_TEXT);
    return status;
    }
    
    final public void setStatus(String text) {
    statusProperty().set(text);
    }
    
    final public String getStatus() {
    return status == null?null:statusProperty().get();
    }

    void setText(boolean Joystickthrow) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
}

