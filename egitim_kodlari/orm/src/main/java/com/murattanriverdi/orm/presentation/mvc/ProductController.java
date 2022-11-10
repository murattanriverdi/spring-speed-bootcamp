package com.murattanriverdi.orm.presentation.mvc;


import com.murattanriverdi.orm.data.entity.Product;
import com.murattanriverdi.orm.data.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
@RequestMapping("/inventory")
public class ProductController {

    //@Autowired
    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/product/insert")
    @ResponseBody
    public String insertProduct() {
        Product product = new Product();
        product.setProductName("Cep Telefonu");
        product.setSalesPrice(6570);
        productRepository.save(product);
        return "Kaydedildi : " + product.getProductId();
    }

    @GetMapping("/product/find")
    @ResponseBody
    public String findProduct() {
        long productId = 1;
        Optional<Product> productOpt = productRepository.findById(productId);
        if(productOpt.isPresent()){
            Product product = productOpt.get();
            System.out.println(product.getProductId() +" "+product.getProductName()+" "+product.getSalesPrice());
            return "Ürün Bulundu : "+product.getProductName();
        }
        return "Ürün Bulunamadı!";
    }

    @GetMapping("/product/list")
    @ResponseBody
    public String listProducts() {
        Iterable<Product> products = productRepository.findAll();
        int count = 0;
        for(Product product : products){
            System.out.println("Ürün :" + product.getProductId()+" "+product.getProductName()+" "+product.getSalesPrice());
            count ++;
        }
        return "Ürün sayısı : "+count;
    }

    @GetMapping("/product/delete")
    @ResponseBody
    public String deleteProduct() {
        long productId = 10;
        if(!productRepository.existsById(productId)){
            return "Ürün Bulunamadı! : "+ productId;
        }
        productRepository.deleteById(productId);
        return  "Ürün silindi! ";
    }

    @GetMapping("/product/expensives")
    @ResponseBody
    public String listExpensiceProducts() {
        double minPrice = 5001;
        Iterable<Product> products = productRepository.findAllBySalesPriceMin(minPrice);
        int count = 0;
        for(Product product : products){
            System.out.println("Ürün :" + product.getProductId()+" "+product.getProductName()+" "+product.getSalesPrice());
            count ++;
        }
        return "Ürün sayısı : "+count;
    }

}
