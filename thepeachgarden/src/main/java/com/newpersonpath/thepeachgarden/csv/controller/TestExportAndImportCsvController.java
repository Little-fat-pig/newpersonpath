package com.newpersonpath.thepeachgarden.csv.controller;

import com.newpersonpath.thepeachgarden.csv.service.CsvExportTestService;
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
 * @date 2023/7/3 14:36
 */
@RestController
public class TestExportAndImportCsvController {

    @Autowired
    private CsvExportTestService csvExportTestService;

    /**
     * 导入csv文件
     *
     * @param upload
     * @param request
     */
    @RequestMapping(value = "/api/test/import",method = RequestMethod.POST)
    public void importTest(@RequestParam("file") MultipartFile upload, HttpServletRequest request){
        csvExportTestService.importCsv(upload,request);
    }

    /**
     * 导出csv文件
     *
     * @param response
     */
    @RequestMapping(value = "/api/test/export",method = RequestMethod.POST)
    public void exportTest(HttpServletResponse response){
        csvExportTestService.exportCsv(response);
    }

}
