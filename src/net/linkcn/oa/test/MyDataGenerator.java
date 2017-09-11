package net.linkcn.oa.test;

import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import net.linkcn.oa.entity.Inboxanddustbin;
import net.linkcn.oa.util.HibernateUtil;

public class MyDataGenerator extends SchedThread
{
    Session session = HibernateUtil.getSession();
    String  hql     = "from Inboxanddustbin i where i.inbdusDeptId = :deptId and "
        + "i.user.userId = :userId and i.inbdusType = :type and i.inbdusIsnewtype = :isNewType";

    @SuppressWarnings("unchecked")
    protected List<Inboxanddustbin> executeWork()
    {
        Query query = session.createQuery(hql);
        query.setParameter("deptId", 2);
        query.setParameter("userId", 1);
        query.setParameter("type", "收");
        query.setParameter("isNewType", "新");
        List<Inboxanddustbin> list = query.list();
        for (Iterator iterator = list.iterator(); iterator.hasNext();)
        {
            Inboxanddustbin user = (Inboxanddustbin) iterator.next();
            System.out.println(user.getInbdusId() + " " + user.getUser().getUserId());
        }
        System.out.println("Execute work ...");
        return list;
    }

    protected long getNextTime()
    {
        return System.currentTimeMillis() + 2000L;
    }

    public static void main(String argv[])
    {
        MyDataGenerator generator = new MyDataGenerator();
        generator.start();
    }
}