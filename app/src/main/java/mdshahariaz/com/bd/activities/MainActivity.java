package mdshahariaz.com.bd.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;

import mdshahariaz.com.bd.adapters.CategoryAdapter;
import mdshahariaz.com.bd.adapters.ProductAdapter;
import mdshahariaz.com.bd.databinding.ActivityMainBinding;
import mdshahariaz.com.bd.model.Category;
import mdshahariaz.com.bd.model.Product;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    CategoryAdapter categoryAdapter;
    ArrayList<Category> categories;

    ProductAdapter productAdapter;
    ArrayList<Product> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initCategories();
        initProducts();

    }

    void initCategories(){
        categories=new ArrayList<>();
        categories.add(new Category("Sports","https://cdn0.iconfinder.com/data/icons/stroke-ball-icons-2/633/02_Soccer-512.png","#FF0000","Details",1));
        categories.add(new Category("Electronics","https://cdn0.iconfinder.com/data/icons/stroke-ball-icons-2/633/02_Soccer-512.png","#00008B","Details",1));

        categoryAdapter=new CategoryAdapter(this,categories);

        GridLayoutManager layoutManager = new GridLayoutManager(this,4);
        binding.categoriesList.setLayoutManager(layoutManager);
        binding.categoriesList.setAdapter(categoryAdapter);
    }

    void initProducts(){
        products=new ArrayList<>();
        products.add(new Product("Sports","https://cdn0.iconfinder.com/data/icons/stroke-ball-icons-2/633/02_Soccer-512.png","#FF0000",12,12,1,1));

        productAdapter=new ProductAdapter(this,products);

        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        binding.productlist.setLayoutManager(layoutManager);
        binding.productlist.setAdapter(productAdapter);
    }
}