package com.mynet.yatota.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mynet.yatota.Model.DownloadModel;
import com.mynet.yatota.R;

import java.util.List;

public class DownloadAdapter extends RecyclerView.Adapter<DownloadAdapter.ViewHolder> {

    private List<DownloadModel> dataSet;
    private Context context;

    public DownloadAdapter(
            List<DownloadModel> dataSet, Context context) {
        this.dataSet = dataSet;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.download_items_layout, parent, false);
        return new ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder,
                                 final int position) {
        holder.No.setText(dataSet.get(position).getId());
        holder.dates.setText(dataSet.get(position).getComptime());
        holder.timeSd.setText(dataSet.get(position).getTimeserved());
        holder.atted.setText(dataSet.get(position).getAttendant());
        holder.gend.setText(dataSet.get(position).getCustomergender());
        holder.ag.setText(dataSet.get(position).getCustomerage());
        holder.servc.setText(dataSet.get(position).getServicetype());
        holder.amt.setText(dataSet.get(position).getAmount());
        holder.mcodes.setText(dataSet.get(position).getMpesacode());

    }


    @Override
    public int getItemCount() {
        return dataSet.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        TextView No,dates,timeSd,atted,gend,ag,servc,amt,mcodes;


        ViewHolder(final View itemView) {
            super(itemView);
            No = itemView.findViewById(R.id.item_number1);
            dates = itemView.findViewById(R.id.date12);
            timeSd = itemView.findViewById(R.id.time12);
            atted = itemView.findViewById(R.id.attendant12);
            gend = itemView.findViewById(R.id.customerG1);
            ag = itemView.findViewById(R.id.customerAge1);
            servc = itemView.findViewById(R.id.custService1);
            amt = itemView.findViewById(R.id.amount12);
            mcodes = itemView.findViewById(R.id.mpesacode12);

        }

    }



}
