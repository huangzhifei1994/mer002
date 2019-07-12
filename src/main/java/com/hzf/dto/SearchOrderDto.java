package com.hzf.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SearchOrderDto {
private String keyword;
private Date fromTime;
private Date toTime;
private Integer search_status=0;
}
