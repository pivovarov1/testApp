package com.example.home.testapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String EXTRA_MESSAGE = "com.example.testapp.MESSAGE";
    private Button mCrowsCounterButton;
    private TextView mInfoTextView;
    private int mCount = 0;

    private Button bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,bt0,btPoint,btPlus,btMinus,btMulti,btDivision,btEqual,btClear;
    private TextView inputMain;

    private int op1;
    private int op2;
    private int flagAction;
    private double result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCrowsCounterButton = findViewById(R.id.button_counter);
        mInfoTextView = findViewById(R.id.textView2);
        //mCrowsCounterButton.setOnClickListener(this);

        bt0 = findViewById(R.id.bt0);
        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        bt3 = findViewById(R.id.bt3);
        bt4 = findViewById(R.id.bt4);
        bt5 = findViewById(R.id.bt5);
        bt6 = findViewById(R.id.bt6);
        bt7 = findViewById(R.id.bt7);
        bt8 = findViewById(R.id.bt8);
        bt9 = findViewById(R.id.bt9);
        btPoint = findViewById(R.id.btPoint);
        btPlus = findViewById(R.id.btPlus);
        btMinus = findViewById(R.id.btMinus);
        btMulti = findViewById(R.id.btMulti);
        btDivision = findViewById(R.id.btDivision);
        btEqual = findViewById(R.id.btEqual);
        btClear = findViewById(R.id.btClear);
        inputMain = findViewById(R.id.inputMain);

        bt0.setOnClickListener(this);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        bt5.setOnClickListener(this);
        bt6.setOnClickListener(this);
        bt7.setOnClickListener(this);
        bt8.setOnClickListener(this);
        bt9.setOnClickListener(this);
        btPoint.setOnClickListener(this);
        btPlus.setOnClickListener(this);
        btMinus.setOnClickListener(this);
        btMulti.setOnClickListener(this);
        btDivision.setOnClickListener(this);
        btEqual.setOnClickListener(this);
        btClear.setOnClickListener(this);

        op1 = 0;
        op2 = 0;
        flagAction = 0;
        result = 0;

        inputMain.setText(Integer.toString(op1));
        mInfoTextView.setText("Let's go!");
        //mInfoTextView.setText("Я выпил " + mCount + " кружек пива! Let's go!");

    }

    /** Клик на кнопку */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void counter (View view){

        mCrowsCounterButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                if (mCount < 3) {
                    mInfoTextView.setText("Я выпил " + ++mCount + " кружек пива! Good job!");
                }
                else
                {
                    mInfoTextView.setText("Я выпил " + ++mCount + " кружек пива! I'm drunk %)");
                }
            }

        });
    }

    @SuppressLint("ResourceType")
    @Override
    public void onClick(View v) {

        //inputMain.setText("Нажата кнопка: " + v.getId());
        switch (v.getId())
        {
            case R.id.bt0:
                ClickNumber(0);
                break;
            case R.id.bt1:
                ClickNumber(1);
                break;
            case R.id.bt2:
                ClickNumber(2);
                break;
            case R.id.bt3:
                ClickNumber(3);
                break;
            case R.id.bt4:
                ClickNumber(4);
                break;
            case R.id.bt5:
                ClickNumber(5);
                break;
            case R.id.bt6:
                ClickNumber(6);
                break;
            case R.id.bt7:
                ClickNumber(7);
                break;
            case R.id.bt8:
                ClickNumber(8);
                break;
            case R.id.bt9:
                ClickNumber(9);
                break;
            case R.id.btPlus:
                if (flagAction == 0)
                    flagAction = 1;
                result = op1 + op2;
                if (op2 != 0)
                {
                    inputMain.setText(Double.toString(result));
                }
                result = 0;
                break;
            case R.id.btMinus:
                if (flagAction == 0)
                    flagAction = 2;
                break;
            case R.id.btMulti:
                if (flagAction == 0)
                    flagAction = 3;
                break;
            case R.id.btDivision:
                if (flagAction == 0)
                    flagAction = 4;
                break;
            case R.id.btEqual:
                switch (flagAction)
                {
                    case 1:
                        result = op1 + op2;
                        if (op2 != 0)
                        {
                            inputMain.setText(Double.toString(result));

                        }
                        break;
                    case 2:
                        result = op1 - op2;
                        break;
                    case 3:
                        result = op1 * op2;
                        break;
                    case 4:
                        result = (double) op1 / (double) op2;
                        break;
                    default:
                        Toast.makeText(this, "Операция не задана", Toast.LENGTH_LONG).show();
                }

                if (flagAction != 0)
                {
                    inputMain.setText(Double.toString(result));
                    op1 = (int) result;
                    op2 = 0;
                    result = 0;
                    flagAction = 0;
                }
                break;
            case R.id.btClear:
                op1 = 0;
                op2 = 0;
                result = 0;
                flagAction = 0;
                inputMain.setText(Integer.toString(op1));
                break;


        }
    }

    private void ClickNumber (int num) {

        if (flagAction == 0)
        {
            op1 = op1*10 + num;
            inputMain.setText(Integer.toString(op1));
        }
        else
        {
            op2 = op2*10 + num;
            inputMain.setText(Integer.toString(op2));
        }


    }
}
