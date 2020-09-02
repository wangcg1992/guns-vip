/**
 * 添加或者修改页面
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









































































































































    //表单提交事件
    form.on('submit(btnSubmit)', function (data) {
        var ajax = new $ax(Feng.ctxPath + "/botPatrolRepairOrder/addItem", function (data) {
            Feng.success("添加成功！");
            window.location.href = Feng.ctxPath + '/botPatrolRepairOrder'
        }, function (data) {
            Feng.error("添加失败！" + data.responseJSON.message)
        });
        ajax.set(data.field);
        ajax.start();

        return false;
    });

    $('#cancel').click(function(){
        window.location.href = Feng.ctxPath + '/botPatrolRepairOrder'
    });

});