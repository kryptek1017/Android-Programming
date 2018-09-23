package kryptek1017.homework2_gpacalc;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText grade_1;
    EditText grade_2;
    EditText grade_3;
    EditText grade_4;
    EditText grade_5;
    TextView gpa_result;
    Button button;
    ConstraintLayout background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grade_1=(EditText) findViewById(R.id.grade_1);
        grade_2=(EditText) findViewById(R.id.grade_2);
        grade_3=(EditText) findViewById(R.id.grade_3);
        grade_4=(EditText) findViewById(R.id.grade_4);
        grade_5=(EditText) findViewById(R.id.grade_5);
        gpa_result=(TextView) findViewById(R.id.gpa_result);
        background=(ConstraintLayout) findViewById(R.id.background);
        button=(Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (grade_1.getText().length()==0 && grade_2.getText().length()==0 &&
                        grade_3.getText().length()==0 && grade_4.getText().length()== 0
                        && grade_5.getText().length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please enter grades to calculate GPA", Toast.LENGTH_LONG).show();
                } else {
                    double gpa = calcGPA(grade_1.getText().toString(), grade_2.getText().toString(),
                            grade_3.getText().toString(), grade_4.getText().toString(), grade_5.getText().toString());
                    gpa_result.setText(String.valueOf(gpa));

                    setBackground(gpa);
                    grade_1.getText().clear();
                    grade_2.getText().clear();
                    grade_3.getText().clear();
                    grade_4.getText().clear();
                    grade_5.getText().clear();

                }
            }

        });
    }

    private double calcGPA(String grade1, String grade2, String grade3, String grade4, String grade5) {
        return ((Double.valueOf(grade1) + Double.valueOf(grade2)  + Double.valueOf(grade3)
                + Double.valueOf(grade4) + Double.valueOf(grade5)) / 5);
    }

    private void setBackground (double gpa) {
        if (gpa <= 60) {
            background.setBackgroundColor(Color.RED);

        }else if (gpa >60 && gpa <80 ) {
            background.setBackgroundColor(Color.YELLOW);
        } else{
            background.setBackgroundColor(Color.GREEN);
        }
    }
}
