package ro.sda.hypermarket.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.hypermarket.core.entity.Stock;
import ro.sda.hypermarket.core.repository.StockRepository;
import ro.sda.hypermarket.core.service.StockService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Service
@Path("/stock")
public class StockRestService {

    @Autowired
    private StockService stockService;

    @Autowired
    private StockRepository stockRepository;

    @Path("/find-all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Stock> findAll(){
        return stockRepository.findAll();
    }

    @Path("/find/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Stock getStock(@PathParam("id") long id){
        return stockService.getStock(id, false);
    }

    @Path("/create")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Stock create(Stock stock){
        return stockService.create(stock, false);
    }
}
