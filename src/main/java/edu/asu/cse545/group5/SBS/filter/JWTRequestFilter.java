package edu.asu.cse545.group5.SBS.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import edu.asu.cse545.group5.SBS.service.SBSUserDetailsService;
import edu.asu.cse545.group5.SBS.util.JwtUtil;

@Component
public class JWTRequestFilter extends OncePerRequestFilter {

    @Autowired 
    private SBSUserDetailsService userDetailsService;

    @Autowired 
    private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
        final String authHeader = request.getHeader("Authorization");

        String id = null;
        String token = null;

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            token = authHeader.substring(7);
            id = jwtUtil.extractUsernameFromToken(token);
        }

        if (id != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails uDetails = this.userDetailsService.loadUserByUsername(id);
            if (jwtUtil.validateJWTToken(token, uDetails)) {
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                    uDetails, null, uDetails.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filterChain.doFilter(request, response);
    }
}
