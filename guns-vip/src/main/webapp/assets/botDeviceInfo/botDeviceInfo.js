layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * 设备信息表管理
     */
    var BotDeviceInfo = {
        tableId: "botDeviceInfoTable"
    };

    /**
     * 初始化表格的列
     */
    BotDeviceInfo.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'id', hide: true, title: 'id'},
            {field: 'deviceName', sort: true, title: '设备名称'},
            {field: 'deviceCode', sort: true, title: '设备编码'},
            {field: 'deviceModel', sort: true, title: '设备型号'},
            {field: 'deviceTypeId', sort: true, title: '设备类型id'},
            {field: 'unitId', sort: true, title: '机组id'},
            {field: 'systemId', sort: true, title: '系统id'},
            {field: 'mainMaterial', sort: true, title: '主要材料'},
            {field: 'weight', sort: true, title: '重量'},
            {field: 'putIntoOperateTime', sort: true, title: '投运时间'},
            {field: 'outFactoryTime', sort: true, title: '出厂时间'},
            {field: 'installTime', sort: true, title: '安装时间'},
            {field: 'installPosition', sort: true, title: '安装位置'},
            {field: 'deviceFactoryId', sort: true, title: '设备生产厂家id'},
            {field: 'originalCost', sort: true, title: '初始价值'},
            {field: 'deviceFunction', sort: true, title: '设备功能'},
            {field: 'operationMothod', sort: true, title: '操作方法'},
            {field: 'designLifetime', sort: true, title: '设计寿命'},
            {field: 'repairCount', sort: true, title: '维修次数'},
            {field: 'repairRequirement', sort: true, title: '维保要求'},
            {field: 'warningCount', sort: true, title: '预警次数'},
            {field: 'replaceCount', sort: true, title: '替换次数'},
            {field: 'deviceStatue', sort: true, title: '设备运行状态'},
            {field: 'imageUrl', sort: true, title: '图片地址'},
            {field: 'qrCodeImageUrl', sort: true, title: '二维码图片地址'},
            {field: 'specifications', sort: true, title: '设备规格信息'},
            {field: 'paramsRange', sort: true, title: '设备参数范围信息'},
            {field: 'orDeviceId', sort: true, title: '初始设备id,默认为本设备id'},
            {field: 'runCurrentValue', sort: true, title: '运行电流'},
            {field: 'runVoltageValue', sort: true, title: '运行电压'},
            {field: 'ratedPower', sort: true, title: '额定功率'},
            {field: 'speed', sort: true, title: '转速'},
            {field: 'runDeviceId', sort: true, title: '运行主设备id'},
            {field: 'deviceCount', sort: true, title: '设备总台数'},
            {field: 'operateCount', sort: true, title: '运行台数'},
            {field: 'backupCount', sort: true, title: '备用台数'},
            {field: 'parentId', sort: true, title: '父设备id-针对电机'},
            {field: 'isElectricDevice', sort: true, title: '是否带电设备，默认为1(是)'},
            {field: 'isChange', sort: true, title: '是否更换(0表示不需更换，1表示需要更换)'},
            {field: 'createBy', sort: true, title: '创建者'},
            {field: 'createDate', sort: true, title: '创建时间'},
            {field: 'updateBy', sort: true, title: '更新者'},
            {field: 'updateDate', sort: true, title: '更新时间'},
            {field: 'deleteBy', sort: true, title: '删除者'},
            {field: 'deleteDate', sort: true, title: '删除时间'},
            {field: 'remarks', sort: true, title: '备注'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    BotDeviceInfo.search = function () {
        var queryData = {};


        table.reload(BotDeviceInfo.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 跳转到添加页面
     */
    BotDeviceInfo.jumpAddPage = function () {
        window.location.href = Feng.ctxPath + '/botDeviceInfo/add'
    };

    /**
    * 跳转到编辑页面
    *
    * @param data 点击按钮时候的行数据
    */
    BotDeviceInfo.jumpEditPage = function (data) {
        window.location.href = Feng.ctxPath + '/botDeviceInfo/edit?id=' + data.id
    };

    /**
     * 导出excel按钮
     */
    BotDeviceInfo.exportExcel = function () {
        var checkRows = table.checkStatus(BotDeviceInfo.tableId);
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
    BotDeviceInfo.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/botDeviceInfo/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(BotDeviceInfo.tableId);
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
        elem: '#' + BotDeviceInfo.tableId,
        url: Feng.ctxPath + '/botDeviceInfo/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: BotDeviceInfo.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        BotDeviceInfo.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {

    BotDeviceInfo.jumpAddPage();

    });

    // 导出excel
    $('#btnExp').click(function () {
        BotDeviceInfo.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + BotDeviceInfo.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            BotDeviceInfo.jumpEditPage(data);
        } else if (layEvent === 'delete') {
            BotDeviceInfo.onDeleteItem(data);
        }
    });
});
