package chainofresponsability;

public class ChainPatternDemo {
    private static AbstractLogger getChainOfLoggers(){
        AbstractLogger debugLogger = new DebugLogger(AbstractLogger.DEBUG);
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger infoLogger = new InfoLogger(AbstractLogger.INFO);

        infoLogger.setNextLogger(errorLogger);
        errorLogger.setNextLogger(debugLogger);

        return infoLogger;
    }

    public static void main(String[] args) {
        AbstractLogger loggerChain = getChainOfLoggers();
        loggerChain.logMessage(AbstractLogger.INFO, "This is Information");
        loggerChain.logMessage(AbstractLogger.DEBUG, "Debug information");
        loggerChain.logMessage(AbstractLogger.ERROR, "Error information");
    }
}
