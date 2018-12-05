package script;


import com.alibaba.fastjson.JSON;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by yexianjin on 2018/5/2.
 */
public class ApplyGrouponBillEntityOld {

    public static class Reception {
        public static class ReceptionDay {
            private List<Integer> weeks;
            private Integer inventory;
            private List<RangeDateTime<String>> fieldTimes;
            private int playTime;

            public List<Integer> getWeeks() {
                return weeks;
            }

            public void setWeeks(List<Integer> weeks) {
                this.weeks = weeks;
            }

            public Integer getInventory() {
                return inventory;
            }

            public void setInventory(Integer inventory) {
                this.inventory = inventory;
            }

            public int getPlayTime() {
                return playTime;
            }

            public void setPlayTime(int playTime) {
                this.playTime = playTime;
            }

            public List<RangeDateTime<String>> getFieldTimes() {
                return fieldTimes;
            }

            public void setFieldTimes(List<RangeDateTime<String>> fieldTimes) {
                this.fieldTimes = fieldTimes;
            }
        }

        private boolean needAppoint;
        private RangeDateTime<String> receptionDate;
        private List<RangeDateTime<String>> excludeReceptionDate;
        private String suitableDay;
        private List<ReceptionDay> receptionDayInfo;


        public void removeNUllDate(){
            List<RangeDateTime<String>> result =null;
            if(CollectionUtils.isNotEmpty(this.excludeReceptionDate)){
                result =  this.excludeReceptionDate.stream().filter(item ->StringUtils.isNotBlank(item.getStart())&&
                        StringUtils.isNotBlank(item.getEnd())).collect(Collectors.toList());
            }
            if(CollectionUtils.isEmpty(result)){
                result  = null;
            }
            this.excludeReceptionDate =result;
        }

        public boolean isNeedAppoint() {
            return needAppoint;
        }

        public void setNeedAppoint(boolean needAppoint) {
            this.needAppoint = needAppoint;
        }

        public RangeDateTime<String> getReceptionDate() {
            return receptionDate;
        }

        public void setReceptionDate(RangeDateTime<String> receptionDate) {
            this.receptionDate = receptionDate;
        }

        public List<RangeDateTime<String>> getExcludeReceptionDate() {
            return excludeReceptionDate;
        }

        public void setExcludeReceptionDate(List<RangeDateTime<String>> excludeReceptionDate) {
            this.excludeReceptionDate = excludeReceptionDate;
        }

        public String getSuitableDay() {
            return suitableDay;
        }

        public void setSuitableDay(String suitableDay) {
            this.suitableDay = suitableDay;
        }

        public List<ReceptionDay> getReceptionDayInfo() {
            return receptionDayInfo;
        }

        public void setReceptionDayInfo(List<ReceptionDay> receptionDayInfo) {
            this.receptionDayInfo = receptionDayInfo;
        }
    }

    public static class SaleUnit {
        private String option;
        private Integer adtCount;
        private Integer chdCount;
        private Integer ticketCount;

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

    private String applyNo;
    private String bizType;
    private String bizTypeName;
    private String category;
    private String categoryName;
    private String itemType;
    private String itemTypeName;
    private List<ApplyShopModel> shopsInfo;
    private boolean hasSignedClub;
    private boolean hasAllDayTicket;
    private boolean directSign;
    private boolean sole;
    private Integer aheadDays;
    private String receptionMode;
    private int contractCount;
    private Reception receptionInfo;
    private String project;
    private Integer projectCount;
    private String setMeal;
    private String setMealRemark;
    private BigDecimal originPrice;
    private BigDecimal coinPrice;
    private String pricingParty;
    private BigDecimal price;
    private SaleUnit saleUnit;
    private RangeData<Integer> ageLimit;
    private RangeData<Integer> heightLimit;
    private String settlementType;
    private String accountPeriod;
    private String purchaseType;
    private BigDecimal moneyAmount;
    private BigDecimal settlementPrice;
    private String settlementStatement;
    private Integer ticketCount;
    private String additionalClause;

    public String getApplyNo() {
        return applyNo;
    }

    public void setApplyNo(String applyNo) {
        this.applyNo = applyNo;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getBizTypeName() {
        return bizTypeName;
    }

    public void setBizTypeName(String bizTypeName) {
        this.bizTypeName = bizTypeName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getItemTypeName() {
        return itemTypeName;
    }

    public void setItemTypeName(String itemTypeName) {
        this.itemTypeName = itemTypeName;
    }

    public List<ApplyShopModel> getShopsInfo() {
        return shopsInfo;
    }

    public void setShopsInfo(List<ApplyShopModel> shopsInfo) {
        this.shopsInfo = shopsInfo;
    }

    public boolean isHasSignedClub() {
        return hasSignedClub;
    }

    public void setHasSignedClub(boolean hasSignedClub) {
        this.hasSignedClub = hasSignedClub;
    }

    public boolean isHasAllDayTicket() {
        return hasAllDayTicket;
    }

    public void setHasAllDayTicket(boolean hasAllDayTicket) {
        this.hasAllDayTicket = hasAllDayTicket;
    }

    public boolean isDirectSign() {
        return directSign;
    }

    public void setDirectSign(boolean directSign) {
        this.directSign = directSign;
    }

    public boolean isSole() {
        return sole;
    }

    public void setSole(boolean sole) {
        this.sole = sole;
    }


    public String getReceptionMode() {
        return receptionMode;
    }

    public void setReceptionMode(String receptionMode) {
        this.receptionMode = receptionMode;
    }

    public int getContractCount() {
        return contractCount;
    }

    public void setContractCount(int contractCount) {
        this.contractCount = contractCount;
    }

    public Reception getReceptionInfo() {
        return receptionInfo;
    }

    public void setReceptionInfo(Reception receptionInfo) {
        this.receptionInfo = receptionInfo;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getSetMeal() {
        return setMeal;
    }

    public void setSetMeal(String setMeal) {
        this.setMeal = setMeal;
    }

    public String getSetMealRemark() {
        return setMealRemark;
    }

    public void setSetMealRemark(String setMealRemark) {
        this.setMealRemark = setMealRemark;
    }

    public BigDecimal getOriginPrice() {
        return originPrice;
    }

    public void setOriginPrice(BigDecimal originPrice) {
        this.originPrice = originPrice;
    }

    public String getPricingParty() {
        return pricingParty;
    }

    public void setPricingParty(String pricingParty) {
        this.pricingParty = pricingParty;
    }


    public SaleUnit getSaleUnit() {
        return saleUnit;
    }

    public void setSaleUnit(SaleUnit saleUnit) {
        this.saleUnit = saleUnit;
    }

    public RangeData<Integer> getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(RangeData<Integer> ageLimit) {
        this.ageLimit = ageLimit;
    }

    public RangeData<Integer> getHeightLimit() {
        return heightLimit;
    }

    public void setHeightLimit(RangeData<Integer> heightLimit) {
        this.heightLimit = heightLimit;
    }

    public String getSettlementType() {
        return settlementType;
    }

    public void setSettlementType(String settlementType) {
        this.settlementType = settlementType;
    }

    public String getAccountPeriod() {
        return accountPeriod;
    }

    public void setAccountPeriod(String accountPeriod) {
        this.accountPeriod = accountPeriod;
    }

    public String getPurchaseType() {
        return purchaseType;
    }

    public void setPurchaseType(String purchaseType) {
        this.purchaseType = purchaseType;
    }

    public String getSettlementStatement() {
        return settlementStatement;
    }

    public void setSettlementStatement(String settlementStatement) {
        this.settlementStatement = settlementStatement;
    }

    public Integer getTicketCount() {
        return ticketCount;
    }

    public void setTicketCount(Integer ticketCount) {
        this.ticketCount = ticketCount;
    }

    public BigDecimal getCoinPrice() {
        return coinPrice;
    }
    public void setCoinPrice(BigDecimal coinPrice) {
        this.coinPrice = coinPrice;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(BigDecimal moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public BigDecimal getSettlementPrice() {
        return settlementPrice;
    }

    public void setSettlementPrice(BigDecimal settlementPrice) {
        this.settlementPrice = settlementPrice;
    }

    public String getAdditionalClause() {
        return additionalClause;
    }

    public void setAdditionalClause(String additionalClause) {
        this.additionalClause = additionalClause;
    }

    public Integer getAheadDays() {
        return aheadDays;
    }

    public void setAheadDays(Integer aheadDays) {
        this.aheadDays = aheadDays;
    }

    public Integer getProjectCount() {
        return projectCount;
    }

    public void setProjectCount(Integer projectCount) {
        this.projectCount = projectCount;
    }

    public static void main(String args[]){
        String  jsonString="{\"accountPeriod\":\"week\",\"ageLimit\":{\"max\":10,\"min\":3},\"aheadDays\":null,\"applyNo\":\"DL20180509212981\",\"bizType\":\"groupon\",\"bizTypeName\":\"拼团\",\"category\":\"swjq\",\"categoryName\":\"室外景区(e.g.水上乐园)\",\"coinPrice\":0.0,\"contractCount\":-1,\"directSign\":true,\"hasAllDayTicket\":true,\"hasSignedClub\":true,\"heightLimit\":{\"max\":null,\"min\":null},\"itemType\":\"\",\"itemTypeName\":\"\",\"moneyAmount\":null,\"originPrice\":100.0,\"price\":40.0,\"pricingParty\":\"other\",\"project\":\"太阳雨\",\"purchaseType\":\"zhihuanmiandan\",\"receptionInfo\":{\"excludeReceptionDate\":[{\"end\":\"2018-05-12\",\"start\":\"2018-05-12\"}],\"needAppoint\":true,\"receptionDate\":{\"end\":\"2018-06-17\",\"start\":\"2018-05-09\"},\"receptionDayInfo\":[{\"fieldTimes\":[{\"end\":\"19:00\",\"start\":\"09:00\"}],\"inventory\":50,\"playTime\":-1,\"weeks\":[1,2,3,4,5]},{\"fieldTimes\":[{\"end\":\"23:28\",\"start\":\"09:00\"}],\"inventory\":200,\"playTime\":-1,\"weeks\":[6,7]},{\"fieldTimes\":[{\"end\":\"19:00\",\"start\":\"09:00\"}],\"inventory\":100,\"playTime\":-1,\"weeks\":[8]}],\"suitableDay\":\"all\"},\"receptionMode\":\"baochang\",\"saleUnit\":{\"adtCount\":2,\"chdCount\":1,\"option\":\"person\",\"ticketCount\":null},\"setMeal\":\"oneadultonechd\",\"setMealRemark\":\"\",\"settlementPrice\":10,\"settlementStatement\":\"风格化\",\"settlementType\":\"verify\",\"shopsInfo\":[{\"indoorArea\":56689.0,\"outdoorArea\":null,\"shoeCabinetCount\":null,\"shopBranchName\":\"佩奇分店\",\"shopId\":\"5ada90830cf28f56fd995c95\",\"shopName\":\"佩奇商户\"}],\"sole\":true,\"ticketCount\":5677}";

        ApplyGrouponBillEntity entity = JSON.parseObject(jsonString,ApplyGrouponBillEntity.class);
    }
}
