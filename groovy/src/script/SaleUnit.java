package script;

import org.apache.commons.lang3.StringUtils;

public class SaleUnit{
    private String option;
    private Integer adtCount;
    private Integer chdCount;
    private Integer ticketCount;

    public boolean validate() {
        if (StringUtils.isBlank(option)) {
            return false;
        }
        if (StringUtils.equals(option, "person") && (adtCount == null || adtCount <= 0) && (chdCount == null || chdCount <= 0)) {
            return false;
        }
        if (StringUtils.equals(option, "ticket") && (ticketCount == null || ticketCount <= 0)) {
            return false;
        }
        return true;
    }

    public String createDesc() {
        if (StringUtils.equals("person", option)) {
            if (adtCount != null && adtCount > 0 && chdCount != null && chdCount > 0) {
                return adtCount + "大" + chdCount + "小";
            } else if (adtCount != null && adtCount > 0) {
                return adtCount + "位成人";
            } else if (chdCount != null && chdCount > 0) {
                return chdCount + "位儿童";
            }
        } else if (StringUtils.equals("ticket", option) && ticketCount != null && ticketCount > 0) {
            return ticketCount + "张门票";
        }
        return "";
    }



    public String getUnitDesc() {
        if (StringUtils.equals("person", option)) {
            if (adtCount != null && adtCount > 0 && chdCount != null && chdCount > 0) {
                return adtCount + "大" + chdCount + "小";
            } else if (adtCount != null && adtCount > 0) {
                return adtCount + "位成人";
            } else if (chdCount != null && chdCount > 0) {
                return chdCount + "位儿童";
            }
        } else if (StringUtils.equals("ticket", option) && ticketCount != null && ticketCount > 0) {
            return ticketCount + "张门票";
        }
        return "";
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public Integer getAdtCount() {
        return adtCount;
    }

    public void setAdtCount(Integer adtCount) {
        this.adtCount = adtCount;
    }

    public Integer getChdCount() {
        return chdCount;
    }

    public void setChdCount(Integer chdCount) {
        this.chdCount = chdCount;
    }

    public Integer getTicketCount() {
        return ticketCount;
    }

    public void setTicketCount(Integer ticketCount) {
        this.ticketCount = ticketCount;
    }
}
