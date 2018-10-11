package ro.sda.hypermarket.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.hypermarket.core.entity.Purchase;
import ro.sda.hypermarket.core.repository.PurchaseRepository;
import ro.sda.hypermarket.core.service.PurchaseService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Service
@Path("/purchase")
public class PurchaseRestService {

    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Path("/find-all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Purchase> findAll(){
        return purchaseRepository.findAll();
    }

    @Path("/find/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Purchase getPurchase(@PathParam("id") long id){
        return purchaseService.getPurchase(id, false);
    }

    @Path("/create")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Purchase create(Purchase purchase){
        return purchaseService.create(purchase, false);
    }
}
