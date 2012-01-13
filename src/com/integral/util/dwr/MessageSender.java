package com.integral.util.dwr;

import java.util.Collection;

import org.directwebremoting.Browser;
import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.ScriptSessionFilter;

/** 
 * <p>Description: [描述该类概要功能介绍]</p>
 * @author  <a href="mailto: swpigris81@126.com">代超</a>
 * @version $Revision$ 
 */
public class MessageSender {

    /**
     * <p>Discription:[方法功能中文描述]</p>
     * @param args
     * @author:[代超]
     * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */

    public static void main(String[] args) {

    }
    
    public void sendMessage(final String receiverid, final String msg){
        Browser.withAllSessionsFiltered(new ScriptSessionFilter(){

            @Override
            public boolean match(ScriptSession session) {
                if (session.getAttribute("messageId") == null)
                    return false;
                else
                    return (session.getAttribute("messageId")).equals(receiverid);
                }
        },new Runnable(){
          //ScriptSessions.addFunctionCall("ExtTalk.updateMegGroup", data);//之所以不用这个方法，是因为这个
          //方法有bug的存在，会对所有不论过不过滤的scriptsession进行推送，相当于全推送，没有起到过滤的作用
            private ScriptBuffer script = new ScriptBuffer();
            @Override
            public void run() {
                //这里写你页面的js函数", 这个参数是传给js函数的
                script.appendCall("jsFunctionName");
                Collection<ScriptSession> colls = Browser.getTargetSessions();
                for (ScriptSession scriptSession : colls) {
                    //scriptSession.addScript(initFunctionCall("dwr.util.setValue", "info", msg));
                    scriptSession.addScript(script);
                }
            }
        });
    }
}