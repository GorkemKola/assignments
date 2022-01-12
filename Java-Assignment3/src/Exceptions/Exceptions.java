package Exceptions;

public class Exceptions extends Exception {
    //this class is to block going out of map.
    public static class OutOfBordersException extends Exceptions {
    }

    //this class is to check if commandline and Max Moves have the same length.
    public static class MoveCounterException extends Exceptions {
    }

    //This class is to finish commandline faster.
    public static class MoveFinished extends Exceptions {
    }
}

