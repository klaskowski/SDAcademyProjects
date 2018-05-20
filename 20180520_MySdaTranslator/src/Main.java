
public class Main {
    public static void translate(IReader iReader, ITranslator iTranslator, IDisplay iDisplay) {
        String input = iReader.read();
        String translated = iTranslator.translate(input);
        iDisplay.display(translated);
    }

    public static void main(String[] args) {
        SDASystemReader sysRead = new SDASystemReader();
        SDATranslate trans = new SDATranslate();
        SDADisplayer displayer = new SDADisplayer();

        translate(sysRead, trans, displayer);

    }
}
