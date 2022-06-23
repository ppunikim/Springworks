package com.callor.ems.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class FilesVO {
	private long	i_seq;
	private long	i_bseq;
	private String	i_originalName;
	private String	i_imageName;
}
