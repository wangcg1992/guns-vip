package cn.stylefeng.guns.core.component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 存储键值对
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValuePair<T> implements Serializable {

    private String key;

    private T value;
}