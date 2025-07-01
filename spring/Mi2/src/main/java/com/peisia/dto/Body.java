
package com.peisia.dto;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Body {

    public String dataType;                        //"json"    [1,2,3]      ["개","고양이"] 
    public Items items;                            // 여기 안에 item 1개가 있음 그런데 그 item 코드가 중요함
    public Integer pageNo;                         //     1            이건 현재 페이지 번호 
    public Integer numOfRows;                      //     10           한 페이지에 보여줄 데이터 수 최대 10개 가능 이라는 거(10 일경우) 
    public Integer totalCount;                     //     2            전체 테이터의 총 개수 지금은 2가 있다는 뜻

}
