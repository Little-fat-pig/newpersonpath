package com.newpersonpath.thepeachgarden.easypoi.controller;

import com.newpersonpath.thepeachgarden.easypoi.service.ExcelExportTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author
 * @version 1.0
 * @date 2023/7/3 14:40
 */
@RestController
public class TestExportAndImportExcelController {


    @Autowired
    private ExcelExportTestService excelExportTestService;

    @RequestMapping(value = "/api/test/import/excel",method = RequestMethod.POST)
    public void importTest(@RequestParam("file") MultipartFile upload, HttpServletRequest request){
        excelExportTestService.excelImport(upload,request);
    }


    @RequestMapping(value = "/api/test/export/excel",method = RequestMethod.POST)
    public void exportTest(HttpServletResponse response){
        excelExportTestService.excelExport(response);
    }
}
