package com.itbl.bpdbtender;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ProjectDetailAdapter extends ArrayAdapter<ProjectDetail> {

    private List<ProjectDetail> list;

    private LayoutInflater inflator;


    public ProjectDetailAdapter(Activity context, List<ProjectDetail> list) {
        super(context, R.layout.row_project_details, list);
        this.list = list;
        inflator = context.getLayoutInflater();

    }







    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ProjectDetailAdapter.ProjectDetailHolder ProjectDetailHolder;

        if(convertView == null){

            //row = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView= inflator.inflate(R.layout.row_project_details,null);
            ProjectDetailHolder = new ProjectDetailAdapter.ProjectDetailHolder();

            ProjectDetailHolder.tx_ref_date = (TextView)convertView.findViewById(R.id.ref_date);
            ProjectDetailHolder.tx_cntr_type= (TextView)convertView.findViewById(R.id.cntr_type);
            ProjectDetailHolder.tx_opening_date = (TextView)convertView.findViewById(R.id.opening);
            ProjectDetailHolder.tx_pkj_no= (TextView)convertView.findViewById(R.id.package_no);
            ProjectDetailHolder.tx_location= (TextView)convertView.findViewById(R.id.location);
            ProjectDetailHolder.tx_fc_curr= (TextView)convertView.findViewById(R.id.fcurr_code);
            ProjectDetailHolder.tx_pkg_name= (TextView)convertView.findViewById(R.id.package_name);
            ProjectDetailHolder.tx_ref_no = (TextView)convertView.findViewById(R.id.ref_no);
            ProjectDetailHolder.tx_currency_name= (TextView)convertView.findViewById(R.id.curr_name);
            ProjectDetailHolder.tx_closing_date = (TextView)convertView.findViewById(R.id.closing);
            ProjectDetailHolder.tx_pkj_id= (TextView)convertView.findViewById(R.id.package_id);


            convertView.setTag(ProjectDetailHolder);


            convertView.setTag(R.id.ref_date, ProjectDetailHolder.tx_ref_date);
            convertView.setTag(R.id.cntr_type, ProjectDetailHolder.tx_cntr_type);
            convertView.setTag(R.id.opening, ProjectDetailHolder.tx_opening_date);
            convertView.setTag(R.id.package_no, ProjectDetailHolder.tx_pkj_no);
            convertView.setTag(R.id.location, ProjectDetailHolder.tx_location);
            convertView.setTag(R.id.fcurr_code, ProjectDetailHolder.tx_fc_curr);
            convertView.setTag(R.id.package_name, ProjectDetailHolder.tx_pkg_name);
            convertView.setTag(R.id.ref_no, ProjectDetailHolder.tx_ref_no);
            convertView.setTag(R.id.curr_name, ProjectDetailHolder.tx_currency_name);
            convertView.setTag(R.id.closing, ProjectDetailHolder.tx_closing_date);
            convertView.setTag(R.id.package_id, ProjectDetailHolder.tx_pkj_id);


        }

        else{
            ProjectDetailHolder = (ProjectDetailAdapter.ProjectDetailHolder)convertView.getTag();

        }
        ProjectDetailHolder.tx_ref_date.setText(list.get(position).getRef_date());
        ProjectDetailHolder.tx_cntr_type.setText(list.get(position).getCntr_code());
        ProjectDetailHolder.tx_opening_date.setText(list.get(position).getOpening_date());
        ProjectDetailHolder.tx_pkj_no.setText(list.get(position).getPkg_no());
        ProjectDetailHolder.tx_location.setText(list.get(position).getLocation());
        ProjectDetailHolder.tx_fc_curr.setText(list.get(position).getFc_curr());
        ProjectDetailHolder.tx_pkg_name.setText(list.get(position).getPkgName());
        ProjectDetailHolder.tx_ref_no.setText(list.get(position).getRef_no());
        ProjectDetailHolder.tx_currency_name.setText(list.get(position).getCurr_name());
        ProjectDetailHolder.tx_closing_date.setText(list.get(position).getClosing_date());
        ProjectDetailHolder.tx_pkj_id.setText(list.get(position).getPkj_id());




        return convertView;

    }



    static class ProjectDetailHolder{
        protected static TextView tx_ref_date;
        protected static TextView tx_cntr_type;
        protected static TextView tx_opening_date;
        protected static TextView tx_pkj_no;
        protected static TextView tx_location;
        protected static TextView tx_fc_curr;
        protected static TextView tx_pkg_name;
        protected static TextView tx_ref_no;
        protected static TextView tx_currency_name;
        protected static TextView tx_closing_date;
        protected static TextView tx_pkj_id;
    }
}
