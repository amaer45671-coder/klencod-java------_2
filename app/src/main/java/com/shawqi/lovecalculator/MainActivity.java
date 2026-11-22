package com.shawqi.lovecalculator;

import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText etName1, etName2;
    TextView tvTitle, tvResult, tvMessage;
    Button btnCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName1 = findViewById(R.id.etName1);
        etName2 = findViewById(R.id.etName2);
        tvTitle = findViewById(R.id.tvTitle);
        tvResult = findViewById(R.id.tvResult);
        tvMessage = findViewById(R.id.tvMessage);
        btnCalc = findViewById(R.id.btnCalc);

        Animation blink = new AlphaAnimation(1.0f, 0.0f);
        blink.setDuration(500);
        blink.setRepeatMode(Animation.REVERSE);
        blink.setRepeatCount(Animation.INFINITE);
        tvTitle.startAnimation(blink);

        btnCalc.setOnClickListener(v -> {
            String name1 = etName1.getText().toString().trim();
            String name2 = etName2.getText().toString().trim();

            if (name1.isEmpty() || name2.isEmpty()) {
                tvResult.setText("اكتب الاسمين اولاً 😅");
                return;
            }

            int total = (name1 + name2).hashCode();
            Random random = new Random(Math.abs(total));
            int percent = 50 + random.nextInt(50);

            tvResult.setText(percent + "% ❤️");

            if (percent >= 90) {
                tvMessage.setText("واااو حب اسطوري يا القيادة شوقي 🔥❤️");
            } else if (percent >= 75) {
                tvMessage.setText("حب قوي جداً 💖");
            } else if (percent >= 60) {
                tvMessage.setText("حب حلو بس يحتاج اهتمام اكثر 🥰");
            } else {
                tvMessage.setText("حاولوا تتقربوا من بعض اكثر 💌");
            }
        });
    }
}