public class ProductAlreadyExistsException extends Exception {
    public ProductAlreadyExistsException(){
        super();
    }

    public ProductAlreadyExistsException(String message){
        super(message);
    }
}
