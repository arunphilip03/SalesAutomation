package com.sfa.view;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import java.util.ListIterator;

import javax.faces.component.UIComponent;
import javax.faces.event.ActionEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;

import oracle.adf.view.rich.component.rich.layout.RichPanelTabbed;

import oracle.adf.view.rich.component.rich.layout.RichShowDetailItem;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;

public class GeneralInfoBean {
    private String currentTaskId;
    private String currentInteractionId;
    private RichPanelTabbed panelTab;

    static RichShowDetailItem previousActiveTab = null;

    static boolean isAfterTf = false;

    public GeneralInfoBean() {
    }


    public void beforeTaskFlow() {
        System.out.println("BEFORE");

        previousActiveTab = getActiveTab();
    }

    public void afterTaskFlow() {
        System.out.println("AFTER");

        System.out.println("previousActiveTab " + previousActiveTab.getId());
        isAfterTf = true;


    }
    
    
    public BigDecimal getCurrentContactIdTaskEdit() {
        
        DCBindingContainer bc = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding iterator = bc.findIteratorBinding("ContactTasksVO1Iterator");
        
        
        BigDecimal accountId = (BigDecimal) iterator.getCurrentRow().getAttribute("ContactId");
        
        String taskName = (String) iterator.getCurrentRow().getAttribute("TaskName");
        System.out.println("Task Name row= "+ taskName);
        System.out.println("Contact ID row = " + accountId);
        return accountId;
        
    }


    public String getCurrentAccountName() {

        DCBindingContainer bc = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding iterator = bc.findIteratorBinding("CustomerAccountView1Iterator");
        Row row = iterator.getCurrentRow();

        String accountName = (String) row.getAttribute("AccountName");

        System.out.println("selected account = " + accountName);

        return accountName;

    }


    public String getCurrentContactNameMain() {

        DCBindingContainer bc = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding iterator = bc.findIteratorBinding("CustomerContactsView1Iterator");
        Row row = iterator.getCurrentRow();

        String contactName = (String) row.getAttribute("ContactName");

        System.out.println("selected contact = " + contactName);

        return contactName;

    }


    public String getCurrentContactName() {

        DCBindingContainer bc = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding iterator = bc.findIteratorBinding("CustomerContactsView2Iterator");
        Row row = iterator.getCurrentRow();

        String contactName = (String) row.getAttribute("ContactName");

        System.out.println("selected contact = " + contactName);

        return contactName;

    }


    public BigDecimal getCurrentAppointmentId() {
        DCBindingContainer bc = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();

        DCIteratorBinding iterator = bc.findIteratorBinding("ContactAppointmentsVO1Iterator");

        Row row = iterator.getCurrentRow();

        BigDecimal id = (BigDecimal) row.getAttribute("AppointmentId");

        String appointmentId_Str = id.toString();


        System.out.println("selected appointment= " + appointmentId_Str+"val");

        return id;

    }


    public String getCurrentContactId() {

        DCBindingContainer bc = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();

        DCIteratorBinding iterator = bc.findIteratorBinding("CustomerContactsView2Iterator");

        Row row = iterator.getCurrentRow();

        BigDecimal contactId = (BigDecimal) row.getAttribute("ContactId");

        String conactId_Str = contactId.toString();


        System.out.println("selected contact id in link = " + conactId_Str);

        return conactId_Str;

    }

    public void setCurrentTaskId(String currentTaskId) {
        this.currentTaskId = currentTaskId;
    }

    public String getCurrentTaskId() {
        DCBindingContainer bc = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();

        DCIteratorBinding iterator = bc.findIteratorBinding("ContactTasksVO1Iterator");

        Row row = iterator.getCurrentRow();

        BigDecimal id = (BigDecimal) row.getAttribute("TaskId");

        String taskId_Str = id.toString();


        System.out.println("selected task= " + taskId_Str);

        return taskId_Str;
    }

    public void setCurrentInteractionId(String currentInteractionId) {
        this.currentInteractionId = currentInteractionId;
    }

    public String getCurrentInteractionId() {

        DCBindingContainer bc = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();

        DCIteratorBinding iterator = bc.findIteratorBinding("ContactInteractionsVO1Iterator");

        Row row = iterator.getCurrentRow();

        BigDecimal id = (BigDecimal) row.getAttribute("InteractionId");

        String appointmentId_Str = id.toString();


        System.out.println("selected appointment= " + appointmentId_Str);

        return appointmentId_Str;


        //return currentInteractionId;
    }

    public void setPanelTab(RichPanelTabbed panelTab) {

        System.out.println("Set tab");


        this.panelTab = panelTab;

        for (UIComponent child : panelTab.getChildren()) {
            RichShowDetailItem sdi = (RichShowDetailItem) child;
            System.out.println(sdi.getId());

            if (isAfterTf) {
                if (sdi.getId().equals(previousActiveTab.getId())) {
                    System.out.println("equals");
                    sdi.setDisclosed(true);
                }else {
                    sdi.setDisclosed(false);
                }
            }

            //            if(sdi.isDisclosed()) {
            //                previousActiveTab = sdi;
            //            }

            System.out.println(sdi.isDisclosed());


        }

    }


    public RichShowDetailItem getActiveTab() {
        RichPanelTabbed panelTab = getPanelTab();
        RichShowDetailItem activeChild = null;

        for (UIComponent child : panelTab.getChildren()) {
            RichShowDetailItem sdi = (RichShowDetailItem) child;

            if (sdi.isDisclosed()) {

                System.out.println(sdi.getId());
                activeChild = sdi;


            }

            // System.out.println(sdi.isDisclosed());

        }
        return activeChild;


    }

    public RichPanelTabbed getPanelTab() {

        System.out.println("Get tab");
        return panelTab;
    }
}
