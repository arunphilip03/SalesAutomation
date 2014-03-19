package com.sfa.view.backing;

import java.util.ArrayList;
import java.util.Iterator;

import javax.faces.event.ActionEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;

public class RollbackBean {
    public RollbackBean() {
        super();
    }


    public void onRollBack(ActionEvent actionEvent) {

        System.out.println("Rolling back");

        DCBindingContainer bc = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();

        //DCIteratorBinding iterator = bc.findIteratorBinding("CustomerContactsView2Iterator");


        ArrayList iteratorList;
        iteratorList = bc.getIterBindingList();

        System.out.println("Size: " + iteratorList.size());

        Iterator listIterator = iteratorList.listIterator();

        while (listIterator.hasNext()) {

            DCIteratorBinding iterator2 = (DCIteratorBinding) listIterator.next();

            System.out.println(iterator2.getDisplayName());

            ViewObject vo = iterator2.getViewObject();
            Row row = vo.getCurrentRow();

            if (row != null) {

                row.refresh(oracle.jbo.Row.REFRESH_REMOVE_NEW_ROWS);
            }

        }



    }


    public void onRollBackAppointments(ActionEvent actionEvent) {

        System.out.println("Rolling back appointments");

        DCBindingContainer bc = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();

        DCIteratorBinding iterator = bc.findIteratorBinding("AppointmentsView2Iterator");

        ViewObject vo = iterator.getViewObject();

        Row row = vo.getCurrentRow();

        //row.remove();

        if (!row.isDead()) {

            row.refresh(oracle.jbo.Row.REFRESH_REMOVE_NEW_ROWS);
        }


    }
    
    
    public void onRollBackAppointmentsConEdit(ActionEvent actionEvent) {

        System.out.println("Rolling back appointments contact edit");

        DCBindingContainer bc = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();

        DCIteratorBinding iterator = bc.findIteratorBinding("ContactAppointmentsVO1Iterator");

        ViewObject vo = iterator.getViewObject();

        Row row = vo.getCurrentRow();

        //row.remove();

        if (!row.isDead()) {

            row.refresh(oracle.jbo.Row.REFRESH_REMOVE_NEW_ROWS);
        }


    }
    
    
        public void onRollBackTasks(ActionEvent actionEvent) {
            
            System.out.println("Rolling back tasks");
            
            DCBindingContainer bc = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();

            DCIteratorBinding iterator = bc.findIteratorBinding("TasksView3Iterator");

            ViewObject vo = iterator.getViewObject();

            Row row = vo.getCurrentRow();

            //row.remove();

            if (!row.isDead()) {

                row.refresh(oracle.jbo.Row.REFRESH_REMOVE_NEW_ROWS);
            }
            
            
        }
        
        
        public void onRollBackContactInteractions(ActionEvent actionEvent) {
            
            System.out.println("Rolling back contact interactions");
            
            DCBindingContainer bc = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();

            DCIteratorBinding iterator = bc.findIteratorBinding("ContactInteractionsVO1Iterator");

            ViewObject vo = iterator.getViewObject();

            Row row = vo.getCurrentRow();

            //row.remove();

            if (!row.isDead()) {

                row.refresh(oracle.jbo.Row.REFRESH_REMOVE_NEW_ROWS);
            }
            
            
        }
        
    public void onRollBackTasksConEdit(ActionEvent actionEvent) {
        
        System.out.println("Rolling back tasks contact edit");
        
        DCBindingContainer bc = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();

        DCIteratorBinding iterator = bc.findIteratorBinding("ContactTasksVO1Iterator");
        
            ViewObject vo = iterator.getViewObject();

            Row row = vo.getCurrentRow();

            //row.remove();

            if (!row.isDead()) {

                row.refresh(oracle.jbo.Row.REFRESH_REMOVE_NEW_ROWS);
            }
            
        }
        
    
    
    
    public void OpportunityRollback(ActionEvent actionEvent) {
        
        System.out.println("Rolling back contact interactions");
        
        DCBindingContainer bc = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();

        DCIteratorBinding iterator = bc.findIteratorBinding("OpportunitiesView1Iterator");

        ViewObject vo = iterator.getViewObject();

        Row row = vo.getCurrentRow();

        //row.remove();

        if (!row.isDead()) {

            row.refresh(oracle.jbo.Row.REFRESH_REMOVE_NEW_ROWS);
        }
        
        
    }
        
        
 
    public void OpportunityAppnmntRollback(ActionEvent actionEvent) {
        
        System.out.println("Rolling back contact interactions");
        
        DCBindingContainer bc = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();

        DCIteratorBinding iterator = bc.findIteratorBinding("OpportunityAppointmentView2Iterator");

        ViewObject vo = iterator.getViewObject();

        Row row = vo.getCurrentRow();

        //row.remove();

        if (!row.isDead()) {

            row.refresh(oracle.jbo.Row.REFRESH_REMOVE_NEW_ROWS);
        }
        
        
        
    } 
    
    public void OpportunityInteractionRollback(ActionEvent actionEvent) {
        
        
        DCBindingContainer bc = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();

        DCIteratorBinding iterator = bc.findIteratorBinding("ContactInteractionsView2Iterator");

        ViewObject vo = iterator.getViewObject();

        Row row = vo.getCurrentRow();

        //row.remove();

        if (!row.isDead()) {

            row.refresh(oracle.jbo.Row.REFRESH_REMOVE_NEW_ROWS);
        }
        
        
        
    } 
    
    public void OpportunityNoteRollback(ActionEvent actionEvent) {
        
        
        DCBindingContainer bc = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();

        DCIteratorBinding iterator = bc.findIteratorBinding("OpportunityNotes2Iterator");

        ViewObject vo = iterator.getViewObject();

        Row row = vo.getCurrentRow();

        //row.remove();

        if (!row.isDead()) {

            row.refresh(oracle.jbo.Row.REFRESH_REMOVE_NEW_ROWS);
        }
        
        
        
    } 
    public void OpportunityRevenueRollback(ActionEvent actionEvent) {
        
        
        DCBindingContainer bc = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();

        DCIteratorBinding iterator = bc.findIteratorBinding("OpportunityRevenueItemsView2Iterator");

        ViewObject vo = iterator.getViewObject();

        Row row = vo.getCurrentRow();

        //row.remove();

        if (!row.isDead()) {

            row.refresh(oracle.jbo.Row.REFRESH_REMOVE_NEW_ROWS);
        }
        
        
        
    } 
    
    public void OpportunityTaskRollback(ActionEvent actionEvent) {
        
        
        DCBindingContainer bc = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();

        DCIteratorBinding iterator = bc.findIteratorBinding("OpportunityTaskView2Iterator");

        ViewObject vo = iterator.getViewObject();

        Row row = vo.getCurrentRow();

        //row.remove();

        if (!row.isDead()) {

            row.refresh(oracle.jbo.Row.REFRESH_REMOVE_NEW_ROWS);
        }
        
        
        
    } 
}
