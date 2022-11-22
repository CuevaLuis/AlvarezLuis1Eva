package cueva.luis.alvarezluis1eva;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView nombre;
    ImageButton bCalculadora;
    Button bContacto;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = (TextView) findViewById(R.id.textView);
        anim1();

        bCalculadora = (ImageButton) findViewById(R.id.imageCalculadora);
        bCalculadora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (view.getContext(), calculadora.class);
                startActivity(intent);
            }
        });

        bContacto = (Button) findViewById(R.id.buttonContacto);
        bContacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (view.getContext(), contacto.class);
                startActivity(intent);
            }
        });
    }

    public void anim1(){
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim1);
        nombre.startAnimation(animation);
    }
}