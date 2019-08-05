package util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author: 于锦江
 * Date: 2019/6/22
 * Time: 14:48
 */
public class MyBatisGeneration {

    public static void main(String[] args) {
//        try {
//            generator();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


        String str="10排12座";

        System.out.println(str.length());

        System.out.println((int)str.charAt(0)-'0');

//        int[][] param =new int[10][5];
//
//        System.out.println(JSONObject.toJSONString(param));
//
//        int[][] p1=jsonToTwoArr(JSONObject.toJSONString(param));
//
//        for(int i =0 ;i<p1.length;i++){
//
//            for(int j=0;j<p1[i].length;j++){
//                System.out.println(p1[i][j]);
//            }
//        }




    }

    private static int[][] jsonToTwoArr(String str) {

        int[][] param = new int[10][5];

        final JSONArray arr = JSON.parseArray(str);

        for (int i = 0; i < arr.size(); i++) {
            JSONArray jsonArray = JSON.parseArray( arr.get(i).toString());
            for (int j = 0; j < jsonArray.size(); j++) {

                param[i][j] = i+j;
            }
        }

        return param;
    }

//     static void generator() throws Exception{
//
//        List<String> warnings = new ArrayList<String>();
//        boolean overwrite = true;
//        //指定逆向工程配置文件
//        File configFile = new File("src/main/resources/mybatis/generatorConfig.xml");
//        ConfigurationParser cp = new ConfigurationParser(warnings);
//        Configuration config = cp.parseConfiguration(configFile);
//        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
//        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
//                callback, warnings);
//        myBatisGenerator.generate(null);
//    }
}
