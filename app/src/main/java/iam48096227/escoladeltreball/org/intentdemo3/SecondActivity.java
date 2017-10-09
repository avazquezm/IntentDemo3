package iam48096227.escoladeltreball.org.intentdemo3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {
    EditText editText;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        setup();
    }

    private void setup() {
        editText = (EditText) findViewById(R.id.editText2);
        intent = getIntent();
        editText.setText(intent.getCharSequenceExtra(Intent.EXTRA_COMPONENT_NAME));
    }

    @Override
    public void finish(){
        Intent localIntent = new Intent();
        localIntent.putExtra(Intent.EXTRA_COMPONENT_NAME, editText.getText().toString());
        setResult(RESULT_OK, localIntent);

        super.finish();
    }
}
