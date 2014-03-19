package com.sfa.view.backing;


import com.sfa.model.service.AppModuleImpl;

import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.Date;

import java.util.HashMap;
import java.util.List;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;


import javax.faces.event.ValueChangeEvent;
import javax.faces.validator.ValidatorException;

import oracle.adf.model.BindingContext;

import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCDataControl;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.adf.view.rich.component.rich.input.RichSelectBooleanCheckbox;

import oracle.binding.AttributeBinding;
import oracle.binding.BindingContainer;


import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.server.ViewObjectImpl;
import oracle.jbo.uicli.binding.JUCtrlListBinding;

public class AssignMultipleRoles {


    private Number userId;
    private Timestamp srtDate;
    private Timestamp endDate;
    Map<Number, String> check = new HashMap<Number, String>();
    private RichSelectBooleanCheckbox checkBox;

    public AssignMultipleRoles() {
    }

    public void assignSelectedRoles(ActionEvent actionEvent) {
        ArrayList<Map<String, Object>> values = new ArrayList<Map<String, Object>>();

        System.out.println("hi");
        System.out.println(check);
        BindingContext bctx = BindingContext.getCurrent();
        BindingContainer bindings = bctx.getCurrentBindingsEntry();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        DCBindingContainer bc = (DCBindingContainer) bindings;

        DCDataControl dc = bctx.findDataControl("AppModuleDataControl");
        AppModuleImpl aapM = (AppModuleImpl) dc.getDataProvider();

        //aapM.getDBTransaction().rollback();


        AttributeBinding attr = (AttributeBinding) bindings.getControlBinding("UserId");
        this.userId = (Number) attr.getInputValue();

        //        JUCtrlListBinding allRolesList = (JUCtrlListBinding) bindings.get("Selected");
        //                int[] selVals = allRolesList.getSelectedIndices();
        //                if(selVals != null){
        //                for(int i=0;i<selVals.length;i++)
        //        System.out.println(selVals[i]);
        //                }
        DCIteratorBinding iter = bc.findIteratorBinding("AdminUserRoleassign1Iterator");

        for (Row row : iter.getAllRowsInRange()) {
            System.out.println((String) row.getAttribute("SelectedFlag"));
            if (row.getAttribute("SelectedFlag") != null) {
                if ("true".equals(row.getAttribute("SelectedFlag"))) {
                    //                if(row.getAttribute("EffecStartDate")==null ||row.getAttribute("EffecEndDate")==null ){
                    //                    FacesMessage message = new FacesMessage("Passwords must match");
                    //                    throw new ValidatorException(message);
                    //                }
                    Map<String, Object> m = new HashMap<String, Object>();
                    m.put("RoleId", row.getAttribute("RoleId1"));
                    m.put("EffecStartDate", row.getAttribute("EffecStartDate"));
                    m.put("EffecEndDate", row.getAttribute("EffecEndDate"));
                    values.add(m);
                }

            }
        }
        aapM.getDBTransaction().rollback();

        ViewObjectImpl impl = aapM.getRoleAssignmentView3();
        DCIteratorBinding iter1 = bc.findIteratorBinding("RoleAssignmentTestView1Iterator");
        for (Row row : iter1.getAllRowsInRange()) {
            System.out.println("romve"+row.getAttribute("UserId"));
            row.remove();
          
        }

        if (values != null) {

            for (Map<String, Object> m1 : values) {
                System.out.println(m1);
                Row r1 = iter1.getRowSetIterator().createRow();
                r1.setAttribute("UserId", userId);

                r1.setAttribute("RoleId", m1.get("RoleId"));

                r1.setAttribute("EffecStartDate", m1.get("EffecStartDate"));
                r1.setAttribute("EffecEndDate", m1.get("EffecEndDate"));
                iter1.getRowSetIterator().insertRow(r1);
                iter1.executeQuery();
            }


        }

        //aapM.getDBTransaction().commit();
                OperationBinding op = bc.getOperationBinding("Commit");
                if (op != null) {
                    op.execute();
                }

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
    public void checkboxValueChange(ValueChangeEvent valueChangeEvent) {
        // Add event code here...

        String value = String.valueOf(checkBox.getValue());
        System.out.println(value);
        BindingContext bctx = BindingContext.getCurrent();
        BindingContainer bindings = bctx.getCurrentBindingsEntry();
        DCBindingContainer bc = (DCBindingContainer) bindings;
        DCIteratorBinding iter = bc.findIteratorBinding("AdminUserRolesView1Iterator");
        Row r = iter.getCurrentRow();
        if (check.containsKey(r.getAttribute("RoleId"))) {
            check.remove(r.getAttribute("RoleId"));
            check.put((Number) r.getAttribute("RoleId"), value);
        } else {
            check.put((Number) r.getAttribute("RoleId"), value);
        }
    }

    public void setCheckBox(RichSelectBooleanCheckbox checkBox) {
        this.checkBox = checkBox;
    }

    public RichSelectBooleanCheckbox getCheckBox() {
        return checkBox;
    }
}
