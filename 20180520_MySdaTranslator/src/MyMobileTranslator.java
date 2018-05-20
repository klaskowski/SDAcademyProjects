public class MyMobileTranslator implements ITranslator {


    @Override
    public String translate(String input) {
        String output = new String();
        if (input == null) {
            return null;
        }
        try {
            input = input.toUpperCase();
            for (int i = 0; i < input.length(); i++) {
                String character = String.valueOf(input.charAt(i));

                for (Integer key : OldPhoneCode.MOBILE_DIGITS.keySet()) {
                    String str = OldPhoneCode.MOBILE_DIGITS.get(key);
                    for (int j = 0; j < str.length(); j++) {
                        int position = 0;
                        char c = str.charAt(j);
                        String cToString = String.valueOf(c);
                        if (cToString.equals(character)) {
                            position = j + 1;
                        }
                        for (int k = 1; k <= position; k++) {
                            output = output.concat(String.valueOf(key));
                        }
                    }
                }
                output = output.concat(".");
            }
        } catch (NullPointerException e) {
            System.out.println("Translation Null Pointer Exception");
            return null;
        } catch (Exception e) {
            System.out.println("Translation Exception");
            System.out.println(e.toString());
            return null;
        }
        return output;

    }


}
