package com.hzf.param;

import com.hzf.param.SearchOrderParam;
import com.hzf.param.SearchOrderParam.SearchOrderParamBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class SearchOrderParam {
 private String keyword;
 private String fromTime;
 private String toTime;
 private String search_status;
}
