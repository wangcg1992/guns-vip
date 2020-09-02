package cn.stylefeng.guns.utils;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.HashUtil;
import cn.hutool.core.util.IdUtil;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

//import java.util.UUID;

/**
 * 封装各种生成唯一性ID算法的工具类.
 * @author ThinkGem
 * @version 2013-01-15
 */
@Service
@Lazy(false)
public class IdGen  {

	/**
	 * 封装JDK自带的UUID, 通过Random数字生成, 中间无-分割.
	 */
	public static String uuid() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

    /**
     * 自定义ID，由yyyyMMddHHmmss格式化日期字符串和UUID组成
     */
	public static String customId(){
//        String DateTimeStr=DateUtils.formatDate(new Date(),"yyyyMMddHHmmss");
//        String uuidStr=IdGen.uuid() ;
//        return DateTimeStr+uuidStr;

		return snowflake.nextIdStr();
    }

	/**
	 * Activiti ID 生成
	 */
	public String getNextId() {
		return IdGen.customId();
	}

	private final static Long workId;

	private final static long dataSourceId;

	private final  static Snowflake snowflake;

	static {
		workId = (long) Math.abs(HashUtil.fnvHash(String.valueOf(System.currentTimeMillis()).getBytes()) % 32);
		dataSourceId = (long) Math.abs(HashUtil.fnvHash(String.valueOf(System.currentTimeMillis()).getBytes()) % 32);
		snowflake = IdUtil.createSnowflake(workId,dataSourceId);
	}

	/**
	 * 获取一个String类型的id
	 */
	public static String getStringId(){
		return snowflake.nextIdStr();
	}

}
