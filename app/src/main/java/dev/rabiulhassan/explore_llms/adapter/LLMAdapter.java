package dev.rabiulhassan.explore_llms.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import dev.rabiulhassan.explore_llms.DetailActivity;
import dev.rabiulhassan.explore_llms.R;
import dev.rabiulhassan.explore_llms.model.LLM;
import java.util.List;

public class LLMAdapter extends RecyclerView.Adapter<LLMAdapter.ViewHolder> {
    private List<LLM> llmList;
    private Context context;

    public LLMAdapter(Context context, List<LLM> llmList) {
        this.context = context;
        this.llmList = llmList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_llm, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LLM llm = llmList.get(position);
        holder.nameTextView.setText(llm.getName());
        holder.imageView.setImageResource(llm.getImageResourceId());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("llm_name", llm.getName());
            intent.putExtra("llm_description", llm.getDescription());
            intent.putExtra("llm_image", llm.getImageResourceId());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return llmList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView nameTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.llm_image);
            nameTextView = itemView.findViewById(R.id.llm_name);
        }
    }
}
