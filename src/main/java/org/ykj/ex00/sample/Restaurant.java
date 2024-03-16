package org.ykj.ex00.sample;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@ToString
@RequiredArgsConstructor//생성자 자동생성
public class Restaurant {
  //생성자 주입
  private final Chef chef;

//  public Restaurant(Chef chef) {
//    this.chef = chef;
//  }
}
