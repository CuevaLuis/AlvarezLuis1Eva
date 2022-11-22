package cueva.luis.alvarezluis1eva;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class calculadora extends AppCompatActivity {

    static TextView result;

    Button b0;
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    Button b5;
    Button b6;
    Button b7;
    Button b8;
    Button b9;

    Button bDiv;
    Button bMul;
    Button bSum;
    Button bRes;

    Button bIgual;
    Button bPunto;
    Button bInv;
    Button bBorrar;

    static String numOne;
    static String numTwo;

    static int operacion;
    static boolean finish;

    public static void teclaNumero(int i){

        boolean change = false;

        if (!numOne.equals("0") && (numTwo.equals("") || numTwo.equals("0")) && numOne.length()<8 && operacion == -1){
            numOne += i;
            result.setText(numOne);
            change = true;
        }

        if (numOne.equals("0") && numTwo.equals("") && numOne.length()<8 && operacion == -1){
            numOne = i + "";
            result.setText(numOne);
            change = true;
        }

        if(!numTwo.equals("0") && numTwo.length()<8 && operacion != -1){
            numTwo += i;
            result.setText(numTwo);
            change = true;
        }

        if(numTwo.equals("0") && numTwo.length()<8 && operacion != -1){
            numTwo = i + "";
            result.setText(numTwo);
            change = true;
        }

        if (finish && numOne.length()<8 && !change){
            finish = false;
            numOne = i + "";
            result.setText(numOne);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        result = (TextView) findViewById(R.id.textResult);

        b0 = (Button) findViewById(R.id.b0);
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b3 = (Button) findViewById(R.id.b3);
        b4 = (Button) findViewById(R.id.b4);
        b5 = (Button) findViewById(R.id.b5);
        b6 = (Button) findViewById(R.id.b6);
        b7 = (Button) findViewById(R.id.b7);
        b8 = (Button) findViewById(R.id.b8);
        b9 = (Button) findViewById(R.id.b9);

        bDiv = (Button) findViewById(R.id.bDiv);
        bMul = (Button) findViewById(R.id.bMul);
        bSum = (Button) findViewById(R.id.bPlus);
        bRes = (Button) findViewById(R.id.bSub);

        bIgual = (Button) findViewById(R.id.bEqual);
        bPunto = (Button) findViewById(R.id.bDot);
        bInv = (Button) findViewById(R.id.bInv);
        bBorrar = (Button) findViewById(R.id.bDelete);

        numOne = "0";
        numTwo = "";

        operacion = -1;
        finish = false;

        result.setText(numOne);

        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!numOne.equals("0") && (numTwo.equals("") || numTwo.equals("0")) && numOne.length()<8 && operacion == -1){
                    numOne += "0";
                    result.setText(numOne);
                }

                if (numOne.equals("0") && numTwo.equals("") && numOne.length()<8 && operacion == -1){

                }

                if(!numTwo.equals("0") && numTwo.length()<8 && operacion != -1){
                    numTwo += "0";
                    result.setText(numTwo);
                }

                if(numTwo.equals("0") && operacion != -1){

                }

                if (finish){
                    finish = false;
                    result.setText(numOne);
                }
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teclaNumero(1);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teclaNumero(2);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teclaNumero(3);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teclaNumero(4);
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teclaNumero(5);
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teclaNumero(6);
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teclaNumero(7);
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teclaNumero(8);
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teclaNumero(9);
            }
        });


        bDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numTwo = "0";
                operacion = 1;
                result.setText(numTwo);
            }
        });

        bMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numTwo = "0";
                operacion = 2;
                result.setText(numTwo);
            }
        });

        bSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numTwo = "0";
                operacion = 3;
                result.setText(numTwo);
            }
        });

        bRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numTwo = "0";
                operacion = 4;
                result.setText(numTwo);
            }
        });


        bIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (operacion != -1) {
                    switch (operacion) {
                        case 1:
                            try {
                                numOne = Funciones.dividir(Double.parseDouble(numOne), Double.parseDouble(numTwo)) + "";
                                result.setText(numOne + "");
                            } catch (ArithmeticException e){
                                numOne = 0 + "";
                                result.setText(numOne);
                            } finally {
                                numTwo = "0";
                                finish = true;
                                operacion = -1;
                                break;
                            }
                        case 2:
                            numOne = Funciones.multiplicar(Double.parseDouble(numOne), Double.parseDouble(numTwo)) + "";
                            result.setText(numOne + "");
                            numTwo = "0";
                            finish = true;
                            operacion = -1;
                            break;
                        case 3:
                            numOne = Funciones.sumar(Double.parseDouble(numOne), Double.parseDouble(numTwo)) + "";
                            result.setText(numOne + "");
                            numTwo = "0";
                            finish = true;
                            operacion = -1;
                            break;
                        case 4:
                            numOne = Funciones.restar(Double.parseDouble(numOne), Double.parseDouble(numTwo)) + "";
                            result.setText(numOne);
                            numTwo = "0";
                            finish = true;
                            operacion = -1;
                            break;
                    }
                }
            }
        });

        bPunto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!numOne.contains(".") && numTwo.equals("")){
                    numOne +=".";
                    result.setText(numOne);
                }

                if (finish && !numOne.contains(".")){
                    finish = false;
                    numOne +=".";
                    result.setText(numOne);
                }

                if (numTwo.equals("0") && numOne.length()<8 && operacion == -1 && !numOne.contains(".")){
                    numOne += ".";
                    result.setText(numOne);
                }

                if(!numTwo.equals("") && numTwo.length()<8 && operacion != -1 && !numTwo.contains(".")){
                    numTwo += ".";
                    result.setText(numTwo);
                }
            }
        });

        bInv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(operacion == -1){
                    Double res = Funciones.inverso(Double.parseDouble(numOne));
                    numOne = res + "";
                    result.setText(numOne);
                } else{
                    Double res = Funciones.inverso(Double.parseDouble(numTwo));
                    numTwo = res + "";
                    result.setText(numTwo);
                }
            }
        });

        bBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!numOne.equals("0") && numTwo.equals("") && numOne.length()<8){
                    numOne = "0";
                    result.setText(numOne);
                }

                if(!numTwo.equals("") && !numTwo.equals("0") && numTwo.length()<8){
                    numTwo = "0";
                    result.setText(numTwo);
                }

                if(finish){
                    numOne = "0";
                    result.setText(numOne);
                }
            }
        });
    }
}