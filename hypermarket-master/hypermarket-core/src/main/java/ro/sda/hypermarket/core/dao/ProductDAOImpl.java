package ro.sda.hypermarket.core.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.entity.Category;
import ro.sda.hypermarket.core.entity.Product;
import ro.sda.hypermarket.core.entity.Purchase;
import ro.sda.hypermarket.core.entity.PurchasedProduct;

import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class ProductDAOImpl implements ProductDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private CategoryDAO categoryDAO;

    @Autowired
    private SupplierDAO supplierDAO;

    @Autowired
    private PurchasedProductDAO purchasedProductDAO;

    @Override
    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Product create(Product product) {
        getCurrentSession().save(product);
        return product;
    }

    @Override
    public Product update(Product product) {
        Transaction tr = getCurrentSession().beginTransaction();
        getCurrentSession().update(product);
        getCurrentSession().flush();
        tr.commit();
        return product;
    }

    @Override
    public Product getProduct(long id) {
        Product searchedProduct = getCurrentSession().get(Product.class, id);
        return searchedProduct;
    }

    @Override
    public List<Product> getCertainProducts(String category, Long suppId, Long clId){
        //Get ID for given category
        Category searchedCategory = categoryDAO.findByName(category);


        //Get all products from a certain category and a certain supplier
        Query query = getCurrentSession().createQuery("SELECT prod FROM Product prod WHERE prod.category.id = :catId AND prod.supplier.id = :suppId");
        query.setParameter("catId", searchedCategory.getId());
        query.setParameter("suppId", suppId);
        List<Product> productList = new ArrayList<>();
        productList = (List<Product>) query.list();

        //Get all entries from Purchased Product
        List<PurchasedProduct> purchasedProductList = new ArrayList<>();
            query = getCurrentSession().createQuery("FROM PurchasedProduct");
            purchasedProductList = query.list();

        //Get ALL entries from PP with product ID
//        List<PurchasedProduct> purchasedProductsWithProdId = new ArrayList<>();
//        for(Product p:productList){
//            for(PurchasedProduct pp:purchasedProductList){
//                if(p.getId() == pp.getProduct().getId()){
//                    purchasedProductsWithProdId.add(pp);
//                }
//            }
//        }

        //Get all entries from PP with product id with clientID
        query = getCurrentSession().createQuery("FROM Purchase p WHERE p.client.id = :clId");
        query.setParameter("clId", clId);
        List<Purchase> purchasesListForClient = new ArrayList<>();
        purchasesListForClient = query.list();



        List<PurchasedProduct> finalList = new ArrayList<>();
//        for(PurchasedProduct pp:purchasedProductsWithProdId){
//            if(purchasesListForClient.contains(pp.getPurchase())){
//                finalList.add(pp);
//            }
//        }

        //Simpler - Check if purchasedProduct list contains the specific products and the specific purchases
        for(PurchasedProduct pp:purchasedProductList){
            if(productList.contains(pp.getProduct()) && purchasesListForClient.contains(pp.getPurchase())){
                finalList.add(pp);
            }
        }

        //Get the product list from purchased products list
        List<Product> finalProductList = new ArrayList<>();
        for(PurchasedProduct pp:finalList) {
            finalProductList.add(pp.getProduct());
        }
        return finalProductList;
    }

    @Override
    public List<Product> findAll() {
        CriteriaQuery<Product> criteriaQuery = getCurrentSession().getCriteriaBuilder().createQuery(Product.class);
        criteriaQuery.from(Product.class);
        List<Product> productList = getCurrentSession().createQuery(criteriaQuery).getResultList();
        return productList;
    }

    @Override
    public void delete(Product product) {
        Transaction tr = getCurrentSession().beginTransaction();
        Product found = (Product) getCurrentSession().get(Product.class, product.getId());
        getCurrentSession().delete(found);
        getCurrentSession().flush();
        tr.commit();
    }


}
