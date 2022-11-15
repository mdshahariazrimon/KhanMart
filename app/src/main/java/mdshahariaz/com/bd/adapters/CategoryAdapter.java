package mdshahariaz.com.bd.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import mdshahariaz.com.bd.R;
import mdshahariaz.com.bd.databinding.ItemCategoriesBinding;
import mdshahariaz.com.bd.model.Category;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    Context context;
    ArrayList<Category>categories;

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CategoryViewHolder(LayoutInflater.from(context).inflate(R.layout.item_categories,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category category=categories.get(position);
        holder.binding.label.setText(category.getName());
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    //Create a subclass
    public class CategoryViewHolder extends RecyclerView.ViewHolder{
        //To enable view binding, go to gradle...
        //TO use view binding
        ItemCategoriesBinding binding;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ItemCategoriesBinding.bind(itemView);
        }
    }
}
