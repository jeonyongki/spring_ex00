package org.ykj.ex00.domain;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SampleDTOList {
  private List<SampleDTO> list = new ArrayList<>();
}
