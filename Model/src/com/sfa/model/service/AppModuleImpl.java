package com.sfa.model.service;

import com.sfa.model.service.common.AppModule;

import oracle.jbo.Row;
import oracle.jbo.domain.BlobDomain;
import oracle.jbo.server.ApplicationModuleImpl;
import oracle.jbo.server.ViewLinkImpl;
import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sat Mar 08 17:48:31 IST 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class AppModuleImpl extends ApplicationModuleImpl implements AppModule {
    /**
     * This is the default constructor (do not remove).
     */
    public AppModuleImpl() {
    }

    /**
     * Container's getter for AppointmentInviteesView1.
     * @return AppointmentInviteesView1
     */
    public ViewObjectImpl getAppointmentInviteesView1() {
        return (ViewObjectImpl) findViewObject("AppointmentInviteesView1");
    }

    /**
     * Container's getter for AppointmentsView1.
     * @return AppointmentsView1
     */
    public ViewObjectImpl getAppointmentsView1() {
        return (ViewObjectImpl) findViewObject("AppointmentsView1");
    }

    /**
     * Container's getter for ContactInteractionsView1.
     * @return ContactInteractionsView1
     */
    public ViewObjectImpl getContactInteractionsView1() {
        return (ViewObjectImpl) findViewObject("ContactInteractionsView1");
    }

    /**
     * Container's getter for CustomerAccountView1.
     * @return CustomerAccountView1
     */
    public ViewObjectImpl getCustomerAccountView1() {
        return (ViewObjectImpl) findViewObject("CustomerAccountView1");
    }

    /**
     * Container's getter for CustomerContactsView1.
     * @return CustomerContactsView1
     */
    public ViewObjectImpl getCustomerContactsView1() {
        return (ViewObjectImpl) findViewObject("CustomerContactsView1");
    }

    /**
     * Container's getter for InteractionTeamView1.
     * @return InteractionTeamView1
     */
    public ViewObjectImpl getInteractionTeamView1() {
        return (ViewObjectImpl) findViewObject("InteractionTeamView1");
    }

    /**
     * Container's getter for NotesParentView1.
     * @return NotesParentView1
     */
    public ViewObjectImpl getNotesParentView1() {
        return (ViewObjectImpl) findViewObject("NotesParentView1");
    }

    /**
     * Container's getter for NotesView1.
     * @return NotesView1
     */
    public ViewObjectImpl getNotesView1() {
        return (ViewObjectImpl) findViewObject("NotesView1");
    }

    /**
     * Container's getter for OpportunitiesView1.
     * @return OpportunitiesView1
     */
    public ViewObjectImpl getOpportunitiesView1() {
        return (ViewObjectImpl) findViewObject("OpportunitiesView1");
    }

    /**
     * Container's getter for OpportunityAttachmentsView1.
     * @return OpportunityAttachmentsView1
     */
    public ViewObjectImpl getOpportunityAttachmentsView1() {
        return (ViewObjectImpl) findViewObject("OpportunityAttachmentsView1");
    }

    /**
     * Container's getter for OpportunityRevenueItemsView1.
     * @return OpportunityRevenueItemsView1
     */
    public ViewObjectImpl getOpportunityRevenueItemsView1() {
        return (ViewObjectImpl) findViewObject("OpportunityRevenueItemsView1");
    }

    /**
     * Container's getter for OpportunityTeamView1.
     * @return OpportunityTeamView1
     */
    public ViewObjectImpl getOpportunityTeamView1() {
        return (ViewObjectImpl) findViewObject("OpportunityTeamView1");
    }

    /**
     * Container's getter for ProductCatalogView1.
     * @return ProductCatalogView1
     */
    public ViewObjectImpl getProductCatalogView1() {
        return (ViewObjectImpl) findViewObject("ProductCatalogView1");
    }

    /**
     * Container's getter for RoleAssignmentView1.
     * @return RoleAssignmentView1
     */
    public ViewObjectImpl getRoleAssignmentView1() {
        return (ViewObjectImpl) findViewObject("RoleAssignmentView1");
    }

    /**
     * Container's getter for RolesView1.
     * @return RolesView1
     */
    public ViewObjectImpl getRolesView1() {
        return (ViewObjectImpl) findViewObject("RolesView1");
    }

    /**
     * Container's getter for TaskTeamView1.
     * @return TaskTeamView1
     */
    public ViewObjectImpl getTaskTeamView1() {
        return (ViewObjectImpl) findViewObject("TaskTeamView1");
    }

    /**
     * Container's getter for TasksView1.
     * @return TasksView1
     */
    public ViewObjectImpl getTasksView1() {
        return (ViewObjectImpl) findViewObject("TasksView1");
    }

    /**
     * Container's getter for UsersView1.
     * @return UsersView1
     */
    public ViewObjectImpl getUsersView1() {
        return (ViewObjectImpl) findViewObject("UsersView1");
    }

    /**
     * Container's getter for BooleanLuView1.
     * @return BooleanLuView1
     */
    public ViewObjectImpl getBooleanLuView1() {
        return (ViewObjectImpl) findViewObject("BooleanLuView1");
    }

    /**
     * Container's getter for ContactBuyingroleLuView1.
     * @return ContactBuyingroleLuView1
     */
    public ViewObjectImpl getContactBuyingroleLuView1() {
        return (ViewObjectImpl) findViewObject("ContactBuyingroleLuView1");
    }

    /**
     * Container's getter for InteractionsDirectionLuView1.
     * @return InteractionsDirectionLuView1
     */
    public ViewObjectImpl getInteractionsDirectionLuView1() {
        return (ViewObjectImpl) findViewObject("InteractionsDirectionLuView1");
    }

    /**
     * Container's getter for InteractionsTypeLuView1.
     * @return InteractionsTypeLuView1
     */
    public ViewObjectImpl getInteractionsTypeLuView1() {
        return (ViewObjectImpl) findViewObject("InteractionsTypeLuView1");
    }

    /**
     * Container's getter for OpportunityDecisionlevelLuView1.
     * @return OpportunityDecisionlevelLuView1
     */
    public ViewObjectImpl getOpportunityDecisionlevelLuView1() {
        return (ViewObjectImpl) findViewObject("OpportunityDecisionlevelLuView1");
    }

    /**
     * Container's getter for OpportunityRisklevelLuView1.
     * @return OpportunityRisklevelLuView1
     */
    public ViewObjectImpl getOpportunityRisklevelLuView1() {
        return (ViewObjectImpl) findViewObject("OpportunityRisklevelLuView1");
    }

    /**
     * Container's getter for OpportunitySaleschannelLuView1.
     * @return OpportunitySaleschannelLuView1
     */
    public ViewObjectImpl getOpportunitySaleschannelLuView1() {
        return (ViewObjectImpl) findViewObject("OpportunitySaleschannelLuView1");
    }

    /**
     * Container's getter for OpportunitySalesmethodLuView1.
     * @return OpportunitySalesmethodLuView1
     */
    public ViewObjectImpl getOpportunitySalesmethodLuView1() {
        return (ViewObjectImpl) findViewObject("OpportunitySalesmethodLuView1");
    }

    /**
     * Container's getter for OpportunitySalestageLuView1.
     * @return OpportunitySalestageLuView1
     */
    public ViewObjectImpl getOpportunitySalestageLuView1() {
        return (ViewObjectImpl) findViewObject("OpportunitySalestageLuView1");
    }

    /**
     * Container's getter for ProductCategoryLuView1.
     * @return ProductCategoryLuView1
     */
    public ViewObjectImpl getProductCategoryLuView1() {
        return (ViewObjectImpl) findViewObject("ProductCategoryLuView1");
    }

    /**
     * Container's getter for TaskPriorityLuView1.
     * @return TaskPriorityLuView1
     */
    public ViewObjectImpl getTaskPriorityLuView1() {
        return (ViewObjectImpl) findViewObject("TaskPriorityLuView1");
    }

    /**
     * Container's getter for AppointmentInviteesView2.
     * @return AppointmentInviteesView2
     */
    public ViewObjectImpl getAppointmentInviteesView2() {
        return (ViewObjectImpl) findViewObject("AppointmentInviteesView2");
    }

    /**
     * Container's getter for AppointmentsView2.
     * @return AppointmentsView2
     */
    public ViewObjectImpl getAppointmentsView2() {
        return (ViewObjectImpl) findViewObject("AppointmentsView2");
    }

    /**
     * Container's getter for CustomerAccountView2.
     * @return CustomerAccountView2
     */
    public ViewObjectImpl getCustomerAccountView2() {
        return (ViewObjectImpl) findViewObject("CustomerAccountView2");
    }

    /**
     * Container's getter for AppointmentInviteesView3.
     * @return AppointmentInviteesView3
     */
    public ViewObjectImpl getAppointmentInviteesView3() {
        return (ViewObjectImpl) findViewObject("AppointmentInviteesView3");
    }

    /**
     * Container's getter for CustomerContactsView2.
     * @return CustomerContactsView2
     */
    public ViewObjectImpl getCustomerContactsView2() {
        return (ViewObjectImpl) findViewObject("CustomerContactsView2");
    }

    /**
     * Container's getter for InteractionTeamView2.
     * @return InteractionTeamView2
     */
    public ViewObjectImpl getInteractionTeamView2() {
        return (ViewObjectImpl) findViewObject("InteractionTeamView2");
    }

    /**
     * Container's getter for InteractionTeamView3.
     * @return InteractionTeamView3
     */
    public ViewObjectImpl getInteractionTeamView3() {
        return (ViewObjectImpl) findViewObject("InteractionTeamView3");
    }

    /**
     * Container's getter for NotesParentView2.
     * @return NotesParentView2
     */
    public ViewObjectImpl getNotesParentView2() {
        return (ViewObjectImpl) findViewObject("NotesParentView2");
    }

    /**
     * Container's getter for AppointmentsView3.
     * @return AppointmentsView3
     */
    public ViewObjectImpl getAppointmentsView3() {
        return (ViewObjectImpl) findViewObject("AppointmentsView3");
    }

    /**
     * Container's getter for ContactInteractionsView2.
     * @return ContactInteractionsView2
     */
    public ViewObjectImpl getContactInteractionsView2() {
        return (ViewObjectImpl) findViewObject("ContactInteractionsView2");
    }

    /**
     * Container's getter for OpportunitiesView2.
     * @return OpportunitiesView2
     */
    public ViewObjectImpl getOpportunitiesView2() {
        return (ViewObjectImpl) findViewObject("OpportunitiesView2");
    }

    /**
     * Container's getter for OpportunitiesView3.
     * @return OpportunitiesView3
     */
    public ViewObjectImpl getOpportunitiesView3() {
        return (ViewObjectImpl) findViewObject("OpportunitiesView3");
    }

    /**
     * Container's getter for OpportunityAttachmentsView2.
     * @return OpportunityAttachmentsView2
     */
    public ViewObjectImpl getOpportunityAttachmentsView2() {
        return (ViewObjectImpl) findViewObject("OpportunityAttachmentsView2");
    }

    /**
     * Container's getter for OpportunityRevenueItemsView2.
     * @return OpportunityRevenueItemsView2
     */
    public ViewObjectImpl getOpportunityRevenueItemsView2() {
        return (ViewObjectImpl) findViewObject("OpportunityRevenueItemsView2");
    }

    /**
     * Container's getter for OpportunityTeamView2.
     * @return OpportunityTeamView2
     */
    public ViewObjectImpl getOpportunityTeamView2() {
        return (ViewObjectImpl) findViewObject("OpportunityTeamView2");
    }

    /**
     * Container's getter for OpportunityTeamView3.
     * @return OpportunityTeamView3
     */
    public ViewObjectImpl getOpportunityTeamView3() {
        return (ViewObjectImpl) findViewObject("OpportunityTeamView3");
    }

    /**
     * Container's getter for OpportunityRevenueItemsView3.
     * @return OpportunityRevenueItemsView3
     */
    public ViewObjectImpl getOpportunityRevenueItemsView3() {
        return (ViewObjectImpl) findViewObject("OpportunityRevenueItemsView3");
    }

    /**
     * Container's getter for RoleAssignmentView2.
     * @return RoleAssignmentView2
     */
    public ViewObjectImpl getRoleAssignmentView2() {
        return (ViewObjectImpl) findViewObject("RoleAssignmentView2");
    }

    /**
     * Container's getter for TasksView2.
     * @return TasksView2
     */
    public ViewObjectImpl getTasksView2() {
        return (ViewObjectImpl) findViewObject("TasksView2");
    }

    /**
     * Container's getter for TasksView3.
     * @return TasksView3
     */
    public ViewObjectImpl getTasksView3() {
        return (ViewObjectImpl) findViewObject("TasksView3");
    }

    /**
     * Container's getter for TaskTeamView2.
     * @return TaskTeamView2
     */
    public ViewObjectImpl getTaskTeamView2() {
        return (ViewObjectImpl) findViewObject("TaskTeamView2");
    }

    /**
     * Container's getter for TaskTeamView3.
     * @return TaskTeamView3
     */
    public ViewObjectImpl getTaskTeamView3() {
        return (ViewObjectImpl) findViewObject("TaskTeamView3");
    }

    /**
     * Container's getter for InteractionTeamView4.
     * @return InteractionTeamView4
     */
    public ViewObjectImpl getInteractionTeamView4() {
        return (ViewObjectImpl) findViewObject("InteractionTeamView4");
    }

    /**
     * Container's getter for TasksView4.
     * @return TasksView4
     */
    public ViewObjectImpl getTasksView4() {
        return (ViewObjectImpl) findViewObject("TasksView4");
    }

    /**
     * Container's getter for AppointmentInviteesView4.
     * @return AppointmentInviteesView4
     */
    public ViewObjectImpl getAppointmentInviteesView4() {
        return (ViewObjectImpl) findViewObject("AppointmentInviteesView4");
    }

    /**
     * Container's getter for RoleAssignmentView3.
     * @return RoleAssignmentView3
     */
    public ViewObjectImpl getRoleAssignmentView3() {
        return (ViewObjectImpl) findViewObject("RoleAssignmentView3");
    }

    /**
     * Container's getter for TaskTeamView4.
     * @return TaskTeamView4
     */
    public ViewObjectImpl getTaskTeamView4() {
        return (ViewObjectImpl) findViewObject("TaskTeamView4");
    }

    /**
     * Container's getter for OpportunityTeamView4.
     * @return OpportunityTeamView4
     */
    public ViewObjectImpl getOpportunityTeamView4() {
        return (ViewObjectImpl) findViewObject("OpportunityTeamView4");
    }

    /**
     * Container's getter for CustomerSearchVO1.
     * @return CustomerSearchVO1
     */
    public ViewObjectImpl getCustomerSearchVO1() {
        return (ViewObjectImpl) findViewObject("CustomerSearchVO1");
    }

    /**
     * Container's getter for ContactVO1.
     * @return ContactVO1
     */
    public ViewObjectImpl getContactVO1() {
        return (ViewObjectImpl) findViewObject("ContactVO1");
    }

    /**
     * Container's getter for AppointmentInviteesVO1.
     * @return AppointmentInviteesVO1
     */
    public ViewObjectImpl getAppointmentInviteesVO1() {
        return (ViewObjectImpl) findViewObject("AppointmentInviteesVO1");
    }

    /**
     * Container's getter for AppointmentsView4.
     * @return AppointmentsView4
     */
    public ViewObjectImpl getAppointmentsView4() {
        return (ViewObjectImpl) findViewObject("AppointmentsView4");
    }

    /**
     * Container's getter for AppointmentInviteesVO2.
     * @return AppointmentInviteesVO2
     */
    public ViewObjectImpl getAppointmentInviteesVO2() {
        return (ViewObjectImpl) findViewObject("AppointmentInviteesVO2");
    }

    /**
     * Container's getter for AppointmentInviteesVO3.
     * @return AppointmentInviteesVO3
     */
    public ViewObjectImpl getAppointmentInviteesVO3() {
        return (ViewObjectImpl) findViewObject("AppointmentInviteesVO3");
    }

    /**
     * Container's getter for ProductCategoryView1.
     * @return ProductCategoryView1
     */
    public ViewObjectImpl getProductCategoryView1() {
        return (ViewObjectImpl) findViewObject("ProductCategoryView1");
    }

    /**
     * Container's getter for ValidRolesView1.
     * @return ValidRolesView1
     */
    public ViewObjectImpl getValidRolesView1() {
        return (ViewObjectImpl) findViewObject("ValidRolesView1");
    }

    /**
     * Container's getter for PrimaryContactExistsVO1.
     * @return PrimaryContactExistsVO1
     */
    public ViewObjectImpl getPrimaryContactExistsVO1() {
        return (ViewObjectImpl) findViewObject("PrimaryContactExistsVO1");
    }

    /**
     * Container's getter for AppointmentInvUsersVO1.
     * @return AppointmentInvUsersVO1
     */
    public ViewObjectImpl getAppointmentInvUsersVO1() {
        return (ViewObjectImpl) findViewObject("AppointmentInvUsersVO1");
    }

    /**
     * Container's getter for OpportunityNotes2.
     * @return OpportunityNotes2
     */
    public ViewObjectImpl getOpportunityNotes2() {
        return (ViewObjectImpl) findViewObject("OpportunityNotes2");
    }

    /**
     * Container's getter for AppointmentInvContactsVO1.
     * @return AppointmentInvContactsVO1
     */
    public ViewObjectImpl getAppointmentInvContactsVO1() {
        return (ViewObjectImpl) findViewObject("AppointmentInvContactsVO1");
    }

    /**
     * Container's getter for OpportunitytaskView2.
     * @return OpportunitytaskView2
     */
    public ViewObjectImpl getOpportunitytaskView2() {
        return (ViewObjectImpl) findViewObject("OpportunitytaskView2");
    }

    /**
     * Container's getter for NotesVO1.
     * @return NotesVO1
     */
    public ViewObjectImpl getNotesVO1() {
        return (ViewObjectImpl) findViewObject("NotesVO1");
    }

    /**
     * Container's getter for OpportunityAppointmentView2.
     * @return OpportunityAppointmentView2
     */
    public ViewObjectImpl getOpportunityAppointmentView2() {
        return (ViewObjectImpl) findViewObject("OpportunityAppointmentView2");
    }

    /**
     * Container's getter for AllUsersVO1.
     * @return AllUsersVO1
     */
    public ViewObjectImpl getAllUsersVO1() {
        return (ViewObjectImpl) findViewObject("AllUsersVO1");
    }

    /**
     * Container's getter for AppointmentInviteesVO4.
     * @return AppointmentInviteesVO4
     */
    public ViewObjectImpl getAppointmentInviteesVO4() {
        return (ViewObjectImpl) findViewObject("AppointmentInviteesVO4");
    }

    /**
     * Container's getter for TaskTeamVO1.
     * @return TaskTeamVO1
     */
    public ViewObjectImpl getTaskTeamVO1() {
        return (ViewObjectImpl) findViewObject("TaskTeamVO1");
    }

    /**
     * Container's getter for CustomerContactsView4.
     * @return CustomerContactsView4
     */
    public ViewObjectImpl getCustomerContactsView4() {
        return (ViewObjectImpl) findViewObject("CustomerContactsView4");
    }

    /**
     * Container's getter for RelatedContacts1.
     * @return RelatedContacts1
     */
    public ViewObjectImpl getRelatedContacts1() {
        return (ViewObjectImpl) findViewObject("RelatedContacts1");
    }

    /**
     * Container's getter for InteractionTeamView5.
     * @return InteractionTeamView5
     */
    public ViewObjectImpl getInteractionTeamView5() {
        return (ViewObjectImpl) findViewObject("InteractionTeamView5");
    }

    /**
     * Container's getter for ContactsInAccountVO1.
     * @return ContactsInAccountVO1
     */
    public ViewObjectImpl getContactsInAccountVO1() {
        return (ViewObjectImpl) findViewObject("ContactsInAccountVO1");
    }

    /**
     * Container's getter for TaskTeamView6.
     * @return TaskTeamView6
     */
    public ViewObjectImpl getTaskTeamView6() {
        return (ViewObjectImpl) findViewObject("TaskTeamView6");
    }

    /**
     * Container's getter for ContactInteractionsVO1.
     * @return ContactInteractionsVO1
     */
    public ViewObjectImpl getContactInteractionsVO1() {
        return (ViewObjectImpl) findViewObject("ContactInteractionsVO1");
    }

    /**
     * Container's getter for ContactTasksVO1.
     * @return ContactTasksVO1
     */
    public ViewObjectImpl getContactTasksVO1() {
        return (ViewObjectImpl) findViewObject("ContactTasksVO1");
    }

    /**
     * Container's getter for ContactAppointmentsVO1.
     * @return ContactAppointmentsVO1
     */
    public ViewObjectImpl getContactAppointmentsVO1() {
        return (ViewObjectImpl) findViewObject("ContactAppointmentsVO1");
    }

    /**
     * Container's getter for ContactOpportunitiesVO1.
     * @return ContactOpportunitiesVO1
     */
    public ViewObjectImpl getContactOpportunitiesVO1() {
        return (ViewObjectImpl) findViewObject("ContactOpportunitiesVO1");
    }

    /**
     * Container's getter for AppointmentInviteesFk1Link1.
     * @return AppointmentInviteesFk1Link1
     */
    public ViewLinkImpl getAppointmentInviteesFk1Link1() {
        return (ViewLinkImpl) findViewLink("AppointmentInviteesFk1Link1");
    }

    /**
     * Container's getter for AppointmentsFk1Link1.
     * @return AppointmentsFk1Link1
     */
    public ViewLinkImpl getAppointmentsFk1Link1() {
        return (ViewLinkImpl) findViewLink("AppointmentsFk1Link1");
    }

    /**
     * Container's getter for CustomerAccountFk1Link1.
     * @return CustomerAccountFk1Link1
     */
    public ViewLinkImpl getCustomerAccountFk1Link1() {
        return (ViewLinkImpl) findViewLink("CustomerAccountFk1Link1");
    }

    /**
     * Container's getter for AppointmentInviteesFk2Link1.
     * @return AppointmentInviteesFk2Link1
     */
    public ViewLinkImpl getAppointmentInviteesFk2Link1() {
        return (ViewLinkImpl) findViewLink("AppointmentInviteesFk2Link1");
    }

    /**
     * Container's getter for CustomerContactsFk1Link1.
     * @return CustomerContactsFk1Link1
     */
    public ViewLinkImpl getCustomerContactsFk1Link1() {
        return (ViewLinkImpl) findViewLink("CustomerContactsFk1Link1");
    }

    /**
     * Container's getter for InteractionTeamFk1Link1.
     * @return InteractionTeamFk1Link1
     */
    public ViewLinkImpl getInteractionTeamFk1Link1() {
        return (ViewLinkImpl) findViewLink("InteractionTeamFk1Link1");
    }

    /**
     * Container's getter for InteractionTeamFk3Link1.
     * @return InteractionTeamFk3Link1
     */
    public ViewLinkImpl getInteractionTeamFk3Link1() {
        return (ViewLinkImpl) findViewLink("InteractionTeamFk3Link1");
    }

    /**
     * Container's getter for NotesParentFk1Link1.
     * @return NotesParentFk1Link1
     */
    public ViewLinkImpl getNotesParentFk1Link1() {
        return (ViewLinkImpl) findViewLink("NotesParentFk1Link1");
    }

    /**
     * Container's getter for AppointmentsFk2Link1.
     * @return AppointmentsFk2Link1
     */
    public ViewLinkImpl getAppointmentsFk2Link1() {
        return (ViewLinkImpl) findViewLink("AppointmentsFk2Link1");
    }

    /**
     * Container's getter for ContactInteractionsFk1Link1.
     * @return ContactInteractionsFk1Link1
     */
    public ViewLinkImpl getContactInteractionsFk1Link1() {
        return (ViewLinkImpl) findViewLink("ContactInteractionsFk1Link1");
    }

    /**
     * Container's getter for OppurtunitiesFk1Link1.
     * @return OppurtunitiesFk1Link1
     */
    public ViewLinkImpl getOppurtunitiesFk1Link1() {
        return (ViewLinkImpl) findViewLink("OppurtunitiesFk1Link1");
    }

    /**
     * Container's getter for OppurtunitiesFk2Link1.
     * @return OppurtunitiesFk2Link1
     */
    public ViewLinkImpl getOppurtunitiesFk2Link1() {
        return (ViewLinkImpl) findViewLink("OppurtunitiesFk2Link1");
    }

    /**
     * Container's getter for OppurtunityDocumentsFk1Link1.
     * @return OppurtunityDocumentsFk1Link1
     */
    public ViewLinkImpl getOppurtunityDocumentsFk1Link1() {
        return (ViewLinkImpl) findViewLink("OppurtunityDocumentsFk1Link1");
    }

    /**
     * Container's getter for OppurtunityRevenueItemsFk2Link1.
     * @return OppurtunityRevenueItemsFk2Link1
     */
    public ViewLinkImpl getOppurtunityRevenueItemsFk2Link1() {
        return (ViewLinkImpl) findViewLink("OppurtunityRevenueItemsFk2Link1");
    }

    /**
     * Container's getter for OppurtunityTeamFk1Link1.
     * @return OppurtunityTeamFk1Link1
     */
    public ViewLinkImpl getOppurtunityTeamFk1Link1() {
        return (ViewLinkImpl) findViewLink("OppurtunityTeamFk1Link1");
    }

    /**
     * Container's getter for OppurtunityTeamFk2Link1.
     * @return OppurtunityTeamFk2Link1
     */
    public ViewLinkImpl getOppurtunityTeamFk2Link1() {
        return (ViewLinkImpl) findViewLink("OppurtunityTeamFk2Link1");
    }

    /**
     * Container's getter for OppurtunityRevenueItemsFk1Link1.
     * @return OppurtunityRevenueItemsFk1Link1
     */
    public ViewLinkImpl getOppurtunityRevenueItemsFk1Link1() {
        return (ViewLinkImpl) findViewLink("OppurtunityRevenueItemsFk1Link1");
    }

    /**
     * Container's getter for UserRolesFk2Link1.
     * @return UserRolesFk2Link1
     */
    public ViewLinkImpl getUserRolesFk2Link1() {
        return (ViewLinkImpl) findViewLink("UserRolesFk2Link1");
    }

    /**
     * Container's getter for TasksFk2Link1.
     * @return TasksFk2Link1
     */
    public ViewLinkImpl getTasksFk2Link1() {
        return (ViewLinkImpl) findViewLink("TasksFk2Link1");
    }

    /**
     * Container's getter for TasksFk3Link1.
     * @return TasksFk3Link1
     */
    public ViewLinkImpl getTasksFk3Link1() {
        return (ViewLinkImpl) findViewLink("TasksFk3Link1");
    }

    /**
     * Container's getter for TaskTeamFk1Link1.
     * @return TaskTeamFk1Link1
     */
    public ViewLinkImpl getTaskTeamFk1Link1() {
        return (ViewLinkImpl) findViewLink("TaskTeamFk1Link1");
    }

    /**
     * Container's getter for TaskTeamFk2Link1.
     * @return TaskTeamFk2Link1
     */
    public ViewLinkImpl getTaskTeamFk2Link1() {
        return (ViewLinkImpl) findViewLink("TaskTeamFk2Link1");
    }

    /**
     * Container's getter for InteractionTeamFk2Link1.
     * @return InteractionTeamFk2Link1
     */
    public ViewLinkImpl getInteractionTeamFk2Link1() {
        return (ViewLinkImpl) findViewLink("InteractionTeamFk2Link1");
    }

    /**
     * Container's getter for TasksFk1Link1.
     * @return TasksFk1Link1
     */
    public ViewLinkImpl getTasksFk1Link1() {
        return (ViewLinkImpl) findViewLink("TasksFk1Link1");
    }

    /**
     * Container's getter for AppointmentInviteesFk3Link1.
     * @return AppointmentInviteesFk3Link1
     */
    public ViewLinkImpl getAppointmentInviteesFk3Link1() {
        return (ViewLinkImpl) findViewLink("AppointmentInviteesFk3Link1");
    }

    /**
     * Container's getter for UserRolesFk1Link1.
     * @return UserRolesFk1Link1
     */
    public ViewLinkImpl getUserRolesFk1Link1() {
        return (ViewLinkImpl) findViewLink("UserRolesFk1Link1");
    }

    /**
     * Container's getter for TaskTeamFk3Link1.
     * @return TaskTeamFk3Link1
     */
    public ViewLinkImpl getTaskTeamFk3Link1() {
        return (ViewLinkImpl) findViewLink("TaskTeamFk3Link1");
    }

    /**
     * Container's getter for OppurtunityTeamFk3Link1.
     * @return OppurtunityTeamFk3Link1
     */
    public ViewLinkImpl getOppurtunityTeamFk3Link1() {
        return (ViewLinkImpl) findViewLink("OppurtunityTeamFk3Link1");
    }

    /**
     * Container's getter for AppointmentInviteeVL1.
     * @return AppointmentInviteeVL1
     */
    public ViewLinkImpl getAppointmentInviteeVL1() {
        return (ViewLinkImpl) findViewLink("AppointmentInviteeVL1");
    }

    /**
     * Container's getter for AppointmentInvUsers1.
     * @return AppointmentInvUsers1
     */
    public ViewLinkImpl getAppointmentInvUsers1() {
        return (ViewLinkImpl) findViewLink("AppointmentInvUsers1");
    }

    /**
     * Container's getter for noteOpportunityViewLink1.
     * @return noteOpportunityViewLink1
     */
    public ViewLinkImpl getnoteOpportunityViewLink1() {
        return (ViewLinkImpl) findViewLink("noteOpportunityViewLink1");
    }

    /**
     * Container's getter for AppointmentInvContactsVL1.
     * @return AppointmentInvContactsVL1
     */
    public ViewLinkImpl getAppointmentInvContactsVL1() {
        return (ViewLinkImpl) findViewLink("AppointmentInvContactsVL1");
    }

    /**
     * Container's getter for OpportunityTaskLink1.
     * @return OpportunityTaskLink1
     */
    public ViewLinkImpl getOpportunityTaskLink1() {
        return (ViewLinkImpl) findViewLink("OpportunityTaskLink1");
    }

    /**
     * Container's getter for AccountNotesVL1.
     * @return AccountNotesVL1
     */
    public ViewLinkImpl getAccountNotesVL1() {
        return (ViewLinkImpl) findViewLink("AccountNotesVL1");
    }

    /**
     * Container's getter for OpportunityAppointmentLink1.
     * @return OpportunityAppointmentLink1
     */
    public ViewLinkImpl getOpportunityAppointmentLink1() {
        return (ViewLinkImpl) findViewLink("OpportunityAppointmentLink1");
    }

    /**
     * Container's getter for TaskTeamVL1.
     * @return TaskTeamVL1
     */
    public ViewLinkImpl getTaskTeamVL1() {
        return (ViewLinkImpl) findViewLink("TaskTeamVL1");
    }

    /**
     * Container's getter for OppAppointmntInviteeViewLink1.
     * @return OppAppointmntInviteeViewLink1
     */
    public ViewLinkImpl getOppAppointmntInviteeViewLink1() {
        return (ViewLinkImpl) findViewLink("OppAppointmntInviteeViewLink1");
    }

    /**
     * Container's getter for RelatedContactsVL1.
     * @return RelatedContactsVL1
     */
    public ViewLinkImpl getRelatedContactsVL1() {
        return (ViewLinkImpl) findViewLink("RelatedContactsVL1");
    }

    /**
     * Container's getter for OpportunityContactsView1.
     * @return OpportunityContactsView1
     */
    public ViewLinkImpl getOpportunityContactsView1() {
        return (ViewLinkImpl) findViewLink("OpportunityContactsView1");
    }

    /**
     * Container's getter for ContactInteractionsVL1.
     * @return ContactInteractionsVL1
     */
    public ViewLinkImpl getContactInteractionsVL1() {
        return (ViewLinkImpl) findViewLink("ContactInteractionsVL1");
    }

    /**
     * Container's getter for InteractionTeamFk3Link2.
     * @return InteractionTeamFk3Link2
     */
    public ViewLinkImpl getInteractionTeamFk3Link2() {
        return (ViewLinkImpl) findViewLink("InteractionTeamFk3Link2");
    }

    /**
     * Container's getter for ContactTasksVL1.
     * @return ContactTasksVL1
     */
    public ViewLinkImpl getContactTasksVL1() {
        return (ViewLinkImpl) findViewLink("ContactTasksVL1");
    }

    /**
     * Container's getter for OpportunityTaskTeamViewLink1.
     * @return OpportunityTaskTeamViewLink1
     */
    public ViewLinkImpl getOpportunityTaskTeamViewLink1() {
        return (ViewLinkImpl) findViewLink("OpportunityTaskTeamViewLink1");
    }

    public void uploadFiletoDB(String fileName, String contentType, BlobDomain blob) {
        System.out.println("am");
        ViewObjectImpl vo = this.getOpportunityAttachmentsView2();
        try {
            Row row = vo.createRow();
            row.setAttribute("DocumentName", fileName);
            row.setAttribute("DocumentType", contentType);
            row.setAttribute("Document", blob);
            vo.insertRow(row);
            this.getDBTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Container's getter for ContactAppointmentsVL1.
     * @return ContactAppointmentsVL1
     */
    public ViewLinkImpl getContactAppointmentsVL1() {
        return (ViewLinkImpl) findViewLink("ContactAppointmentsVL1");
    }


    /**
     * Container's getter for SalesHomeOppoView1.
     * @return SalesHomeOppoView1
     */
    public ViewObjectImpl getSalesHomeOppoView1() {
        return (ViewObjectImpl) findViewObject("SalesHomeOppoView1");
    }

    /**
     * Container's getter for SalesRepOppoCreatedView1.
     * @return SalesRepOppoCreatedView1
     */
    public ViewObjectImpl getSalesRepOppoCreatedView1() {
        return (ViewObjectImpl) findViewObject("SalesRepOppoCreatedView1");
    }


    /**
     * Container's getter for ContactOpportunitiesVL1.
     * @return ContactOpportunitiesVL1
     */
    public ViewLinkImpl getContactOpportunitiesVL1() {
        return (ViewLinkImpl) findViewLink("ContactOpportunitiesVL1");
    }

    /**
     * Container's getter for ContactInteractionTeamVO1.
     * @return ContactInteractionTeamVO1
     */
    public ViewObjectImpl getContactInteractionTeamVO1() {
        return (ViewObjectImpl) findViewObject("ContactInteractionTeamVO1");
    }

    /**
     * Container's getter for ContactInteractionsTeamVL1.
     * @return ContactInteractionsTeamVL1
     */
    public ViewLinkImpl getContactInteractionsTeamVL1() {
        return (ViewLinkImpl) findViewLink("ContactInteractionsTeamVL1");
    }

    /**
     * Container's getter for CurrencyLuView1.
     * @return CurrencyLuView1
     */
    public ViewObjectImpl getCurrencyLuView1() {
        return (ViewObjectImpl) findViewObject("CurrencyLuView1");
    }

    /**
     * Container's getter for ActiveUsersVO1.
     * @return ActiveUsersVO1
     */
    public ViewObjectImpl getActiveUsersVO1() {
        return (ViewObjectImpl) findViewObject("ActiveUsersVO1");
    }

    /**
     * Container's getter for InactiveUsersVO1.
     * @return InactiveUsersVO1
     */
    public ViewObjectImpl getInactiveUsersVO1() {
        return (ViewObjectImpl) findViewObject("InactiveUsersVO1");
    }

    /**
     * Container's getter for ActiveRoles1.
     * @return ActiveRoles1
     */
    public ViewObjectImpl getActiveRoles1() {
        return (ViewObjectImpl) findViewObject("ActiveRoles1");
    }

    /**
     * Container's getter for InactiveRoles1.
     * @return InactiveRoles1
     */
    public ViewObjectImpl getInactiveRoles1() {
        return (ViewObjectImpl) findViewObject("InactiveRoles1");
    }

    /**
     * Container's getter for ContactAppointmentsVO2.
     * @return ContactAppointmentsVO2
     */
    public ViewObjectImpl getContactAppointmentsVO2() {
        return (ViewObjectImpl) findViewObject("ContactAppointmentsVO2");
    }

    /**
     * Container's getter for ContactToAppointmentVL1.
     * @return ContactToAppointmentVL1
     */
    public ViewLinkImpl getContactToAppointmentVL1() {
        return (ViewLinkImpl) findViewLink("ContactToAppointmentVL1");
    }

    /**
     * Container's getter for ContactTasksVO2.
     * @return ContactTasksVO2
     */
    public ViewObjectImpl getContactTasksVO2() {
        return (ViewObjectImpl) findViewObject("ContactTasksVO2");
    }

    /**
     * Container's getter for ContactToTaskVL1.
     * @return ContactToTaskVL1
     */
    public ViewLinkImpl getContactToTaskVL1() {
        return (ViewLinkImpl) findViewLink("ContactToTaskVL1");
    }

    /**
     * Container's getter for ContactInteractionsVO2.
     * @return ContactInteractionsVO2
     */
    public ViewObjectImpl getContactInteractionsVO2() {
        return (ViewObjectImpl) findViewObject("ContactInteractionsVO2");
    }

    /**
     * Container's getter for ContactToInteractionsVL1.
     * @return ContactToInteractionsVL1
     */
    public ViewLinkImpl getContactToInteractionsVL1() {
        return (ViewLinkImpl) findViewLink("ContactToInteractionsVL1");
    }

    /**
     * Container's getter for ContactOpportunitiesVO2.
     * @return ContactOpportunitiesVO2
     */
    public ViewObjectImpl getContactOpportunitiesVO2() {
        return (ViewObjectImpl) findViewObject("ContactOpportunitiesVO2");
    }

    /**
     * Container's getter for ContactToOpportunityVL1.
     * @return ContactToOpportunityVL1
     */
    public ViewLinkImpl getContactToOpportunityVL1() {
        return (ViewLinkImpl) findViewLink("ContactToOpportunityVL1");
    }
}

