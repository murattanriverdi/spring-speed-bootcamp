package com.murattanriverdi.orm.presentation.client;

import com.murattanriverdi.orm.business.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class CommerceClient {

    @Autowired
    private  ProductClient productClient;

    @GetMapping("/product/get")
    @ResponseBody
    public String getProduct() {

        long productId = 303;
        //Product product =  new Product(productId, "Cep Telefonu", 1450);
        //Rest Client => Rest Service Controller içinde  çağırıp onu rest client gibi davranıp test etmiş olduk
        //String url = "http://localhost:8080/api/product/" + productId;
       // RestTemplate restTemplate = new RestTemplate();
        ProductDto productDto =productClient.getProduct(productId);
        System.out.println("Ürün :" + productDto.getProductName());
        return "Edinme Başarılı! => Ürün: " + productDto.getProductName() +" "+productDto.getSalesPrice();
    }

    @GetMapping("/product/post")
    @ResponseBody
    public String postProduct() {
        ProductDto product = new ProductDto(0, "Fritöz", 645);
        String url = "http://localhost:8080/api/product/";
        RestTemplate restTemplate = new RestTemplate();
        ProductDto result = restTemplate.postForObject(url, product, ProductDto.class);
        return "Yollama Başarılı! => "+ result.getProductId();

    }

    @GetMapping("/product/put")
    @ResponseBody
    public String putProduct() {
        ProductDto productDto = new ProductDto(302, "Bulaşık Makinesi", 7000);
        String url = "http://localhost:8080/api/product/";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.exchange(url, HttpMethod.PUT, new HttpEntity<ProductDto>(productDto),Void.class);
        return "Güncelleme Başarılı";

    }

    @GetMapping("/product/delete")
    @ResponseBody
    public String deleteProduct() {
        long productId=303;
        String url = "http://localhost:8080/api/product/"+productId;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(url);
        return "Silme Başarılı";

    }

}
