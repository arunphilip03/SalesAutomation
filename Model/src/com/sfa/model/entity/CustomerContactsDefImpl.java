package com.sfa.model.entity;

import java.math.BigDecimal;

import java.sql.SQLException;

import java.util.Date;

import java.util.Iterator;

import oracle.jbo.ApplicationModule;
import oracle.jbo.ViewObject;
import oracle.jbo.server.DBTransaction;
import oracle.jbo.server.EntityDefImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Fri Feb 28 14:03:42 IST 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class CustomerContactsDefImpl extends EntityDefImpl {
    /**
     * This is the default constructor (do not remove).
     */
    public CustomerContactsDefImpl() {
    }

    private ViewObject getPrimaryContactExistsView(DBTransaction t) {
        ApplicationModule root = t.getRootApplicationModule();
        ViewObject vo = root.findViewObject("ContactPrimaryExist");
        if (vo == null) {
            vo = root.createViewObject("ContactPrimaryExist", "com.sfa.model.VO.ContactPrimaryExist");
        }
        return vo;
    }

    public boolean exists(DBTransaction t, String isPrimary, Number accountId) {
        ViewObject vo = getPrimaryContactExistsView(t);
        vo.defineNamedWhereClauseParam("ID", null, null);
        vo.defineNamedWhereClauseParam("ISPRIMARY", null, null);
        System.out.println("Account id: "+ accountId);
                System.out.println("is primary: "+ isPrimary);
                
        vo.setNamedWhereClauseParam("ID", accountId);
        vo.setNamedWhereClauseParam("ISPRIMARY", isPrimary);


        vo.setForwardOnly(true);
        vo.executeQuery();
        if (vo.first() != null) {
            System.out.println("found contact in database!");
            return true;
        }
       
        return false;
    }
    
    
//    public boolean contactExists(DBTransaction t, String contactName, Number accountId) {
//        
//    }

    public static oracle.jbo.domain.Number toADFNumber(BigDecimal l) {
        oracle.jbo.domain.Number n = null;
        if (l != null) {
            try {
                n = new oracle.jbo.domain.Number(l);
            } catch (SQLException e) {
            }
        }
        return n;
    }


}

