package notpint;

/**
 * @Description：消息类型枚举类
 * @Author wb-zmx300072 2018/2/24 10:09
 */
public enum  MessageTypeEnums {


    email("email"),
    sms("sms"),
    web("web"),
    aliwork("aliwork"),
    wangwang("wangwang"),
    mutipart_mail("mutipart_mail"),
    dingTalk("dingTalk");

    private String key;

    private MessageTypeEnums(String key){
        this.key = key;
    }

    public String getKey(){
        return key;
    }

    public static boolean contains(String type){
        for(MessageTypeEnums typeEnum : MessageTypeEnums.values()){
            if(typeEnum.getKey().equals(type)){
                return true;
            }
        }
        return false;
    }

}
