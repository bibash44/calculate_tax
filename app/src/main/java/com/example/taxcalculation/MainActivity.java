package com.example.taxcalculation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText salary;
    Button calculate;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        salary = findViewById(R.id.txt_salary);
        calculate = findViewById(R.id.btn_calculate);
        result = findViewById(R.id.txt_result);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Double monthly_salary = Double.parseDouble(salary.getText().toString());

                if (monthly_salary >= 1.0 || monthly_salary < 200000.0) {
                    Double tax = first_tax(monthly_salary);
                    result.setText("Your tax amount is "+tax);
                }

                if (monthly_salary >= 200000.0 || monthly_salary < 350000.0) {
                    Double tax = second_tax(monthly_salary);
                    result.setText("Your tax amount is "+tax);

                }

                if (monthly_salary >= 350000.0) {
                    Double tax = third_tax(monthly_salary);
                    result.setText("Your tax amount is "+tax);
                }
            }
        });

    }

    /*Calculation of tax for salary 1 to 200000*/
    public  Double first_tax(Double salary) {

        Double tax_paid =  (1.0/100.0) * salary;
        Log.d("1", tax_paid.toString());
        return tax_paid;
    }

    /*Calculation of tax for salary 200000 to 350000*/
    public  Double second_tax(Double salary) {
        Double first_tax = (1.0/100)* 200000.0;

        Double remaning_salary = salary - 200000.0;

        Double remaning_tax = (15.0/100.0) * remaning_salary;

        Double total_tax = first_tax + remaning_tax;

        Log.d("2", total_tax.toString());

        return total_tax;
    }

    /*Calculation of tax for salary more than 350000*/

    public  Double third_tax(Double salary) {
        Double first_tax = (1.0/100.0)*200000.0;

        Double next_tax = (15.0/100.0) * 150000.0;

        Double remaning_salary = salary - (150000.0+200000.0);

        Double remaning_tax = (25.0/100.0) * remaning_salary;

        Double total_tax = first_tax + next_tax + remaning_tax;

        Log.d("3", total_tax.toString());

        return total_tax;
    }
}
