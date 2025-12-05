package cl.duoc.ms_products_bff.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.ms_products_bff.model.dto.ProductDTO;
import cl.duoc.ms_products_bff.service.ProductService;
import feign.FeignException.FeignClientException;

@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:5174"})
@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    ProductService productService;
    
    @GetMapping()
    public ResponseEntity<List<ProductDTO>> selectAllProduct(){
        ResponseEntity<List<ProductDTO>> listProductDTO = productService.selectAllProduct();
        return listProductDTO;
    }

    @GetMapping("/GetProductByCode/{code}")
    public ResponseEntity<?> getProductByCode(@PathVariable("code") String code){
        return productService.getProductByCode(code);
    }
    
    @PostMapping("/insertProduct")
    public ResponseEntity<String> insertProduct(@RequestBody ProductDTO productDTO){
        try{
        return productService.insertProduct(productDTO);}
        catch(FeignClientException feignClientException){
            return ResponseEntity.status(feignClientException.status()).body(feignClientException.contentUTF8());
        }
    }

    @DeleteMapping("/DeleteProductByCode/{code}")
    public ResponseEntity<String> deleteProduct(@PathVariable("code") String code){
        try{
        return productService.deleteProduct(code);}
        catch(FeignClientException feignClientException){
            return ResponseEntity.status(feignClientException.status()).body(feignClientException.contentUTF8());
        }
    }

    @PutMapping("/UpdateProduct")
    public ResponseEntity<String> updateProduct(@RequestBody ProductDTO productDTO){
        try{
        return productService.updateProduct(productDTO);}
        catch(FeignClientException feignClientException){
            return ResponseEntity.status(feignClientException.status()).body(feignClientException.contentUTF8());
        }
    }
}
