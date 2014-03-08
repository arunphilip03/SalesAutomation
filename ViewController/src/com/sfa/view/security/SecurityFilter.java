package com.sfa.view.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;

import javax.servlet.ServletResponse;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.servlet.ADFBindingFilter;
import oracle.adf.share.ADFContext;

import oracle.binding.BindingContainer;

import oracle.jbo.ApplicationModule;
import oracle.jbo.Row;
import oracle.jbo.ViewObject;


public class SecurityFilter extends ADFBindingFilter {

    private String userName = null;


    public SecurityFilter() {
        super();
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        super.init(filterConfig);
        System.out.println("Initialising security filter");

    }
    
    public BindingContainer getBindings() {
         return BindingContext.getCurrent().getCurrentBindingsEntry();
    }


    public void getRoles(String userName) {

        DCBindingContainer bindings = (DCBindingContainer) getBindings();
        ApplicationModule am  = bindings.getDataControl().getApplicationModule();

        ViewObject vo = am.findViewObject("GetUserRolesVO");
        //vo.setWhereClause("First_Name = :bEmpName");
        vo.defineNamedWhereClauseParam("USER_NAME", null, null);
        vo.setNamedWhereClauseParam("USER_NAME", userName);
        vo.executeQuery();
        
        while(vo.hasNext()) {
            Row row = vo.next();
            System.out.println("Role:  " + row.getAttribute("role_name") );
        }

    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        super.doFilter(servletRequest, servletResponse, filterChain);

        System.out.println("Inside security filter");


        userName = ADFContext.getCurrent().getSecurityContext().getUserName();

        if (userName != null) {
            System.out.println("Logged in user: " + userName);
            if(!userName.equals("anonymous"))
            //getRoles(userName);
            
        }


        // filterChain.doFilter(servletRequest, servletResponse);


    }


    @Override
    public void destroy() {
        super.destroy();

        System.out.println("Destroying security filter");
    }
}
