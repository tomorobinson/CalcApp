package jp.techacademy.tomokazu.kawano.calcapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editText1, editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);

        //足し算ボタン
        Button buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(this);

        //引き算ボタン
        Button buttonSubtract = (Button) findViewById(R.id.buttonSubtract);
        buttonSubtract.setOnClickListener(this);

        //掛け算ボタン
        Button buttonMultiply = (Button) findViewById(R.id.buttonMultiply);
        buttonMultiply.setOnClickListener(this);

        //割り算ボタン
        Button buttonDivide = (Button) findViewById(R.id.buttonDivide);
        buttonDivide.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String warningMsg = "";

        if (editText1.getText().toString().length() != 0 && editText2.getText().toString().length() != 0) {
            //EditTextが空白でなければ、StringからFloatへ変換
            float value1 = Float.parseFloat(editText1.getText().toString());
            float value2 = Float.parseFloat(editText2.getText().toString());
            float result = 0;

            switch (v.getId()) {
                case R.id.buttonAdd:
                    result = value1 + value2;
                    break;
                case R.id.buttonSubtract:
                    result = value1 - value2;
                    break;
                case R.id.buttonMultiply:
                    result = value1 * value2;
                    break;
                case R.id.buttonDivide:
                    if (value2 != 0) {
                        result = value1 / value2;
                    } else {
                        warningMsg = "ZERO徐算は控えてください!";
                        showAlertDialog(warningMsg);
                    }
                    break;
                default:
                    break;
            }

            if (warningMsg.equals("")){
                Intent intent = new Intent(this, CalcResult.class);
                intent.putExtra("RESULT", result);
                startActivity(intent);
            }

        } else {
            // AlertDialogで数値を入力する様注意
            warningMsg = "数値を入力してください!";
            showAlertDialog(warningMsg);
        }
    }

    private void callIntent(float result) {

    }

    private void showAlertDialog(String warningMsg) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("注意");
        alertDialogBuilder.setMessage(warningMsg);

        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}