package com.sfa.model.generic;

import oracle.adf.share.logging.ADFLogger;

import oracle.jbo.AttributeDef;
import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaItem;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.server.TransactionEvent;
import oracle.jbo.server.ViewDefImpl;
import oracle.jbo.server.ViewObjectImpl;
import oracle.jbo.server.ViewRowImpl;

public class GenericVOImpl extends ViewObjectImpl {
    private static final ADFLogger _logger = ADFLogger.createADFLogger(GenericVOImpl.class);
    private Key currentRowKey;
    private int currentRowIndexInRange;
    
    public void beforeRollback(TransactionEvent TransactionEvent) {
        System.out.println("hitB");
        if (this.isExecuted()) {
            ViewRowImpl currentRow = (ViewRowImpl)this.getCurrentRow();
            if (currentRow != null) {
                byte newRowState = currentRow.getNewRowState();
                if (newRowState != Row.STATUS_INITIALIZED && newRowState != Row.STATUS_NEW) {
                    currentRowKey = currentRow.getKey();
                    int rangeIndexOfCurrentRow = this.getRangeIndexOf(currentRow);
                    currentRowIndexInRange = rangeIndexOfCurrentRow;
                }
            }
        }
        super.beforeRollback(TransactionEvent);
    }
        
    public void afterRollback(TransactionEvent TransactionEvent) {
        
        System.out.println("hitA");
        super.afterRollback(TransactionEvent);
        if (currentRowKey != null) {
            _logger.fine("STARTING CURRENT ROW RESET");
            System.out.println("STARTING CURRENT ROW RESET");
            this.executeQuery();
            Key k = new Key(currentRowKey.getAttributeValues());
            Row[] found = this.findByKey(k, 1);
            if (found != null && found.length == 1) {
                Row r = this.getRow(k);
                this.setCurrentRow(r);
                if (currentRowIndexInRange >= 0) {
                    this.scrollRangeTo(r, currentRowIndexInRange);
                }
            }
            
            _logger.info("FINISHING CURRENT ROW RESET");
        }
        currentRowKey = null;
    }
}
