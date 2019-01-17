package np.com.ashok.testanimationphone;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etusername;
    EditText etpassword;
    Button btnlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etusername = findViewById(R.id.etUsername);
        etpassword = findViewById(R.id.etPassword);

        btnlogin = findViewById(R.id.btnLogin);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, ""+etusername.getText()+"\n"+etpassword.getText(), Toast.LENGTH_SHORT).show();
            validate();

            }
        });

    }
    public void validate()
    {
        String username = etusername.getText().toString().trim();
        String password = etpassword.getText().toString().trim();

        if (username.equals("")&&password.equals(""))
        {
            Toast.makeText(this, "Empty Field.", Toast.LENGTH_LONG).show();
        }
        else if (username.equals("admin")&&password.equals("admin"))
        {
//            Toast.makeText(this, "Correct Information... :) ", Toast.LENGTH_LONG).show();
            Intent intentobj = new Intent(MainActivity.this,Main2Activity.class);

            intentobj.putExtra("keytoaccess",username);

            startActivity(intentobj);
            //Animation after clicking LOGIN
            overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
        }
        else
        {
            Toast.makeText(this, "Wrong Information...", Toast.LENGTH_LONG).show();
        }
    }
}
