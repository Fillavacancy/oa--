package net.linkcn.oa.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
public class User implements java.io.Serializable
{
    // Fields
    private Integer   userId;
    private Encrypted encrypted;
    private Dept      dept;
    private UserType  userType;
    private String    userName;
    private String    userPwd;
    private String    userRealName;
    private String    userSex;
    private Integer   userAge;
    private String    userIdentity;
    private String    userPhone;
    private String    userContent;
    private String    userBirthday;
    private String    userState;
    private String    userHomeaddress;
    private String    userCompanyaddress;
    private String    userMail;
    private String    userLock;
    private Set       inboxanddustbins  = new HashSet(0);
    private Set       outboxanddraftses = new HashSet(0);

    // Constructors
    /** default constructor */
    public User()
    {
    }

    /** minimal constructor */
    public User(Encrypted encrypted, UserType userType, String userName, String userPwd, String userRealName, String userIdentity, String userPhone, String userContent, String userMail)
    {
        this.encrypted = encrypted;
        this.userType = userType;
        this.userName = userName;
        this.userPwd = userPwd;
        this.userRealName = userRealName;
        this.userIdentity = userIdentity;
        this.userPhone = userPhone;
        this.userContent = userContent;
        this.userMail = userMail;
    }

    /** full constructor */
    public User(Encrypted encrypted, Dept dept, UserType userType, String userName, String userPwd, String userRealName, String userSex, Integer userAge, String userIdentity, String userPhone, String userContent, String userBirthday, String userState, String userHomeaddress, String userCompanyaddress, String userMail, String userLock, Set inboxanddustbins, Set outboxanddraftses)
    {
        this.encrypted = encrypted;
        this.dept = dept;
        this.userType = userType;
        this.userName = userName;
        this.userPwd = userPwd;
        this.userRealName = userRealName;
        this.userSex = userSex;
        this.userAge = userAge;
        this.userIdentity = userIdentity;
        this.userPhone = userPhone;
        this.userContent = userContent;
        this.userBirthday = userBirthday;
        this.userState = userState;
        this.userHomeaddress = userHomeaddress;
        this.userCompanyaddress = userCompanyaddress;
        this.userMail = userMail;
        this.userLock = userLock;
        this.inboxanddustbins = inboxanddustbins;
        this.outboxanddraftses = outboxanddraftses;
    }

    // Property accessors
    public Integer getUserId()
    {
        return this.userId;
    }

    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }

    public Encrypted getEncrypted()
    {
        return this.encrypted;
    }

    public void setEncrypted(Encrypted encrypted)
    {
        this.encrypted = encrypted;
    }

    public Dept getDept()
    {
        return this.dept;
    }

    public void setDept(Dept dept)
    {
        this.dept = dept;
    }

    public UserType getUserType()
    {
        return this.userType;
    }

    public void setUserType(UserType userType)
    {
        this.userType = userType;
    }

    public String getUserName()
    {
        return this.userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getUserPwd()
    {
        return this.userPwd;
    }

    public void setUserPwd(String userPwd)
    {
        this.userPwd = userPwd;
    }

    public String getUserRealName()
    {
        return this.userRealName;
    }

    public void setUserRealName(String userRealName)
    {
        this.userRealName = userRealName;
    }

    public String getUserSex()
    {
        return this.userSex;
    }

    public void setUserSex(String userSex)
    {
        this.userSex = userSex;
    }

    public Integer getUserAge()
    {
        return this.userAge;
    }

    public void setUserAge(Integer userAge)
    {
        this.userAge = userAge;
    }

    public String getUserIdentity()
    {
        return this.userIdentity;
    }

    public void setUserIdentity(String userIdentity)
    {
        this.userIdentity = userIdentity;
    }

    public String getUserPhone()
    {
        return this.userPhone;
    }

    public void setUserPhone(String userPhone)
    {
        this.userPhone = userPhone;
    }

    public String getUserContent()
    {
        return this.userContent;
    }

    public void setUserContent(String userContent)
    {
        this.userContent = userContent;
    }

    public String getUserBirthday()
    {
        return this.userBirthday;
    }

    public void setUserBirthday(String userBirthday)
    {
        this.userBirthday = userBirthday;
    }

    public String getUserState()
    {
        return this.userState;
    }

    public void setUserState(String userState)
    {
        this.userState = userState;
    }

    public String getUserHomeaddress()
    {
        return this.userHomeaddress;
    }

    public void setUserHomeaddress(String userHomeaddress)
    {
        this.userHomeaddress = userHomeaddress;
    }

    public String getUserCompanyaddress()
    {
        return this.userCompanyaddress;
    }

    public void setUserCompanyaddress(String userCompanyaddress)
    {
        this.userCompanyaddress = userCompanyaddress;
    }

    public String getUserMail()
    {
        return this.userMail;
    }

    public void setUserMail(String userMail)
    {
        this.userMail = userMail;
    }

    public String getUserLock()
    {
        return this.userLock;
    }

    public void setUserLock(String userLock)
    {
        this.userLock = userLock;
    }

    public Set getInboxanddustbins()
    {
        return this.inboxanddustbins;
    }

    public void setInboxanddustbins(Set inboxanddustbins)
    {
        this.inboxanddustbins = inboxanddustbins;
    }

    public Set getOutboxanddraftses()
    {
        return this.outboxanddraftses;
    }

    public void setOutboxanddraftses(Set outboxanddraftses)
    {
        this.outboxanddraftses = outboxanddraftses;
    }
}