
package com.senac.senac.dto;


import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.senac.senac.entity.Sale;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SaleDto {

    private Long id;
    private String userName;
    private Date date;
    private String productName;
    private String formmattedDate;
    private BigDecimal price;

    public SaleDto(Sale sale) {
        this.id = sale.getId();
        this.userName = sale.getUser().getId().toString();
        this.date = sale.getDate();
        this.productName = sale.getProduct().getName();
        this.formmattedDate = new SimpleDateFormat("dd/MM/yyy").format(date);
        this.price = sale.getProduct().getPrice();
    }
}
