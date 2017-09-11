package net.linkcn.oa.entity;

/**
 * Outboxanddrafts entity. @author MyEclipse Persistence Tools
 */
public class Outboxanddrafts implements java.io.Serializable
{
    // Fields
    private Integer outdraId;
    private User    user;
    private String  outdraUserMail;
    private String  outdraRecipients;
    private String  outdraPeopleWhoCopied;
    private String  outdraBlindCarbon;
    private String  outdraSubject;
    private String  outdraAccessory;
    private String  outdraContent;
    private String  outdraDate;
    private String  outdraType;

    // Constructors
    /** default constructor */
    public Outboxanddrafts()
    {
    }

    /** minimal constructor */
    public Outboxanddrafts(User user, String outdraUserMail, String outdraDate, String outdraType)
    {
        this.user = user;
        this.outdraUserMail = outdraUserMail;
        this.outdraDate = outdraDate;
        this.outdraType = outdraType;
    }

    /** full constructor */
    public Outboxanddrafts(User user, String outdraUserMail, String outdraRecipients, String outdraPeopleWhoCopied, String outdraBlindCarbon, String outdraSubject, String outdraAccessory, String outdraContent, String outdraDate, String outdraType)
    {
        this.user = user;
        this.outdraUserMail = outdraUserMail;
        this.outdraRecipients = outdraRecipients;
        this.outdraPeopleWhoCopied = outdraPeopleWhoCopied;
        this.outdraBlindCarbon = outdraBlindCarbon;
        this.outdraSubject = outdraSubject;
        this.outdraAccessory = outdraAccessory;
        this.outdraContent = outdraContent;
        this.outdraDate = outdraDate;
        this.outdraType = outdraType;
    }

    // Property accessors
    public Integer getOutdraId()
    {
        return this.outdraId;
    }

    public void setOutdraId(Integer outdraId)
    {
        this.outdraId = outdraId;
    }

    public User getUser()
    {
        return this.user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public String getOutdraUserMail()
    {
        return this.outdraUserMail;
    }

    public void setOutdraUserMail(String outdraUserMail)
    {
        this.outdraUserMail = outdraUserMail;
    }

    public String getOutdraRecipients()
    {
        return this.outdraRecipients;
    }

    public void setOutdraRecipients(String outdraRecipients)
    {
        this.outdraRecipients = outdraRecipients;
    }

    public String getOutdraPeopleWhoCopied()
    {
        return this.outdraPeopleWhoCopied;
    }

    public void setOutdraPeopleWhoCopied(String outdraPeopleWhoCopied)
    {
        this.outdraPeopleWhoCopied = outdraPeopleWhoCopied;
    }

    public String getOutdraBlindCarbon()
    {
        return this.outdraBlindCarbon;
    }

    public void setOutdraBlindCarbon(String outdraBlindCarbon)
    {
        this.outdraBlindCarbon = outdraBlindCarbon;
    }

    public String getOutdraSubject()
    {
        return this.outdraSubject;
    }

    public void setOutdraSubject(String outdraSubject)
    {
        this.outdraSubject = outdraSubject;
    }

    public String getOutdraAccessory()
    {
        return this.outdraAccessory;
    }

    public void setOutdraAccessory(String outdraAccessory)
    {
        this.outdraAccessory = outdraAccessory;
    }

    public String getOutdraContent()
    {
        return this.outdraContent;
    }

    public void setOutdraContent(String outdraContent)
    {
        this.outdraContent = outdraContent;
    }

    public String getOutdraDate()
    {
        return this.outdraDate;
    }

    public void setOutdraDate(String outdraDate)
    {
        this.outdraDate = outdraDate;
    }

    public String getOutdraType()
    {
        return this.outdraType;
    }

    public void setOutdraType(String outdraType)
    {
        this.outdraType = outdraType;
    }
}