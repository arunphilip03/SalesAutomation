package com.sfa.view.backing;


import oracle.adf.model.BindingContext;
import oracle.adf.view.rich.event.DialogEvent;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import org.apache.myfaces.trinidad.event.ReturnEvent;

public class ConfirmBean {
    public ConfirmBean() {
    }
    
    
    public void dialogListener(DialogEvent dialogEvent) {
        
        if(dialogEvent.getOutcome().equals(DialogEvent.Outcome.ok)) {
            BindingContainer bc = BindingContext.getCurrent().getCurrentBindingsEntry();
            OperationBinding opDelete = bc.getOperationBinding("Delete"); 
            OperationBinding opCommit = bc.getOperationBinding("Commit"); 
            opDelete.execute();
            opCommit.execute();
            
        
        }
    }
    
    public void dialogListenerAppnmnt(DialogEvent dialogEvent) {
        
        if(dialogEvent.getOutcome().equals(DialogEvent.Outcome.ok)) {
            BindingContainer bc = BindingContext.getCurrent().getCurrentBindingsEntry();
            OperationBinding opDelete = bc.getOperationBinding("Delete1"); 
            OperationBinding opCommit = bc.getOperationBinding("Commit"); 
            opDelete.execute();
            opCommit.execute();
            
        
        }
    }
    
    public void dialogListenerInteractn(DialogEvent dialogEvent) {
        
        if(dialogEvent.getOutcome().equals(DialogEvent.Outcome.ok)) {
            BindingContainer bc = BindingContext.getCurrent().getCurrentBindingsEntry();
            OperationBinding opDelete = bc.getOperationBinding("Delete2"); 
            OperationBinding opCommit = bc.getOperationBinding("Commit"); 
            opDelete.execute();
            opCommit.execute();
            
        
        }
    }
    
    public void dialogListenerTask(DialogEvent dialogEvent) {
        
        if(dialogEvent.getOutcome().equals(DialogEvent.Outcome.ok)) {
            BindingContainer bc = BindingContext.getCurrent().getCurrentBindingsEntry();
            OperationBinding opDelete = bc.getOperationBinding("Delete3"); 
            OperationBinding opCommit = bc.getOperationBinding("Commit"); 
            opDelete.execute();
            opCommit.execute();
            
        
        }
    }


    public void dialogListenerNotes(DialogEvent dialogEvent) {
        
        if(dialogEvent.getOutcome().equals(DialogEvent.Outcome.ok)) {
            BindingContainer bc = BindingContext.getCurrent().getCurrentBindingsEntry();
            OperationBinding opDelete = bc.getOperationBinding("Delete4"); 
            OperationBinding opCommit = bc.getOperationBinding("Commit"); 
            opDelete.execute();
            opCommit.execute();
            
        
        }
    }
}
