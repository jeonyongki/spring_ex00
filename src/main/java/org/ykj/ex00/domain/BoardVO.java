package org.ykj.ex00.domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class BoardVO {
  private Long bno;
  private String title;
  private String content;
  private String writer;

  private LocalDateTime regDate;
  private LocalDateTime updateDate;
}
