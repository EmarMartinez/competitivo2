package com.bosonit.competitivo2.Filter;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class Filter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String redirect = request.getHeader("redirige");
//        System.out.println(redirect);
        if(redirect!= null) {
            if (redirect.equals("SALTA")) {
                if (!request.getRequestURI().equals("/salta")) response.sendRedirect("salta");
            }
        }

        String add = request.getHeader("add");
        if(add!=null) {
            if(request.getMethod().equals("POST")) {
                if(!request.getRequestURI().equals("/modificarbody")) {
                    response.setStatus(307);
                    response.addHeader("Location", "modificarbody");
                }
            }

        }

        filterChain.doFilter(request, response);
    }
}
