package com.bartech.sms.data.network.model;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bartech.sms.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ahmed on 7/4/2018.
 */

public class GetVisitsRecycler extends RecyclerView.Adapter<GetVisitsRecycler.RecyclerViewHolder> {
    private Context mContext;
    public List<SmsVisitsListResponse> getAllVisits;

    public GetVisitsRecycler(Context context, List<SmsVisitsListResponse> visitsListResponses) {
        mContext = context;
        getAllVisits = visitsListResponses;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.activity_visits_recycler_data,parent,false);
        return new RecyclerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(GetVisitsRecycler.RecyclerViewHolder holder, int position) {
        SmsVisitsListResponse currentItem = getAllVisits.get(position);
        String complaintNumber = String.valueOf(currentItem.getData());
        String deviceDate = String.valueOf(currentItem.getData());
        String technicianName = String.valueOf(currentItem.getData());
        holder.txtComplaintNumber.setText(complaintNumber);
        holder.txtDeviceDate.setText(deviceDate);
        holder.txtTechnicianName.setText(technicianName);
    }

    @Override
    public int getItemCount() {
        return getAllVisits.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.txt_complaint_number)
        TextView txtComplaintNumber;
        @BindView(R.id.txt_device_date)
        TextView txtDeviceDate;
        @BindView(R.id.txt_technician_name)
        TextView txtTechnicianName;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
