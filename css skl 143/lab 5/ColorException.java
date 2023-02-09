public class ColorException extends RuntimeException {
    
    public ColorException() {
        super("An error occured in Color");
    }

    public ColorException(String msg) {
        super(msg);
    }
}