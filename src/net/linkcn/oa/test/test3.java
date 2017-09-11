package net.linkcn.oa.test;

import javax.mail.FetchProfile;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.UIDFolder;
import javax.mail.URLName;
import com.sun.mail.pop3.POP3Folder;

public class test3
{
    public static void main(String[] args) throws MessagingException
    {
        URLName url = new URLName("pop3", "smtp.qq.com", 465, "", "xiangjunzhong@qq.com", "nldbsgfexxxqdcgc");
        Session session = Session.getInstance(System.getProperties(), null);
        Store store = session.getStore(url);
        POP3Folder inbox = null;
        try
        {
            store.connect();
            inbox = (POP3Folder) store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);
            FetchProfile profile = new FetchProfile();
            profile.add(UIDFolder.FetchProfileItem.UID);
            profile.add(FetchProfile.Item.ENVELOPE);
            Message[] messages = inbox.getMessages();
            inbox.fetch(messages, profile);
            int j = messages.length - 1;
            for (int i = 0; i < messages.length; i++, j--)
                System.out.println(inbox.getUID(messages[i]));
        } finally
        {
            try
            {
                inbox.close(false);
            } catch (Exception e)
            {
            }
            try
            {
                store.close();
            } catch (Exception e)
            {
            }
        }
    }
}
