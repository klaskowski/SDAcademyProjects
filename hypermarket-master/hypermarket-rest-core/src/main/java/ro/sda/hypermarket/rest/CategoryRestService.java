package ro.sda.hypermarket.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.hypermarket.core.entity.Category;
import ro.sda.hypermarket.core.repository.CategoryRepository;
import ro.sda.hypermarket.core.service.CategoryService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Service
@Path("/category")
public class CategoryRestService {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryRepository categoryRepository;

    @Path("/find-all")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Category> findAll(){
        return categoryService.findAll(false);
    }

    @Path("/find/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Category getCategory(@PathParam("id") long id){
        return categoryService.getCategory(id, false);
    }

    @Path("/create")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Category create(Category category){
        return categoryService.create(category, false);
    }

    @Path("/find")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Category findByNameQuery(@QueryParam("name") String name){
        return categoryRepository.findByName(name);
    }
}
