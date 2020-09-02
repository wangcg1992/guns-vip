package cn.stylefeng.guns.config;

public class HdhbConstant {

    //报警原因分析Job
    public static final String FIR_MACHINE_LOAD = "CJPP:P100TOFGD02";//1#机组负荷
    public static final String SEC_MACHINE_LOAD = "CJPP:P102TOFGD02";//2#机组负荷
    public static final int ELEC_LIMIT_VALUE = 30;//浆液循环泵开关电流界限值
    public static final double ELEC_LOAD_VALUE = 10;//电机停机电流
    public static final String FIR_MACHINE_ECLE = "CJPP:P104HTK21AJ001CE002";//#1磨机的B相电流
    public static final String SEC_MACHINE_ECLE = "CJPP:P104HTK22AJ001CE002";//#2磨机的B相电流
    public static final String FIR_BOX_DENSITY_ID = "10142";//#1磨机浆液箱浆液密度
    public static final String SEC_BOX_DENSITY_ID = "10143";//#2磨机浆液箱浆液密度

    //球磨机报警模型
    public static final String[] BALL_TAGS = new String[]{"CJPP:P104HTK11CFLJ","CJPP:P104HTK12CFLJ"};//球磨机1、2#称重给料机累计流量输出

    //日前计划
    public static final String FIR_COLUMN_ID = "20190826104740495909137ddc881a9"; //1#日前计划
    public static final String SEC_COLUMN_ID = "20190826104740495909137ddc884a9"; //2#日前计划

    //煤质参数
    public static final String[] COAL_PARAMETER = new String[]{"Mad","Stad","Star","Vdaf","FCad","TotalDayFDL","TotalDaySWDL"}; //空干基水分,空干基水分,空干基全硫,收到基全硫,干燥无灰基挥发分,空干基固定碳,发电量，上网量

    //报表文件导入
    public static final String FILE_PATH = "\\static\\template\\#fileName\\reports\\";//文件存放路径
    public static final String[] ELEC_REGISTERS = {"fElec", "sEec", "totalElec", "highElec", "lowElec", "systemElec"};//脱硫,脱销电量指标登记表
    public static final String[] MACHINE_ELECS = {"fPump1", "fPump2", "fPump3", "fPump4", "fPump5", "fPump5Avg", "fFanMachine1", "fFanMachine2", "fBallMachine", "fRemoveSo", "sPump1", "sPump2", "sPump3", "sPump4", "sPump5", "sPump5Avg", "sFanMachine1", "sFanMachine2", "sBallMachine", "sRemoveSo"};//脱硫电量指标登记表

    public static final int BATCH_ELEC =  9000;//批次

    //脱硫
    public static final String[] SO_CONFIG = {"TotalMonthFDL","TotalMonthSWDL","LimestonePowderConsumptionImport","DesulfurizationPowerConsumption","DesulphurizationWaterQuantity","LimestoneConsumption"};
    //脱销
    public static final String[] NO_CONFIG = {"SteamMonthCost","DenitrificationWaterQuantity","AmmoniaMonthCost"};

    //经济指标脱硫
    public static final String LOW_ELEC = "lowElec";//各班组低压总用电量
    public static final String HIGH_ELEC = "highElec";//各班组6kv总用电量
    public static final String TOTAL_ELEC = "totalElec";//各班组#1#2总发电量
    public static final String I_TLSHSH = "I_TLSHSH";//石灰石用量
    public static final String I_TLSH = "I_TLSH";//水用量
    public static final String I_SO2TCL = "I_SO2TCL";//so2脱除量
    public static final String ELEC_PRICE = "ElecPrice";//电单价
    public static final String STONE_PRICE = "StonePrice";//石灰石单价
    public static final String WATER_PRICE = "WaterPrice";//水单价
    //经济指标脱硝
    public static final String[] I_YAHL = {"I_YAHL","I_AYAHL"};//各班组液氨使用量
    public static final String I_ZQLLLJ = "I_ZQLLLJ";//各班组水蒸气使用量
    public static final String AMMONIA_PRICE = "AmmoniaPrice";//液氨单价
    public static final String STEAM_PRICE = "SteamPrice";//水蒸气单价
    public static final String I_NOXTCL = "I_NOXTCL";//各班组NOX脱除量
    //废气排放连续监测小时平均值
    public static final String[] FLUE_GAS_AVGS = {"GasPlatformValue","SO2PlatformValue","NOXPlatformValue"};

    //#1炉脱硝A侧出口
    public static final String[] F_NOX_A_EXIT_VALS = {"FNoAvgAExit","FNoDisAExit","FNoTotalAExit","FO2AvgAExit","FSmokeSpeedAvgAExit","FSmokeTempAvgAExit"};
    //#1炉脱硝A侧入口
    public static final String[] F_NOX_A_ENTRY_VALS = {"FNoAvgAEntry","FNoDisAEntry","FNoTotalAEntry","FO2AvgAEntry","FSmokeSpeedAvgAEntry","FSmokeTempAvgAEntry"};
    //#1炉脱硝B侧出口
    public static final String[] F_NOX_B_EXIT_VALS = {"FNoAvgBExit","FNoDisBExit","FNoTotalBExit","FO2AvgBExit","FSmokeSpeedAvgBExit","FSmokeTempAvgBExit"};
    //#1炉脱硝B侧入口
    public static final String[] F_NOX_B_ENTRY_VALS = {"FNoAvgBEntry","FNoDisBEntry","FNoTotalBEntry","FO2AvgBEntry","FSmokeSpeedAvgBEntry","FSmokeTempAvgBEntry"};

    //#2炉脱硝A侧出口
    public static final String[] S_NOX_A_EXIT_VALS = {"SNoAvgAExit","SNoDisAExit","SNoTotalAExit","SO2AvgAExit","SSmokeSpeedAvgAExit","SSmokeTempAvgAExit"};
    //#2炉脱硝A侧入口
    public static final String[] S_NOX_A_ENTRY_VALS = {"SNoAvgAEntry","SNoDisAEntry","SNoTotalAEntry","SO2AvgAEntry","SSmokeSpeedAvgAEntry","SSmokeTempAvgAEntry"};
    //#2炉脱硝B侧出口
    public static final String[] S_NOX_B_EXIT_VALS = {"SNoAvgBExit","SNoDisBExit","SNoTotalBExit","SO2AvgBExit","SSmokeSpeedAvgBExit","SSmokeTempAvgBExit"};
    //#2炉脱硝B侧入口
    public static final String[] S_NOX_B_ENTRY_VALS = {"SNoAvgBEntry","SNoDisBEntry","SNoTotalBEntry","SO2AvgBEntry","SSmokeSpeedAvgBEntry","SSmokeTempAvgBEntry"};

    //1号炉吸收塔原烟气入口
    public static final String[] F_UNTREATED_VALS = {"FUntreatedSmokeDustAvg","FUntreatedSmokeDustDis","FUntreatedSo2Avg","FUntreatedSo2Dis","FUntreatedSo2Total"
            ,"FUntreatedNoxAvg","FUntreatedNoxDis","FUntreatedO2Avg","FUntreatedSmokeSpeedAvg","FUntreatedSmokeTemp"};
    //2号炉吸收塔原烟气入口
    public static final String[] S_UNTREATED_VALS = {"SUntreatedSmokeDustAvg","SUntreatedSmokeDustDis","SUntreatedSo2Avg","SUntreatedSo2Dis","SUntreatedSo2Total"
            ,"SUntreatedNoxAvg","SUntreatedNoxDis","SUntreatedO2Avg","SUntreatedSmokeSpeedAvg","SUntreatedSmokeTemp"};
    //1号炉吸收塔净烟气出口
    public static final String[] F_FLUE_VALS = {"FFlueSmokeDustAvg","GasCEMSValue","FFlueSo2Avg","SO2CEMSValue","FFlueSo2Total","FFlueNoxAvg","NOXCEMSValue","FFlueO2Avg","FFlueSmokeSpeedAvg","FFlueSmokeTemp"};
    //2号炉吸收塔净烟气出口
    public static final String[] S_FLUE_VALS = {"SFlueSmokeDustAvg","GasCEMS2Value","SFlueSo2Avg","SO2CEMS2Value","SFlueSo2Total","SFlueNoxAvg","NOXCEMS2Value","SFlueO2Avg","SFlueSmokeSpeedAvg","SFlueSmokeTemp"};

}
