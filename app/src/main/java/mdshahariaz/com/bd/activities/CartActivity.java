package mdshahariaz.com.bd.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;

import mdshahariaz.com.bd.R;
import mdshahariaz.com.bd.adapters.CartAdapter;
import mdshahariaz.com.bd.databinding.ActivityCartBinding;
import mdshahariaz.com.bd.model.Product;

public class CartActivity extends AppCompatActivity {

    ActivityCartBinding binding;
    CartAdapter adapter;
    ArrayList<Product>products;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        products = new ArrayList<>();

        products.add(new Product("P1","---","",45,45,45,1));

        adapter = new CartAdapter(this,products);

        binding.cartList.setLayoutManager(new LinearLayoutManager(this));
        binding.cartList.setAdapter(adapter);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }
}