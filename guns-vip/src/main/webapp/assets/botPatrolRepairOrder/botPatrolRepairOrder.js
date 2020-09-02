layui.use(['table', 'admin', 'ax', 'func','laydate'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;
    var laydate = layui.laydate;
    var leftChart = echarts.init(document.getElementById("leftChart"));
    list();
    /**
     * //常规用法
     */
    laydate.render({
        elem: '#test1'
    });
    laydate.render({
        elem: '#test2'
    });
    /**
     * 缺陷检修工单管理
     */
    var BotPatrolRepairOrder = {
        tableId: "botPatrolRepairOrderTable"
    };

    /**
     * 初始化表格的列
     */
    BotPatrolRepairOrder.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'id', hide: true, title: '缺陷联系单表id'},
            {field: 'patrolDefectId', sort: true, title: '缺陷联系单id'},
            {field: 'deviceType', sort: true, title: '设备名称'},
            {field: 'returnFaultType', sort: true, title: '故障类型'},
            {field: 'returnChangePart', sort: true, title: '更换部件'},
            {field: 'returnReatmentMeasure', sort: true, title: '处理措施'},
            {field: 'discoveryTime', sort: true, title: '发现时间'},
            {field: 'returnEliminateTime', sort: true, title: '处理时间'},
            {field: 'returnEliminatePersonId', sort: true, title: '负责人'},

            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    BotPatrolRepairOrder.search = function () {
        var queryData = {};


        table.reload(BotPatrolRepairOrder.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 跳转到添加页面
     */
    BotPatrolRepairOrder.jumpAddPage = function () {
        window.location.href = Feng.ctxPath + '/botPatrolRepairOrder/add'
    };

    /**
    * 跳转到编辑页面
    *
    * @param data 点击按钮时候的行数据
    */
    BotPatrolRepairOrder.jumpEditPage = function (data) {
        window.location.href = Feng.ctxPath + '/botPatrolRepairOrder/edit?id=' + data.id
    };

    /**
     * 导出excel按钮
     */
    BotPatrolRepairOrder.exportExcel = function () {
        var checkRows = table.checkStatus(BotPatrolRepairOrder.tableId);
        if (checkRows.data.length === 0) {
            Feng.error("请选择要导出的数据");
        } else {
            table.exportFile(tableResult.config.id, checkRows.data, 'xls');
        }
    };

    /**
     * 点击删除
     *
     * @param data 点击按钮时候的行数据
     */
    BotPatrolRepairOrder.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/botPatrolRepairOrder/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(BotPatrolRepairOrder.tableId);
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("id", data.id);
            ajax.start();
        };
        Feng.confirm("是否删除?", operation);
    };

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + BotPatrolRepairOrder.tableId,
        url: Feng.ctxPath + '/botPatrolRepairOrder/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: BotPatrolRepairOrder.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        BotPatrolRepairOrder.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {

    BotPatrolRepairOrder.jumpAddPage();

    });

    // 导出excel
    $('#btnExp').click(function () {
        BotPatrolRepairOrder.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + BotPatrolRepairOrder.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            BotPatrolRepairOrder.jumpEditPage(data);
        } else if (layEvent === 'delete') {
            BotPatrolRepairOrder.onDeleteItem(data);
        }
    });

    /**
     * 插入Echrts图
     */
    //全局设置Echrts - 根据窗口的大小变动图表
    window.onresize = function(){
        leftChart.resize();
    }

    /**
     * 定义函数：
     * @constructor
     */
    function Map() {
        this.keys = new Array();
        this.values= new Array();
        //添加键值对
        this.set = function (key, value) {
            if (this.values[key] == null) {//如键不存在则身【键】数组添加键名
                this.keys.push(value);
            }
            this.values[key] = value;//给键赋值
        };
        //获取键对应的值
        this.get = function (key) {
            return this.values[key];
        };
        //去除键值，(去除键数据中的键名及对应的值)
        this.remove = function (key) {
            this.keys.remove(key);
            this.values[key] = null;
        };
        //判断键值元素是否为空
        this.isEmpty = function () {
            return this.keys.length == 0;
        };
        //获取键值元素大小
        this.size = function () {
            return this.keys.length;
        };
    }

    /**
     * 调用函数：
     * @constructor
     */
    function list(){

        var deviceTypeJson=new Map();

        var faultTypeJson = new Map();


        var changePartJson = new Map();


        $.ajax({
            url:'botPatrolRepairOrder/echarts?'+(new Date()).getTime(),
            type:'post',
            async: false,
            dataType:'json',
            success:function (result){

                var firstChartData=JSON.parse(result.firstChartData);
                var faultTypeData=JSON.parse(result.faultTypeData);
                var changePartData=JSON.parse(result.changePartData);

                for(var i=0;i<firstChartData.length;i++){
                    var  key=firstChartData[i].device_type;
                    var  value=firstChartData[i].cnt;
                    deviceTypeJson.set("'"+key+"'",value)

                    //
                    $.ajax({
                        url: 'botPatrolRepairOrder/queryFaultType?faulttype=' +key,
                        type: 'post',
                        async: false,
                        dataType: 'json',
                        success: function (result) {

                            //刷新右侧图

                        }

                    });
                }
                for (var i=0;i<faultTypeData.length;i++){
                    var key=faultTypeData[i].return_fault_type;
                    var value=faultTypeData[i].cnt;
                    faultTypeJson.set("'"+key+"'",value)
                }
                for (var i=0;i<changePartData.length;i++){
                    var key=changePartData[i].return_change_part;
                    var value=changePartData[i].cnt;
                    changePartJson.set("'"+key+"'",value)
                }

                // deviceTypeJson=firstChartData;


                // 使用指定的配置项和数据显示图表。
                leftChart.setOption({
                    tooltip: {},
                    title: [{
                        text: '故障类型',

                        left: '25%',
                        textAlign: 'center'
                    }, {
                        text: '更换部件',
                        subtext: '总计 ' + Object.keys(faultTypeJson.values).reduce(function (all, key) {
                            return all + faultTypeJson.values[key];
                        }, 0),
                        left: '75%',
                        textAlign: 'center'
                    }, {
                        text: '所需耗材',
                        subtext: '总计 ' + Object.keys(changePartJson.values).reduce(function (all, key) {
                            return all + changePartJson.values[key];
                        }, 0),
                        left: '75%',
                        top: '50%',
                        textAlign: 'center'
                    }],
                    grid: [{
                        top: 50,
                        width: '60%',
                        bottom: '5%',
                        left: 10,
                        containLabel: true
                    }],
                    xAxis: [{
                        type: 'category',
                        data: Object.keys(deviceTypeJson.values),
                        axisTick: {
                            alignWithLabel: true, //柱状图中心是否对齐刻度位置
                            show: false //不显示刻度
                        },
                        axisLine: {
                            show:false, //不显示横轴线
                            lineStyle: {
                                color: 'rgba(255, 129, 109, 0.1)',
                                width: 1 //这里是为了突出显示加上的
                            }
                        },
                        axisLabel: {
                            textStyle: {
                                color: '#0a0a0a',
                                fontSize: 16
                            },
                            interval:0,
                            formatter:function (params) {
                                var  ret = "";//拼接加\n返回的类目项
                                var maxLength = 5;//每项显示文字个数
                                var valLength = params.length;//X轴类目项的文字个数
                                var rowN = Math.ceil(valLength / maxLength); //类目项需要换行的行数
                                if (rowN > 1)//如果类目项的文字大于5,
                                {
                                    for (var i = 0; i < rowN; i++) {
                                        var temp = "";//每次截取的字符串
                                        var start = i * maxLength;//开始截取的位置
                                        var end = start + maxLength;//结束截取的位置
                                        //这里也可以加一个是否是最后一行的判断，但是不加也没有影响，那就不加吧
                                        temp = params.substring(start, end) + "\n";
                                        ret += temp; //凭借最终的字符串
                                    }
                                    return ret;
                                }else {
                                    return params;
                                }
                            }
                        }
                    }],
                    yAxis: [{
                        name:'单位：次',
                        nameLocation:'end',
                        nameTextStyle:{
                            color:"rgba(17,17,17,1)",
                            fontSize:12
                        },
                        min:0,
                        max:14,
                        splitNumber: 1,
                        axisTick: {
                            show: false
                        },
                        axisLine: {
                            lineStyle: {
                                color: 'rgba(255, 129, 109, 0.1)',
                                width: 1 //这里是为了突出显示加上的
                            }
                        },
                        axisLabel: {
                            textStyle: {
                                color: '#0a0a0a'
                            }
                        },
                        splitArea: {
                            areaStyle: {
                                color: 'rgba(255,255,255,.5)'
                            }
                        },
                        splitLine: {
                            show: true,
                            lineStyle: {
                                color: 'rgba(255, 129, 109, 0.1)',
                                width: 0.5,
                                type: 'dashed'
                            }
                        }
                    }],
                    legend:[{
                        id:'faultTypeJson',
                        //orient: 'vertical',
                        icon: "circle",
                        right: 'right',
                        bottom:'50%',
                        data: Object.keys(faultTypeJson.values).map(function (key) {
                            return {
                                name: key.replace('.js', ''),
                                value: faultTypeJson.values[key]
                            }
                        })
                    },{
                        id:'changePartJson',
                        //orient: 'vertical',
                        icon: "circle",
                        bottom:'0%',
                        left: 'right',
                        data: Object.keys(changePartJson.values).map(function (key) {
                            return {
                                name: key.replace('.js', ''),
                                value: changePartJson.values[key]
                            };
                        })
                    }],
                    series: [{
                        type: 'pictorialBar',
                        stack: 'chart',
                        barCategoryGap: '50%',
                        symbol: 'path://M0,10 L10,10 C5.5,10 5.5,5 5,0 C4.5,5 4.5,10 0,10 z',
                        itemStyle: {
                            normal: {
                                color: {
                                    type: 'linear',
                                    x: 0,
                                    y: 0,
                                    x2: 0,
                                    y2: 1,
                                    colorStops: [{
                                        offset: 0,
                                        color: 'rgba(0,77,167,1)' //  0%  处的颜色
                                    },
                                        {
                                            offset: 1,
                                            color: 'rgba(0,244,255,1)' //  100%  处的颜色
                                        }
                                    ],
                                    global: false //  缺省为  false
                                }
                            },
                            emphasis: {
                                opacity: 1
                            }
                        },
                        z: 12,

                        data: Object.keys(deviceTypeJson.values).map(function (key) {
                            debugger;
                            return deviceTypeJson.values[key];
                        })
                    }, {
                        type: 'bar',
                        stack: 'chart',
                        silent: true,
                        itemStyle: {
                            normal: {
                                color: '#eee'
                            }
                        },
                        data: Object.keys(deviceTypeJson).map(function (key) {
                            return deviceTypeJson.all - deviceTypeJson[key];
                        })
                    },  {
                        type: 'pie',
                        radius: ['20%', '30%'],
                        center: ['75%', '25%'],
                        label:{
                            formatter: '{b}：{d}%',
                        },
                        data: Object.keys(faultTypeJson.values).map(function (key) {
                            return {
                                name: key.replace('.js', ''),
                                value: faultTypeJson.values[key]
                            }
                        })
                    }, {
                        type: 'pie',
                        radius: ['20%', '30%'],
                        center: ['75%', '75%'],
                        label:{
                            formatter: '{b}：{d}%',
                        },
                        data: Object.keys(changePartJson.values).map(function (key) {
                            return {
                                name: key.replace('.js', ''),
                                value: changePartJson.values[key]
                            };
                        })
                    }]
                });
            }
        })
    }
    //
    // var deviceTypeJson = {
    //         '石灰石球磨机':2,
    //         '氧化风机':8,
    //         '斗式提升机':2,
    //         'CEMS故障':7,
    //         '泵':12,
    //         '除雾器':6,
    //         '搅拌器故障':2,
    //         '石膏旋流器':3
    // };
    // var faultTypeJson = {
    //     "泵轴承损坏": 335,
    //     "旋流器压力异常": 310,
    //     "料斗变形": 234,
    //     "机封漏浆": 148,
    //     "阀门腐蚀": 148,
    //     "给料机链条故障": 148,
    //     "除雾器压差异常": 148,
    //     "滤网堵塞": 148
    // };
    // var changePartJson ={
    //     "法兰1": 335,
    //     "轴承1": 310,
    //     "法兰2": 234,
    //     "轴承2": 148,
    //     "法兰3": 148,
    //     "轴承3": 148,
    //     "法兰4": 148,
    //     "轴承4": 148
    // };

});

