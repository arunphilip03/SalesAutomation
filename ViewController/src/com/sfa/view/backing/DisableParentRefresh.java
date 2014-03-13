package com.sfa.view.backing;

import java.util.Date;

import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;

import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.event.ReturnPopupEvent;

import oracle.binding.AttributeBinding;
import oracle.binding.BindingContainer;

import oracle.binding.OperationBinding;

import oracle.jbo.Key;

import oracle.jbo.Row;
import oracle.jbo.uicli.binding.JUCtrlListBinding;

import org.apache.myfaces.trinidad.event.DisclosureEvent;

public class DisableParentRefresh {
    private RichInputDate closeDate;

    public DisableParentRefresh() {
        super();
    }
   

//    public void keepParentRow(ActionEvent actionEvent) {
//        BindingContext bctx = BindingContext.getCurrent();
//        BindingContainer bindings = bctx.getCurrentBindingsEntry();
//        DCIteratorBinding parentIter = (DCIteratorBinding)bindings.get("OpportunitiesView1Iterator");
//                        Key parentKey = parentIter.getCurrentRow().getKey();
//                  //You can add your operation code here, i have used simple Cancel operation with Rollback and    Execute
//                  OperationBinding createOpBAddress1 = bindings.getOperationBinding("CreateInsert");
//                  createOpBAddress1.execute();
//                  
//                        OperationBinding createOpBAddress = bindings.getOperationBinding("Rollback");
//                        createOpBAddress.execute();
//                        
//                        parentIter.setCurrentRowWithKey(parentKey.toStringFormat(true));
//    }

    public void notesDisclosure(DisclosureEvent disclosureEvent) {
        BindingContext bctx = BindingContext.getCurrent();
        BindingContainer bindings = bctx.getCurrentBindingsEntry();
        OperationBinding createOpBAddress1 = bindings.getOperationBinding("ExecuteWithParams");
        createOpBAddress1.execute();
    }

   

    public void closeDateReturnListner(ReturnPopupEvent returnPopupEvent) {
        // Add event code here...
        Date d = new Date();
        System.out.println(d);
        // Add event code here...
        BindingContainer bindings =
        BindingContext.getCurrent().getCurrentBindingsEntry();
        // Get the sepecific list binding
        JUCtrlListBinding listBinding =
        (JUCtrlListBinding)bindings.get("SalesStage");
        // Get the value which is currently selected
        String selectedValue = (String)listBinding.getAttributeValue();
        System.out.println(selectedValue);
        
        DCBindingContainer bc = (DCBindingContainer)bindings;
        DCIteratorBinding iter = bc.findIteratorBinding("OpportunitiesView1Iterator");
        Row r1 = iter.getCurrentRow();
        
        
        if("CLOSED".equals(selectedValue)){
            AttributeBinding attr = (AttributeBinding) bindings.getControlBinding("CloseDate");
            attr.setInputValue(d);
                       
            r1.setAttribute("CloseDate",d);
            if(!(closeDate.isDisabled())){
                    closeDate.setDisabled(true);
                }
        }
        else{
            
            Date d1= null;
            r1.setAttribute("CloseDate",d1);
            if (closeDate.isDisabled()) {
                   closeDate.setDisabled(false);                   
               }
        }
       
    }

    public void setCloseDate(RichInputDate closeDate) {
        this.closeDate = closeDate;
    }

    public RichInputDate getCloseDate() {
        return closeDate;
    }
}
