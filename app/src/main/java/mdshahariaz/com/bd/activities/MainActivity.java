package mdshahariaz.com.bd.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import mdshahariaz.com.bd.adapters.CategoryAdapter;
import mdshahariaz.com.bd.adapters.ProductAdapter;
import mdshahariaz.com.bd.databinding.ActivityMainBinding;
import mdshahariaz.com.bd.model.Category;
import mdshahariaz.com.bd.model.Product;
import mdshahariaz.com.bd.utils.Constants;

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
        initSlider();
        getRecentProducts();
    }

    private void initSlider() {
        binding.carousel.addData(new CarouselItem("https://www.shutterstock.com/image-vector/banner-best-offer-260nw-706166626.jpg","Offer"));
    }

    void initCategories(){
        categories=new ArrayList<>();

        categoryAdapter=new CategoryAdapter(this,categories);

        getCategories();

        GridLayoutManager layoutManager = new GridLayoutManager(this,4);
        binding.categoriesList.setLayoutManager(layoutManager);
        binding.categoriesList.setAdapter(categoryAdapter);
    }

    void getCategories(){
        RequestQueue queue = Volley.newRequestQueue(this);

        StringRequest request= new StringRequest(Request.Method.GET, Constants.GET_CATEGORIES_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject mainObj= new JSONObject(response);
                    if (mainObj.getString("status").equals("success")){

                        JSONArray categoriesArray =mainObj.getJSONArray("categories");

                        for(int i=0;i<categoriesArray.length();i++)
                        {
                            JSONObject object=categoriesArray.getJSONObject(i);
                            Category category=new Category(
                                    object.getString("name"),
                                    Constants.CATEGORIES_IMAGE_URL+object.getString("icon"),
                                    object.getString("color"),
                                    object.getString("brief"),
                                    object.getInt("id")
                            );
                            categories.add(category);
                        }
                        categoryAdapter.notifyDataSetChanged();
                    }else {
                        //Do Nothing
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue.add(request);
    }

    void getRecentProducts(){
        RequestQueue queue=Volley.newRequestQueue(this);

        String url= Constants.GET_PRODUCTS_URL+"?count=8";
        StringRequest request=new StringRequest(Request.Method.GET, url, response -> {
            try {
                JSONObject object=new JSONObject(response);
                if (object.getString("status").equals("success")){
                    JSONArray productsArray= object.getJSONArray("products");
                    for (int i=0;i<productsArray.length();i++){
                        JSONObject childObj = productsArray.getJSONObject(i);
                        Product product=new Product(
                                childObj.getString("name"),
                                Constants.PRODUCTS_IMAGE_URL+childObj.getString("image"),
                                childObj.getString("status"),
                                childObj.getDouble("price"),
                                childObj.getDouble("price_discount"),
                                childObj.getInt("stock"),
                                childObj.getInt("id")

                        );
                        products.add(product);
                    }
                    productAdapter.notifyDataSetChanged();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }, error -> {

        });
        queue.add(request);
    }

    void initProducts(){
        products=new ArrayList<>();
        //products.add(new Product("Sports","https://cdn0.iconfinder.com/data/icons/stroke-ball-icons-2/633/02_Soccer-512.png","#FF0000",12,12,1,1));

        productAdapter=new ProductAdapter(this,products);

        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        binding.productlist.setLayoutManager(layoutManager);
        binding.productlist.setAdapter(productAdapter);
    }
}