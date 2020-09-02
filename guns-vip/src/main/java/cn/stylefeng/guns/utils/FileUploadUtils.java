package cn.stylefeng.guns.utils;

import cn.hutool.core.io.FileTypeUtil;
import cn.hutool.core.io.FileUtil;
import cn.stylefeng.guns.core.component.UploadPathProperties;
import cn.stylefeng.guns.core.exception.ParamException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

/**
 * 文件上传工具类
 * 主要是为了配合springmvc的实现进行完成,
 * 上传的文件保存在服务器本地
 *
 * @author xulu
 */
@Slf4j
@Component
public class FileUploadUtils {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class UploadContext {

        private Boolean success;

        private String saveFullPath;

    }

    /**
     * 文件路径分割符
     */
    public static final String FILE_PATH_SEP_TAG = File.separator;

    private FileUploadUtils() {
    }

    private static UploadPathProperties uploadPathProperties;

    /**
     * 直接保存文件,保存的位置为 yyyy/mm/dd
     *
     * @param file
     * @return
     */
    public static UploadContext uploadContext(MultipartFile file) {
        return uploadContext(file, DateFormatUtils.format(new Date(), "yyyy/mm/dd"), UUID.randomUUID().toString());
    }

    /**
     * 使用一个默认的文件名进行文件的保存
     *
     * @param file
     * @param savePath
     * @return
     */
    public static UploadContext uploadContext(MultipartFile file, String savePath) {
        return uploadContext(file, savePath, UUID.randomUUID().toString());
    }

    /**
     * 上传文件,返回一个context对象
     *
     * @param file
     * @param savePath
     * @param saveName
     * @return
     */
    public static UploadContext uploadContext(MultipartFile file, String savePath, String saveName) {
        return upload(file, savePath, saveName) ?
                UploadContext.builder()
                        .saveFullPath(new StringBuilder().append(savePath).append(FILE_PATH_SEP_TAG).append(saveName).append(".").append(fileType(file)).toString())
                        .success(true).build()
                : UploadContext.builder().success(false).build();
    }

    /**
     * 实现文件上传功能
     *
     * @param file
     * @param savePath 保存的路径,实际上就是文件最终全路径
     * @return
     */
    private static boolean upload(MultipartFile file, String savePath, String saveName) {
        if (Objects.isNull(file)) {
            return false;
        }
        try {
            String fileSavePath = new StringBuilder()
                    .append(uploadPathProperties.getPath())
                    .append(savePath)
                    .toString();

            log.debug("file path is {}", fileSavePath);
            FileUtil.mkdir(fileSavePath);
            FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(new File(new StringBuilder(fileSavePath)
                    .append(FILE_PATH_SEP_TAG)
                    .append(saveName)
                    .append(".")
                    .append(fileType(file))
                    .toString())));
        } catch (IOException e) {
            log.error("upload error", e);
            return false;
        }
        return true;

    }

    @Autowired
    public void setUploadPathProperties(UploadPathProperties uploadPathProperties) {
        FileUploadUtils.uploadPathProperties = uploadPathProperties;
    }

    /**
     * 获取文件的类型名称
     *
     * @param file
     * @return
     */
    private static String fileType(MultipartFile file) {
        try {
            return FileTypeUtil.getType(file.getInputStream());
        } catch (IOException e) {
            throw new ParamException("file not found");
        }
    }
}
