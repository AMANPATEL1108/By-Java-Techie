package com.example.Jdbcactive.api.filter;

import jakarta.servlet.*;
import org.javalite.activejdbc.Base;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;


public class ApplicationFilter implements Filter {

    private Logger LOGGER = LoggerFactory.getLogger(ApplicationFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        System.out.println("Rsourcces opened");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        long befor = System.currentTimeMillis();
        try {
            Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/ticket", "root", "mysql");
            Base.openTransaction();
            filterChain.doFilter(servletRequest, servletResponse);

            Base.commitTransaction();
        } catch (IOException | ServletException e) {
            Base.rollbackTransaction();
            throw e;
        } finally {
            Base.close();
        }
        LOGGER.info("Process took : {} miliseconds", System.currentTimeMillis() - befor);
    }

    @Override
    public void destroy() {
        System.out.println("Rsourcces destoroyesss");

    }
}
