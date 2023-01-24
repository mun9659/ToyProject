package com.toyProject.common;

import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JsonResult<T> {
	private boolean success;
	private String message;
	private T data;
}

