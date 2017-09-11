package net.linkcn.oa.entity;

/**
 * Personalbook entity. @author MyEclipse Persistence Tools
 */
public class Personalbook implements java.io.Serializable
{
    // Fields
    private Integer perbookId;
    private Integer friendId;
    private String  perbookUsename;
    private String  perbookPhone;
    private String  perbookMail;
    private String  perbookDate;
    private Integer userId;

    // Constructors
    /** default constructor */
    public Personalbook()
    {
    }

    /** minimal constructor */
    public Personalbook(Integer friendId, String perbookUsename, String perbookMail, String perbookDate, Integer userId)
    {
        this.friendId = friendId;
        this.perbookUsename = perbookUsename;
        this.perbookMail = perbookMail;
        this.perbookDate = perbookDate;
        this.userId = userId;
    }

    /** full constructor */
    public Personalbook(Integer friendId, String perbookUsename, String perbookPhone, String perbookMail, String perbookDate, Integer userId)
    {
        this.friendId = friendId;
        this.perbookUsename = perbookUsename;
        this.perbookPhone = perbookPhone;
        this.perbookMail = perbookMail;
        this.perbookDate = perbookDate;
        this.userId = userId;
    }

    // Property accessors
    public Integer getPerbookId()
    {
        return this.perbookId;
    }

    public void setPerbookId(Integer perbookId)
    {
        this.perbookId = perbookId;
    }

    public Integer getFriendId()
    {
        return this.friendId;
    }

    public void setFriendId(Integer friendId)
    {
        this.friendId = friendId;
    }

    public String getPerbookUsename()
    {
        return this.perbookUsename;
    }

    public void setPerbookUsename(String perbookUsename)
    {
        this.perbookUsename = perbookUsename;
    }

    public String getPerbookPhone()
    {
        return this.perbookPhone;
    }

    public void setPerbookPhone(String perbookPhone)
    {
        this.perbookPhone = perbookPhone;
    }

    public String getPerbookMail()
    {
        return this.perbookMail;
    }

    public void setPerbookMail(String perbookMail)
    {
        this.perbookMail = perbookMail;
    }

    public String getPerbookDate()
    {
        return this.perbookDate;
    }

    public void setPerbookDate(String perbookDate)
    {
        this.perbookDate = perbookDate;
    }

    public Integer getUserId()
    {
        return this.userId;
    }

    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }
}