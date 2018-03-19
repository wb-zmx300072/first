/*
package com.alibaba.work;

import com.alibaba.aliwork.mc.model.MessageVO;
import com.alibaba.aliwork.mc.service.AliworkMcService;
import com.alibaba.fastjson.JSON;
import com.alibaba.iwork.shared.commons.model.result.PojoResult;
import com.util.BeanUtil;

*/
/**
 * @Description：TODO
 * @Author wb-zmx300072 2018/1/15 9:41
 *//*

public class Msg {

    public static void main(String[] args) throws InterruptedException {
        sendAliwork();

    }


    */
/**
     * 测试阿里内外消息
     *//*

    private  static  void sendAliwork() throws InterruptedException {
        AliworkMcService aliworkMcService = (AliworkMcService)BeanUtil.getBean("aliworkMcService");
        MessageVO msg = new MessageVO();
        msg.setMsgTypeId("7_3");
        msg.setReceiverNo("60918");
        msg.setSenderNo("77294");
//        msg.setTitle("this is title" + DateUtil.java.formateDatetime(new Date()));
//        msg.setContent("this is content"+ DateUtil.java.formateDatetime(new Date()));
        msg.setTitle("this is title" );
        msg.setContent("this is content");
        msg.setReceiverAlias("60918");
        msg.setEnableMsgFormat(false);
        msg.setResourceUrl("www.baidu.com");
        PojoResult<Boolean> result =  aliworkMcService.sendMCMsg(msg);
        System.out.println(JSON.toJSONString(result));
        if (!result.isSuccess()){
            Thread.sleep(1000);
            System.out.println("waiting ....");
            sendAliwork();
        }
    }

}
*/
