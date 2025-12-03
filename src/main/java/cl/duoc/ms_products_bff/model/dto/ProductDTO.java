package cl.duoc.ms_products_bff.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProductDTO {
     @JsonProperty(value = "product_id")
        private String idProduct;

    @JsonProperty(value = "nombre")
        private String productName;

    @JsonProperty(value = "descripcion")
        private String descripcion;

    @JsonProperty(value = "precio")
        private int price;

    @JsonProperty(value = "stock")
        private int stock;

    @JsonProperty(value = "categoria_id")
        private String categoriaId;

    @JsonProperty(value = "imagen")
        private String imagen;

    @JsonProperty(value = "personalizable")
        private boolean personalizable;

    @JsonProperty(value = "max_msg_chars")
        private int maxMsgChars;

    @JsonProperty(value = "tipo_forma")
        private String tipoForma;

    @JsonProperty(value = "tamanos_disponibles")
        private String tamanosDisponibles;

    @JsonProperty(value = "code")
        private String code;
}
