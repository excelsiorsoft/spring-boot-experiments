package com.excelsiorsoft.jacksonmapping.dto.test1;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
public  class Item {
    public int id;
    public String itemName;
    public User owner;
}