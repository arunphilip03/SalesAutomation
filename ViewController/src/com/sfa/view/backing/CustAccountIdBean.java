package com.sfa.view.backing;

import com.sfa.model.service.AppModuleImpl;

import javax.faces.context.FacesContext;

import javax.faces.event.ActionEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCDataControl;

import oracle.binding.AttributeBinding;
import oracle.binding.BindingContainer;

import oracle.jbo.Row;
import oracle.jbo.server.ViewObjectImpl;

public class CustAccountIdBean {
    public CustAccountIdBean() {
    }
    public void CustAccountAppnmnt(ActionEvent actionEvent){
    BindingContext bctx = BindingContext.getCurrent();
    BindingContainer bindings = bctx.getCurrentBindingsEntry();
    FacesContext facesContext = FacesContext.getCurrentInstance();

    DCDataControl dc = bctx.findDataControl("AppModuleDataControl");
    AppModuleImpl aapM = (AppModuleImpl) dc.getDataProvider();
    ViewObjectImpl impl = aapM.getOpportunityAppointmentView2();
    
    AttributeBinding attr = (AttributeBinding) bindings.getControlBinding("CustAccountId");
    Number custAccountId = (Number) attr.getInputValue();
    
    Row r2 = impl.getCurrentRow();
    r2.setAttribute("CustAccountId", custAccountId);
        aapM.getDBTransaction().commit();
        impl.executeQuery();
    }
    public void CustAccountTask(ActionEvent actionEvent){
    BindingContext bctx = BindingContext.getCurrent();
    BindingContainer bindings = bctx.getCurrentBindingsEntry();
    FacesContext facesContext = FacesContext.getCurrentInstance();

    DCDataControl dc = bctx.findDataControl("AppModuleDataControl");
    AppModuleImpl aapM = (AppModuleImpl) dc.getDataProvider();
    ViewObjectImpl impl = aapM.getOpportunitytaskView2();
    
    AttributeBinding attr = (AttributeBinding) bindings.getControlBinding("CustAccountId");
    Number custAccountId = (Number) attr.getInputValue();
    
    Row r2 = impl.getCurrentRow();
    r2.setAttribute("CustAccountId", custAccountId);
        aapM.getDBTransaction().commit();
        impl.executeQuery();
    }
    
}
