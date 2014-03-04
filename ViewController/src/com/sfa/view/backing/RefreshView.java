package com.sfa.view.backing;

import com.sfa.model.service.AppModuleImpl;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCDataControl;
import oracle.adf.model.binding.DCIteratorBinding;

import oracle.jbo.server.ViewObjectImpl;

import org.apache.myfaces.trinidad.context.RequestContext;
import org.apache.myfaces.trinidad.event.ReturnEvent;

public class RefreshView {
    public RefreshView() {
    }
    
    
    public void contactDialogReturnListener(ReturnEvent returnEvent) {
        BindingContext bc = BindingContext.getCurrent();
        
        DCBindingContainer dcb = (DCBindingContainer)bc.getCurrentBindingsEntry();
        DCIteratorBinding iter = dcb.findIteratorBinding("CustomerContactsView2Iterator");
        
        iter.executeQuery();
        
        RequestContext.getCurrentInstance().addPartialTarget(returnEvent.getComponent().getParent().getParent());
            
    }
    
    
    public void customerDialogReturnListener(ReturnEvent returnEvent) {
        BindingContext bc = BindingContext.getCurrent();
        
        DCBindingContainer dcb = (DCBindingContainer)bc.getCurrentBindingsEntry();
        DCIteratorBinding iter = dcb.findIteratorBinding("CustomerAccountView1Iterator");
        
        iter.executeQuery();
        
        RequestContext.getCurrentInstance().addPartialTarget(returnEvent.getComponent().getParent().getParent());
            
    }
   
}
