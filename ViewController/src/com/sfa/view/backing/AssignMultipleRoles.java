package com.sfa.view.backing;


import com.sfa.model.service.AppModuleImpl;

import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.Date;

import java.util.List;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;


import javax.faces.validator.ValidatorException;

import oracle.adf.model.BindingContext;

import oracle.adf.model.binding.DCDataControl;
import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.binding.AttributeBinding;
import oracle.binding.BindingContainer;


import oracle.jbo.Row;
import oracle.jbo.server.ViewObjectImpl;
import oracle.jbo.uicli.binding.JUCtrlListBinding;

public class AssignMultipleRoles {
   

    private Number userId;
    private Timestamp srtDate;
    private Timestamp endDate;

    public AssignMultipleRoles() {
    }

    public void assignSelectedRoles(ActionEvent actionEvent) {
        List<Number> roleId = new ArrayList<Number>();

        System.out.println("hi");
        BindingContext bctx = BindingContext.getCurrent();
        BindingContainer bindings = bctx.getCurrentBindingsEntry();
        FacesContext facesContext = FacesContext.getCurrentInstance();

        DCDataControl dc = bctx.findDataControl("AppModuleDataControl");
        AppModuleImpl aapM = (AppModuleImpl) dc.getDataProvider();
        ViewObjectImpl impl = aapM.getRoleAssignmentView3();
        //aapM.getDBTransaction().rollback();

        UIViewRoot root = facesContext.getViewRoot();
        // RichInputText inputText = (RichInputText)root.findComponent("it1");
        //this.userId = (Number)inputText.getValue();
        AttributeBinding attr = (AttributeBinding) bindings.getControlBinding("UserId");
        this.userId = (Number) attr.getInputValue();
        AttributeBinding attr1 = (AttributeBinding) bindings.getControlBinding("EffecStartDate");
        this.srtDate = (Timestamp) attr1.getInputValue();
        AttributeBinding attr2 = (AttributeBinding) bindings.getControlBinding("EffecEndDate");
        this.endDate = (Timestamp) attr2.getInputValue();


        JUCtrlListBinding allRolesList = (JUCtrlListBinding) bindings.get("ValidRolesView1");
        int[] selVals = allRolesList.getSelectedIndices();

        for (int indx : selVals) {
            Row rw = allRolesList.getRowAtRangeIndex(indx);
            roleId.add((Number) rw.getAttribute("RoleId"));
        }
        int i=0;
        for (Object o : roleId) {
            Row r2=null;
            if(i==0)
            {
             r2 = impl.getCurrentRow();
            }
            else {
            r2= impl.createRow();
            }
           // Row r2 = impl.getCurrentRow();
            r2.setAttribute("UserId", userId);
            r2.setAttribute("EffecStartDate", srtDate);
            r2.setAttribute("EffecEndDate", endDate);
            r2.setAttribute("RoleId", (Number) o);
            //impl.insertRow(r2);
            aapM.getDBTransaction().commit();
            impl.executeQuery();
            i++;
            //System.out.println("hi");
        }
        // System.out.println(roleId);
        // aapM.getDBTransaction().commit();
    }

 


    //    public void passwordValidator(FacesContext facesContext, UIComponent uIComponent, Object object) {
    //        // Add event code here...
    //        String confirm = (String)object;
    //      String original = (String)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("it6");
    //       BindingContext bctx = BindingContext.getCurrent();
    //       BindingContainer bindings = bctx.getCurrentBindingsEntry();
    //        AttributeBinding attr = (AttributeBinding)bindings.getControlBinding("Password");
    //        //String original = (String)attr.getInputValue();
    //
    //        System.out.println(original);
    //        if(!(confirm.equals(original))){
    //            FacesMessage message = new FacesMessage("Passwords must match");
    //                    throw new ValidatorException(message);
    //        }
    //    }
}
