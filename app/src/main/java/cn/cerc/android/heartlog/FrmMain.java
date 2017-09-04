package cn.cerc.android.heartlog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FrmMain extends AppCompatActivity implements View.OnClickListener {

    TextView lblMessage;
    EditText edtNum1, edtNum2, edtNum3;
    Button btnSave, btnList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_main);
        this.setTitle("血压历史记录");

        edtNum1 = (EditText) findViewById(R.id.edtNum1);
        edtNum2 = (EditText) findViewById(R.id.edtNum2);
        edtNum3 = (EditText) findViewById(R.id.edtNum3);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);
        btnList = (Button) findViewById(R.id.btnList);
        btnList.setOnClickListener(this);
        lblMessage = (TextView) findViewById(R.id.lblMessage);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_frm_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

//        if (item.getItemId() == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSave:
                try {
                    int num1 = Integer.parseInt(edtNum1.getText().toString());
                    int num2 = Integer.parseInt(edtNum2.getText().toString());
                    int num3 = Integer.parseInt(edtNum3.getText().toString());
                    Database db = new Database(this);
                    db.save(num1, num2, num3);
                    FrmList.startForm(this);
                } catch (NumberFormatException e) {
                    lblMessage.setText(e.getMessage());
                }
                break;
            case R.id.btnList: {
                FrmList.startForm(this);
                break;
            }
            default:
                break;
        }
    }
}
