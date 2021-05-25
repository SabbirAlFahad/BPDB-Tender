package com.itbl.bpdbtender;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ProjectNameView3 extends AppCompatActivity {

    ProjectNameAdapter3 projectNameAdapter3;
    ListView listView;
    ArrayList<ProjectNameList3> projectNameLists3=new ArrayList<>();
    TextView header;
    EditText inputSearch;
    SharedPreferences sharedPreferences;
    String strLoction="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_project_name_list3);
        listView = findViewById(R.id.table_contractlist);
        inputSearch = findViewById(R.id.search_tname);


        header = findViewById(R.id.header);
//        header.setTypeface(ResourcesCompat.getFont(this, R.font.aldrich));
//         json_string = getIntent().getExtras().getString("json_data");

        sharedPreferences = getSharedPreferences("project_NAME", Context.MODE_PRIVATE);
        strLoction = sharedPreferences.getString("PROJECT_NAME", "");
        inputSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text
                //Supplier.this.adapter.getFilter().filter(inputSearch.getText().toString());
                String text = inputSearch.getText().toString().toLowerCase(Locale.getDefault());
                projectNameAdapter3.getFilter().filter(text);

            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
            }
        });


        Display task = new Display(ProjectNameView3.this);
        task.execute();

//
    }

    public class Display extends AsyncTask<Void, Void, String> {
        @SuppressWarnings("unused")
        private Activity context;

        @SuppressWarnings("unused")
        ProgressDialog pd=null;

        public Display(Activity context){
            this.context = context;
        }

        @Override
        protected void onPreExecute(){
            pd = ProgressDialog.show(ProjectNameView3.this, " Processing",
                    "Please wait...");
        }

        @Override
        protected String doInBackground(Void... params){
            final List<Pair<String, String>> postParameters = new ArrayList<>();
            postParameters.add(new Pair("strLocation", strLoction));
            String result = "";

            try{

                int count = 0;

                String projectName,projectId;

                try {
                    String response = CustomHttpClientGet.execute(" ");
                    result = response.toString();
                    //result=result.replaceAll("[^a-zA-Z0-9]+","");

                } catch (Exception e) {
                    Log.e("log_tag", "Error in http connection!!" + e.toString());
                }

                JSONArray jsonArray = new JSONArray(result.toString());

                while (count < jsonArray.length()){

                    JSONObject JO = jsonArray.getJSONObject(count);


                    projectName = JO.getString("project_NAME");
                    projectId = JO.getString("project_ID");

                    ProjectNameList3 ProjectNameList3 = new ProjectNameList3(projectName,projectId);
                    projectNameLists3.add(ProjectNameList3);
                    count++;
                }
            }

            catch (Exception e) {
                Log.e("log_tag", "Error in http connection!!" + e.toString());
            }

            return result;
        }




        @Override
        protected void onPostExecute(String result) {
            pd.dismiss();

            projectNameAdapter3 =new ProjectNameAdapter3(ProjectNameView3.this,projectNameLists3);
            listView.setAdapter(projectNameAdapter3);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(ProjectNameView3.this, ContractListView.class);
                    intent.putExtra("projID",projectNameLists3.get(position).getProjectId());
                    startActivity(intent);

                }
            });
        }
    }

}
