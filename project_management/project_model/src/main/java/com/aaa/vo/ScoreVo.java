package com.aaa.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ScoreVo implements Serializable {
    /**
     * 1:加
     * 0:减
     */
    private Integer plusOrSubtract;
    private String reason;
    private Integer points;
    private Long unitId;
}
