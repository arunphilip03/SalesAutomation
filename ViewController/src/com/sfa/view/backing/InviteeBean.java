package com.sfa.view.backing;

import java.util.ArrayList;
import java.util.List;

import java.util.Map;

import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import javax.faces.model.SelectItem;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;

import oracle.adf.view.rich.component.rich.input.RichSelectManyShuttle;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.AttributeBinding;
import oracle.binding.BindingContainer;

import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.domain.Number;

public class InviteeBean {
    private RichSelectManyShuttle selectManyShuttleComponent;

    public InviteeBean() {
        super();
    }
    private BindingContainer bindings;
    private List allRoles;
    private List selectedRoles;
    private boolean refreshIterator = false;

    /**
     * Setter method for Bindings 
     * @param bindings
     */
//    public void setBindings(BindingContainer bindings) {
//        this.bindings = bindings;
//    }

    /**
     * Getter method for Bindings
     * @return
     */
    public BindingContainer getBindings() {
        
        BindingContext context = BindingContext.getCurrent();
        BindingContainer bindings = context.getCurrentBindingsEntry();
        return bindings;
    }

    /**
     * Setter method for AllRoles.
     * @param allRoles
     */
    public void setAllRoles(List allRoles) {
        this.allRoles = allRoles;
    }

    /**
     * Getter method for AllRoles.
     * @return
     */
    public List getAllRoles() {
        if (allRoles == null) {
            allRoles = selectItemsForIterator();
        }
        return allRoles;
    }

    /**
     * Setter method for SelectedRoles
     * @param selectedRoles
     */
    public void setSelectedRoles(List selectedRoles) {
        this.selectedRoles = selectedRoles;
    }

    /**
     * Getter methoe for Selected Roles
     * @return
     */
    public List getSelectedRoles() {
        List selectedList = null;
        AdfFacesContext fctx = AdfFacesContext.getCurrentInstance();
        Map<String, Object> pfs = fctx.getPageFlowScope();
        if (pfs != null) {
            if (pfs.get("selectedList") == null || refreshIterator)
                selectedList = attributeListForIterator();
            else
                selectedList = (List)pfs.get("selectedList");
        }
        return selectedList;
    }

    /**
     * Helper method to return the selected roles for an Employee
     * @return
     */
    public List attributeListForIterator() {
        DCBindingContainer bc = (DCBindingContainer)getBindings();
        DCIteratorBinding iter = bc.findIteratorBinding("AppointmentInviteesVO3Iterator");
        List attributeList = new ArrayList();
        for (Row row : iter.getAllRowsInRange()) {
            attributeList.add(row.getAttribute("ContactId"));
        }
        return attributeList;
    }

    public List<SelectItem> selectItemsForIterator() {
        DCBindingContainer bc = (DCBindingContainer)getBindings();
        DCIteratorBinding iter = bc.findIteratorBinding("CustomerContactsView2Iterator");
        List<SelectItem> selectItems = new ArrayList<SelectItem>();
        for (Row row : iter.getAllRowsInRange()) {
            selectItems.add(new SelectItem(row.getAttribute("ContactId"),
                                           (String)row.getAttribute("ContactName")));
        }
        return selectItems;
    }

    public void onRoleChange(ValueChangeEvent valueChangeEvent) {
        List<Number> selectedListFromUI = null;
        if (valueChangeEvent.getOldValue().equals(valueChangeEvent.getNewValue()))
            return;
        selectedListFromUI = (ArrayList<Number>)valueChangeEvent.getNewValue();
        AdfFacesContext fctx = AdfFacesContext.getCurrentInstance();
        Map<String, Object> pfs = fctx.getPageFlowScope();
        if (pfs != null) {
            if (selectedListFromUI != null) {
                pfs.put("selectedList", selectedListFromUI);
            } else {
                pfs.put("selectedList", new ArrayList());
            }
        }
    }

    public Number getCurrentEmpId() {
        DCBindingContainer bc = (DCBindingContainer)getBindings();
        AttributeBinding attr = (AttributeBinding)bc.findCtrlBinding("AppointmentId");
        
        AttributeBinding attr2 = (AttributeBinding)bc.get("AppointmentId");
        System.out.println("Appointment ID1: "+attr.getInputValue() );
        System.out.println("Appointment ID1: "+attr2.getInputValue() );
        
        Number empId = (Number)attr.getInputValue();
        return empId;
    }

    public String onCommit() {
        DCBindingContainer bc = (DCBindingContainer)getBindings();
        DCIteratorBinding iter = bc.findIteratorBinding("AppointmentInviteesVO3Iterator");
        
        
        //temp-to delete
       // AttributeBinding attr = (AttributeBinding)bc.get("AppointmentId");
        
        //Removing all rows for the current EmpId from EmpRolesVO
        for (Row row : iter.getAllRowsInRange()) {
            row.remove();
        }
        List roles = getSelectedRoles();
        int size = roles.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                Row row = iter.getRowSetIterator().createRow();
                //System.out.println("Appointment ID: "+attr.getInputValue() );
                System.out.println("Contact ID: "+roles.get(i));
                
                row.setAttribute("AppointmentId", getCurrentEmpId());
                row.setAttribute("ContactId", roles.get(i));
                iter.getRowSetIterator().insertRow(row);
            }
        }
        OperationBinding op = bc.getOperationBinding("Commit");
        if (op != null) {
           // op.execute();
        }
        return null;
    }

    public String setRefreshIterator() {
        refreshIterator = true;
        return null;
    }

    public void setSelectManyShuttleComponent(RichSelectManyShuttle selectManyShuttleComponent) {
        this.selectManyShuttleComponent = selectManyShuttleComponent;
    }

    public RichSelectManyShuttle getSelectManyShuttleComponent() {
        return selectManyShuttleComponent;
    }

    public void onClearIndices(ActionEvent actionEvent) {
        List list = new ArrayList();
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("selectedList",
                                                                    list);
        if (selectManyShuttleComponent != null) {
            AdfFacesContext.getCurrentInstance().
                addPartialTarget(selectManyShuttleComponent);
        }
    }
}
