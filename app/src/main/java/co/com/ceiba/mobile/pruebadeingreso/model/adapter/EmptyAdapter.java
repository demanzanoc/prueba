package co.com.ceiba.mobile.pruebadeingreso.model.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import co.com.ceiba.mobile.pruebadeingreso.R;

public class EmptyAdapter extends RecyclerView.Adapter<EmptyAdapter.EmtyViewHolder> {

    @NonNull
    @Override
    public EmptyAdapter.EmtyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.empty_view, parent, false);
        return new EmtyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmtyViewHolder holder, int position) {
        //Unnecesary
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public static class EmtyViewHolder extends RecyclerView.ViewHolder {

        public EmtyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
