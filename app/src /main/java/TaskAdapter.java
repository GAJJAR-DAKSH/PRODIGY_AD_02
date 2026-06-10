package com.example.prodigy_ad_02;

import android.app.AlertDialog;
import android.content.Context;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.*;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {

    Context context;
    ArrayList<String> tasks;

    public TaskAdapter(Context context, ArrayList<String> tasks) {
        this.context = context;
        this.tasks = tasks;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.activity_item_task,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.txtTask.setText(tasks.get(position));

        holder.btnDelete.setOnClickListener(v -> {
            tasks.remove(position);
            notifyDataSetChanged();
        });

        holder.btnEdit.setOnClickListener(v -> {

            EditText editText = new EditText(context);
            editText.setText(tasks.get(position));

            new AlertDialog.Builder(context)
                    .setTitle("Edit Task")
                    .setView(editText)
                    .setPositiveButton("Save",(d,w)->{
                        tasks.set(position,
                                editText.getText().toString());
                        notifyDataSetChanged();
                    })
                    .setNegativeButton("Cancel",null)
                    .show();
        });
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtTask;
        Button btnEdit,btnDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtTask = itemView.findViewById(R.id.txtTask);
            btnEdit = itemView.findViewById(R.id.btnEdit);
            btnDelete = itemView.findViewById(R.id.btnDelete);
        }
    }
}
