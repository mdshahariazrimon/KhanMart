package mdshahariaz.com.bd.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;

import mdshahariaz.com.bd.R;
import mdshahariaz.com.bd.adapters.CategoryAdapter;
import mdshahariaz.com.bd.databinding.ActivityMainBinding;
import mdshahariaz.com.bd.model.Category;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    CategoryAdapter categoryAdapter;
    ArrayList<Category> categories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        categories=new ArrayList<>();
        categories.add(new Category("Sports","https://www.flaticon.com/free-icon/sports_857455?term=sports&page=1&position=7&page=1&position=7&related_id=857455&origin=search","#FF0000","Description",1));
        categories.add(new Category("Sports","https://www.flaticon.com/free-icon/sports_857455?term=sports&page=1&position=7&page=1&position=7&related_id=857455&origin=search","#FF0000","Description",1));
        categories.add(new Category("Sports","https://www.flaticon.com/free-icon/sports_857455?term=sports&page=1&position=7&page=1&position=7&related_id=857455&origin=search","#FF0000","Description",1));
        categories.add(new Category("Sports","https://www.flaticon.com/free-icon/sports_857455?term=sports&page=1&position=7&page=1&position=7&related_id=857455&origin=search","#FF0000","Description",1));
        categories.add(new Category("Sports","https://www.flaticon.com/free-icon/sports_857455?term=sports&page=1&position=7&page=1&position=7&related_id=857455&origin=search","#FF0000","Description",1));
        categoryAdapter=new CategoryAdapter(this,categories);

        GridLayoutManager layoutManager = new GridLayoutManager(this,4);
        binding.categoriesList.setLayoutManager(layoutManager);
        binding.categoriesList.setAdapter(categoryAdapter);
        binding.categoriesList.setAdapter(categoryAdapter);
    }
}