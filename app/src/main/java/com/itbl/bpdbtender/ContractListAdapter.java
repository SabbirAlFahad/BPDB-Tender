package com.itbl.bpdbtender;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ContractListAdapter extends ArrayAdapter <ContractList> {
    private List<ContractList> list;

    private LayoutInflater inflator;


    public ContractListAdapter(Activity context, List<ContractList> list) {
        super(context, R.layout.row_contractinfo, list);
        this.list = list;
        inflator = context.getLayoutInflater();

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ContractListAdapter.ContractDetailHolder contractDetailHolder;

        if(convertView == null){
            
            convertView= inflator.inflate(R.layout.row_contractinfo,null);
            contractDetailHolder = new ContractListAdapter.ContractDetailHolder();

            contractDetailHolder.contract_currType = (TextView)convertView.findViewById(R.id.contract_currType);
            contractDetailHolder.contract_price= (TextView)convertView.findViewById(R.id.contract_price);
            contractDetailHolder.contract_value = (TextView)convertView.findViewById(R.id.contract_value);
            contractDetailHolder.contract_No= (TextView)convertView.findViewById(R.id.contract_No);
            contractDetailHolder.contract_issueD= (TextView)convertView.findViewById(R.id.contract_issueD);
            contractDetailHolder.contract_type= (TextView)convertView.findViewById(R.id.contract_type);
            contractDetailHolder.contract_pkgDetails= (TextView)convertView.findViewById(R.id.contract_pkgDetails);
            contractDetailHolder.contract_bankName = (TextView)convertView.findViewById(R.id.contract_bankName);
            contractDetailHolder.contract_RefNo= (TextView)convertView.findViewById(R.id.contract_RefNo);
            contractDetailHolder.contract_suppName = (TextView)convertView.findViewById(R.id.contract_suppName);
            contractDetailHolder.contract_securityInfo= (TextView)convertView.findViewById(R.id.contract_securityInfo);
            contractDetailHolder.contract_Date= (TextView)convertView.findViewById(R.id.contract_Date);
            contractDetailHolder.contract_branchName= (TextView)convertView.findViewById(R.id.contract_branchName);
            contractDetailHolder.contract_expiryD= (TextView)convertView.findViewById(R.id.contract_expiryD);


            convertView.setTag(contractDetailHolder);


            convertView.setTag(R.id.contract_currType, contractDetailHolder.contract_currType);
            convertView.setTag(R.id.contract_price, contractDetailHolder.contract_price);
            convertView.setTag(R.id.contract_value, contractDetailHolder.contract_value);
            convertView.setTag(R.id.contract_No, contractDetailHolder.contract_No);
            convertView.setTag(R.id.contract_issueD, contractDetailHolder.contract_issueD);
            convertView.setTag(R.id.contract_type, contractDetailHolder.contract_type);
            convertView.setTag(R.id.contract_bankName, contractDetailHolder.contract_bankName);
            convertView.setTag(R.id.contract_pkgDetails, contractDetailHolder.contract_pkgDetails);
            convertView.setTag(R.id.contract_RefNo, contractDetailHolder.contract_RefNo);
            convertView.setTag(R.id.contract_suppName, contractDetailHolder.contract_suppName);
            convertView.setTag(R.id.contract_securityInfo, contractDetailHolder.contract_securityInfo);
            convertView.setTag(R.id.contract_Date, contractDetailHolder.contract_Date);
            convertView.setTag(R.id.contract_branchName, contractDetailHolder.contract_branchName);
            convertView.setTag(R.id.contract_expiryD, contractDetailHolder.contract_expiryD);


        }

        else{
            contractDetailHolder = (ContractListAdapter.ContractDetailHolder)convertView.getTag();

        }
        contractDetailHolder.contract_currType.setText(list.get(position).getContract_currType());
        contractDetailHolder.contract_price.setText(list.get(position).getContract_price());
        contractDetailHolder.contract_value.setText(list.get(position).getContract_value());
        contractDetailHolder.contract_No.setText(list.get(position).getContract_No());
        contractDetailHolder.contract_issueD.setText(list.get(position).getContract_issueD());
        contractDetailHolder.contract_type.setText(list.get(position).getContract_type());
        contractDetailHolder.contract_pkgDetails.setText(list.get(position).getContract_pkgDetails());
        contractDetailHolder.contract_bankName.setText(list.get(position).getContract_bankName());
        contractDetailHolder.contract_RefNo.setText(list.get(position).getContract_RefNo());
        contractDetailHolder.contract_suppName.setText(list.get(position).getContract_suppName());
        contractDetailHolder.contract_securityInfo.setText(list.get(position).getContract_securityInfo());
        contractDetailHolder.contract_Date.setText(list.get(position).getContract_Date());
        contractDetailHolder.contract_branchName.setText(list.get(position).getContract_branchName());
        contractDetailHolder.contract_expiryD.setText(list.get(position).getContract_expiryD());

        return convertView;

    }


    static class ContractDetailHolder{
        protected static TextView contract_currType;
        protected static TextView contract_issueD;
        protected static TextView contract_type;
        protected static TextView contract_Date;
        protected static TextView contract_price;
        protected static TextView contract_suppName;
        protected static TextView contract_pkgDetails;
        protected static TextView contract_bankName;
        protected static TextView contract_RefNo;
        protected static TextView contract_securityInfo;
        protected static TextView contract_No;
        protected static TextView contract_value;
        protected static TextView contract_branchName;
        protected static TextView contract_expiryD;
    }
}
