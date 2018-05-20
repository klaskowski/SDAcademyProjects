
public class Main {
    public static void translate(IReader iReader, ITranslator iTranslator, IDisplay iDisplay) {
        String input = iReader.read();
        String translated = iTranslator.translate(input);
        iDisplay.display(translated);
    }

    public static void main(String[] args) {
        MySystemReader mySystemReader = new MySystemReader();
        MyFileReader myFileReader = new MyFileReader();
        MyMorseTranslator myMorseTranslator = new MyMorseTranslator();
        MySystemDisplay mySystemDisplay = new MySystemDisplay();
        MyFileWriter myFileWriter = new MyFileWriter();
        MyMobileTranslator myMobileTranslator = new MyMobileTranslator();

//        System.out.println("**********SystemReader************");
//        translate(mySystemReader, myMorseTranslator, mySystemDisplay);
//
//        System.out.println("***************File Reader*********");
//        translate(myFileReader, myMorseTranslator, mySystemDisplay);
//
//        System.out.println("***************File Writer*********");
//        translate(myFileReader, myMorseTranslator, myFileWriter);

        System.out.println("***************Mobile Translator*********");
        translate(mySystemReader, myMobileTranslator, mySystemDisplay);


    }
}
