package net.linkcn.oa.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * UserType entity. @author MyEclipse Persistence Tools
 */
public class UserType implements java.io.Serializable
{
    // Fields
    private Integer utypeId;
    private String  utypeName;
    private Set     users = new HashSet(0);

    // Constructors
    /** default constructor */
    public UserType()
    {
    }

    /** minimal constructor */
    public UserType(String utypeName)
    {
        this.utypeName = utypeName;
    }

    /** full constructor */
    public UserType(String utypeName, Set users)
    {
        this.utypeName = utypeName;
        this.users = users;
    }

    // Property accessors
    public Integer getUtypeId()
    {
        return this.utypeId;
    }

    public void setUtypeId(Integer utypeId)
    {
        this.utypeId = utypeId;
    }

    public String getUtypeName()
    {
        return this.utypeName;
    }

    public void setUtypeName(String utypeName)
    {
        this.utypeName = utypeName;
    }

    public Set getUsers()
    {
        return this.users;
    }

    public void setUsers(Set users)
    {
        this.users = users;
    }
}