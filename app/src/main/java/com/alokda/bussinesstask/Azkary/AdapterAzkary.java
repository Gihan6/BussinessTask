package com.alokda.bussinesstask.Azkary;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.alokda.bussinesstask.Model.AzkaryModel;
import com.alokda.bussinesstask.R;

import java.util.List;


public class AdapterAzkary extends RecyclerView.Adapter<AdapterAzkary.RecycleViewHolder> {
    public static int position = 0;
    List<AzkaryModel> mList;
    Context context;

    public AdapterAzkary(List<AzkaryModel> mList, Context context) {
        this.mList = mList;
        this.context = context;

    }

    @NonNull
    @Override
    public RecycleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_layout_azkary, viewGroup, false);
        return new RecycleViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull RecycleViewHolder holder, int position) {

        AzkaryModel model = mList.get(position);
        if (model.getTitle() != null && !model.getTitle().equals("")) {
            holder.tv_title.setText(model.getTitle());
        } else {
            holder.tv_title.setVisibility(View.GONE);
        }
        if (model.getDesc() != null && !model.getDesc().equals("")) {
            holder.tv_desc.setText(model.getDesc());
        } else {
            holder.tv_desc.setVisibility(View.GONE);
        }
        if (model.getUseful() != null && !model.getUseful().equals("")) {
            holder.tv_useful.setText(model.getUseful());
        } else {
            holder.tv_useful.setVisibility(View.GONE);
        }
        holder.btn_count.setText(String.valueOf(model.getCount()));

    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class RecycleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tv_title, tv_desc, tv_useful;
        Button btn_count;

        public RecycleViewHolder(View view) {
            super(view);
            view.setOnClickListener(this);

            tv_title = (TextView) view.findViewById(R.id.tv_title);
            tv_desc = (TextView) view.findViewById(R.id.tv_description);
            tv_useful = (TextView) view.findViewById(R.id.tv_useful);
            btn_count = (Button) view.findViewById(R.id.btn_count);
            btn_count.setOnClickListener(this);


        }

        @SuppressLint("ResourceAsColor")
        private void count() {
            int x = Integer.valueOf(btn_count.getText().toString());
            if (x > 0) {
                x--;
            }
            if (x == 0) {
                btn_count.setBackgroundColor(R.color.red);
            }
            btn_count.setText(String.valueOf(x));
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_count:
                    count();
                    break;
                default:
                    break;
            }


        }
    }


}
