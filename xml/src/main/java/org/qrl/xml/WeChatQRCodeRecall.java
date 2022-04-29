package org.qrl.xml;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author qr
 * @date 2022/1/12 16:39
 */
@ToString
@Getter
@Setter
public class WeChatQRCodeRecall {

    private String toUserName;

    private String fromUserName;

    private Date createTime;

    private String event;

    private String eventKey;

    private String ticket;
}
