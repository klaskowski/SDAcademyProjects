public class InvalidAddressException extends Exception {

    public InvalidAddressException(){
        System.out.println("Address not in database");
    }
}
