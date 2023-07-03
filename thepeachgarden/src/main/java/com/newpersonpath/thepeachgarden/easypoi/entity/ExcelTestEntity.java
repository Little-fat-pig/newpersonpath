package com.newpersonpath.thepeachgarden.easypoi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

/**
 * @author
 * @version 1.0
 * @date 2023/7/3 14:12
 */
@Data
@ExcelTarget("Export")
public class ExcelTestEntity {

    private static final long serialVersionUID = 3L;

    @Excel(name = "姓名1", width = 30)
    private String personName1;

    @Excel(name = "姓名2", width = 30)
    private String personName2;

    @Excel(name = "姓名3", width = 30)
    private String personName3;

    @Excel(name = "姓名4", width = 30)
    private String personName4;

    @Excel(name = "姓名5", width = 30)
    private String personName5;

    @Excel(name = "姓名6", width = 30)
    private String personName6;
}
