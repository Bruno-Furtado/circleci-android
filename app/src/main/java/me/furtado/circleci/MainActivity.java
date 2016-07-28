package me.furtado.circleci;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(listener);
    }

    //region Listeners
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle(getString(R.string.title));
            builder.setMessage(getString(R.string.message));

            final String confirmText = getString(R.string.confirm);
            builder.setPositiveButton(confirmText, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast toast = Toast.makeText(getApplicationContext(), confirmText, Toast.LENGTH_SHORT);
                    toast.show();
                }
            });

            final String cancelText = getString(R.string.cancel);
            builder.setNegativeButton(cancelText, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast toast = Toast.makeText(getApplicationContext(), cancelText, Toast.LENGTH_SHORT);
                    toast.show();
                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();
        }
    };
    //endregion
}
