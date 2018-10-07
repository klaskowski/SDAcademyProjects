import com.ewaiter.service.OrderService;
import com.ewaiter.utils.HibernateUtil;

public class Main {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();

        try {
            HibernateUtil.getSessionFactory();
            orderService.createOrder(1,1L);



        }finally {
            HibernateUtil.close();
        }

    }

}
