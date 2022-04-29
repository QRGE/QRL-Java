package org.qrl.xml;

import cn.hutool.core.util.JAXBUtil;

/**
 * @author qr
 * @date 2022/1/12 16:37
 */
public class XmlLearn {

    public static void main(String[] args) {
        String xmlStr = "<xml><ToUserName><![CDATA[gh_2c05be7cb6cc]]></ToUserName><FromUserName><![CDATA[oBXeM6SYFMJbA3TuYeYcXXWsRZQ8]]></FromUserName><CreateTime>1641976172</CreateTime><MsgType><![CDATA[event]]></MsgType><Event><![CDATA[SCAN]]></Event><EventKey><![CDATA[doctorId=null]]></EventKey><Ticket><![CDATA[gQG-8DwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAyeTZsQWh5NVRlY0YxMDAwMHcwN2cAAgTNVd1hAwQAAAAA]]></Ticket></xml>";
        WeChatQRCodeRecall weChatQRCodeRecord = JAXBUtil.xmlToBean(xmlStr, WeChatQRCodeRecall.class);
        System.out.println(weChatQRCodeRecord);
    }
}
