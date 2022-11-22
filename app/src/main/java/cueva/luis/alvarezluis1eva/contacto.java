package cueva.luis.alvarezluis1eva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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