package com.sfa.model.VO;

import com.sfa.model.base.BaseEntityImpl;

import java.math.BigDecimal;

import java.sql.Timestamp;

import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.RowIterator;
import oracle.jbo.RowSet;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sat Mar 08 14:39:01 IST 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class ContactInteractionsVORowImpl extends ViewRowImpl {
    public static final int ENTITY_CONTACTINTERACTIONS = 0;
    public static final int ENTITY_INTERACTIONTEAM = 1;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        Type,
        InteractionId,
        Direction,
        StartDatetime,
        EndDatetime,
        Description,
        Resolution,
        OppurtunityId,
        ContactId,
        InteractionTeamId,
        ObjectVersionNumber,
        RelatedOpportunity,
        CustomerContactsView,
        ContactInteractionTeamVO,
        ContactVO,
        ContactIntTeamVO,
        OpportunitiesView1,
        InteractionsTypeLuView1,
        InteractionsDirectionLuView1;
        static AttributesEnum[] vals = null;
        ;
        private static final int firstIndex = 0;

        public int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        public static final int firstIndex() {
            return firstIndex;
        }

        public static int count() {
            return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;
        }

        public static final AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }


    public static final int TYPE = AttributesEnum.Type.index();
    public static final int INTERACTIONID = AttributesEnum.InteractionId.index();
    public static final int DIRECTION = AttributesEnum.Direction.index();
    public static final int STARTDATETIME = AttributesEnum.StartDatetime.index();
    public static final int ENDDATETIME = AttributesEnum.EndDatetime.index();
    public static final int DESCRIPTION = AttributesEnum.Description.index();
    public static final int RESOLUTION = AttributesEnum.Resolution.index();
    public static final int OPPURTUNITYID = AttributesEnum.OppurtunityId.index();
    public static final int CONTACTID = AttributesEnum.ContactId.index();
    public static final int INTERACTIONTEAMID = AttributesEnum.InteractionTeamId.index();
    public static final int OBJECTVERSIONNUMBER = AttributesEnum.ObjectVersionNumber.index();
    public static final int RELATEDOPPORTUNITY = AttributesEnum.RelatedOpportunity.index();
    public static final int CUSTOMERCONTACTSVIEW = AttributesEnum.CustomerContactsView.index();
    public static final int CONTACTINTERACTIONTEAMVO = AttributesEnum.ContactInteractionTeamVO.index();
    public static final int CONTACTVO = AttributesEnum.ContactVO.index();
    public static final int CONTACTINTTEAMVO = AttributesEnum.ContactIntTeamVO.index();
    public static final int OPPORTUNITIESVIEW1 = AttributesEnum.OpportunitiesView1.index();
    public static final int INTERACTIONSTYPELUVIEW1 = AttributesEnum.InteractionsTypeLuView1.index();
    public static final int INTERACTIONSDIRECTIONLUVIEW1 = AttributesEnum.InteractionsDirectionLuView1.index();

    /**
     * This is the default constructor (do not remove).
     */
    public ContactInteractionsVORowImpl() {
    }

    /**
     * Gets ContactInteractions entity object.
     * @return the ContactInteractions
     */
    public BaseEntityImpl getContactInteractions() {
        return (BaseEntityImpl) getEntity(ENTITY_CONTACTINTERACTIONS);
    }

    /**
     * Gets InteractionTeam entity object.
     * @return the InteractionTeam
     */
    public BaseEntityImpl getInteractionTeam() {
        return (BaseEntityImpl) getEntity(ENTITY_INTERACTIONTEAM);
    }

    /**
     * Gets the attribute value for TYPE using the alias name Type.
     * @return the TYPE
     */
    public String getType() {
        return (String) getAttributeInternal(TYPE);
    }

    /**
     * Sets <code>value</code> as attribute value for TYPE using the alias name Type.
     * @param value value to set the TYPE
     */
    public void setType(String value) {
        setAttributeInternal(TYPE, value);
    }

    /**
     * Gets the attribute value for INTERACTION_ID using the alias name InteractionId.
     * @return the INTERACTION_ID
     */
    public BigDecimal getInteractionId() {
        return (BigDecimal) getAttributeInternal(INTERACTIONID);
    }

    /**
     * Sets <code>value</code> as attribute value for INTERACTION_ID using the alias name InteractionId.
     * @param value value to set the INTERACTION_ID
     */
    public void setInteractionId(BigDecimal value) {
        setAttributeInternal(INTERACTIONID, value);
    }

    /**
     * Gets the attribute value for DIRECTION using the alias name Direction.
     * @return the DIRECTION
     */
    public String getDirection() {
        return (String) getAttributeInternal(DIRECTION);
    }

    /**
     * Sets <code>value</code> as attribute value for DIRECTION using the alias name Direction.
     * @param value value to set the DIRECTION
     */
    public void setDirection(String value) {
        setAttributeInternal(DIRECTION, value);
    }

    /**
     * Gets the attribute value for START_DATETIME using the alias name StartDatetime.
     * @return the START_DATETIME
     */
    public Timestamp getStartDatetime() {
        return (Timestamp) getAttributeInternal(STARTDATETIME);
    }

    /**
     * Sets <code>value</code> as attribute value for START_DATETIME using the alias name StartDatetime.
     * @param value value to set the START_DATETIME
     */
    public void setStartDatetime(Timestamp value) {
        setAttributeInternal(STARTDATETIME, value);
    }

    /**
     * Gets the attribute value for END_DATETIME using the alias name EndDatetime.
     * @return the END_DATETIME
     */
    public Timestamp getEndDatetime() {
        return (Timestamp) getAttributeInternal(ENDDATETIME);
    }

    /**
     * Sets <code>value</code> as attribute value for END_DATETIME using the alias name EndDatetime.
     * @param value value to set the END_DATETIME
     */
    public void setEndDatetime(Timestamp value) {
        setAttributeInternal(ENDDATETIME, value);
    }

    /**
     * Gets the attribute value for DESCRIPTION using the alias name Description.
     * @return the DESCRIPTION
     */
    public String getDescription() {
        return (String) getAttributeInternal(DESCRIPTION);
    }

    /**
     * Sets <code>value</code> as attribute value for DESCRIPTION using the alias name Description.
     * @param value value to set the DESCRIPTION
     */
    public void setDescription(String value) {
        setAttributeInternal(DESCRIPTION, value);
    }

    /**
     * Gets the attribute value for RESOLUTION using the alias name Resolution.
     * @return the RESOLUTION
     */
    public String getResolution() {
        return (String) getAttributeInternal(RESOLUTION);
    }

    /**
     * Sets <code>value</code> as attribute value for RESOLUTION using the alias name Resolution.
     * @param value value to set the RESOLUTION
     */
    public void setResolution(String value) {
        setAttributeInternal(RESOLUTION, value);
    }

    /**
     * Gets the attribute value for OPPURTUNITY_ID using the alias name OppurtunityId.
     * @return the OPPURTUNITY_ID
     */
    public BigDecimal getOppurtunityId() {
        return (BigDecimal) getAttributeInternal(OPPURTUNITYID);
    }

    /**
     * Sets <code>value</code> as attribute value for OPPURTUNITY_ID using the alias name OppurtunityId.
     * @param value value to set the OPPURTUNITY_ID
     */
    public void setOppurtunityId(BigDecimal value) {
        setAttributeInternal(OPPURTUNITYID, value);
    }

    /**
     * Gets the attribute value for CONTACT_ID using the alias name ContactId.
     * @return the CONTACT_ID
     */
    public BigDecimal getContactId() {
        return (BigDecimal) getAttributeInternal(CONTACTID);
    }

    /**
     * Sets <code>value</code> as attribute value for CONTACT_ID using the alias name ContactId.
     * @param value value to set the CONTACT_ID
     */
    public void setContactId(BigDecimal value) {
        setAttributeInternal(CONTACTID, value);
    }

    /**
     * Gets the attribute value for INTERACTION_TEAM_ID using the alias name InteractionTeamId.
     * @return the INTERACTION_TEAM_ID
     */
    public BigDecimal getInteractionTeamId() {
        return (BigDecimal) getAttributeInternal(INTERACTIONTEAMID);
    }

    /**
     * Sets <code>value</code> as attribute value for INTERACTION_TEAM_ID using the alias name InteractionTeamId.
     * @param value value to set the INTERACTION_TEAM_ID
     */
    public void setInteractionTeamId(BigDecimal value) {
        setAttributeInternal(INTERACTIONTEAMID, value);
    }

    /**
     * Gets the attribute value for OBJECT_VERSION_NUMBER using the alias name ObjectVersionNumber.
     * @return the OBJECT_VERSION_NUMBER
     */
    public Integer getObjectVersionNumber() {
        return (Integer) getAttributeInternal(OBJECTVERSIONNUMBER);
    }

    /**
     * Sets <code>value</code> as attribute value for OBJECT_VERSION_NUMBER using the alias name ObjectVersionNumber.
     * @param value value to set the OBJECT_VERSION_NUMBER
     */
    public void setObjectVersionNumber(Integer value) {
        setAttributeInternal(OBJECTVERSIONNUMBER, value);
    }

    /**
     * Gets the attribute value for the calculated attribute RelatedOpportunity.
     * @return the RelatedOpportunity
     */
    public String getRelatedOpportunity() {
        Object oppId = getAttributeInternal(OPPURTUNITYID);
        String oppName = null;
        if(oppId != null) {
            Object[] obj = {oppId};
            Key key = new Key(obj);
            
            Row[] rows = getOpportunitiesView1().findByKey(key, 1);
            if(rows !=null && rows.length > 0) {
                oppName = (String)rows[0].getAttribute("OpportunityName");
            }
                       
        }
            
        
        return oppName;
        
        
        //return (String) getAttributeInternal(RELATEDOPPORTUNITY);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute RelatedOpportunity.
     * @param value value to set the  RelatedOpportunity
     */
    public void setRelatedOpportunity(String value) {
        setAttributeInternal(RELATEDOPPORTUNITY, value);
    }

    /**
     * Gets the associated <code>Row</code> using master-detail link CustomerContactsView.
     */
    public Row getCustomerContactsView() {
        return (Row) getAttributeInternal(CUSTOMERCONTACTSVIEW);
    }

    /**
     * Sets the master-detail link CustomerContactsView between this object and <code>value</code>.
     */
    public void setCustomerContactsView(Row value) {
        setAttributeInternal(CUSTOMERCONTACTSVIEW, value);
    }

    /**
     * Gets the associated <code>RowIterator</code> using master-detail link ContactInteractionTeamVO.
     */
    public RowIterator getContactInteractionTeamVO() {
        return (RowIterator) getAttributeInternal(CONTACTINTERACTIONTEAMVO);
    }

    /**
     * Gets the associated <code>Row</code> using master-detail link ContactVO.
     */
    public Row getContactVO() {
        return (Row) getAttributeInternal(CONTACTVO);
    }

    /**
     * Sets the master-detail link ContactVO between this object and <code>value</code>.
     */
    public void setContactVO(Row value) {
        setAttributeInternal(CONTACTVO, value);
    }

    /**
     * Gets the associated <code>RowIterator</code> using master-detail link ContactIntTeamVO.
     */
    public RowIterator getContactIntTeamVO() {
        return (RowIterator) getAttributeInternal(CONTACTINTTEAMVO);
    }

    /**
     * Gets the view accessor <code>RowSet</code> OpportunitiesView1.
     */
    public RowSet getOpportunitiesView1() {
        return (RowSet) getAttributeInternal(OPPORTUNITIESVIEW1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> InteractionsTypeLuView1.
     */
    public RowSet getInteractionsTypeLuView1() {
        return (RowSet) getAttributeInternal(INTERACTIONSTYPELUVIEW1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> InteractionsDirectionLuView1.
     */
    public RowSet getInteractionsDirectionLuView1() {
        return (RowSet) getAttributeInternal(INTERACTIONSDIRECTIONLUVIEW1);
    }
}

