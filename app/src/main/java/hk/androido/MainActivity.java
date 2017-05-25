package hk.androido;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private RelativeLayout layout;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        layout = (RelativeLayout) findViewById(R.id.parentLayout);
        textView = (TextView) findViewById(R.id.textView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterPictureInPictureMode();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(isInPictureInPictureMode()){
            toggleUi();
        }

    }

    private void toggleUi() {
        button.setVisibility(View.INVISIBLE);
        layout.setBackgroundColor(getColor(R.color.colorPrimaryDark));
        textView.setVisibility(View.VISIBLE);
    }
}
