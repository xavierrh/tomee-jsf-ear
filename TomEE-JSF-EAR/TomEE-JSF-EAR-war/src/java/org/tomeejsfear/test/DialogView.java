/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.tomeejsfear.test;

import java.io.Serializable;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import org.primefaces.context.RequestContext;
 
//@javax.faces.bean.ManagedBean(name = "dfDialogView")
//@javax.faces.bean.ViewScoped
@javax.inject.Named("dfDialogView")
@javax.faces.view.ViewScoped
public class DialogView implements Serializable{
         
    String createTime;

    public String getCreateTime() {
        return createTime;
    }
    
    String param1;

    public String getParam1() {
        return param1;
    }

    public void setParam1(String param1) {
        this.param1 = param1;
    }
    
    Boolean actionViewCalled = false;

    public Boolean getActionViewCalled() {
        return actionViewCalled;
    }

    public void setActionViewCalled(Boolean actionViewCalled) {
        this.actionViewCalled = actionViewCalled;
    }
   
    public void viewAction()
    {
        actionViewCalled = true;
    }
    
    @PostConstruct
    public void onPostConstruct()
    {
        Calendar c = Calendar.getInstance();
        createTime = c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND);
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "DialogView.onPostConstruct() @ " + createTime);
    }
     
    public void close() {
        RequestContext.getCurrentInstance().closeDialog(null);
    }
}
