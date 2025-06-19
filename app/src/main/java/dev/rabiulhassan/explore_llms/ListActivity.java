package dev.rabiulhassan.explore_llms;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

import dev.rabiulhassan.explore_llms.adapter.LLMAdapter;
import dev.rabiulhassan.explore_llms.model.LLM;

public class ListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LLMAdapter adapter;
    private List<LLM> llmList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(R.layout.activity_list);

            // Setup Toolbar
            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            // Setup RecyclerView
            recyclerView = findViewById(R.id.recycler_view);
            recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)); // 1 column for single layout
            initializeLLMList();

            adapter = new LLMAdapter(this, llmList);
            recyclerView.setAdapter(adapter);

            // Setup SearchView
            SearchView searchView = findViewById(R.id.search_view);
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    adapter.getFilter().filter(newText);
                    return true;
                }
            });

            // Check if list is empty
            if (llmList.isEmpty()) {
                Toast.makeText(this, "No LLMs available", Toast.LENGTH_SHORT).show();
            }

        } catch (Exception e) {
            Log.e("ListActivity", "Error in onCreate", e);
            finish();
        }
    }

    private void initializeLLMList() {
        llmList = new ArrayList<>();
        llmList.add(new LLM(
                getString(R.string.chatgpt_name),
                getString(R.string.chatgpt_description),
                "November 2022",
                R.drawable.img_chatgpt,
                R.drawable.banner_chatgpt
        ));
        llmList.add(new LLM(
                getString(R.string.gemini_name),
                getString(R.string.gemini_description),
                "December 2023",
                R.drawable.img_gemini,
                R.drawable.banner_gemini
        ));
        llmList.add(new LLM(
                getString(R.string.claude_name),
                getString(R.string.claude_description),
                "March 2023",
                R.drawable.img_claude,
                R.drawable.banner_claude
        ));
        llmList.add(new LLM(
                getString(R.string.tongyi_name),
                getString(R.string.tongyi_description),
                "April 2023",
                R.drawable.img_tongyi,
                R.drawable.banner_tongyi
        ));
        llmList.add(new LLM(
                getString(R.string.tigerllm_name),
                getString(R.string.tigerllm_description),
                "June 2024",
                R.drawable.img_tiger,
                R.drawable.banner_tigerllm
        ));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    // Optional menu handler
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_about) {
            Toast.makeText(this, "About clicked", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_settings) {
            Toast.makeText(this, "Settings clicked", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
