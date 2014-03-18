package com.sfa.view.backing;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;

import org.apache.myfaces.trinidad.context.RequestContext;

public class RefreshCreateBean {
    public RefreshCreateBean() {
    }

    public void refreshAppointment() {
        System.out.println("Refreshing 3..............");
        BindingContext bc = BindingContext.getCurrent();
        
        DCBindingContainer dcb = (DCBindingContainer)bc.getCurrentBindingsEntry();
        DCIteratorBinding iter = dcb.findIteratorBinding("ContactAppointmentsVO1Iterator");
        
        iter.executeQuery();
        
        //RequestContext.getCurrentInstance().addPartialTarget(returnEvent.getComponent().getParent().getParent());
    }
}
