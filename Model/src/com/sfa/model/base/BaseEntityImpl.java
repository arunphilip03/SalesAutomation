package com.sfa.model.base;

import oracle.jbo.AttributeDef;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.TransactionEvent;

public class BaseEntityImpl extends EntityImpl {
    public BaseEntityImpl() {
        super();
    }
    
    private static final byte SOFT_DELETE_TYPE = 11;

        public int getSoftDeleteColumn() {
            int colIndex = -1;
            for (AttributeDef def : getEntityDef().getAttributeDefs()) {
                if (((AttributeDefImpl)def).getHistoryKind() == SOFT_DELETE_TYPE) {
                    colIndex = def.getIndex();
                }
            }
            return colIndex;
        }

        @Override
        public void remove() {
            int deleteCol = getSoftDeleteColumn();
            if(deleteCol != -1) {
                setAttribute(deleteCol, "Y");
            }

            super.remove();
        }

        @Override
        protected void doDML(int operation, TransactionEvent transactionEvent) {
            int deleteCol = getSoftDeleteColumn();
            
            if(EntityImpl.DML_UPDATE == operation && deleteCol != -1) {
                System.out.println("updating...");
                setAttribute(deleteCol, "N");
            }
            
            if (EntityImpl.DML_DELETE == operation && deleteCol != -1) {
                System.out.println("deleting...");
                operation = DML_UPDATE;
            }
            if(EntityImpl.DML_INSERT == operation && deleteCol != -1) {
                System.out.println("inserting...");
                setAttribute(deleteCol, "N");
            }
            
            super.doDML(operation, transactionEvent);

        }
    
    
}
