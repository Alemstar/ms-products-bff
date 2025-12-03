package cl.duoc.ms_products_bff.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import cl.duoc.ms_products_bff.clients.ProductBsFeingClient;
import cl.duoc.ms_products_bff.model.dto.ProductDTO;
import feign.FeignException;

@Service
public class ProductService {
@Autowired
    ProductBsFeingClient productBsFeingClient;

    public ResponseEntity<?> getProductById(String idProduct){
        try {
            return productBsFeingClient.getProductById(idProduct);
        } catch (FeignException feignException){
            return ResponseEntity.status(feignException.status()).body(feignException.contentUTF8());
            }   
    }
    
    public ResponseEntity<List<ProductDTO>> selectAllProduct(){
        List<ProductDTO> listProductDTO = productBsFeingClient.selectAllProduct().getBody();

        return (listProductDTO != null)? new ResponseEntity<>(listProductDTO, HttpStatus.OK):
                                         new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<String> insertProduct(ProductDTO productDTO){
        return productBsFeingClient.insertProduct(productDTO);
    }

    public ResponseEntity<String> deleteProduct(String idProduct){
        return productBsFeingClient.deleteProduct(idProduct);
    }

    public ResponseEntity<String> updateProduct(ProductDTO productDTO){
        return productBsFeingClient.updateProduct(productDTO);
    }
}
