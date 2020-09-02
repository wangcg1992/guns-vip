layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * 订单表管理
     */
    var BizOrder = {
        tableId: "bizOrderTable"
    };

    /**
     * 初始化表格的列
     */
    BizOrder.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'id', hide: true, title: '主键'},
            {field: 'goodsName', sort: true, title: '商品名称'},
            {field: 'place', sort: true, title: '下单地点'},
            {field: 'createTime', sort: true, title: '下单时间'},
            {field: 'userName', sort: true, title: '下单用户名称'},
            {field: 'userPhone', sort: true, title: '下单用户电话'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    BizOrder.search = function () {
        var queryData = {};


        table.reload(BizOrder.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 跳转到添加页面
     */
    BizOrder.jumpAddPage = function () {
        window.location.href = Feng.ctxPath + '/bizOrder/add'
    };

    /**
    * 跳转到编辑页面
    *
    * @param data 点击按钮时候的行数据
    */
    BizOrder.jumpEditPage = function (data) {
        window.location.href = Feng.ctxPath + '/bizOrder/edit?id=' + data.id
    };

    /**
     * 导出excel按钮
     */
    BizOrder.exportExcel = function () {
        var checkRows = table.checkStatus(BizOrder.tableId);
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
    BizOrder.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/bizOrder/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(BizOrder.tableId);
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
        elem: '#' + BizOrder.tableId,
        url: Feng.ctxPath + '/bizOrder/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: BizOrder.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        BizOrder.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {

    BizOrder.jumpAddPage();

    });

    // 导出excel
    $('#btnExp').click(function () {
        BizOrder.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + BizOrder.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            BizOrder.jumpEditPage(data);
        } else if (layEvent === 'delete') {
            BizOrder.onDeleteItem(data);
        }
    });
});
