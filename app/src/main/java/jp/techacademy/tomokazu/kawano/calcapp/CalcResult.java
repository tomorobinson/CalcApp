package jp.techacademy.tomokazu.kawano.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CalcResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_result);

        Intent intent = getIntent();
        float result = intent.getFloatExtra("RESULT", 0);

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText("計算結果: " + String.valueOf(result));
    }
}