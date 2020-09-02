package cn.stylefeng.guns.core.component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 文件上传路径属性配置
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UploadPathProperties {

    /**
     * 文件上传路径
     */
    private  String path;

}
