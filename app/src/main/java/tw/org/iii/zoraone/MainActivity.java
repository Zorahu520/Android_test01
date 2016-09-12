package tw.org.iii.zoraone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private View guess;
    private EditText textNum;
    private TextView info;
    private String answer;
    private Button btnSmallLeft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        answer = createAnswer(3);

        textNum = (EditText) findViewById(R.id.textNum);
        info = (TextView) findViewById(R.id.infoSom);

        guess = findViewById(R.id.guess);
        guess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doGuess();
            }
        });

        btnSmallLeft = (Button) findViewById(R.id.btn1);
        btnSmallLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View b1) {
                doRestart();
            }
        });
    }

    public void doRestart(){
        btnSmallLeft.setText("");

    }

    public void doGuess(){
        String strtextNum = textNum.getText().toString();
        String result = checkAB(answer,strtextNum);
        info.append(strtextNum + ":" + result + "\n");
        textNum.setText("");

    }

    static String createAnswer(int n){
        //借用 poker的機制:
        // 洗牌
        int[] poker = new int[n];
        for (int i=0; i<poker.length; i++){
            int temp;
            // 檢查機制
            boolean isRepeat;
            do {
                temp = (int)(Math.random()*10);
                isRepeat = false;
                for (int j=0; j<i; j++){
                    if (temp == poker[j]){
                        isRepeat = true;
                        break;
                    }
                }
            }while(isRepeat);
            poker[i] = temp;
        }
        String ret = "";
        for (int p : poker)ret += p;

        return ret;
    }
    static String checkAB(String a, String g){
        int A, B; A = B = 0;
        for (int i=0; i<g.length(); i++){
            if (g.charAt(i) == a.charAt(i)){
                A++;
            }else if (a.indexOf(g.charAt(i))!=-1){
                B++;
            }
        }
        return A + "A" + B + "B";
    }


}
