package com.sfa.view.backing;

import java.util.Iterator;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;

import oracle.adf.view.rich.component.rich.layout.RichPanelFormLayout;

import oracle.binding.BindingContainer;

import oracle.jbo.Key;
import oracle.jbo.Row;


public class UserIdStoreBean {
   
    private Number user;
    private Key parentKey ;
  //  private RichPanelFormLayout iteratr;

 
    public UserIdStoreBean() {
        super();
    }

    public void setUser(Number user) {
        this.user = user;
    }

    public Number getUser() {
        BindingContext context = BindingContext.getCurrent();
        BindingContainer bindings = context.getCurrentBindingsEntry();
        DCBindingContainer bc = (DCBindingContainer)bindings;
        DCIteratorBinding iter = bc.findIteratorBinding("UsersView1Iterator");
        parentKey=iter.getCurrentRow().getKey();
        Row row = iter.getCurrentRow();
            user = (Number)row.getAttribute("UserId");
          
        System.out.println(user);
        return user;
    }

//    public void setIteratr(RichPanelFormLayout iteratr) {
//        this.iteratr = iteratr;
//    }
//
//    public RichPanelFormLayout getIteratr() {
//        BindingContext context = BindingContext.getCurrent();
//        BindingContainer bindings = context.getCurrentBindingsEntry();
//        DCBindingContainer bc = (DCBindingContainer)bindings;
//        DCIteratorBinding iter = bc.findIteratorBinding("UsersView1Iterator");
//        iter.setCurrentRowWithKey(parentKey.toStringFormat(true));
//        return iteratr;
//    }
}
