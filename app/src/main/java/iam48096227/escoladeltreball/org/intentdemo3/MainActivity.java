package iam48096227.escoladeltreball.org.intentdemo3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;
    CheckBox capital, inverse;
    EditText editText;
    public static final int SECOND_ACTIVITY_REQUEST_CODE = 23434;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setup();
    }

    private void setup(){
        button = (Button) findViewById(R.id.btn_sendme);
        editText = (EditText) findViewById(R.id.editText);
        capital = (CheckBox) findViewById(R.id.chk_capital);
        inverse = (CheckBox) findViewById(R.id.chk_inverse);
        button.setOnClickListener(v -> switchActivity());
    }

    private void switchActivity() {
        String s = editText.getText().toString();
        Intent intent = new Intent(this, SecondActivity.class);
        if(capital.isChecked()){
            s = s.toUpperCase();
        }
        if(inverse.isChecked()){
            StringBuilder sb = new StringBuilder();
            sb.append(s);
            s = sb.reverse().toString();
        }

        intent.putExtra(Intent.EXTRA_COMPONENT_NAME, s);
        //poden haver mes putExtra
        startActivityForResult(intent, SECOND_ACTIVITY_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == SECOND_ACTIVITY_REQUEST_CODE){
            if(resultCode == RESULT_OK){
                if(data.hasExtra(Intent.EXTRA_COMPONENT_NAME)){
                    editText.setText(data.getCharSequenceExtra(Intent.EXTRA_COMPONENT_NAME));
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }




}
