package com.newpersonpath.thepeachgarden.csv.service.Impl;

import com.newpersonpath.thepeachgarden.csv.service.CsvExportTestService;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;

/**
 * @author
 * @version 1.0
 * @date 2023/7/3 13:58
 */
@Slf4j
@Service
public class CsvExportTestServiceImpl implements CsvExportTestService {


    /**
     * 导出csv文件
     *
     * @param response
     */

    @Override
    public void exportCsv(HttpServletResponse response) {
        try {
            ServletOutputStream outputStream = response.getOutputStream();
            String filename = "姓名统计.csv";
            String encode = URLEncoder.encode(filename, "UTF-8");
            //            设置两个头 一个是文件的打开方式 一个是mime类型
            response.setHeader("Content-Disposition", "attachment;filename=" +encode );
            response.setContentType("text/csv");
            //            创建一个用来写入到csv文件中的writer
            CSVWriter writer = new CSVWriter(new OutputStreamWriter(outputStream, "gbk"));
            String[] strings = {"姓名1", "姓名2", "姓名3", "姓名4", "姓名5", "姓名6"};
            writer.writeNext(strings);
            for (int i = 0; i < 10; i++) {
                String[] dataArray = new String[strings.length];
                dataArray[0] = i+"";
                dataArray[1] = i+"";
                dataArray[2] = i+"";
                dataArray[3] = i+"";
                dataArray[4] = i+"";
                dataArray[5] = i+"";
                writer.writeNext(dataArray);
            }
            writer.close();
        } catch (Exception e) {
            log.error("写入csv文件异常{}", e);
        }

    }

    @Override
    public void importCsv(MultipartFile upload, HttpServletRequest request) {

        InputStream inputStream = null;
        InputStreamReader inputStreamReader=null;
        try {
            inputStream = upload.getInputStream();
            inputStreamReader=new InputStreamReader(inputStream, "gb2312");
            Reader reader=inputStreamReader;
            CSVReader csvReader=new CSVReader(reader);
            String[] titles = csvReader.readNext();
            while (true){
                //一行一行读取
                String[] content = csvReader.readNext();
//                Iterator<String[]> iterator = csvReader.iterator();
                if (ObjectUtils.isNotEmpty(content)){
                    //获取流中csv文件的信息
                }
            }

        } catch (Exception e) {
            log.error("导入csv文件异常");

        }
    }
}
