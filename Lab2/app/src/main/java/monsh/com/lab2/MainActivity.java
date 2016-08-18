package monsh.com.lab2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //Create Instance Variables

    private Button send;
    private EditText name;
    private EditText mail;
    private EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize my instance variables
        send = (Button) findViewById(R.id.btn_send);
        name = (EditText) findViewById(R.id.edt_name);
        mail = (EditText) findViewById(R.id.edt_mail);
        pass = (EditText) findViewById(R.id.edt_pass);

        //Add listeners to my views

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Name, Email, Password;

                Name = name.getText().toString();
                Email = mail.getText().toString();
                Password = pass.getText().toString();

                name.setText(" ");
                mail.setText(" ");
                pass.setText(" ");

                Intent intent = new Intent(getApplicationContext(), ShowActivity.class);

                intent.putExtra("name",Name);
                intent.putExtra("mail",Email);
                intent.putExtra("pass",Password);

                startActivity(intent);

            }
        });

    }
}
