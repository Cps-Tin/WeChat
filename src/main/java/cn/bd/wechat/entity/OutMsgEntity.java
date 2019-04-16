package cn.bd.wechat.entity;


import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author _Cps
 * @create 2019-03-09 09:22
 */
@Setter
@Getter
@XmlRootElement(name="xml")            //指定根元素
@XmlAccessorType(XmlAccessType.FIELD)  //把Xml封装到字段上面 属性(get/set)或字段
public class OutMsgEntity {

   /**
    * 字段开头大写是为了不用为每个字段进行xml的转换
    * 或者给字段添加注解 @Xm'lElement("ToUserName")
    *
    * @Xm'lElement("ToUserName")
    * private String toUserName;
    *
    * 都属于jaxb注解
    */

   //被动回复消息的共有属性
   private String ToUserName;	    //用户OpenID 接受送方帐号（一个OpenID）
   private String FromUserName;	    //开发者微信号
   private Long CreateTime;	        //消息创建时间 （整型）
   private String MsgType;	        //消息类型，文本为text 图片image
   private String Content;	        //文本消息内容

   //被动回复媒体类型消息的属性
   @XmlElementWrapper(name="Image") //添加XML父节点
   private String[] MediaId;        //图文消息媒体id，必须在微信服务器上，没有的话先用其他接口上传媒体（图片/语音）


   private Integer ArticleCount;	    //图文消息个数；当用户发送文本、图片、视频、图文、地理位置这五种消息时，开发者只能回复1条图文消息；其余场景最多可回复8条图文消息

   @XmlElementWrapper(name="Articles")
   private ArticleItem[] item;             //图文项 可以有多个  item[Title,Description,PicUrl,Url]





}
