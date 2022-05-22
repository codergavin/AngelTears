package com.ruoyi.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.*;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Gavin Li
 * @version 1.0
 * @group HummingBird
 * @date 2022/4/26 15:30
 * @desc
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@WebAppConfiguration
public class BaseControllerTest {

    public static final String Authorization = "Authorization";// X-Auth-Token / Authorization

    public static String TOKEN = "";

    @Autowired
    private WebApplicationContext wac;

    protected MockMvc mockMvc;

    private void login() throws Exception {
        Map<String,Object> map = new HashMap<>();

        map.put("username","admin");
        map.put("password","admin");

        String context = JSONObject.toJSONString(map);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                        .post("/login")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(context))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        TOKEN = JSON.parseObject(JSON.parseObject(mvcResult.getResponse().getContentAsString()).getString("data")).getString("token");
        System.out.println("----Token:" + TOKEN);
    }

    @BeforeEach
    public void init() throws Exception {
        System.out.println("开始测试-----------------");
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        login();
    }

    @AfterEach
    public void after() {
        System.out.println("测试结束-----------------");
    }

    /**
     * 获取列表的基础方法
     * @param requestUrl 请求地址
     * @throws Exception
     */
    protected void baseList(String requestUrl) throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(requestUrl).header(Authorization,TOKEN))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        printResult(mvcResult);
    }

    /**
     * 获取单个信息的基础方法
     * @param requestUrl 请求地址
     * @return
     * @throws Exception
     */
    protected MvcResult baseGetInfo(String requestUrl) throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(requestUrl).header(Authorization,TOKEN))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        printResult(mvcResult);
        return mvcResult;
    }

    /**
     * POST的基础方法
     * @param requestUrl 请求地址
     * @param map
     * @throws Exception
     */
    protected void basePostInfo(String requestUrl, Map<String,Object> map) throws Exception {
        String context = JSONObject.toJSONString(map);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                        .post(requestUrl).header(Authorization,TOKEN)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(context))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        printResult(mvcResult);
    }

    /**
     * 新增信息的基础方法
     * @param requestUrl 请求地址
     * @param map
     * @throws Exception
     */
    protected void baseAdd(String requestUrl, Map<String,Object> map) throws Exception {
        basePostInfo(requestUrl,map);
    }

    /**
     * 更新信息的基础方法
     * @param requestUrl 请求地址
     * @param map
     * @throws Exception
     */
    protected void baseUpdate(String requestUrl,Map<String,Object> map) throws Exception {
        String context = JSONObject.toJSONString(map);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                        .put(requestUrl).header(Authorization,TOKEN)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(context))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        printResult(mvcResult);
    }

    /**
     * 删除信息的基础方法
     * @param requestUrl 请求地址
     * @throws Exception
     */
    protected void baseDelete(String requestUrl) throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete(requestUrl).header(Authorization,TOKEN))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        printResult(mvcResult);
    }

    /**
     * 删除请求携带参数的基础方法
     * @param requestUrl 请求地址
     * @param map
     * @throws Exception
     */
    protected void baseBatchDelete(String requestUrl,Map<String,Object> map) throws Exception {
        String context = JSONObject.toJSONString(map);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete(requestUrl).header(Authorization,TOKEN)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(context))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        printResult(mvcResult);
    }

    /**
     * 下载文件的基础方法
     * @param requestUrl 请求地址
     * @throws Exception
     */
    protected void baseDownloadFile(String requestUrl) throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(requestUrl).header(Authorization,TOKEN))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        downloadFile(mvcResult.getResponse());
        printResult(mvcResult);
    }

    /**
     * 上传文件基础方法
     * @param requestUrl 请求地址
     * @param filePath 上传文件路径
     * @throws Exception
     */
    protected void baseUploadFile(String requestUrl,String filePath) throws Exception {
        File uploadFile = new File(filePath);
        MvcResult mvcResult =  mockMvc.perform(
                        MockMvcRequestBuilders
                                .multipart(requestUrl)
                                .file(
                                        new MockMultipartFile("file", uploadFile.getName(), ",multipart/form-data",
                                                new FileInputStream(uploadFile))
                                ).header(Authorization,TOKEN)
                ).andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        printResult(mvcResult);
    }

    /**
     * 上传文件携带参数的基础方法
     * @param requestUrl 请求地址
     * @param filePath 上传文件路径
     * @param key 参数的Key
     * @param value 参数的Value
     * @throws Exception
     */
    protected void baseUploadFileWithParams(String requestUrl,String filePath,String key,String value) throws Exception {
        File uploadFile = new File(filePath);
        MvcResult mvcResult =  mockMvc.perform(
                        MockMvcRequestBuilders
                                .multipart(requestUrl)
                                .file(
                                        new MockMultipartFile("file", uploadFile.getName(), ",multipart/form-data",
                                                new FileInputStream(uploadFile))
                                ).param(key,value).header(Authorization,TOKEN)
                ).andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        printResult(mvcResult);
    }

    /**
     * 批量文件上传
     */
    protected void baseUploadFileList(String requestUrl,String filePath1,String filePath2) throws Exception {
        File uploadFile1 = new File(filePath1);
        File uploadFile2 = new File(filePath2);
        MvcResult mvcResult =  mockMvc.perform(MockMvcRequestBuilders.fileUpload("/personnel/detail/batchUpdateImport")
                .file(new MockMultipartFile("files", uploadFile1.getName(), ",multipart/form-data",
                        new FileInputStream(uploadFile1))
                ).file(new MockMultipartFile("files", uploadFile2.getName(), ",multipart/form-data",
                        new FileInputStream(uploadFile2))).header(Authorization,TOKEN)
        ).andExpect(MockMvcResultMatchers.status().isOk()).andReturn() ;

        printResult(mvcResult);
    }

    /**
     * 下载文件
     * @param response
     * @throws IOException
     */
    private void downloadFile(MockHttpServletResponse response) throws IOException {
        downloadFile(response,"C:\\Users\\Administrator\\Downloads");
    }

    /**
     * 下载文件
     * @param response
     * @param downloadPath
     * @throws IOException
     */
    private void downloadFile(MockHttpServletResponse response,String downloadPath) throws IOException {
        String fileName = response.getHeaderValues("Content-Disposition").get(0).toString();
        fileName = fileName.replace("attachment;filename=","") ;
//        String fileName = "testName";
        File file = new File(downloadPath + "\\" + URLDecoder.decode(fileName, "UTF-8"));
        if (!file.exists()) {
            file.createNewFile();
        }
        OutputStream outputStream = new FileOutputStream(file);
        outputStream.write(response.getContentAsByteArray());
        outputStream.flush();
    }

    /**
     * 打印结果信息
     * @param mvcResult
     * @throws UnsupportedEncodingException
     */
    private void printResult(MvcResult mvcResult) throws UnsupportedEncodingException {
        System.out.println(mvcResult.getResponse().getContentAsString(Charset.forName("UTF-8")));
    }
}
