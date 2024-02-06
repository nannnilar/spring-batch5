package com.example.restapijersy.api;

import com.example.restapijersy.data.Employee;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Path("employee")
@Component
public class EmployeeResource {
    private static final List<Employee> employees = List.of(
            new Employee(1,"John","Doe","john@gmail.com"),
            new Employee(2,"Thomas","Hardy","thomas@gmail.com"),
            new Employee(3,"Jack","Dalsan","jack@gmail.com")
    );
//    localhost:8080/api/employee/1.json
    @GET
    @Path("/{id}.{type}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Response findEmployeeById(@PathParam("type")String type,@PathParam("id") int id){
        var employee = employees.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, id + "Not Found"));
        if (type.equals("xml")) {
            return Response.ok(employee)
                    .type("application/xml")
                    .build();
        }
        return Response.ok(employee)
                .type("application/json").build();
    }
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> listAllEmployee(){
        return employees;
    }
}
