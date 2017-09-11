package net.linkcn.oa.daos;

import java.util.List;
import net.linkcn.oa.entity.Inboxanddustbin;
import net.linkcn.oa.entity.Outboxanddrafts;
import net.linkcn.oa.entity.Personalbook;

/**
 * 用户邮箱操作接口
 * 
 * @author Mr-XJZ
 */
public interface IUserMail
{
    // 实现分页查询信息
    public List<Inboxanddustbin> InfoPage(Integer pagesize, Integer pageindex) throws Exception;

    // 查询自己所有的私人通讯录好友
    public List<Personalbook> infoPersonalbooks(Integer userId) throws Exception;

    // 根据私人好友编号进行删除好友功能
    public boolean delPersonalbooksByid(Integer id) throws Exception;

    // 根据私人好友编号进行修改数据
    public boolean updPersonalbooksByid(Personalbook personalbook) throws Exception;

    // 新增私人好友信息
    public boolean savePersonalbooks(Personalbook personalbook) throws Exception;

    // 根据用户编号进行修改登录密码
    public boolean updLoginPwd(Integer id, String pwd) throws Exception;

    // 查询所有的员工信息
    @SuppressWarnings("unchecked")
    public List infoUserAll() throws Exception;

    // 查询所有的部门信息
    @SuppressWarnings("unchecked")
    public List infoDeptAll() throws Exception;

    // 根据类别查询所有的员工信息
    @SuppressWarnings("unchecked")
    public List infoUserAll(Integer type) throws Exception;

    // 添加草稿箱信息
    public boolean saveDrafts(Outboxanddrafts outboxanddrafts) throws Exception;

    // 发送邮件
    public boolean sendUserMail(Inboxanddustbin inboxanddustbin) throws Exception;

    // 根据用户编号查询所属草稿箱  或者查询所属发件箱
    @SuppressWarnings("unchecked")
    public List infoOutboxanddrafts(Integer userID, String infoType) throws Exception;
    
    // 根据用户编号查询所属垃圾箱  或者查询所属收件箱
    @SuppressWarnings("unchecked")
    public List infoInboxanddustbin(Integer userID, String infoType) throws Exception;
}
