package com.sfa.model.generic;

import oracle.jbo.Session;
import oracle.jbo.server.ApplicationModuleImpl;

public class GenericAMImpl extends ApplicationModuleImpl {
    public GenericAMImpl() {
        super();
    }

    protected void prepareSession(Session session) {
        super.prepareSession(session);
        
        this.getDBTransaction().setClearCacheOnRollback(false);
    }
}
