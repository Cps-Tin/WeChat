package cn.bd.wechat.entity;


import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author _Cps
 * @create 2019-03-09 09:22
 */
@Setter
@Getter
@XmlRootElement(name="xml")            //指定根元素
@XmlAccessorType(XmlAccessType.FIELD)  //把Xml封装到字段上面 属性(get/set)或字段
public class InMsgEntity {

   //接受消息共有共有属性
   private String ToUserName;	    //开发者微信号
   private String FromUserName;	    //发送方帐号（一个OpenID）
   private Long CreateTime;	        //消息创建时间 （整型）
   private String MsgType;	        //消息类型，文本为text 图片image
   private String Content;	        //文本消息内容
   private Long MsgId;	            //消息id，64位整型
   private String Event;            //事件类型,Event 事件类型，CLICK(点击菜单) subscribe(订阅)、unsubscribe(取消订阅)

   //媒体类型消息的属性
   private String PicUrl;	        //图片链接统生成）
   private String MediaId;	        //图片消息媒体id，可以调用获取临时素材接口拉取数据。

   public String getToUserName() {
      return ToUserName;
   }

   public void setToUserName(String toUserName) {
      ToUserName = toUserName;
   }

   public String getFromUserName() {
      return FromUserName;
   }

   public void setFromUserName(String fromUserName) {
      FromUserName = fromUserName;
   }

   public Long getCreateTime() {
      return CreateTime;
   }

   public void setCreateTime(Long createTime) {
      CreateTime = createTime;
   }

   public String getMsgType() {
      return MsgType;
   }

   public void setMsgType(String msgType) {
      MsgType = msgType;
   }

   public String getContent() {
      return Content;
   }

   public void setContent(String content) {
      Content = content;
   }

   public Long getMsgId() {
      return MsgId;
   }

   public void setMsgId(Long msgId) {
      MsgId = msgId;
   }

   public String getEvent() {
      return Event;
   }

   public void setEvent(String event) {
      Event = event;
   }

   public String getPicUrl() {
      return PicUrl;
   }

   public void setPicUrl(String picUrl) {
      PicUrl = picUrl;
   }

   public String getMediaId() {
      return MediaId;
   }

   public void setMediaId(String mediaId) {
      MediaId = mediaId;
   }
}
