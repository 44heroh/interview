package com.company;

public class CategoryTypeServiceImpl implements CategoryTypeService{
    @Override
    public Integer getType(String orderType) {
        Integer orderCategory = null;
        switch (orderType) {
            case "food":
                orderCategory = 2;
                break;
            case "electronic devices":
                orderCategory = 3;
                break;
            case "other":
                orderCategory = 4;
                break;
            default:
                orderCategory = 1;
        }
        return orderCategory;
    }
}
