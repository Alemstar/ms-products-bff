package cl.duoc.ms_products_bff.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import cl.duoc.ms_products_bff.model.dto.ProductDTO;

@FeignClient(name = "ms-products-bs", url = "http://localhost:8281/api/products")
public interface ProductBsFeingClient {
    @GetMapping()
    public ResponseEntity<List<ProductDTO>> selectAllProduct();

    @GetMapping("/{idProduct}")
    public ResponseEntity<?> getProductById(@PathVariable(name = "idProduct") Long idProduct);

    @PostMapping()
    public ResponseEntity<String> insertProduct(@RequestBody ProductDTO productDTO);
    
    @DeleteMapping("/DeleteProductById/{idProduct}")
    public ResponseEntity<String> deleteProduct(@PathVariable(name = "idProduct") Long idProduct);

    @PutMapping("/UpdateProduct")
    public ResponseEntity<String> updateProduct(@RequestBody ProductDTO productDTO);

}
