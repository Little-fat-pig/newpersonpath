package com.newpersonpath.thepeachgarden.easypoi.service.Impl;


import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import com.newpersonpath.thepeachgarden.easypoi.entity.ExcelImportTestEntity;
import com.newpersonpath.thepeachgarden.easypoi.entity.ExcelTestEntity;
import com.newpersonpath.thepeachgarden.easypoi.service.ExcelExportTestService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @author
 * @version 1.0
 * @date 2023/7/3 13:58
 */
@Slf4j
@Service
public class ExcelExportTestServiceImpl implements ExcelExportTestService {


    /**
     * 导出excel
     *
     * @param response
     */
    @Override
    public void excelExport(HttpServletResponse response) {
        ExportParams exportParams = new ExportParams();
        exportParams.setSheetName("导出excel统计");
        exportParams.setType(ExcelType.XSSF);
        List<ExcelTestEntity> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ExcelTestEntity excelTestEntity = new ExcelTestEntity();
            excelTestEntity.setPersonName1(i + "");
            excelTestEntity.setPersonName2(i + "");
            excelTestEntity.setPersonName3(i + "");
            excelTestEntity.setPersonName4(i + "");
            excelTestEntity.setPersonName5(i + "");
            excelTestEntity.setPersonName6(i + "");
            list.add(excelTestEntity);
        }
        log.info("写入excel数据成功" + list);
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, ExcelTestEntity.class, list);
        try {
            String encode = URLEncoder.encode("导出excel统计" + ".xlsx", "UTF-8");
            response.setHeader("Content-Type", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setHeader("Content-Disposition", "attachment;filename=" + encode);
            workbook.write(response.getOutputStream());
            workbook.close();
        } catch (Exception e) {
            log.error("写入excel数据异常", e);
        }

    }


    /**
     * 导入excel
     *
     * @param upload
     * @param request
     */
    @Override
    public void excelImport(MultipartFile upload, HttpServletRequest request) {
        List<ExcelImportTestEntity> excelImportTestEntityList = null;
        ImportParams importParams = new ImportParams();
        importParams.setHeadRows(1);
        try {
            excelImportTestEntityList = ExcelImportUtil.importExcel(upload.getInputStream(), ExcelImportTestEntity.class, importParams);
        } catch (Exception e) {
            log.error("上传文件错误{}", e);
        }
        //数据保存到数据库    excelImportTestEntityList


    }
}
