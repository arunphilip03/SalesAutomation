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
        
        String appType = null;
        AdfFacesContext fctx = AdfFacesContext.getCurrentInstance();
        Map<String, Object> pfs = fctx.getPageFlowScope();
        if (pfs != null) {

            appType = (String) pfs.get("appType");
            System.out.println("Type:: " + appType);
        }
       
        DCBindingContainer bc = (DCBindingContainer) getBindings();
        DCIteratorBinding iter = bc.findIteratorBinding("AppointmentInviteesVO3Iterator");
        List attributeList = new ArrayList();
        for (Row row : iter.getAllRowsInRange()) {
            attributeList.add(row.getAttribute("ContactId"));
        }
        if (appType.equals("contact")) {
            
            String source_contact = getSourceContactId();
            
            BigDecimal contactID = new BigDecimal(source_contact);
            
            //System.out.println("Big: "+contactID.toString());
                    if(!attributeList.contains(contactID))
                    {
                        //System.out.println("Adding");
                        attributeList.add(contactID);
                    }
                    
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
    
    
    public String getSourceContactId() {
        
        String contactId_no = null;
        DCBindingContainer bc = (DCBindingContainer) getBindings();
        AttributeBinding contactId = (AttributeBinding) bc.getControlBinding("ContactId");
        contactId_no = contactId.toString();
        System.out.println("Current contact id= " + contactId_no.toString());
        
        return contactId_no;
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
            
            getSourceContactId();

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

        System.out.println("Commiting appointments");

        DCBindingContainer bc = (DCBindingContainer) getBindings();

        DCIteratorBinding iter1 = bc.findIteratorBinding("AppointmentsView2Iterator");
        DCIteratorBinding iter = bc.findIteratorBinding("AppointmentInviteesVO3Iterator");

        BigDecimal accountId = (BigDecimal) iter1.getCurrentRow().getAttribute("CustAccountId");
        System.out.println("Account ID = " + accountId);
        
        BigDecimal appId = (BigDecimal) iter1.getCurrentRow().getAttribute("AppointmentId");
        System.out.println("App Id = " + appId);
        
        AttributeBinding accountIdBinding = (AttributeBinding) bc.getControlBinding("CustAccountId");
        System.out.println("Account id while commit= " + accountIdBinding.toString());
        
        BigDecimal accontIdBind = (BigDecimal)accountIdBinding.getInputValue();
        
        
        iter1.getCurrentRow().setAttribute("CustAccountId", accontIdBind);
        
        BigDecimal accountId2 = (BigDecimal) iter1.getCurrentRow().getAttribute("CustAccountId");
        System.out.println("Account ID2 = " + accountId2);
        

        //Removing all rows for the current EmpId from EmpRolesVO
        for (Row row : iter.getAllRowsInRange()) {
            row.remove();
        }
        List roles = getSelectedContacts();
        
        
        
        /* Check for creating contact in list- In case of contact appointments */
        
        String appType = null;
        AdfFacesContext fctx = AdfFacesContext.getCurrentInstance();
        Map<String, Object> pfs = fctx.getPageFlowScope();
        if (pfs != null) {

            appType = (String) pfs.get("appType");
            System.out.println("Type:: " + appType);
        }
        
        if (appType.equals("contact")) {
            
            String source_contact = getSourceContactId();
            
            BigDecimal contactID = new BigDecimal(source_contact);
            
            System.out.println("Checking source contact " + contactID);
                    if(!roles.contains(contactID))
                    {
                        System.out.println("Adding");
                        roles.add(contactID);
                    }
                    
        }
        /* End of Check */
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        int size = roles.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
               

                Object contactId = roles.get(i);
                System.out.println("Contact ID: " + contactId);
                if (contactId != null) {
                    Row row = iter.getRowSetIterator().createRow();

                    row.setAttribute("AppointmentId", appId);
                    row.setAttribute("ContactId", contactId);
                    iter.getRowSetIterator().insertRow(row);
                }

            }
        }

        List users = getSelectedUsers();
        int users_size = users.size();
        if (users_size > 0) {
            for (int i = 0; i < users_size; i++) {
                

                Object userId = users.get(i);
                System.out.println("UserID: " + userId);
                if (userId != null) {
                    Row row = iter.getRowSetIterator().createRow();
                    row.setAttribute("AppointmentId", appId);
                    row.setAttribute("UserId", userId);
                    iter.getRowSetIterator().insertRow(row);
                }
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
