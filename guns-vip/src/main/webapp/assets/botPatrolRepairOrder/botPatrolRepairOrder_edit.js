/**
 * 详情对话框
 */
var BotPatrolRepairOrderInfoDlg = {
    data: {
        id: "",
        patrolDefectId: "",
        defectCode: "",
        unitId: "",
        deviceType: "",
        deviceId: "",
        orderStatue: "",
        defectContent: "",
        defectGrade: "",
        defectSpecialty: "",
        runZhi: "",
        discoveryDate: "",
        discoveryTime: "",
        discoveryPersonId: "",
        infoMaintenanceTime: "",
        timeLimit: "",
        timeLimitUnit: "",
        receiveTime: "",
        receivePersonId: "",
        eliminatePersonId: "",
        hangUpReason: "",
        hangUpPersonId: "",
        hangUpTime: "",
        returnEliminateTime: "",
        returnEliminatePersonId: "",
        returnFaultType: "",
        returnChangePart: "",
        returnReatmentMeasure: "",
        returnApplyOverTime: "",
        returnApplyOverTimeUnit: "",
        returnApplyResult: "",
        returnApplyCheckPersonId: "",
        returnApplyCheckTime: "",
        returnOverTime: "",
        returnOverTimeUnit: "",
        returnTime: "",
        returnPersonId: "",
        checkResult: "",
        checkPersonId: "",
        checkTime: "",
        createBy: "",
        createDate: "",
        updateBy: "",
        updateDate: "",
        remarks: "",
        delFlag: ""
    }
};

layui.use(['form', 'admin', 'ax','laydate','upload','formSelects'], function () {
    var $ = layui.jquery;
    var $ax = layui.ax;
    var form = layui.form;
    var admin = layui.admin;









































































































































    //获取详情信息，填充表单
    var ajax = new $ax(Feng.ctxPath + "/botPatrolRepairOrder/detail?id=" + Feng.getUrlParam("id"));
    var result = ajax.start();
    form.val('botPatrolRepairOrderForm', result.data);

    //表单提交事件
    form.on('submit(btnSubmit)', function (data) {
        var ajax = new $ax(Feng.ctxPath + "/botPatrolRepairOrder/editItem", function (data) {
            Feng.success("更新成功！");
            window.location.href = Feng.ctxPath + '/botPatrolRepairOrder'
        }, function (data) {
            Feng.error("更新失败！" + data.responseJSON.message)
        });
        ajax.set(data.field);
        ajax.start();

        return false;
    });

    $('#cancel').click(function(){
        window.location.href = Feng.ctxPath + '/botPatrolRepairOrder'
    });
});