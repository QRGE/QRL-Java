package org.qrl.wechat.enterprise.constant;

/**
 * 企业微信常用的api
 * @Author QR
 * @Date 2021/11/8 10:30 AM
 */
@SuppressWarnings("unused")
public class WeChatEnterpriseApi {

    /**
     * 获取企业微信的 accessToken 需要提供 corpid 和 corpsecret
     * corpid: 每个企业都拥有唯一的corpid，获取此信息可在管理后台"我的企业"－"企业信息"下查看"企业ID"
     * corpsecret: secret是企业应用里面用于保障数据安全的钥匙, "每一个应用"都有一个独立的访问密钥
     * access_token: 是企业后台去企业微信的后台获取信息时的重要票据, 由corpid和secret产生. "所有接口"在通信时都需要携带此信息用于验证接口的访问权限
     */
    public final static String getAccessToken = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=ID&corpsecret=SECRET";
}
