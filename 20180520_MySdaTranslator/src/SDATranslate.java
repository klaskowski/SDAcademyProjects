public class SDATranslate implements ITranslator {

    @Override
    public String translate(String input) {
        input = input.toLowerCase();
        String output = new String();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            String s = String.valueOf(c);
            String mCode = MorseCode.MORSE_CODE.get(s);
            if (mCode == null) {
                mCode = " ";
            }
            output = output.concat(mCode);
        }
        return output;
    }
}
