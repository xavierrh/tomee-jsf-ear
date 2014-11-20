package org.tomeejsfear.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
 
@javax.inject.Named("dfView")
@javax.faces.view.ViewScoped
public class Dialogs implements Serializable{
    
    String createTime;

    public String getCreateTime() {
        return createTime;
    }
    
    @PostConstruct
    public void onPostConstruct()
    {
        Calendar c = Calendar.getInstance();
        createTime = c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND);
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Dialogs.onPostConstruct() @ " + createTime);
        
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bean POST CONSTRUCT", "");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public void open() {
        
        
        List<String> paramList = new ArrayList<String>();
        paramList.add("PARENT CREATED AT " + createTime);
        Map<String, List<String>> paramMap = new HashMap<String, List<String>>();
        paramMap.put("param1", paramList);
        
        RequestContext.getCurrentInstance().openDialog("dialogContent",null, paramMap);
    }
     
    public void onClose(SelectEvent event) {
        //Car car = (Car) event.getObject();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Dialog closed", "Event:" + event);
         
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
