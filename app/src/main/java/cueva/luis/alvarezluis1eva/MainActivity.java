package cueva.luis.alvarezluis1eva;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView nombre;
    ImageButton bCalculadora;
    Button bContacto;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.SnOpA:
                Intent intent = new Intent (this, contacto.class);
                startActivity(intent);
                break;
            case R.id.SnOpB:
                String url2 = "https://www.gmail.com/";

                Intent intent4 = new Intent(Intent.ACTION_VIEW, Uri.parse(url2));
                startActivity(intent4);
                break;
            case R.id.SnOp1:
                Intent intent2 = new Intent (this, calculadora.class);
                startActivity(intent2);
                break;
            case R.id.SnOp2:
                String url = "https://web2.0calc.es/";

                Intent intent3 = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent3);
                break;
        }
        return true;
    }

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