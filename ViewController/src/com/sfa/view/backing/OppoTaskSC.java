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

public class OppoTaskSC  {
    private RichSelectManyShuttle selectManyShuttleComponentU; 
    private RichSelectManyShuttle selectManyShuttleComponentC;
    private List selectedContacts;
    private List selectedUsers;
    private BindingContainer bindings;
    private List allContacts;
    private List allUsers;
    private boolean refreshIterator = false;
   
    public OppoTaskSC() {
    }

    public void setSelectedContacts(List selectedContacts) {
        this.selectedContacts = selectedContacts;
    }

    public List getSelectedContacts() {
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
    
    public List attributeListForIterator() {
        DCBindingContainer bc = (DCBindingContainer)getBindings();
        DCIteratorBinding iter = bc.findIteratorBinding("TaskTeamView6Iterator");
        List attributeList = new ArrayList();
        for (Row row : iter.getAllRowsInRange()) {
            if("CONTACT".equals((String)row.getAttribute("InviteeType")))
            attributeList.add(row.getAttribute("ContactId"));
            
        }
       // System.out.println(attributeList);
        return attributeList;
    }
    
    public List<SelectItem> selectItemsForIterator() {
        DCBindingContainer bc = (DCBindingContainer)getBindings();
        DCIteratorBinding iter = bc.findIteratorBinding("CustomerContactsView4Iterator");
        List<SelectItem> selectItems = new ArrayList<SelectItem>();
        
        for (Row row : iter.getAllRowsInRange()) {
            selectItems.add(new SelectItem(row.getAttribute("ContactId"),
                                           (String)row.getAttribute("ContactName")));
        }
        return selectItems;
    }


    public void onContactChange(ValueChangeEvent valueChangeEvent) {
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
    
    public Number getCurrentTaskId() {
        DCBindingContainer bc = (DCBindingContainer)getBindings();
        AttributeBinding attr = (AttributeBinding)bc.findCtrlBinding("TaskId");
        Number appointmentId = (Number)attr.getInputValue();
        return appointmentId;
    }
    
    public void onCommit(ActionEvent actionEvent) {
        DCBindingContainer bc = (DCBindingContainer)getBindings();
        DCIteratorBinding iter = bc.findIteratorBinding("TaskTeamView6Iterator");
        //Removing all rows for the current EmpId from EmpRolesVO
        for (Row row : iter.getAllRowsInRange()) {
            row.remove();
        }
        List contacts = getSelectedContacts();
        int sizec = contacts.size();
        if (sizec > 0) {
            for (int i = 0; i < sizec; i++) {
                Row row = iter.getRowSetIterator().createRow();
                row.setAttribute("TaskId", getCurrentTaskId());
                row.setAttribute("ContactId", contacts.get(i));
                iter.getRowSetIterator().insertRow(row);
            }
        }
        
        
        
        List users = getSelectedUsers();
        System.out.println(users);
        int size = users.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                Row row = iter.getRowSetIterator().createRow();
                row.setAttribute("TaskId", getCurrentTaskId());
                row.setAttribute("UserId", users.get(i));
                iter.getRowSetIterator().insertRow(row);
            }
        }
        
        
        OperationBinding op = bc.getOperationBinding("Commit");
        if (op != null) {
            op.execute();
        }
        
    }
    
    public String setRefreshIterator() {
        refreshIterator = true;
        return null;
    }

    public void setSelectManyShuttleComponentC(RichSelectManyShuttle selectManyShuttleComponent) {
        this.selectManyShuttleComponentC = selectManyShuttleComponent;
    }

    public RichSelectManyShuttle getSelectManyShuttleComponentC() {
        return selectManyShuttleComponentC;
    }
    
    public void setSelectManyShuttleComponentU(RichSelectManyShuttle selectManyShuttleComponent) {
        this.selectManyShuttleComponentU = selectManyShuttleComponent;
    }

    public RichSelectManyShuttle getSelectManyShuttleComponentU() {
        return selectManyShuttleComponentU;
    }
    public void setBindings(BindingContainer bindings) {
        this.bindings = bindings;
    }

    public BindingContainer getBindings() {
        BindingContext context = BindingContext.getCurrent();
                BindingContainer bindings = context.getCurrentBindingsEntry();
        return bindings;
    }

    public void setAllContacts(List allUsers) {
        this.allContacts = allUsers;
    }

    public List getAllContacts() {
        if (allContacts == null) {
            allContacts = selectItemsForIterator();
        }
        
        return allContacts;
    }

    public void setRefreshIterator(boolean refreshIterator) {
        this.refreshIterator = refreshIterator;
    }

  
  
  
  
    public void setSelectedUsers(List selectedUsers) {
        this.selectedUsers = selectedUsers;
    }

    public List getSelectedUsers() {
        List selectedList = null;
        AdfFacesContext fctx = AdfFacesContext.getCurrentInstance();
        Map<String, Object> pfs = fctx.getPageFlowScope();
        if (pfs != null) {
            if (pfs.get("selectedListU") == null || refreshIterator)
                selectedList = attributeListForIteratorU();
            else
                selectedList = (List)pfs.get("selectedListU");
        }
        return selectedList;
       
    }
    
    public List attributeListForIteratorU() {
        DCBindingContainer bc = (DCBindingContainer)getBindings();
        DCIteratorBinding iter = bc.findIteratorBinding("TaskTeamView6Iterator");
        List attributeList = new ArrayList();
        for (Row row : iter.getAllRowsInRange()) {
            if("USER".equals((String)row.getAttribute("InviteeType")))
            {
            attributeList.add(row.getAttribute("UserId"));
           // System.out.println(row.getAttribute("Name"));
            }
        }
        return attributeList;
    }
    
    public List<SelectItem> selectItemsForIteratorU() {
        DCBindingContainer bc = (DCBindingContainer)getBindings();
        DCIteratorBinding iter = bc.findIteratorBinding("UsersView1Iterator");
        List<SelectItem> selectItems = new ArrayList<SelectItem>();
        
        for (Row row : iter.getAllRowsInRange()) {
            selectItems.add(new SelectItem(row.getAttribute("UserId"),
                                           (String)row.getAttribute("FirstName")));
        }
        return selectItems;
    }


    public void onUserChange(ValueChangeEvent valueChangeEvent) {
        List<Number> selectedListFromUI = null;
        if (valueChangeEvent.getOldValue().equals(valueChangeEvent.getNewValue()))
            return;
        selectedListFromUI = (ArrayList<Number>)valueChangeEvent.getNewValue();
        AdfFacesContext fctx = AdfFacesContext.getCurrentInstance();
        Map<String, Object> pfsu = fctx.getPageFlowScope();
        if (pfsu != null) {
            if (selectedListFromUI != null) {
                pfsu.put("selectedListU", selectedListFromUI);
            } else {
                pfsu.put("selectedListU", new ArrayList());
            }
        }
    
    }
    public List getAllUsers() {
        if (allUsers == null) {
            allUsers = selectItemsForIteratorU();
        }
        
        return allUsers;
    }
}

