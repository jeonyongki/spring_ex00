package org.ykj.ex00.domain;

import lombok.*;

@Builder
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SampleDTO {
  private String name;
  private int age;
}
