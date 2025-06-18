package dev.rabiulhassan.explore_llms.adapter;

import android.content.Context;
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

import dev.rabiulhassan.explore_llms.R;
import dev.rabiulhassan.explore_llms.model.LLM;

import java.util.ArrayList;
import java.util.List;

public class LLMAdapter extends RecyclerView.Adapter<LLMAdapter.ViewHolder> implements Filterable {

    private Context context;
    private List<LLM> llmList;
    private List<LLM> llmListFull; // For filtering

    public LLMAdapter(Context context, List<LLM> llmList) {
        this.context = context;
        this.llmList = llmList;
        this.llmListFull = new ArrayList<>(llmList);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView llmImage;
        TextView llmName;
        TextView llmReleaseDate;
        TextView llmDescription;
        Button readMoreButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            llmImage = itemView.findViewById(R.id.llm_image);
            llmName = itemView.findViewById(R.id.llm_name);
            llmReleaseDate = itemView.findViewById(R.id.llm_date);
            llmDescription = itemView.findViewById(R.id.llm_description);
            readMoreButton = itemView.findViewById(R.id.btn_read_more);
        }
    }

    @NonNull
    @Override
    public LLMAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_llm, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LLMAdapter.ViewHolder holder, int position) {
        LLM currentLLM = llmList.get(position);
        holder.llmName.setText(currentLLM.getName());
        holder.llmReleaseDate.setText(currentLLM.getReleaseDate());
        holder.llmDescription.setText(currentLLM.getDescription());
        holder.llmImage.setImageResource(currentLLM.getImageResourceId());

        // You can add click listener on readMoreButton here if needed
        holder.readMoreButton.setOnClickListener(v -> {
            // Handle Read More click
            // For example, start a detail activity or show dialog
        });
    }

    @Override
    public int getItemCount() {
        return llmList.size();
    }

    @Override
    public Filter getFilter() {
        return llmFilter;
    }

    private final Filter llmFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<LLM> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(llmListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (LLM llm : llmListFull) {
                    if (llm.getName().toLowerCase().contains(filterPattern)) {
                        filteredList.add(llm);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            llmList.clear();
            //noinspection unchecked
            llmList.addAll((List<LLM>) results.values);
            notifyDataSetChanged();
        }
    };
}
