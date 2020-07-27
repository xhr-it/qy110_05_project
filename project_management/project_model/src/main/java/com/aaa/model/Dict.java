package com.aaa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/*** 
 * @author CZT
 * @date 2020/7/17   
 * @param
 * @return 
 *****字典实体类
**/ 
@Table(name = "t_dict")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Dict implements Serializable {
    /**
     * 字典ID
     */
    @Id
    private Long dictId;

    /**
     * 键
     */

    private Long keyy;

    /**
     * 值
     */

    private String valuee;

    /**
     * 字段名称
     */

    private String fieldName;

    /**
     * 表名
     */

    private String tableName;


}