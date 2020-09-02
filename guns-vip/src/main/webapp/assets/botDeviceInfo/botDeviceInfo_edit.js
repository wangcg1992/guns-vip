/**
 * 详情对话框
 */
var BotDeviceInfoInfoDlg = {
    data: {
        id: "",
        deviceName: "",
        deviceCode: "",
        deviceModel: "",
        deviceTypeId: "",
        unitId: "",
        systemId: "",
        mainMaterial: "",
        weight: "",
        putIntoOperateTime: "",
        outFactoryTime: "",
        installTime: "",
        installPosition: "",
        deviceFactoryId: "",
        originalCost: "",
        deviceFunction: "",
        operationMothod: "",
        designLifetime: "",
        repairCount: "",
        repairRequirement: "",
        warningCount: "",
        replaceCount: "",
        deviceStatue: "",
        imageUrl: "",
        qrCodeImageUrl: "",
        specifications: "",
        paramsRange: "",
        orDeviceId: "",
        runCurrentValue: "",
        runVoltageValue: "",
        ratedPower: "",
        speed: "",
        runDeviceId: "",
        deviceCount: "",
        operateCount: "",
        backupCount: "",
        parentId: "",
        isElectricDevice: "",
        isChange: "",
        createBy: "",
        createDate: "",
        updateBy: "",
        updateDate: "",
        deleteBy: "",
        deleteDate: "",
        remarks: ""
    }
};

layui.use(['form', 'admin', 'ax','laydate','upload','formSelects'], function () {
    var $ = layui.jquery;
    var $ax = layui.ax;
    var form = layui.form;
    var admin = layui.admin;









































































































































    //获取详情信息，填充表单
    var ajax = new $ax(Feng.ctxPath + "/botDeviceInfo/detail?id=" + Feng.getUrlParam("id"));
    var result = ajax.start();
    form.val('botDeviceInfoForm', result.data);

    //表单提交事件
    form.on('submit(btnSubmit)', function (data) {
        var ajax = new $ax(Feng.ctxPath + "/botDeviceInfo/editItem", function (data) {
            Feng.success("更新成功！");
            window.location.href = Feng.ctxPath + '/botDeviceInfo'
        }, function (data) {
            Feng.error("更新失败！" + data.responseJSON.message)
        });
        ajax.set(data.field);
        ajax.start();

        return false;
    });

    $('#cancel').click(function(){
        window.location.href = Feng.ctxPath + '/botDeviceInfo'
    });
});