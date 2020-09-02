package cn.stylefeng.guns.utils;

import cn.stylefeng.guns.core.exception.ParamException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.FileCopyUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * 文件下载
 */
@Slf4j
public abstract class FileDownUtils {

    protected FileDownUtils(){}

    /**
     * 设置文件下载时候的头信息
     * @param fileName
     */
    protected static void setHeader(String fileName){
        HttpServletResponse response = ServletUtils.getResponse();
        try {
            response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            log.error("file download encode exception, msg is {}", e); // 不会出现
        }
    }

    /**
     * 文件下载
     * @param fileName 文件的名称
     * @param in  输入流
     */
    public static void download(String  fileName, FileInputStream in){
        setHeader(fileName);
        try {
            FileCopyUtils.copy(in,ServletUtils.getResponse().getOutputStream());
        } catch (IOException e) {
            log.error("FileDownUtils download exception {}",e);
            // do nothing
        }
    }

    /**
     * 文件下载
     * @param FileName
     * @param file
     */
    public static void  download(String FileName, File file){
        try {
            download(FileName,new FileInputStream(file));
        } catch (FileNotFoundException e) {
            throw new ParamException("file 不存在");
        }
    }
}
