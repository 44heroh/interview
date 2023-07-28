package com.company;

import java.math.BigDecimal;
import java.util.Date;

@Data
class Order {
    private String orderType;
    private int category;
    private String description;
    private BigDecimal amount;
    private Date createdAt;
}
