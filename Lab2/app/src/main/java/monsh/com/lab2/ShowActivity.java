package monsh.com.lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowActivity extends AppCompatActivity {

    //Create my instance variables
    private TextView nombre;
    private TextView correo;
    private TextView contra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        //Link my views
        nombre = (TextView)findViewById(R.id.tv_name);
        correo = (TextView) findViewById(R.id.tv_mail);
        contra = (TextView)findViewById(R.id.tv_pass);

        //Define my strings
        String name,mail,pass;

        //Create a Bundle
        Bundle extras = getIntent().getExtras();
        name= extras.get("name").toString();
        mail = extras.get("mail").toString();
        pass = extras.get("pass").toString();

        //Set Texts
        nombre.setText(name);
        correo.setText(mail);
        contra.setText(pass);

    }
}
