package net.linkcn.oa.entity;

/**
 * Label entity. @author MyEclipse Persistence Tools
 */
public class Label implements java.io.Serializable
{
    // Fields
    private Integer labelId;
    private String  labelType;
    private String  labelContent;
    private Integer userId;

    // Constructors
    /** default constructor */
    public Label()
    {
    }

    /** minimal constructor */
    public Label(String labelType, Integer userId)
    {
        this.labelType = labelType;
        this.userId = userId;
    }

    /** full constructor */
    public Label(String labelType, String labelContent, Integer userId)
    {
        this.labelType = labelType;
        this.labelContent = labelContent;
        this.userId = userId;
    }

    // Property accessors
    public Integer getLabelId()
    {
        return this.labelId;
    }

    public void setLabelId(Integer labelId)
    {
        this.labelId = labelId;
    }

    public String getLabelType()
    {
        return this.labelType;
    }

    public void setLabelType(String labelType)
    {
        this.labelType = labelType;
    }

    public String getLabelContent()
    {
        return this.labelContent;
    }

    public void setLabelContent(String labelContent)
    {
        this.labelContent = labelContent;
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