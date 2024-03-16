package org.ykj.ex00.domain;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TodoDTO {
  private String title;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date dueDate;
}
