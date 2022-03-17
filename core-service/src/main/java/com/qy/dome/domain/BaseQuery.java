package com.qy.dome.domain;

import lombok.Data;


@Data
public class BaseQuery {
    private Integer currentPage=1;

    private Integer pageSize=10;

}
