package dev.rabiulhassan.explore_llms;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import dev.rabiulhassan.explore_llms.adapter.LLMAdapter;
import dev.rabiulhassan.explore_llms.model.LLM;
import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private LLMAdapter adapter;
    private List<LLM> llmList;    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(R.layout.activity_list);

            recyclerView = findViewById(R.id.recycler_view);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            initializeLLMList();
            adapter = new LLMAdapter(this, llmList);
            recyclerView.setAdapter(adapter);
        } catch (Exception e) {
            Log.e("ListActivity", "Error in onCreate", e);
            finish();
        }
    }    private void initializeLLMList() {
        llmList = new ArrayList<>();
        llmList.add(new LLM(
            getString(R.string.chatgpt_name),
            getString(R.string.chatgpt_description),
            R.drawable.img_chatgpt
        ));
        llmList.add(new LLM(
            getString(R.string.gemini_name),
            getString(R.string.gemini_description),
            R.drawable.img_gemini
        ));
        llmList.add(new LLM(
            getString(R.string.claude_name),
            getString(R.string.claude_description),
            R.drawable.img_claude
        ));
        llmList.add(new LLM(
            getString(R.string.tongyi_name),
            getString(R.string.tongyi_description),
            R.drawable.img_tongyi
        ));
        llmList.add(new LLM(
            getString(R.string.tigerllm_name),
            getString(R.string.tigerllm_description),
            R.drawable.img_tiger
        ));
    }
}
