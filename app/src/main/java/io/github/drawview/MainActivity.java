package io.github.drawview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import io.github.drawview.practice.Practice14BezierCircleView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void start(View view) {
       Practice14BezierCircleView p =  findViewById(R.id.pra14);
       p.startAnimate();
    }
}
