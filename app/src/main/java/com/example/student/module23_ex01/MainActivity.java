package com.example.student.module23_ex01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText emp_name,emp_id,emp_gender;
    private Button button_inputEmp,button_remove;
    private RadioGroup groupGender;
    private RadioButton radioButtonFemale,radioButtonMale;
    private ArrayList<Employee> myList = null;
    private MyArrayAdapter adapter = null;
    private ListView lvEmployee = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emp_name = findViewById(R.id.emp_name);
        emp_id = findViewById(R.id.emp_id);
        groupGender = findViewById(R.id.groupGender);
        lvEmployee = findViewById(R.id.my_listView);
        myList = new ArrayList<>();
        adapter = new MyArrayAdapter(this,R.layout.my_item_layout,myList);
        lvEmployee.setAdapter(adapter);
        button_inputEmp = findViewById(R.id.button_inputEmp);
        button_remove = findViewById(R.id.button_remove);
        button_inputEmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputEmp();
            }
        });
        button_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteEmp();
            }
        });

    }
    public void inputEmp(){
        String id = emp_id.getText()+"";
        String name = emp_name.getText()+"";
        boolean gender = false;
        if(groupGender.getCheckedRadioButtonId() == R.id.radio_male){
            gender = true;
        }
        Employee emp = new Employee();
        emp.setId(id);
        emp.setName(name);
        emp.setGender(gender);
        myList.add(emp);
        adapter.notifyDataSetChanged();
        emp_id.setText("");
        emp_name.setText("");
        emp_id.requestFocus();
    }
    public void deleteEmp(){
        for(int i = lvEmployee.getChildCount()-1; i>=0; i--){
            View view = lvEmployee.getChildAt(i);
            CheckBox checkBox = findViewById(R.id.check_item);
            if(checkBox.isChecked()){
                myList.remove(i);
            }
        }
        adapter.notifyDataSetChanged();
    }
}
