package entity;

/**
 * TInformation entity. @author MyEclipse Persistence Tools
 */
public class TInformation implements java.io.Serializable
{
    // Fields
    private Integer IId;
    private String  ITitle;
    private String  IContent;
    private Boolean IState;
    private String  IPublisher;
    private String  IPublishTime;
    private String  ITypeName;
    private String  IFilePath;
    private String  IFileSize;
    private String  IUploadTime;
    private Integer IDownloadNum;
    private String  IDownloadExplain;

    // Constructors
    /** default constructor */
    public TInformation()
    {
    }

    /** minimal constructor */
    public TInformation(String ITitle, String IPublisher, String IPublishTime, String ITypeName)
    {
        this.ITitle = ITitle;
        this.IPublisher = IPublisher;
        this.IPublishTime = IPublishTime;
        this.ITypeName = ITypeName;
    }

    /** full constructor */
    public TInformation(String ITitle, String IContent, Boolean IState, String IPublisher, String IPublishTime, String ITypeName, String IFilePath, String IFileSize, String IUploadTime, Integer IDownloadNum, String IDownloadExplain)
    {
        this.ITitle = ITitle;
        this.IContent = IContent;
        this.IState = IState;
        this.IPublisher = IPublisher;
        this.IPublishTime = IPublishTime;
        this.ITypeName = ITypeName;
        this.IFilePath = IFilePath;
        this.IFileSize = IFileSize;
        this.IUploadTime = IUploadTime;
        this.IDownloadNum = IDownloadNum;
        this.IDownloadExplain = IDownloadExplain;
    }

    // Property accessors
    public Integer getIId()
    {
        return this.IId;
    }

    public void setIId(Integer IId)
    {
        this.IId = IId;
    }

    public String getITitle()
    {
        return this.ITitle;
    }

    public void setITitle(String ITitle)
    {
        this.ITitle = ITitle;
    }

    public String getIContent()
    {
        return this.IContent;
    }

    public void setIContent(String IContent)
    {
        this.IContent = IContent;
    }

    public Boolean getIState()
    {
        return this.IState;
    }

    public void setIState(Boolean IState)
    {
        this.IState = IState;
    }

    public String getIPublisher()
    {
        return this.IPublisher;
    }

    public void setIPublisher(String IPublisher)
    {
        this.IPublisher = IPublisher;
    }

    public String getIPublishTime()
    {
        return this.IPublishTime;
    }

    public void setIPublishTime(String IPublishTime)
    {
        this.IPublishTime = IPublishTime;
    }

    public String getITypeName()
    {
        return this.ITypeName;
    }

    public void setITypeName(String ITypeName)
    {
        this.ITypeName = ITypeName;
    }

    public String getIFilePath()
    {
        return this.IFilePath;
    }

    public void setIFilePath(String IFilePath)
    {
        this.IFilePath = IFilePath;
    }

    public String getIFileSize()
    {
        return this.IFileSize;
    }

    public void setIFileSize(String IFileSize)
    {
        this.IFileSize = IFileSize;
    }

    public String getIUploadTime()
    {
        return this.IUploadTime;
    }

    public void setIUploadTime(String IUploadTime)
    {
        this.IUploadTime = IUploadTime;
    }

    public Integer getIDownloadNum()
    {
        return this.IDownloadNum;
    }

    public void setIDownloadNum(Integer IDownloadNum)
    {
        this.IDownloadNum = IDownloadNum;
    }

    public String getIDownloadExplain()
    {
        return this.IDownloadExplain;
    }

    public void setIDownloadExplain(String IDownloadExplain)
    {
        this.IDownloadExplain = IDownloadExplain;
    }
}