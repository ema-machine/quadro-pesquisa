package info.gezielcarvalho.quadropesquisa;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void executaConsulta(View view){

        String response;
        String url = "https://jsonplaceholder.typicode.com/todos/";

        EditText txtConsulta = findViewById(R.id.texto_id);
        url += txtConsulta.getText().toString();

        TextView txtid = findViewById(R.id.txt_id);
        TextView txtTitle = findViewById(R.id.txt_title);
        TextView txtCompleted = findViewById(R.id.txt_completed);

        new DataGet(txtid, txtTitle, txtCompleted).execute(url);

    }
}