package com.example.yandex_predictor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;

    private static String P_KEY = "pdct.1.1.20200428T151204Z.4857af8742d76958.936d02a9586d70d094806c8f970539ac04957a4d";
    private  static  String P_LANG = "en";
    private static String P_URL = "https://predictor.yandex.net/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText1);
        textView = (TextView) findViewById(R.id.textView1);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                getPredictorText();

            }
        });
    }

    void getPredictorText(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(P_URL)
                .addConverterFactory(GsonConverterFactory
                        .create()).build();

        RestApi restApi = retrofit.create(RestApi.class);
        Call<ModelJSON> call = restApi.getword(P_KEY,editText.getText().toString(),P_LANG);
        call.enqueue(new Callback<ModelJSON>() {
            @Override
            public void onResponse(Call<ModelJSON> call, Response<ModelJSON> response) {
                if(response.code() == 200){
                    String resultText = response.body().getText().get(0);
                    textView.setText(resultText);
                }else {Log.e("code",Integer.toString(response.code()));}
            }

            @Override
            public void onFailure(Call<ModelJSON> call, Throwable t) {

            }
        });
    }
}
