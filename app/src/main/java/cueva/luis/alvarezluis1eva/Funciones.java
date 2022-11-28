package cueva.luis.alvarezluis1eva;

public class Funciones {

    private static java.lang.ArithmeticException ArithmeticException;

    public static double sumar(double a, double b){
        return a + b;
    }

    public static double restar(double a, double b){
        return a - b;
    }

    public static double dividir (double a, double b) throws ArithmeticException{
        if(b == 0){
            throw ArithmeticException;
        }
        return a / b;
    }

    public static double multiplicar(double a, double b){return a * b;}

    public static double inverso(double a){
        String ter = a + "";
        String ret = "";

        for(int i=ter.length() - 1; i>=0; i--){
            ret += ter.charAt(i);
        }

        return Double.parseDouble(ret);
    }

    public static double elevar(double a){
        return Math.pow(a, 2);
    }

}
