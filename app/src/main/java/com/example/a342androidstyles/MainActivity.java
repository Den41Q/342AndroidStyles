package com.example.a342androidstyles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Spinner language;
    private Button btnChange;
    private Spinner margin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_main);
        initView();
    }

    public void initView() {
        btnChange = findViewById(R.id.btn_change);
        language = findViewById(R.id.spinner);
        margin = findViewById(R.id.spinner_margin);

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String spinner = language.getSelectedItem().toString();

                if ("Русский".equalsIgnoreCase(spinner) | "Russian".equalsIgnoreCase(spinner)) {
                    Locale locale = new Locale("ru");
                    Configuration config = new Configuration();
                    config.setLocale(locale);
                    getResources().updateConfiguration(config,
                            getBaseContext().getResources().getDisplayMetrics());
                    recreate();
                } else if ("Английский".equalsIgnoreCase(spinner) |
                        "English".equalsIgnoreCase(spinner)) {
                    Locale locale = new Locale("en");
                    Configuration config = new Configuration();
                    config.setLocale(locale);
                    getResources().updateConfiguration(config,
                            getBaseContext().getResources().getDisplayMetrics());
                    recreate();
                }
            }
        });
    }

    public void changeTheme(View view) {
        String spinMargin = margin.getSelectedItem().toString();

        switch (spinMargin) {
            case "Мелкая":
                Utils.changeToTheme(this, Utils.MARGIN_1);
                break;
            case "Средняя":
                Utils.changeToTheme(this, Utils.MARGIN_2);
                break;
            case "Крупная":
                Utils.changeToTheme(this, Utils.MARGIN_3);
                break;
        }
    }
}