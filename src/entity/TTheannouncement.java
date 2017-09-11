package entity;

import java.sql.Timestamp;

/**
 * TTheannouncement entity. @author MyEclipse Persistence Tools
 */
public class TTheannouncement implements java.io.Serializable
{
    // Fields
    private Integer   theId;
    private String    theTitle;
    private String    theReleasePeople;
    private Timestamp theReleasePeopleTime;
    private Timestamp theShowTime;
    private Timestamp theEndOfTime;
    private String    theContent;

    // Constructors
    /** default constructor */
    public TTheannouncement()
    {
    }

    /** minimal constructor */
    public TTheannouncement(String theTitle, String theReleasePeople, Timestamp theReleasePeopleTime, String theContent)
    {
        this.theTitle = theTitle;
        this.theReleasePeople = theReleasePeople;
        this.theReleasePeopleTime = theReleasePeopleTime;
        this.theContent = theContent;
    }

    /** full constructor */
    public TTheannouncement(String theTitle, String theReleasePeople, Timestamp theReleasePeopleTime, Timestamp theShowTime, Timestamp theEndOfTime, String theContent)
    {
        this.theTitle = theTitle;
        this.theReleasePeople = theReleasePeople;
        this.theReleasePeopleTime = theReleasePeopleTime;
        this.theShowTime = theShowTime;
        this.theEndOfTime = theEndOfTime;
        this.theContent = theContent;
    }

    // Property accessors
    public Integer getTheId()
    {
        return this.theId;
    }

    public void setTheId(Integer theId)
    {
        this.theId = theId;
    }

    public String getTheTitle()
    {
        return this.theTitle;
    }

    public void setTheTitle(String theTitle)
    {
        this.theTitle = theTitle;
    }

    public String getTheReleasePeople()
    {
        return this.theReleasePeople;
    }

    public void setTheReleasePeople(String theReleasePeople)
    {
        this.theReleasePeople = theReleasePeople;
    }

    public Timestamp getTheReleasePeopleTime()
    {
        return this.theReleasePeopleTime;
    }

    public void setTheReleasePeopleTime(Timestamp theReleasePeopleTime)
    {
        this.theReleasePeopleTime = theReleasePeopleTime;
    }

    public Timestamp getTheShowTime()
    {
        return this.theShowTime;
    }

    public void setTheShowTime(Timestamp theShowTime)
    {
        this.theShowTime = theShowTime;
    }

    public Timestamp getTheEndOfTime()
    {
        return this.theEndOfTime;
    }

    public void setTheEndOfTime(Timestamp theEndOfTime)
    {
        this.theEndOfTime = theEndOfTime;
    }

    public String getTheContent()
    {
        return this.theContent;
    }

    public void setTheContent(String theContent)
    {
        this.theContent = theContent;
    }
}