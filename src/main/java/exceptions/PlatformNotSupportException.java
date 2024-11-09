package exceptions;

@SuppressWarnings("unused") // Compilation fails without this class??
public class PlatformNotSupportException extends Exception {
    public PlatformNotSupportException(String message) {
        super(message);
    }
}
