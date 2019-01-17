package np.com.ashok.testanimationphone;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    Button btndial;
    EditText etphoneno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        String data = getIntent().getExtras().getString("keytoaccess").toString();
//        Toast.makeText(this, ""+data, Toast.LENGTH_LONG).setDuration(
        TextView tvusername = findViewById(R.id.tvUsername);

        tvusername.setText(data);

            btndial = findViewById(R.id.btnDial);
            etphoneno = findViewById(R.id.etPhoneNo);
            etphoneno.setInputType(InputType.TYPE_CLASS_NUMBER); //To make sure only numbers are entered


            btndial.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    dialing();
                }
            });
         }
    public void dialing()
    {
        String phonenumbertxt = etphoneno.getText().toString();
        Integer phonenumber = Integer.parseInt(phonenumbertxt);
        Intent dialingintent = new Intent(Intent.ACTION_DIAL);

        //To REVOKE DIALPAD

        dialingintent.setData(Uri.parse("tel:"+phonenumber)); //tel suffix is required to not throw exception
        startActivity(dialingintent);
    }

    //Exit Animation

    public void finish()
    {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
    }
}
