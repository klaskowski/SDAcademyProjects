package ro.sda.hypermarket.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.hypermarket.core.entity.PurchasedProduct;
import ro.sda.hypermarket.core.repository.PurchaseProductRepository;
import ro.sda.hypermarket.core.service.PurchasedProductService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Service
@Path("/purchasedProduct")
public class PurchasedProductRestService {

    @Autowired
    private PurchasedProductService purchasedProductService;

    @Autowired
    private PurchaseProductRepository purchaseProductRepository;

    @Path("/create")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public PurchasedProduct create(PurchasedProduct purchasedProduct){
        return purchasedProductService.create(purchasedProduct, false);
    }

    @Path("/find-all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PurchasedProduct> findAll(){
        return purchaseProductRepository.findAll();
    }

    @Path("/find/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public PurchasedProduct getPurchasedProduct(@PathParam("id") long id){
        return purchaseProductRepository.findById(id);
    }
}
