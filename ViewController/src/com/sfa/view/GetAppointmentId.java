package com.sfa.view;

import java.math.BigDecimal;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;

import oracle.jbo.Row;

public class GetAppointmentId {
    private String currentTaskId;
    private String currentInteractionId;

    public GetAppointmentId() {
    }
    
    
    
    
    public String getCurrentAccountName() {
        
        DCBindingContainer bc = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding iterator = bc.findIteratorBinding("CustomerAccountView1Iterator");
        Row row = iterator.getCurrentRow();
        
        String accountName = (String)row.getAttribute("AccountName");
    
        System.out.println("selected account = "+ accountName);
        
        return accountName;
        
    }
    
    
    public String getCurrentContactName() {
        
        DCBindingContainer bc = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding iterator = bc.findIteratorBinding("CustomerContactsView2Iterator");
        Row row = iterator.getCurrentRow();
        
        String contactName = (String)row.getAttribute("ContactName");
    
        System.out.println("selected contact = "+ contactName);
        
        return contactName;
        
    }
    
    
    public String getCurrentAppointmentId() {
        DCBindingContainer bc = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();

        DCIteratorBinding iterator = bc.findIteratorBinding("ContactAppointmentsVO1Iterator");

        Row row = iterator.getCurrentRow();

        BigDecimal id = (BigDecimal)row.getAttribute("AppointmentId");
        
        String appointmentId_Str = id.toString();
        
        
        
        System.out.println("selected appointment= "+ appointmentId_Str);
        
        return appointmentId_Str;
        
    }

    public void setCurrentTaskId(String currentTaskId) {
        this.currentTaskId = currentTaskId;
    }

    public String getCurrentTaskId() {
        DCBindingContainer bc = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();

        DCIteratorBinding iterator = bc.findIteratorBinding("ContactTasksVO1Iterator");

        Row row = iterator.getCurrentRow();

        BigDecimal id = (BigDecimal)row.getAttribute("TaskId");
        
        String taskId_Str = id.toString();
        
        
        
        System.out.println("selected task= "+ taskId_Str);
        
        return taskId_Str;
    }

    public void setCurrentInteractionId(String currentInteractionId) {
        this.currentInteractionId = currentInteractionId;
    }

    public String getCurrentInteractionId() {
        
        DCBindingContainer bc = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();

        DCIteratorBinding iterator = bc.findIteratorBinding("ContactInteractionsVO1Iterator");

        Row row = iterator.getCurrentRow();

        BigDecimal id = (BigDecimal)row.getAttribute("InteractionId");
        
        String appointmentId_Str = id.toString();
        
        
        
        System.out.println("selected appointment= "+ appointmentId_Str);
        
        return appointmentId_Str;
        
        
        //return currentInteractionId;
    }
}
