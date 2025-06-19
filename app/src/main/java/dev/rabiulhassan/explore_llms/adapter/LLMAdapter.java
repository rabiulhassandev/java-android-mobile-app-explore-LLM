package dev.rabiulhassan.explore_llms.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import dev.rabiulhassan.explore_llms.DetailActivity;
import dev.rabiulhassan.explore_llms.R;
import dev.rabiulhassan.explore_llms.model.LLM;

import java.util.ArrayList;
import java.util.List;

public class LLMAdapter extends RecyclerView.Adapter<LLMAdapter.ViewHolder> implements Filterable {

    private Context context;
    private List<LLM> llmList;           // full original list
    private List<LLM> llmListFiltered;   // filtered list for displaying

    public LLMAdapter(Context context, List<LLM> llmList) {
        this.context = context;
        this.llmList = llmList;
        this.llmListFiltered = new ArrayList<>(llmList);
    }

    @NonNull
    @Override
    public LLMAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_llm, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LLMAdapter.ViewHolder holder, int position) {
        LLM llm = llmListFiltered.get(position);

        holder.llmName.setText(llm.getName());
        holder.llmDescription.setText(llm.getDescription());
        holder.llmReleaseDate.setText("Released: " + llm.getReleaseDate());
        holder.llmImage.setImageResource(llm.getImageResourceId());

        holder.readMoreButton.setOnClickListener(v -> {

            // Navigate to DetailActivity
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("llm_name", llm.getName());
            intent.putExtra("llm_description", llm.getDescription());
            intent.putExtra("llm_release_date", llm.getReleaseDate());
            intent.putExtra("llm_image", llm.getImageResourceId());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return llmListFiltered.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String query = constraint == null ? "" : constraint.toString().toLowerCase().trim();
                List<LLM> filtered = new ArrayList<>();

                if (query.isEmpty()) {
                    filtered.addAll(llmList);
                } else {
                    for (LLM llm : llmList) {
                        if (llm.getName().toLowerCase().contains(query)) {
                            filtered.add(llm);
                        }
                    }
                }

                FilterResults results = new FilterResults();
                results.values = filtered;
                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                llmListFiltered.clear();
                //noinspection unchecked
                llmListFiltered.addAll((List<LLM>) results.values);
                notifyDataSetChanged();
            }
        };
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView llmImage;
        TextView llmName, llmDescription, llmReleaseDate;
        Button readMoreButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            llmImage = itemView.findViewById(R.id.llm_image);
            llmName = itemView.findViewById(R.id.llm_name);
            llmDescription = itemView.findViewById(R.id.llm_description);
            llmReleaseDate = itemView.findViewById(R.id.llm_release_date);
            readMoreButton = itemView.findViewById(R.id.read_more_button);
        }
    }
}
