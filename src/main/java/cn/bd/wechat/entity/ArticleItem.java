package cn.bd.wechat.entity;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * @Author _Cps
 * @create 2019/3/11 11:51
 */
@Setter
@Getter
@XmlAccessorType(XmlAccessType.FIELD)  //把Xml封装到字段上面 属性(get/set)或字段
public class ArticleItem {

    private String Title;           //Title	是	图文消息标题
    private String Description;     //Description	是	图文消息描述
    private String PicUrl;          //PicUrl	是	图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
    private String Url;             //Url	是	点击图文消息跳转链接

    public ArticleItem() {

    }

    public ArticleItem(String title, String description, String picUrl, String url) {
        Title = title;
        Description = description;
        PicUrl = picUrl;
        Url = url;
    }





}
