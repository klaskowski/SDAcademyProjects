package ro.sda.hypermarket.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.hypermarket.core.entity.Supplier;
import ro.sda.hypermarket.core.repository.SupplierRepository;
import ro.sda.hypermarket.core.service.SupplierService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Service
@Path("/supplier")
public class SupplierRestService {

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private SupplierRepository supplierRepository;

    @Path("/find-all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Supplier> findAll(){
        return supplierService.findAll(false);
    }

    @Path("/find/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Supplier getSupplier(@PathParam("id") long id){
        return supplierService.getSupplier(id, false);
    }

    @Path("/create")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Supplier create(Supplier supplier){
        return supplierService.create(supplier, false);
    }

    @Path("/find")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Supplier findByNameQuery(@QueryParam("name") String name){
        return supplierRepository.findByName(name);
    }
}
