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

    public void baseList(String requestUrl) throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(requestUrl).header(Authorization,TOKEN))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        printResult(mvcResult);
    }

    public MvcResult baseGetInfo(String requestUrl) throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(requestUrl).header(Authorization,TOKEN))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        printResult(mvcResult);
        return mvcResult;
    }

    public void basePostInfo(String requestUrl, Map<String,Object> map) throws Exception {
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

    public void baseAdd(String requestUrl, Map<String,Object> map) throws Exception {
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

    public void baseUpdate(String requestUrl,Map<String,Object> map) throws Exception {
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

    public void baseDelete(String requestUrl) throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete(requestUrl).header(Authorization,TOKEN))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        printResult(mvcResult);
    }

    public void baseBatchDelete(String requestUrl,Map<String,Object> map) throws Exception {
        String context = JSONObject.toJSONString(map);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete(requestUrl).header(Authorization,TOKEN)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(context))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        printResult(mvcResult);
    }

    public void baseDownloadFile(String requestUrl) throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(requestUrl).header(Authorization,TOKEN))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        downloadFile(mvcResult.getResponse());
        printResult(mvcResult);
    }

    public void baseUploadFile(String requestUrl,String fileName) throws Exception {
        String result =  mockMvc.perform(
                        MockMvcRequestBuilders
                                .multipart(requestUrl)
                                .file(
                                        new MockMultipartFile("file", fileName, ",multipart/form-data",
                                                new FileInputStream(new File("D:\\" + fileName)))
                                ).header(Authorization,TOKEN)
                ).andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }

    /**
     * 批量修改导入
     */
    @Test
    public void batchUpdateImport1(){
        try {
            String result =  mockMvc.perform(MockMvcRequestBuilders.fileUpload("/personnel/detail/batchUpdateImport")
                    .file(new MockMultipartFile("files", "user_detail_update1.xlsx", ",multipart/form-data",
                            new FileInputStream(new File("D:\\user_detail_update1.xlsx")))).header(Authorization,TOKEN)
            ).andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getContentAsString();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void downloadFile(MockHttpServletResponse response) throws IOException {
        String fileName = response.getHeaderValues("Content-Disposition").get(0).toString();
        fileName = fileName.replace("attachment;filename=","") ;
//        String fileName = "testName";
        File file = new File("C:\\Users\\Administrator\\Downloads\\" + URLDecoder.decode(fileName, "UTF-8"));
        if (!file.exists()) {
            file.createNewFile();
        }
        OutputStream outputStream = new FileOutputStream(file);
        outputStream.write(response.getContentAsByteArray());
        outputStream.flush();
    }

    private void printResult(MvcResult mvcResult) throws UnsupportedEncodingException {
        System.out.println(mvcResult.getResponse().getContentAsString(Charset.forName("UTF-8")));
    }
}
