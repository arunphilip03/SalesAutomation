package com.sfa.view.backing;

import java.math.BigDecimal;

import java.sql.SQLException;

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
import oracle.jbo.ViewObject;
import oracle.jbo.domain.Number;

public class InviteeBean {
    private RichSelectManyShuttle selectManyShuttleComponentContacts;
    private RichSelectManyShuttle selectManyShuttleComponentUsers;

    public InviteeBean() {
        super();
    }
    private BindingContainer bindings;
    private List allContacts;
    private List selectedContacts;

    private List allUsers;
    private List selectedUsers;
    private boolean refreshIterator = false;
    
    private BigDecimal user;


    public void setUser(BigDecimal user) {
        this.user = user;
    }

    public BigDecimal getUser() {
        return user;
    }

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
    public void setAllContacts(List allContacts) {
        this.allContacts = allContacts;
    }

    /**
     * Getter method for AllRoles.
     * @return
     */
    public List getAllContacts() {
        if (allContacts == null) {
            allContacts = selectItemsForIteratorContacts();
        }
        return allContacts;
    }

    /**
     * Setter method for SelectedContacts
     * @param selectedRoles
     */
    public void setSelectedContacts(List selectedContacts) {
        this.selectedContacts = selectedContacts;
    }

    /**
     * Getter method for Selected Contacts
     * @return
     */
    public List getSelectedContacts() {
        List selectedListContact = null;
        AdfFacesContext fctx = AdfFacesContext.getCurrentInstance();
        Map<String, Object> pfs = fctx.getPageFlowScope();
        if (pfs != null) {
            if (pfs.get("selectedListContact") == null || refreshIterator)
                selectedListContact = attributeListForIteratorContacts();
            else
                selectedListContact = (List) pfs.get("selectedListContact");
        }
        return selectedListContact;
    }


    public void setAllUsers(List allUsers) {
        this.allUsers = allUsers;
    }

    public List getAllUsers() {
        if (allUsers == null) {
            allUsers = selectItemsForIteratorUsers();
        }
        return allUsers;
    }

    public void setSelectedUsers(List selectedUsers) {
        this.selectedUsers = selectedUsers;
    }

    public List getSelectedUsers() {

        List selectedListUser = null;
        AdfFacesContext fctx = AdfFacesContext.getCurrentInstance();
        Map<String, Object> pfs = fctx.getPageFlowScope();
        if (pfs != null) {
            if (pfs.get("selectedListUser") == null || refreshIterator)
                selectedListUser = attributeListForIteratorUsers();
            else
                selectedListUser = (List) pfs.get("selectedListUser");
        }
        return selectedListUser;
    }


    /**
     * Helper method to return the selected roles for an Employee
     * @return
     */
    public List attributeListForIteratorContacts() {
        DCBindingContainer bc = (DCBindingContainer) getBindings();
        DCIteratorBinding iter = bc.findIteratorBinding("AppointmentInviteesVO3Iterator");
        List attributeList = new ArrayList();
        for (Row row : iter.getAllRowsInRange()) {
            attributeList.add(row.getAttribute("ContactId"));
        }
        return attributeList;
    }

    public List attributeListForIteratorUsers() {
        DCBindingContainer bc = (DCBindingContainer) getBindings();
        DCIteratorBinding iter = bc.findIteratorBinding("AppointmentInviteesVO3Iterator");
        List attributeList = new ArrayList();
        for (Row row : iter.getAllRowsInRange()) {
            attributeList.add(row.getAttribute("UserId"));
        }
        return attributeList;
    }

    public List<SelectItem> selectItemsForIteratorContacts() {


        AdfFacesContext fctx = AdfFacesContext.getCurrentInstance();
        Map<String, Object> pfs = fctx.getPageFlowScope();
        String appType = null;
        if (pfs != null) {

            appType = (String) pfs.get("appType");
            System.out.println("Type:: " + appType);
        }


        DCBindingContainer bc = (DCBindingContainer) getBindings();
        DCIteratorBinding iter = null;
        List<SelectItem> selectItems = new ArrayList<SelectItem>();
        if (appType.equals("customer")) {
            iter = bc.findIteratorBinding("CustomerContactsView2Iterator");
            //List<SelectItem> selectItems = new ArrayList<SelectItem>();
            for (Row row : iter.getAllRowsInRange()) {
                selectItems.add(new SelectItem(row.getAttribute("ContactId"),
                                               (String) row.getAttribute("ContactName")));
            }

        } else if (appType.equals("contact")) {

            AttributeBinding accountId = (AttributeBinding) bc.getControlBinding("CustAccountId");
            System.out.println("Account id= " + accountId.toString());
            //ContactsInAccountVO

            DCIteratorBinding contactIter = bc.findIteratorBinding("ContactsInAccountVO1Iterator");
            ViewObject viwObj = contactIter.getViewObject();
            viwObj.defineNamedWhereClauseParam("ACCOUNTID", null, null);
            viwObj.setNamedWhereClauseParam("ACCOUNTID", accountId);
            viwObj.executeQuery();


            while (viwObj.hasNext()) {
                Row row = viwObj.next();
                selectItems.add(new SelectItem(row.getAttribute("ContactId"),
                                               (String) row.getAttribute("ContactName")));
            }


            //iter = bc.findIteratorBinding("RelatedContacts1Iterator");
        }

        return selectItems;
    }

    public List<SelectItem> selectItemsForIteratorUsers() {
        DCBindingContainer bc = (DCBindingContainer) getBindings();
        DCIteratorBinding iter = bc.findIteratorBinding("AllUsersVO1Iterator");
        List<SelectItem> selectItems = new ArrayList<SelectItem>();
        for (Row row : iter.getAllRowsInRange()) {
            selectItems.add(new SelectItem(row.getAttribute("UserId"), (String) row.getAttribute("UserName")));
        }
        return selectItems;
    }

    public void onContactChange(ValueChangeEvent valueChangeEvent) {
        List<Number> selectedListFromUI = null;
        if (valueChangeEvent.getOldValue().equals(valueChangeEvent.getNewValue()))
            return;
        selectedListFromUI = (ArrayList<Number>) valueChangeEvent.getNewValue();
        AdfFacesContext fctx = AdfFacesContext.getCurrentInstance();
        Map<String, Object> pfs = fctx.getPageFlowScope();
        if (pfs != null) {
            if (selectedListFromUI != null) {
                pfs.put("selectedListContact", selectedListFromUI);
            } else {
                pfs.put("selectedListContact", new ArrayList());
            }
        }
    }

    public void onUserChange(ValueChangeEvent valueChangeEvent) {
        List<Number> selectedListFromUI = null;
        if (valueChangeEvent.getOldValue().equals(valueChangeEvent.getNewValue()))
            return;
        selectedListFromUI = (ArrayList<Number>) valueChangeEvent.getNewValue();
        AdfFacesContext fctx = AdfFacesContext.getCurrentInstance();
        Map<String, Object> pfs = fctx.getPageFlowScope();
        if (pfs != null) {
            if (selectedListFromUI != null) {
                pfs.put("selectedListUser", selectedListFromUI);
            } else {
                pfs.put("selectedListUser", new ArrayList());
            }
        }
    }

    public Number getCurrentAppointmentId() {
        DCBindingContainer bc = (DCBindingContainer) getBindings();
        //        AttributeBinding attr = (AttributeBinding)bc.findCtrlBinding("AppointmentId");

        DCIteratorBinding iterBind = (DCIteratorBinding) bc.get("AppointmentsView2Iterator");
        BigDecimal appId = (BigDecimal) iterBind.getCurrentRow().getAttribute("AppointmentId");

        //        AttributeBinding attr2 = (AttributeBinding)bc.get("AppointmentId");


        System.out.println("Appointment ID3: " + appId);


        Number empId = null;
        try {
            empId = new Number(appId);
        } catch (SQLException e) {
        }
        return empId;
    }

    public void onCommit(ActionEvent actionEvent) {
        DCBindingContainer bc = (DCBindingContainer) getBindings();
        DCIteratorBinding iter = bc.findIteratorBinding("AppointmentInviteesVO3Iterator");

        //Removing all rows for the current EmpId from EmpRolesVO
        for (Row row : iter.getAllRowsInRange()) {
            row.remove();
        }
        List roles = getSelectedContacts();
        int size = roles.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                Row row = iter.getRowSetIterator().createRow();
                //System.out.println("Appointment ID: "+attr.getInputValue() );
                System.out.println("Contact ID: " + roles.get(i));

                row.setAttribute("AppointmentId", getCurrentAppointmentId());
                row.setAttribute("ContactId", roles.get(i));
                iter.getRowSetIterator().insertRow(row);
            }
        }

        List users = getSelectedUsers();
        int users_size = users.size();
        if (users_size > 0) {
            for (int i = 0; i < users_size; i++) {
                Row row = iter.getRowSetIterator().createRow();
                //System.out.println("Appointment ID: "+attr.getInputValue() );
                System.out.println("UserID: " + users.get(i));

                row.setAttribute("AppointmentId", getCurrentAppointmentId());
                row.setAttribute("UserId", users.get(i));
                iter.getRowSetIterator().insertRow(row);
            }

        }


        OperationBinding op = bc.getOperationBinding("Commit");
        if (op != null) {
            op.execute();
        }
        //return null;
    }

    public String setRefreshIterator() {
        refreshIterator = true;
        return null;
    }

    public void setSelectManyShuttleComponentContacts(RichSelectManyShuttle selectManyShuttleComponent) {
        this.selectManyShuttleComponentContacts = selectManyShuttleComponent;
    }

    public RichSelectManyShuttle getSelectManyShuttleComponentContacts() {
        return selectManyShuttleComponentContacts;
    }


    public void setSelectManyShuttleComponentUsers(RichSelectManyShuttle selectManyShuttleComponentUsers) {
        this.selectManyShuttleComponentUsers = selectManyShuttleComponentUsers;
    }

    public RichSelectManyShuttle getSelectManyShuttleComponentUsers() {
        return selectManyShuttleComponentUsers;
    }


    public void onClearIndices(ActionEvent actionEvent) {
        List list = new ArrayList();
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("selectedList", list);
        if (selectManyShuttleComponentContacts != null) {
            AdfFacesContext.getCurrentInstance().addPartialTarget(selectManyShuttleComponentContacts);
        }
    }
}
