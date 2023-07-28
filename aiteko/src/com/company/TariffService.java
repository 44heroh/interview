package com.company;

import java.math.BigDecimal;

public interface TariffService {
    BigDecimal calculateAmount(String orderType, int category);
}
