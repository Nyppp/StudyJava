public class MessagePrinter {
    private String prefix;

    public MessagePrinter(String prefix){
        this.prefix = prefix;
    }

    public void printWithSuffix(final String suffix){
        class LocalFormater{
            void formatAndPrint(String message){
                System.out.println(prefix + " " + message + " " + suffix);
            }
        }

        LocalFormater formater = new LocalFormater();
        formater.formatAndPrint("Hello Wolrd!");
    }
}
