package net.linkcn.oa.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import net.linkcn.oa.daos.IUserMail;
import net.linkcn.oa.entity.Inboxanddustbin;
import net.linkcn.oa.entity.Outboxanddrafts;
import net.linkcn.oa.entity.Personalbook;
import net.linkcn.oa.entity.User;
import net.linkcn.oa.util.HibernateUtil;

public class UserMail extends HibernateUtil implements IUserMail
{
    Session     session     = null;
    Transaction transaction = null;

    // 实现分页查询信息
    @SuppressWarnings("unchecked")
    public List<Inboxanddustbin> InfoPage(Integer pagesize, Integer pageindex) throws Exception
    {
        List<Inboxanddustbin> list = new ArrayList<Inboxanddustbin>();
        String hql = "from Inboxanddustbin order by inbdusId";
        try
        {
            session = super.getSession();
            Query query = session.createQuery(hql);
            // 设置每次最多检索出的对象的数目
            query.setMaxResults(pagesize);
            // 设置当前显示页面数
            query.setFirstResult((pageindex - 1) * pagesize);
            list = query.list();
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            super.close();
        }
        return list;
    }

    // 查询自己所有的私人通讯录好友
    @SuppressWarnings("unchecked")
    public List<Personalbook> infoPersonalbooks(Integer userId) throws Exception
    {
        List<Personalbook> list = null;
        String hql = "from Personalbook p where p.userId = :userId";
        try
        {
            session = super.getSession();
            list = session.createQuery(hql).setParameter("userId", userId).list();
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            super.close();
        }
        return list;
    }

    // 根据私人好友编号进行删除好友功能
    public boolean delPersonalbooksByid(Integer id) throws Exception
    {
        boolean isOk = false;
        Personalbook personalbook = null;
        try
        {
            session = super.getSession();
            transaction = session.beginTransaction();
            // 根据ID获取要删除的对象
            personalbook = (Personalbook) session.get(Personalbook.class, id);
            if (personalbook == null)
                return false;
            else
            {
                // 删除指定对象
                session.delete(personalbook);
                transaction.commit();
                isOk = true;
            }
        } catch (Exception e)
        {
            if (transaction != null)
            {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally
        {
            super.close();
        }
        return isOk;
    }

    // 根据私人好友编号进行修改数据
    public boolean updPersonalbooksByid(Personalbook personalbook) throws Exception
    {
        boolean isOk = false;
        try
        {
            session = super.getSession();
            transaction = session.beginTransaction();
            // 更新指定的员工信息
            session.update(personalbook);
            transaction.commit();
            isOk = true;
        } catch (Exception e)
        {
            if (transaction != null)
            {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally
        {
            super.close();
        }
        return isOk;
    }

    // 新增私人好友信息
    public boolean savePersonalbooks(Personalbook personalbook) throws Exception
    {
        boolean isOk = false;
        try
        {
            session = super.getSession();
            transaction = session.beginTransaction();
            session.save(personalbook);
            transaction.commit();
            isOk = true;
        } catch (Exception e)
        {
            if (transaction != null)
            {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally
        {
            super.close();
        }
        return isOk;
    }

    // 根据用户编号进行修改登录密码
    public boolean updLoginPwd(Integer id, String pwd) throws Exception
    {
        boolean isOk = false;
        User user = null;
        try
        {
            session = super.getSession();
            transaction = session.beginTransaction();
            user = (User) session.get(User.class, id);
            if (user == null)
                return false;
            else
            {
                user.setUserPwd(pwd);
                transaction.commit();
                isOk = true;
            }
        } catch (Exception e)
        {
            if (transaction != null)
            {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally
        {
            super.close();
        }
        return isOk;
    }

    // 查询所有的员工信息
    @SuppressWarnings("unchecked")
    public List infoUserAll() throws Exception
    {
        List list = null;
        String hql = "from User";
        try
        {
            session = super.getSession();
            list = session.createQuery(hql).list();
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            super.close();
        }
        return list;
    }

    // 查询所有的部门信息
    @SuppressWarnings("unchecked")
    public List infoDeptAll() throws Exception
    {
        List list = null;
        String hql = "from Dept";
        try
        {
            session = super.getSession();
            list = session.createQuery(hql).list();
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            super.close();
        }
        return list;
    }

    // 根据类别查询所有的员工信息
    @SuppressWarnings("unchecked")
    public List infoUserAll(Integer type) throws Exception
    {
        List list = null;
        String hql = "from User u where u.dept.deptId = :deptId";
        try
        {
            session = super.getSession();
            list = session.createQuery(hql).setParameter("deptId", type).list();
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            super.close();
        }
        return list;
    }

    // 添加草稿箱信息
    public boolean saveDrafts(Outboxanddrafts outboxanddrafts) throws Exception
    {
        boolean isOk = false;
        try
        {
            session = super.getSession();
            transaction = session.beginTransaction();
            session.save(outboxanddrafts);
            transaction.commit();
            isOk = true;
        } catch (Exception e)
        {
            if (transaction != null)
            {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally
        {
            super.close();
        }
        return isOk;
    }

    // 发送邮件
    public boolean sendUserMail(Inboxanddustbin inboxanddustbin) throws Exception
    {
        return false;
    }

    // 根据用户编号查询所属草稿箱 或者查询所属发件箱
    @SuppressWarnings("unchecked")
    public List infoOutboxanddrafts(Integer userID, String infoType) throws Exception
    {
        List list = null;
        String hql = "from Outboxanddrafts o where o.user.userId = :userID and o.outdraType = :infoType";
        try
        {
            session = super.getSession();
            list = session.createQuery(hql).setParameter("userID", userID).setParameter("infoType", infoType).list();
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            super.close();
        }
        return list;
    }

    // 根据用户编号查询所属垃圾箱 或者查询所属收件箱
    @SuppressWarnings("unchecked")
    public List infoInboxanddustbin(Integer userID, String infoType) throws Exception
    {
        List list = null;
        String hql = "from Inboxanddustbin i where i.user.userId = :userID and i.inbdusType = :infoType";
        try
        {
            session = super.getSession();
            list = session.createQuery(hql).setParameter("userID", userID).setParameter("inbdusType", infoType).list();
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            super.close();
        }
        return list;
    }
}
