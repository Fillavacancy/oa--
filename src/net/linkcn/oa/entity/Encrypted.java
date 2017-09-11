package net.linkcn.oa.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Encrypted entity. @author MyEclipse Persistence Tools
 */
public class Encrypted implements java.io.Serializable
{
    // Fields
    private Integer encrId;
    private String  encrName;
    private Set     users = new HashSet(0);

    // Constructors
    /** default constructor */
    public Encrypted()
    {
    }

    /** minimal constructor */
    public Encrypted(String encrName)
    {
        this.encrName = encrName;
    }

    /** full constructor */
    public Encrypted(String encrName, Set users)
    {
        this.encrName = encrName;
        this.users = users;
    }

    // Property accessors
    public Integer getEncrId()
    {
        return this.encrId;
    }

    public void setEncrId(Integer encrId)
    {
        this.encrId = encrId;
    }

    public String getEncrName()
    {
        return this.encrName;
    }

    public void setEncrName(String encrName)
    {
        this.encrName = encrName;
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