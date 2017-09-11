package net.linkcn.oa.entity;

/**
 * Inboxanddustbin entity. @author MyEclipse Persistence Tools
 */
public class Inboxanddustbin implements java.io.Serializable
{
    // Fields
    private Integer inbdusId;
    private User    user;
    private String  inbdusUserMail;
    private String  inbdusAddresser;
    private String  inbdusDate;
    private String  inbdusSubject;
    private String  inbdusRecipients;
    private String  inbdusPeopleWhoCopied;
    private String  inbdusBlindCarbon;
    private String  inbdusContent;
    private String  inbdusAccessory;
    private Integer inbdusDeptId;
    private String  inbdusType;
    private String  inbdusIsnewtype;

    // Constructors
    /** default constructor */
    public Inboxanddustbin()
    {
    }

    public Inboxanddustbin(Integer inbdusId, User user, String inbdusUserMail, String inbdusAddresser, String inbdusDate, String inbdusSubject, String inbdusRecipients, String inbdusPeopleWhoCopied, String inbdusBlindCarbon, String inbdusContent, String inbdusAccessory, Integer inbdusDeptId, String inbdusType, String inbdusIsnewtype)
    {
        this.inbdusId = inbdusId;
        this.user = user;
        this.inbdusUserMail = inbdusUserMail;
        this.inbdusAddresser = inbdusAddresser;
        this.inbdusDate = inbdusDate;
        this.inbdusSubject = inbdusSubject;
        this.inbdusRecipients = inbdusRecipients;
        this.inbdusPeopleWhoCopied = inbdusPeopleWhoCopied;
        this.inbdusBlindCarbon = inbdusBlindCarbon;
        this.inbdusContent = inbdusContent;
        this.inbdusAccessory = inbdusAccessory;
        this.inbdusDeptId = inbdusDeptId;
        this.inbdusType = inbdusType;
        this.inbdusIsnewtype = inbdusIsnewtype;
    }

    public Integer getInbdusId()
    {
        return inbdusId;
    }

    public void setInbdusId(Integer inbdusId)
    {
        this.inbdusId = inbdusId;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public String getInbdusUserMail()
    {
        return inbdusUserMail;
    }

    public void setInbdusUserMail(String inbdusUserMail)
    {
        this.inbdusUserMail = inbdusUserMail;
    }

    public String getInbdusAddresser()
    {
        return inbdusAddresser;
    }

    public void setInbdusAddresser(String inbdusAddresser)
    {
        this.inbdusAddresser = inbdusAddresser;
    }

    public String getInbdusDate()
    {
        return inbdusDate;
    }

    public void setInbdusDate(String inbdusDate)
    {
        this.inbdusDate = inbdusDate;
    }

    public String getInbdusSubject()
    {
        return inbdusSubject;
    }

    public void setInbdusSubject(String inbdusSubject)
    {
        this.inbdusSubject = inbdusSubject;
    }

    public String getInbdusRecipients()
    {
        return inbdusRecipients;
    }

    public void setInbdusRecipients(String inbdusRecipients)
    {
        this.inbdusRecipients = inbdusRecipients;
    }

    public String getInbdusPeopleWhoCopied()
    {
        return inbdusPeopleWhoCopied;
    }

    public void setInbdusPeopleWhoCopied(String inbdusPeopleWhoCopied)
    {
        this.inbdusPeopleWhoCopied = inbdusPeopleWhoCopied;
    }

    public String getInbdusBlindCarbon()
    {
        return inbdusBlindCarbon;
    }

    public void setInbdusBlindCarbon(String inbdusBlindCarbon)
    {
        this.inbdusBlindCarbon = inbdusBlindCarbon;
    }

    public String getInbdusContent()
    {
        return inbdusContent;
    }

    public void setInbdusContent(String inbdusContent)
    {
        this.inbdusContent = inbdusContent;
    }

    public String getInbdusAccessory()
    {
        return inbdusAccessory;
    }

    public void setInbdusAccessory(String inbdusAccessory)
    {
        this.inbdusAccessory = inbdusAccessory;
    }

    public Integer getInbdusDeptId()
    {
        return inbdusDeptId;
    }

    public void setInbdusDeptId(Integer inbdusDeptId)
    {
        this.inbdusDeptId = inbdusDeptId;
    }

    public String getInbdusType()
    {
        return inbdusType;
    }

    public void setInbdusType(String inbdusType)
    {
        this.inbdusType = inbdusType;
    }

    public String getInbdusIsnewtype()
    {
        return inbdusIsnewtype;
    }

    public void setInbdusIsnewtype(String inbdusIsnewtype)
    {
        this.inbdusIsnewtype = inbdusIsnewtype;
    }
}