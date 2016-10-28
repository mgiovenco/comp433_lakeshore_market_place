package com.lmp.service;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.Set;

@Path("/employeeservice/")
public class TestService {

    @GET
    @Produces({"application/xml", "application/json"})
    @Path("/employee")
    //@Cacheable(cc="public, maxAge=3600") example for caching
    public Set<String> getEmployees() {
        System.out.println("GET METHOD Request for all employees .............");
        return null;
    }

}