package cueva.luis.alvarezluis1eva;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

public class contacto extends AppCompatActivity {

    Button enviar;
    EditText correo;
    EditText asunto;
    EditText contenido;
    SeekBar puntuacion;

    @Override
    protected void onRestart() {
        super.onRestart();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.MnOp4:
                Intent intent = new Intent (this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.SnOpC:
                String url2 = "https://www.gmail.com/";

                Intent intent4 = new Intent(Intent.ACTION_VIEW, Uri.parse(url2));
                startActivity(intent4);
                break;
            case R.id.SnOp3:
                Intent intent2 = new Intent (this, calculadora.class);
                startActivity(intent2);
                break;
            case R.id.SnOp4:
                String url = "https://web2.0calc.es/";

                Intent intent3 = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent3);
                break;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        correo = (EditText) findViewById(R.id.editCorreo);
        asunto = (EditText) findViewById(R.id.editAsunto);
        contenido = (EditText) findViewById(R.id.editContenido);
        puntuacion = (SeekBar) findViewById(R.id.puntuacion);

        enviar = (Button) findViewById(R.id.buttonEnviar);
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textCorreo = correo.getText().toString();
                String textAsunto = asunto.getText().toString();
                String textContenido = "Puntuacion: " + puntuacion.getProgress() + "\n" + contenido.getText().toString();

                Intent intent = new Intent(Intent.ACTION_SEND);

                intent.putExtra(Intent.EXTRA_EMAIL,
                        new String[] { textCorreo });
                intent.putExtra(Intent.EXTRA_SUBJECT, textAsunto);
                intent.putExtra(Intent.EXTRA_TEXT, textContenido);

                intent.setType("message/rfc822");

                // Lanzo el selector de cliente de Correo
                startActivity(
                        Intent
                                .createChooser(intent,
                                        "Elije un cliente de Correo:"));
            }
        });
    }
}