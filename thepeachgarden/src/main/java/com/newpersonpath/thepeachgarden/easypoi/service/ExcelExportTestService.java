package com.newpersonpath.thepeachgarden.easypoi.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author
 * @version 1.0
 * @date 2023/7/3 13:57
 */
public interface ExcelExportTestService {

    /**
     * 导出excel
     *
     * @param response
     */
    void excelExport(HttpServletResponse response);

    /**
     * 导入excel
     *
     * @param upload
     * @param request
     */
    void excelImport(MultipartFile upload, HttpServletRequest request);
}
