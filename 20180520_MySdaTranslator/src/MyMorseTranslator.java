public class MyMorseTranslator implements ITranslator {

    @Override
    public String translate(String input) {
        String output = new String();

        if(input == null){
            return null;
        }
        try{
            input = input.toLowerCase();
            for (int i = 0; i < input.length(); i++) {
                char character = input.charAt(i);
                String characterInString = String.valueOf(character);
                String characterInMorse = MorseCode.MORSE_CODE.get(characterInString);
                if (characterInMorse == null) {
                    characterInMorse = " ";
                }
                output = output.concat(characterInMorse);
            }
        }catch (NullPointerException e){
            System.out.println("Translation Null Pointer Exception");
            return null;
        } catch (Exception e){
            System.out.println("Translation Exception");
            return null;
        }
        return output;
    }
}
