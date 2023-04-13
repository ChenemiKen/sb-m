package com.chenemiken.departmentservice.exception;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetails {
  private LocalDateTime timeStamp;
  private int status;
  private String error;
  private String path;
}
