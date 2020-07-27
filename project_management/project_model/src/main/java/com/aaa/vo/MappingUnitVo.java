package com.aaa.vo;

import com.aaa.model.MappingUnit;
import com.aaa.model.Score;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class MappingUnitVo implements Serializable {
    private MappingUnit mappingUnit;
    private Boolean isSuccess;
    private Object data;
    private Score score;
}
