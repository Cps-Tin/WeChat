package cn.bd.wechat.controller;

import cn.bd.wechat.entity.ArticleItem;
import cn.bd.wechat.entity.InMsgEntity;
import cn.bd.wechat.entity.OutMsgEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.NoSuchAlgorithmException;

/**
 * @author _Cps
 * @create 2019-03-09 08:06
 */
@Controller
public class TestController {

    @ResponseBody
    @RequestMapping("/index")
    public String index(){
        return "Index";
    }

    /**
     * signature	微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
     * timestamp	时间戳
     * nonce	    随机数
     * echostr	    随机字符串
     */
    @ResponseBody
    @RequestMapping(value = "/weChat",method = RequestMethod.GET)
    public String weChat(String signature,String timestamp,String nonce,String echostr) throws NoSuchAlgorithmException {

        //加密有问题
        /*String []arr = {WeChatUtil.TOKEN ,timestamp ,nonce};
        Arrays.sort(arr);

        StringBuffer sb = new StringBuffer();
        for(String a : arr){
            sb.append(a);
        }
        //* signature	微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
        if( WeChatUtil.TOKEN.equals( SecurityUtil.SHA1(sb.toString()))){
            System.out.println("欢迎来到WeChat世界");
            return echostr;
        }else{
            System.out.println("连接失败！！！");
            return null;
        }*/
        System.out.println("欢迎来到WeChat世界!");
        return echostr;

    }

    /**
     * 当普通微信用户向公众账号发消息时，微信服务器将POST消息的XML数据包到开发者填写的URL上。
     * 1.创建实体类 准备映射参数
     * 2.给参数添加@RequestBody注解,把参数绑定到对象上
     * 3.让实体类的字段与其匹配,参数名要相同，所以实体类开头大写了
     * 4.给实体类添加@XmlRootElement(name="xml") 指定根元素
     * 5.@XmlAccessorType(XmlAccessType.FIELD) property 用于定义这个类中的任何类型需要映射到XML中  Xml → 字段 | 字段 → Xml
     * 6.根据MsgId进行排重
   */
    @ResponseBody
    @RequestMapping(value = "/weChat",method = RequestMethod.POST,produces = {"application/xml;charset=UTF-8"})
    public Object receiveMessage(@RequestBody InMsgEntity inMsg) throws Exception {
        OutMsgEntity outMsg = new OutMsgEntity();
        outMsg.setToUserName(inMsg.getFromUserName());
        outMsg.setFromUserName(inMsg.getToUserName());
        outMsg.setCreateTime(inMsg.getCreateTime());
        System.out.println(inMsg.getMsgType());
        /*被动回复用户信息*/
        if("text".equals(inMsg.getMsgType())){
            if(inMsg.getContent().contains("名字")){
                outMsg.setMsgType("_Cps");
                outMsg.setContent(inMsg.getContent());
            }else if(inMsg.getContent().contains("手机号")){
                outMsg.setMsgType("18848848551");
                outMsg.setContent(inMsg.getContent());
            }else if(inMsg.getContent().equals("【收到不支持的消息类型，暂无法显示】")){
                outMsg.setMsgType("text");
                outMsg.setContent("你瓜皮哦 OvO 正常点好的嘛");
            }else{
                outMsg.setMsgType("text");
                outMsg.setContent(inMsg.getContent());
            }
        }else if("image".equals(inMsg.getMsgType())){
            outMsg.setMsgType("image");
            outMsg.setMediaId(new String[]{inMsg.getMediaId()});
        /*接受事件推荐*/
        }else if(inMsg.getMsgType().equals("event")){
            if(inMsg.getEvent().equals("subscribe")){//关注事件
                outMsg.setMsgType("news");
                outMsg.setArticleCount(1);
                outMsg.setItem(new ArticleItem[]{new ArticleItem("_Cps",
                        "向鱼问水，向马问路\n向神打听我一生的出路",
                        "http://www.144g.com//geren_huisejianyue/logo.png","http://www.144g.com/web-EMMqDBX.html")});
        }
    }else{
            outMsg.setMsgType("text");
            outMsg.setContent("你瓜皮哦 OvO 正常点好的嘛");
        }
        System.out.println(outMsg.toString());

        /*
        不用@XmlRootElement @XmlAccessorType 这些注解
        Map map = new HashMap<String,String>();
        map.put("ToUserName",inMsg.getFromUserName());
        map.put("FromUserName",inMsg.getToUserName());
        map.put("CreateTime",inMsg.getCreateTime().toString());
        map.put("Content",inMsg.getContent());
        map.put("MsgType","text");*/
        //OutMsgEntity out = (OutMsgEntity) WXPayUtil.mapToObject(map,OutMsgEntity.class);WXPayUtil.mapToXml(map)
        return outMsg;
    }


}
