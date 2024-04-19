package data.exceptions;

/**
 * Exception hau gure matriz sistema arazoak daudeanean ejekutazeko erabiliko dugu
 */
public class GameLogicException extends Exception {

    public GameLogicException(String message) {
        super(message);
    }

    public GameLogicException(String message, Throwable cause) {
        super(message, cause);
    }

    public GameLogicException(Throwable cause) {
        super(cause);
    }

    public GameLogicException() {
        super();
    }
}
