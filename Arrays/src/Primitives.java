public class Primitives {

    static char c = 'c';

    public static void printChar(){
        System.out.println(c);
        char c1 = (char)(c + 1);
        System.out.println(c1);
    }

    public static void printAscii(){
        for(short i = 0; i < 256; i++){
            char c = (char)i;
            System.out.println(i + " " + c);
        }
    }


    public static void filterNumbers(String s){
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            int charPos = (int)c;
            if(charPos >= 48 && charPos <=57){
                System.out.print(c);
            }
        }
    }


    public static void main(String[] args){
        //System.out.println("Hello World!");
        //printChar();
        //System.out.println();
        //printAscii();

        //String a = "H3ll0 W0rld";
        //filterNumbers(a);
        //2 oct
//        short s = 32423;
//        System.out.println(s);
//        //4 oct
//        int i = 534237;
//        System.out.println(i);
//        //8 oct
//        long l = 33456746753L;
//        System.out.println(l);
//
//        long l2 = (long)i;
//        System.out.println(l2);
//        long l3 = (long)s;
//        System.out.println(l3);
//
//        int i1 = (int)l;
//        System.out.println(i1);

        short s2 = 32767;
        System.out.println(s2);
        System.out.println((short)(s2 + 1));
        System.out.println();
        System.out.println(Integer.toBinaryString(s2));
        System.out.println(Integer.toBinaryString((short)(s2 + 1)));




    }
}
