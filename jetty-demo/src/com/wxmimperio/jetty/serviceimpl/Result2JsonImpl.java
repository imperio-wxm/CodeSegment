package com.wxmimperio.jetty.serviceimpl;

import com.wxmimperio.jetty.pojo.User;
import com.wxmimperio.jetty.service.Result2Json;
import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by weiximing.imperio on 2016/7/14.
 */
public class Result2JsonImpl implements Result2Json{

    @Override
    public JSONObject result2Json(String id, String username, String age, String gender) {
        Map<String,String > map = new HashMap<String, String>();
        map.put("username",username + "�Ѿ���������");
        map.put("id",id + "�Ѿ���������");
        map.put("age",age + "�Ѿ���������");
        map.put("gender",gender + "�Ѿ���������");

        JSONObject jsonObject = JSONObject.fromObject(map);

        //���������dao��Ĳ���

        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setAge(age);
        user.setGender(gender);

        return jsonObject;
    }
}
