package cn.lcf.ims.entity;


public class BaseChannel implements java.io.Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long channelId;
    private String channelName;
    private String description;
    private String enabledFlag;
    private Long  parentChannelId;
    private String  segment1;
    private String segment2;
    private String segment3;
    private String segment4;
    private String segment5;
    private String segment6;
    private String segment7;
    private String segment8;
    private String segment9;
    private String segment10;
    
    private String channelCode;
    
    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setEnabledFlag(String enabledFlag) {
        this.enabledFlag = enabledFlag;
    }

    public String getEnabledFlag() {
        return enabledFlag;
    }

    public void setParentChannelId(Long parentChannelId) {
        this.parentChannelId = parentChannelId;
    }

    public Long getParentChannelId() {
        return parentChannelId;
    }

    public void setSegment1(String segment1) {
        this.segment1 = segment1;
    }

    public String getSegment1() {
        return segment1;
    }

    public void setSegment2(String segment2) {
        this.segment2 = segment2;
    }

    public String getSegment2() {
        return segment2;
    }

    public void setSegment3(String segment3) {
        this.segment3 = segment3;
    }

    public String getSegment3() {
        return segment3;
    }

    public void setSegment4(String segment4) {
        this.segment4 = segment4;
    }

    public String getSegment4() {
        return segment4;
    }

    public void setSegment5(String segment5) {
        this.segment5 = segment5;
    }

    public String getSegment5() {
        return segment5;
    }

    public void setSegment6(String segment6) {
        this.segment6 = segment6;
    }

    public String getSegment6() {
        return segment6;
    }

    public void setSegment7(String segment7) {
        this.segment7 = segment7;
    }

    public String getSegment7() {
        return segment7;
    }

    public void setSegment8(String segment8) {
        this.segment8 = segment8;
    }

    public String getSegment8() {
        return segment8;
    }

    public void setSegment9(String segment9) {
        this.segment9 = segment9;
    }

    public String getSegment9() {
        return segment9;
    }

    public void setSegment10(String segment10) {
        this.segment10 = segment10;
    }

    public String getSegment10() {
        return segment10;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public String getChannelCode() {
        return channelCode;
    }
}
