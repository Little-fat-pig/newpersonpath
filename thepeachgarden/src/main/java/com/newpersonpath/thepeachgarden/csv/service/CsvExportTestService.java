package com.newpersonpath.thepeachgarden.csv.service;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author
 * @version 1.0
 * @date 2023/7/3 13:57
 */
public interface CsvExportTestService {

    /**
     * 导出csv文件
     *
     * @param response
     */
    void exportCsv(HttpServletResponse response);


    /**
     * 导入csv文件
     *
     * @param upload
     * @param request
     */
    void importCsv(MultipartFile upload, HttpServletRequest request);

}
