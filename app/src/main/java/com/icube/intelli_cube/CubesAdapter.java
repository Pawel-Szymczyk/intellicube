package com.icube.intelli_cube;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.icube.intelli_cube.sqlite.database.model.Cube;

import java.util.List;

public class CubesAdapter extends RecyclerView.Adapter<CubesAdapter.MyViewHolder {

    private Context context;
    private List<Cube> cubesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        // TODO: chnage it to menu context...
//        public TextView cube;
//        public TextView timestamp;

        public MyViewHolder(View view) {
            super(view);
//            cube = view.findViewById(R.id.cu)
        }
    }































}
