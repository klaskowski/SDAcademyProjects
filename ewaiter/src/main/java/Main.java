import com.ewaiter.utils.HibernateUtil;

public class Main {
    public static void main(String[] args) {
        try {
            HibernateUtil.getSessionFactory();




        }finally {
            HibernateUtil.close();
        }

    }

}
