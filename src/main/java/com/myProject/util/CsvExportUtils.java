package com.myProject.util;

import cn.afterturn.easypoi.csv.CsvExportUtil;
import cn.afterturn.easypoi.csv.entity.CsvExportParams;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.util.Collection;

/**
 * csv 文件导出工具类
 *
 * @author wx
 * @date 2022/6/16 09:47
 */
public class CsvExportUtils {

    private static final String SEPARATOR = "/";

    private static final String CSV = ".csv";

    /**
     * csv 文件导出
     *
     * @param fileName  导出文件名称
     * @param pojoClass 导出实体类
     * @param dataSet   导出数据集
     * @param response  相应信息
     * @return void
     * @author wx
     * @date 2022/6/16 09:55
     */
    public static void csvExport(String fileName, Class<?> pojoClass, Collection<?> dataSet, HttpServletResponse response) throws Exception {
        try(OutputStream os = response.getOutputStream()) {
            // 设置响应头信息
            response.setHeader("Content-Disposition", "attachment;filename="
                    + URLEncoder.encode(fileName + ".csv", "UTF-8"));
            response.setCharacterEncoding("UTF-8");
            response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
            // 设置BOM
            os.write(0xEF);
            os.write(0xBB);
            os.write(0xBF);
            CsvExportParams params = new CsvExportParams("UTF-8");
            CsvExportUtil.exportCsv(params, pojoClass, dataSet, os);
        } catch (IOException e) {
            throw new Exception("导出" + fileName + "失败");
        }
    }

    public static void csvExportLocalPath(String filePath, String fileName, Class<?> pojoClass, Collection<?> dataSet) throws Exception {

        File file = new File(filePath + SEPARATOR + fileName + CSV);
        if (!file.getParentFile().exists()) {
            boolean mkdir = file.getParentFile().mkdir();
        }

        try(OutputStream os = Files.newOutputStream(file.toPath())) {
            // 设置BOM
            os.write(0xEF);
            os.write(0xBB);
            os.write(0xBF);
            CsvExportParams params = new CsvExportParams("UTF-8");
            CsvExportUtil.exportCsv(params, pojoClass, dataSet, os);
        } catch (IOException e) {
            throw new Exception("导出" + fileName + "失败");
        }
    }
}
