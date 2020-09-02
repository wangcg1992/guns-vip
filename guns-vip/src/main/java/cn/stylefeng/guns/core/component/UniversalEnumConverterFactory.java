package cn.stylefeng.guns.core.component;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * 统一的枚举转换器
 */
@Component
public class UniversalEnumConverterFactory implements ConverterFactory<String, BaseEnum> {

    /**
     * 其中存储我们使用的转换器
     */
    private static final Map<Class, Converter> converterMap = new WeakHashMap<>();

    /**
     * 通过类型找到对应的转换器
     */
    @Override
    public <T extends BaseEnum> Converter<String, T> getConverter(Class<T> targetType) {
        Converter result = converterMap.get(targetType);
        if(result == null) {
            result = new IntegerStrToEnum<>(targetType);
            converterMap.put(targetType, result);
        }
        return result;
    }

    /**
     * 将我们自定义的基本枚举放入到该转换器工厂中
     * @param <T>
     */
    class IntegerStrToEnum<T extends BaseEnum> implements Converter<String, T> {
        private final Class<T> enumType;
        private final Map<String, T> enumMap = new HashMap<>();
 
        public IntegerStrToEnum(Class<T> enumType) {
            this.enumType = enumType;
            T[] enums = enumType.getEnumConstants();
            for(T e : enums) {
                enumMap.put(e.getValue() + "", e);
            }
        }
 
 
        @Override
        public T convert(String source) {
            T result = enumMap.get(source);
            if(result == null) {
                throw new IllegalArgumentException("No element matches " + source);
            }
            return result;
        }
    }
}