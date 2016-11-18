package samples.com.rxbindingexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.jakewharton.rxbinding.view.RxView;
import com.jakewharton.rxbinding.widget.RxTextView;

import rx.Subscription;
import rx.functions.Action1;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTAG_";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b = (Button)findViewById(R.id.buttonRX);
        Subscription buttonSub =
                RxView.clicks(b).subscribe(new Action1<Void>() {
                    @Override
                    public void call(Void aVoid) {
                        Log.d(TAG, "Reactive call from button: ");
                    }
                });

        final EditText name = (EditText) findViewById(R.id.editRX);
        Subscription editTextSub =
                RxTextView.textChanges(name)
                        .subscribe(new Action1<CharSequence>() {
                            @Override
                            public void call(CharSequence charSequence) {
                                Log.d(TAG, "React to text change");
                            }
                        });
    }
}
