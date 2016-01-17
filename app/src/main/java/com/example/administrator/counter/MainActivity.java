package com.example.administrator.counter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView txt1, txt2, txt3;
    Button btn_mm, btn_equ, btn_add, btn_sub, btn_mul, btn_div, btn_point, btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn_cle, btn_del;
    String strsym;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt1 = (TextView) findViewById(R.id.txt1);
        txt2 = (TextView) findViewById(R.id.txt2);
        txt3 = (TextView) findViewById(R.id.txt3);
        btn_mm = (Button) findViewById(R.id.btn_mm);
        btn_cle = (Button) findViewById(R.id.btn_cle);
        btn_del = (Button) findViewById(R.id.btn_del);
        btn_equ = (Button) findViewById(R.id.btn_equ);
        btn_add = (Button) findViewById(R.id.btn_add);
        btn_sub = (Button) findViewById(R.id.btn_sub);
        btn_mul = (Button) findViewById(R.id.btn_mul);
        btn_div = (Button) findViewById(R.id.btn_div);
        btn_point = (Button) findViewById(R.id.btn_point);
        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btn_point.setOnClickListener(new NumListener());
        btn0.setOnClickListener(new NumListener());
        btn1.setOnClickListener(new NumListener());
        btn2.setOnClickListener(new NumListener());
        btn3.setOnClickListener(new NumListener());
        btn4.setOnClickListener(new NumListener());
        btn5.setOnClickListener(new NumListener());
        btn6.setOnClickListener(new NumListener());
        btn7.setOnClickListener(new NumListener());
        btn8.setOnClickListener(new NumListener());
        btn9.setOnClickListener(new NumListener());
        btn_add.setOnClickListener(new CouListener());
        btn_sub.setOnClickListener(new CouListener());
        btn_mul.setOnClickListener(new CouListener());
        btn_div.setOnClickListener(new CouListener());
        btn_equ.setOnClickListener(new EquListener());
        btn_cle.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                txt1.setText(null);
                txt2.setText(null);
                txt3.setText(null);
            }
        });
        btn_del.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                txt1.setText(null);
            }
        });
        btn_mm.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "然而并没有什么卵用(●_○)", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    class NumListener implements OnClickListener {
        @Override
        public void onClick(View v) {
            Button btn = (Button) v;
            String str1 = (String) btn.getText();
            String str2 = (String) txt1.getText();
            txt1.setText(str2 + str1);
        }
    }

    class CouListener implements OnClickListener {
        @Override
        public void onClick(View v) {
            Button btn = (Button) v;
            strsym = (String) btn.getText();
            txt2.setText(strsym);
            String str = (String) txt1.getText();
            if (str != "") {
                txt3.setText(str);
                txt1.setText(null);
            }
        }
    }

    class EquListener implements OnClickListener {
        @Override
        public void onClick(View v) {
            String add = (String) btn_add.getText();
            String sub = (String) btn_sub.getText();
            String mul = (String) btn_mul.getText();
            String div = (String) btn_div.getText();
            String str1 = (String) txt1.getText();
            String str2 = (String) txt2.getText();
            String str3 = (String) txt3.getText();
            if (str1 == "" || str2 == "" || str3 == "") {
                txt2.setText(null);
            } else {
                Double dou1 = Double.parseDouble(str1);
                Double dou2 = Double.parseDouble(str3);
                Double dou3 = null;
                if (strsym == add) {
                    dou3 = dou2 + dou1;
                } else if (strsym == sub) {
                    dou3 = dou2 - dou1;
                } else if (strsym == mul) {
                    dou3 = dou2 * dou1;
                } else if (strsym == div) {
                    dou3 = dou2 / dou1;
                }
                txt2.setText(null);
                String strdou3 = Double.toString(dou3);
                txt3.setText(strdou3);
                txt1.setText(null);
            }
        }
    }

}
