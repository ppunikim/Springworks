package com.callor.memo.model;

import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.ToString;

@JsonRootName("getFoodKr")
@ToString
public class ApiFood {

	public ApiDTO item;
}
