package com.callor.naver.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.ToString;

@ToString
@JacksonXmlRootElement(localName = "rss")
@JsonIgnoreProperties(ignoreUnknown = true)
public class NaverChannel {
	
	//public String version;
	
	@JacksonXmlProperty(localName = "channel")
	public NaverXMLParent channel;
}
