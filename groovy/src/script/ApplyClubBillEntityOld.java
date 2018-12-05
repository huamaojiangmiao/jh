package script;


import java.math.BigDecimal;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Lists;

public class ApplyClubBillEntityOld {

    private String applyNo;
    private String category;
    private String categoryName;
    private String secondCategory;
    private String secondCategoryName;
    private String bizType;
    private List<ApplyShop> shopsInfo;

    private List<Project> commonProjects;

    // 合作剧目
    private String show;
    // 演出时长
    private Integer showTime;
    private Cooperation attention;
    private List<PlayProject> playProjects;

    private boolean directSign;
    private boolean sole;
    private String settleType;
    private String purchaseType;
    private String accountPeriod;
    private BigDecimal money;
    private String settlementStatement;

    public static class Project{
        private String type;
        private Integer signAmount;
        private Cooperation coProject;
        private SaleUnit unit;
        private String unitDesc;
        private String ticketDesc;
        private String seatType;
        private Double settlePrice;
        private Double marketPrice;
        private List<Inventory> inventoryList;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Integer getSignAmount() {
            return signAmount;
        }

        public void setSignAmount(Integer signAmount) {
            this.signAmount = signAmount;
        }

        public Cooperation getCoProject() {
            return coProject;
        }

        public void setCoProject(Cooperation coProject) {
            this.coProject = coProject;
        }

        public List<Inventory> getInventoryList() {
            return inventoryList;
        }

        public void setInventoryList(List<Inventory> inventoryList) {
            this.inventoryList = inventoryList;
        }

        public SaleUnit getUnit() {
            return unit;
        }

        public void setUnit(SaleUnit unit) {
            this.unit = unit;
        }

        public String getUnitDesc() {
            return unitDesc;
        }

        public void setUnitDesc(String unitDesc) {
            this.unitDesc = unitDesc;
        }

        public String getTicketDesc() {
            return ticketDesc;
        }

        public void setTicketDesc(String ticketDesc) {
            this.ticketDesc = ticketDesc;
        }

        public String getSeatType() {
            return seatType;
        }

        public void setSeatType(String seatType) {
            this.seatType = seatType;
        }

        public Double getSettlePrice() {
            return settlePrice;
        }

        public void setSettlePrice(Double settlePrice) {
            this.settlePrice = settlePrice;
        }

        public Double getMarketPrice() {
            return marketPrice;
        }

        public void setMarketPrice(Double marketPrice) {
            this.marketPrice = marketPrice;
        }
    }

    public static class PlayProject {
        private String type;
        private SaleUnit unit;
        private String unitDesc;
        private String ticketDesc;
        private String seatType;
        private Double settlePrice;
        private Double marketPrice;
        private List<Inventory> inventoryList;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Double getSettlePrice() {
            return settlePrice;
        }

        public void setSettlePrice(Double settlePrice) {
            this.settlePrice = settlePrice;
        }

        public SaleUnit getUnit() {
            return unit;
        }

        public String getUnitDesc() {
            return unitDesc;
        }

        public Double getMarketPrice() {
            return marketPrice;
        }

        public void setMarketPrice(Double marketPrice) {
            this.marketPrice = marketPrice;
        }

        static Pattern ticketPattern = Pattern.compile("(\\d+)张门票");
        static Pattern onePersonPattern = Pattern.compile("(\\d+)位(成人|儿童)");
        static Pattern personPattern = Pattern.compile("(\\d+)大(\\d+)小");

        public void setUnitDesc(String unitDesc) {
            this.unitDesc = unitDesc;
            if (StringUtils.isNotBlank(unitDesc)) {
                unit = new SaleUnit();
                Matcher matcher = ticketPattern.matcher(unitDesc);
                if (matcher.matches()) {
                    unit.setOption("ticket");
                    unit.setTicketCount(Integer.valueOf(matcher.group(1)));
                }
                matcher = onePersonPattern.matcher(unitDesc);
                if (matcher.matches()) {
                    unit.setOption("person");
                    if (unitDesc.contains("成人")) {
                        unit.setAdtCount(Integer.valueOf(matcher.group(1)));
                    } else {
                        unit.setChdCount(Integer.valueOf(matcher.group(1)));
                    }
                }
                matcher = personPattern.matcher(unitDesc);
                if (matcher.matches()) {
                    unit.setOption("person");
                    unit.setChdCount(Integer.valueOf(matcher.group(2)));
                    unit.setAdtCount(Integer.valueOf(matcher.group(1)));
                }
                this.unit = unit;
            }
        }


        public static SaleUnit convertUnit(String desc) {
            SaleUnit saleUnit = new SaleUnit();
            if (StringUtils.isNotBlank(desc)) {
                Matcher matcher = ticketPattern.matcher(desc);
                if (matcher.matches()) {
                    saleUnit.setOption("ticket");
                    saleUnit.setTicketCount(Integer.valueOf(matcher.group(1)));
                }
                matcher = onePersonPattern.matcher(desc);
                if (matcher.matches()) {
                    saleUnit.setOption("person");
                    if (desc.contains("成人")) {
                        saleUnit.setAdtCount(Integer.valueOf(matcher.group(1)));
                    } else {
                        saleUnit.setChdCount(Integer.valueOf(matcher.group(1)));
                    }
                }
                matcher = personPattern.matcher(desc);
                if (matcher.matches()) {
                    saleUnit.setOption("person");
                    saleUnit.setChdCount(Integer.valueOf(matcher.group(2)));
                    saleUnit.setAdtCount(Integer.valueOf(matcher.group(1)));
                }
            }
            return saleUnit;
        }


        public void setUnit(SaleUnit unit) {
            this.unit = unit;
        }

        public String getTicketDesc() {
            return ticketDesc;
        }

        public void setTicketDesc(String ticketDesc) {
            this.ticketDesc = ticketDesc;
        }

        public String getSeatType() {
            return seatType;
        }

        public void setSeatType(String seatType) {
            this.seatType = seatType;
        }

        public List<Inventory> getInventoryList() {
            return inventoryList;
        }

        public void setInventoryList(List<Inventory> inventoryList) {
            this.inventoryList = inventoryList;
        }

    }


    public static class Inventory{
        private String dateType;
        private Integer playTime;
        private Double marketPrice;
        private Double settlePrice;
        private RangeDateTime<String> validDate;
        private List<RangeDateTime<String>> excludeDate;
        private List<InventoryTemplate<String>> dayInventory;
        private List<InventoryTemplate<Integer>> weekInventory;
        private List<ApplyShop> shops;
        private List<String> shopIds;

        public void fillIds() {
            if (CollectionUtils.isNotEmpty(shops)) {
                for (ApplyShop shop : shops) {
                    if (shopIds == null) {
                        shopIds = Lists.newArrayList(shop.getShopId());
                    } else {
                        shopIds.add(shop.getShopId());
                    }
                }
            }
        }

        public String getDateType() {
            return dateType;
        }

        public void setDateType(String dateType) {
            this.dateType = dateType;
        }

        public Integer getPlayTime() {
            return playTime;
        }

        public void setPlayTime(Integer playTime) {
            this.playTime = playTime;
        }

        public Double getMarketPrice() {
            return marketPrice;
        }

        public void setMarketPrice(Double marketPrice) {
            this.marketPrice = marketPrice;
        }

        public Double getSettlePrice() {
            return settlePrice;
        }

        public void setSettlePrice(Double settlePrice) {
            this.settlePrice = settlePrice;
        }

        public RangeDateTime<String> getValidDate() {
            return validDate;
        }

        public void setValidDate(RangeDateTime<String> validDate) {
            this.validDate = validDate;
        }

        public List<RangeDateTime<String>> getExcludeDate() {
            return excludeDate;
        }

        public void setExcludeDate(List<RangeDateTime<String>> excludeDate) {
            this.excludeDate = excludeDate;
        }

        public List<InventoryTemplate<String>> getDayInventory() {
            return dayInventory;
        }

        public void setDayInventory(List<InventoryTemplate<String>> dayInventory) {
            this.dayInventory = dayInventory;
        }

        public List<InventoryTemplate<Integer>> getWeekInventory() {
            return weekInventory;
        }

        public void setWeekInventory(List<InventoryTemplate<Integer>> weekInventory) {
            this.weekInventory = weekInventory;
        }

        public List<ApplyShop> getShops() {
            return shops;
        }

        public void setShops(List<ApplyShop> shops) {
            this.shops = shops;
        }

        public List<String> getShopIds() {
            return shopIds;
        }

        public void setShopIds(List<String> shopIds) {
            this.shopIds = shopIds;
        }

    }

    public static class InventoryTemplate<T>{
        private List<T> days;
        private List<ReceptionDay> receptionSession;


        public List<T> getDays() {
            return days;
        }

        public void setDays(List<T> days) {
            this.days = days;
        }

        public List<ReceptionDay> getReceptionSession() {
            return receptionSession;
        }

        public void setReceptionSession(List<ReceptionDay> receptionSession) {
            this.receptionSession = receptionSession;
        }
    }

    /**
     * 一个场次
     */
    public static class ReceptionDay {
        private Integer inventory;
        private String name;
        private List<RangeDateTime<String>> fieldTimes;

        public ReceptionDay() {
        }

        public ReceptionDay(Integer inventory, List<RangeDateTime<String>> fieldTimes) {
            this.inventory = inventory;
            this.fieldTimes = fieldTimes;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getInventory() {
            return inventory;
        }

        public void setInventory(Integer inventory) {
            this.inventory = inventory;
        }

        public List<RangeDateTime<String>> getFieldTimes() {
            return fieldTimes;
        }

        public void setFieldTimes(List<RangeDateTime<String>> fieldTimes) {
            this.fieldTimes = fieldTimes;
        }
    }

    public static class Cooperation {
        // 合作项目或餐食名称
        private String project;
        private String otherChargeProject;
        private SaleUnit unit;
        private String unitDesc;
        private String addedAdtFee;
        private String addedChdFee;
        private String mealContent;
        private Boolean includeMeal;
        private Integer playTime;
        private Integer coinAmount;
        private Double coinValue;
        private Boolean includePlay;

        private RangeData<Integer> ageLimit;
        private RangeData<Integer> heightLimit;
        private RangeData<Integer> freeAge;
        private RangeData<Integer> freeheight;
        private List<String> entryRequirement;
        private Boolean supportAdtAlone;
        private Boolean supportDelay;
        private RangeDateTime<String> delayDate;
        private String overNightFee;
        private String overTimeFeePolicy;
        private Boolean hasOverTimeFeePolicy;
        private Double adtMinConsumption;
        private Boolean hasAdtMinConsumption;
        private Integer freeAdtCount;
        private Double mixBathHeightLimit;

        public List<String> cooperationDesc() {
            List<String> result = Lists.newArrayList();
            if (StringUtils.isNotBlank(otherChargeProject)) {
                result.add("额外收费项目："+otherChargeProject);
            }
            if (StringUtils.isNotBlank(addedAdtFee)) {
                if (addedAdtFee.matches("\\d+(\\.\\d+)?")) {
                    result.add("额外成人现场付费"+addedAdtFee+"元/人");
                } else {
                    result.add(addedAdtFee);
                }
            }
            if (StringUtils.isNotBlank(addedChdFee)) {
                if (addedChdFee.matches("\\d+(\\.\\d+)?")) {
                    result.add("额外儿童现场付费"+addedChdFee+"元/人");
                } else {
                    result.add(addedChdFee);
                }
            }
            if (ageLimit != null) {
                if (ageLimit.getMax() != null && ageLimit.getMin() != null) {
                    result.add("儿童"+ageLimit.getMin()+"～"+ageLimit.getMax()+"岁可入场");
                } else if (ageLimit.getMin() != null) {
                    result.add("儿童不小于"+ageLimit.getMin()+"岁可入场");
                } else if (ageLimit.getMax() != null) {
                    result.add("儿童不大于"+ageLimit.getMax()+"岁可入场");
                }
            }
            if (heightLimit != null) {
                if (heightLimit.getMax() != null && heightLimit.getMin() != null) {
                    result.add("儿童身高"+heightLimit.getMin()+"cm～"+heightLimit.getMax()+"cm可入场");
                } else if (heightLimit.getMin() != null) {
                    result.add("儿童身高不低于"+heightLimit.getMin()+"cm可入场");
                } else if (heightLimit.getMax() != null) {
                    result.add("儿童身高不高于"+heightLimit.getMax()+"cm可入场");
                }
            }
            if (freeAge != null) {
                if (freeAge.getMin() != null && freeAge.getMax() != null) {
                    result.add(""+freeAge.getMin()+"～"+freeAge.getMax()+"岁儿童免票");
                } else if (freeAge.getMin() != null) {
                    result.add("儿童年龄不小于"+freeAge.getMin()+"岁免票");
                } else if (freeAge.getMax() != null) {
                    result.add("儿童年龄不大于"+freeAge.getMax()+"岁免票");
                }
            }
            if (freeheight != null) {
                if (freeheight.getMin() != null && freeheight.getMax() != null) {
                    result.add(""+freeheight.getMin()+"cm～"+freeheight.getMax()+"cm儿童免票");
                } else if (freeheight.getMin() != null) {
                    result.add("儿童身高不低于"+freeheight.getMin()+"cm免票");
                } else if (freeheight.getMax() != null) {
                    result.add("儿童身高不高于"+freeheight.getMax()+"cm免票");
                }
            }
            if (CollectionUtils.isNotEmpty(entryRequirement)) {
                result.addAll(entryRequirement);
            }
            if (supportAdtAlone != null) {
                result.add((supportAdtAlone ? "":"不")+"支持单成人使用");
            }
            if (supportDelay != null && supportDelay && delayDate != null && StringUtils.isNotBlank(delayDate.getStart()) && StringUtils.isNotBlank(delayDate.getEnd())) {
                result.add("因商户及平台无法提供服务的，服务期限自动顺延。服务期另行更改，更改的具体期限以商户及平台共同确认为准。平台无法提供服务的，商户应配合平台延长服务期限。商户的具体服务期限以平台发布为准");
            }
            if (overNightFee != null) {
                result.add("过夜费"+overNightFee+"元/人");
            }
            if (hasOverTimeFeePolicy != null && StringUtils.isNotBlank(overTimeFeePolicy)) {
                result.add("超时收费："+overTimeFeePolicy);
            }
            if (hasAdtMinConsumption != null && adtMinConsumption != null) {
                result.add("陪同成人最低消费："+adtMinConsumption+"元/人");
            }
            if (freeAdtCount != null) {
                result.add("可免费陪同成人人数"+freeAdtCount+"人");
            }
            if (mixBathHeightLimit != null) {
                result.add("男女宝混浴身高不超过"+mixBathHeightLimit+"cm");
            }
            return result;
        }

        public boolean validate() {
            if ((coinAmount != null && coinAmount < 0) || (coinValue != null && coinValue < 0)
                    || (adtMinConsumption != null && adtMinConsumption < 0)
                    || (freeAdtCount != null && freeAdtCount < 0) || (mixBathHeightLimit != null && mixBathHeightLimit < 0)
                    || (unit != null && !unit.validate())) {
                return false;
            }
            if (supportDelay != null && supportDelay && (delayDate == null || StringUtils.isBlank(delayDate.getStart()) || StringUtils.isBlank(delayDate.getEnd()))) {
                return false;
            }
            return true;
        }

        public Boolean getHasAdtMinConsumption() {
            return hasAdtMinConsumption;
        }

        public void setHasAdtMinConsumption(Boolean hasAdtMinConsumption) {
            this.hasAdtMinConsumption = hasAdtMinConsumption;
        }

        public String getProject() {
            return project;
        }

        public Boolean getIncludeMeal() {
            return includeMeal;
        }

        public void setIncludeMeal(Boolean includeMeal) {
            this.includeMeal = includeMeal;
        }

        public void setProject(String project) {
            this.project = project;
        }

        public void setUnit(SaleUnit unit) {
            this.unit = unit;
        }

        public Boolean getHasOverTimeFeePolicy() {
            return hasOverTimeFeePolicy;
        }

        public void setHasOverTimeFeePolicy(Boolean hasOverTimeFeePolicy) {
            this.hasOverTimeFeePolicy = hasOverTimeFeePolicy;
        }

        public String getUnitDesc() {
            return unitDesc;
        }

        static Pattern ticketPattern = Pattern.compile("(\\d+)张门票");
        static Pattern onePersonPattern = Pattern.compile("(\\d+)位(成人|儿童)");
        static Pattern personPattern = Pattern.compile("(\\d+)大(\\d+)小");

        public void setUnitDesc(String unitDesc) {
            this.unitDesc = unitDesc;
            this.unit = convertUnit(unitDesc);
        }

        public static SaleUnit convertUnit(String desc) {
            SaleUnit saleUnit = new SaleUnit();
            if (StringUtils.isNotBlank(desc)) {
                Matcher matcher = ticketPattern.matcher(desc);
                if (matcher.matches()) {
                    saleUnit.setOption("ticket");
                    saleUnit.setTicketCount(Integer.valueOf(matcher.group(1)));
                }
                matcher = onePersonPattern.matcher(desc);
                if (matcher.matches()) {
                    saleUnit.setOption("person");
                    if (desc.contains("成人")) {
                        saleUnit.setAdtCount(Integer.valueOf(matcher.group(1)));
                    } else {
                        saleUnit.setChdCount(Integer.valueOf(matcher.group(1)));
                    }
                }
                matcher = personPattern.matcher(desc);
                if (matcher.matches()) {
                    saleUnit.setOption("person");
                    saleUnit.setChdCount(Integer.valueOf(matcher.group(2)));
                    saleUnit.setAdtCount(Integer.valueOf(matcher.group(1)));
                }
            }
            return saleUnit;
        }

        public String getOtherChargeProject() {
            return otherChargeProject;
        }

        public void setOtherChargeProject(String otherChargeProject) {
            this.otherChargeProject = otherChargeProject;
        }

        public SaleUnit getUnit() {
            return unit;
        }

        public String getAddedAdtFee() {
            return addedAdtFee;
        }

        public void setAddedAdtFee(String addedAdtFee) {
            this.addedAdtFee = addedAdtFee;
        }

        public String getAddedChdFee() {
            return addedChdFee;
        }

        public void setAddedChdFee(String addedChdFee) {
            this.addedChdFee = addedChdFee;
        }

        public String getMealContent() {
            return mealContent;
        }

        public void setMealContent(String mealContent) {
            this.mealContent = mealContent;
        }

        public Integer getPlayTime() {
            return playTime;
        }

        public void setPlayTime(Integer playTime) {
            this.playTime = playTime;
        }

        public Integer getCoinAmount() {
            return coinAmount;
        }

        public void setCoinAmount(Integer coinAmount) {
            this.coinAmount = coinAmount;
        }

        public Double getCoinValue() {
            return coinValue;
        }

        public void setCoinValue(Double coinValue) {
            this.coinValue = coinValue;
        }

        public Boolean getIncludePlay() {
            return includePlay;
        }

        public void setIncludePlay(Boolean includePlay) {
            this.includePlay = includePlay;
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

        public RangeData<Integer> getFreeAge() {
            return freeAge;
        }

        public void setFreeAge(RangeData<Integer> freeAge) {
            this.freeAge = freeAge;
        }

        public RangeData<Integer> getFreeheight() {
            return freeheight;
        }

        public void setFreeheight(RangeData<Integer> freeheight) {
            this.freeheight = freeheight;
        }

        public List<String> getEntryRequirement() {
            return entryRequirement;
        }

        public void setEntryRequirement(List<String> entryRequirement) {
            this.entryRequirement = entryRequirement;
        }

        public Boolean getSupportAdtAlone() {
            return supportAdtAlone;
        }

        public void setSupportAdtAlone(Boolean supportAdtAlone) {
            this.supportAdtAlone = supportAdtAlone;
        }

        public Boolean getSupportDelay() {
            return supportDelay;
        }

        public void setSupportDelay(Boolean supportDelay) {
            this.supportDelay = supportDelay;
        }

        public RangeDateTime<String> getDelayDate() {
            return delayDate;
        }

        public void setDelayDate(RangeDateTime<String> delayDate) {
            this.delayDate = delayDate;
        }

        public String getOverTimeFeePolicy() {
            return overTimeFeePolicy;
        }

        public void setOverTimeFeePolicy(String overTimeFeePolicy) {
            this.overTimeFeePolicy = overTimeFeePolicy;
        }

        public String getOverNightFee() {
            return overNightFee;
        }

        public void setOverNightFee(String overNightFee) {
            this.overNightFee = overNightFee;
        }

        public Double getAdtMinConsumption() {
            return adtMinConsumption;
        }

        public void setAdtMinConsumption(Double adtMinConsumption) {
            this.adtMinConsumption = adtMinConsumption;
        }

        public Integer getFreeAdtCount() {
            return freeAdtCount;
        }

        public void setFreeAdtCount(Integer freeAdtCount) {
            this.freeAdtCount = freeAdtCount;
        }

        public Double getMixBathHeightLimit() {
            return mixBathHeightLimit;
        }

        public void setMixBathHeightLimit(Double mixBathHeightLimit) {
            this.mixBathHeightLimit = mixBathHeightLimit;
        }
    }

    public static class ApplyShop{
        private String shopName;
        private String shopBranchName;
        private String shopId;
        private Double indoorArea;
        private Double outdoorArea;
        private Integer shoeCabinetCount;

        public String getShopName() {
            return shopName;
        }

        public void setShopName(String shopName) {
            this.shopName = shopName;
        }

        public String getShopBranchName() {
            return shopBranchName;
        }

        public void setShopBranchName(String shopBranchName) {
            this.shopBranchName = shopBranchName;
        }

        public String getShopId() {
            return shopId;
        }

        public void setShopId(String shopId) {
            this.shopId = shopId;
        }

        public Double getIndoorArea() {
            return indoorArea;
        }

        public void setIndoorArea(Double indoorArea) {
            this.indoorArea = indoorArea;
        }

        public Double getOutdoorArea() {
            return outdoorArea;
        }

        public void setOutdoorArea(Double outdoorArea) {
            this.outdoorArea = outdoorArea;
        }

        public Integer getShoeCabinetCount() {
            return shoeCabinetCount;
        }

        public void setShoeCabinetCount(Integer shoeCabinetCount) {
            this.shoeCabinetCount = shoeCabinetCount;
        }
    }


    public String getApplyNo() {
        return applyNo;
    }

    public void setApplyNo(String applyNo) {
        this.applyNo = applyNo;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public List<ApplyShop> getShopsInfo() {
        return shopsInfo;
    }

    public void setShopsInfo(List<ApplyShop> shopsInfo) {
        this.shopsInfo = shopsInfo;
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

    public List<Project> getCommonProjects() {
        return commonProjects;
    }

    public void setCommonProjects(List<Project> commonProjects) {
        this.commonProjects = commonProjects;
    }

    public List<PlayProject> getPlayProjects() {
        return playProjects;
    }

    public void setPlayProjects(List<PlayProject> playProjects) {
        this.playProjects = playProjects;
    }

    public String getSettleType() {
        return settleType;
    }

    public void setSettleType(String settleType) {
        this.settleType = settleType;
    }

    public String getPurchaseType() {
        return purchaseType;
    }

    public void setPurchaseType(String purchaseType) {
        this.purchaseType = purchaseType;
    }

    public String getAccountPeriod() {
        return accountPeriod;
    }

    public void setAccountPeriod(String accountPeriod) {
        this.accountPeriod = accountPeriod;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getSettlementStatement() {
        return settlementStatement;
    }

    public void setSettlementStatement(String settlementStatement) {
        this.settlementStatement = settlementStatement;
    }

    public String getShow() {
        return show;
    }

    public Cooperation getAttention() {
        return attention;
    }

    public void setAttention(Cooperation attention) {
        this.attention = attention;
    }

    public void setShow(String show) {
        this.show = show;
    }

    public Integer getShowTime() {
        return showTime;
    }

    public void setShowTime(Integer showTime) {
        this.showTime = showTime;
    }

    public String getSecondCategory() {
        return secondCategory;
    }

    public void setSecondCategory(String secondCategory) {
        this.secondCategory = secondCategory;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getSecondCategoryName() {
        return secondCategoryName;
    }

    public void setSecondCategoryName(String secondCategoryName) {
        this.secondCategoryName = secondCategoryName;
    }

    public enum DateType {
        RANGE("range", "日期段"), POINT("point", "日期");
        private String code;
        private String name;

        DateType(String code, String name) {
            this.code = code;
            this.name = name;
        }

        public static DateType ofType(String code) {
            for (DateType e : DateType.values()) {
                if (StringUtils.equals(code, e.getCode())) {
                    return e;
                }
            }
            return null;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public enum ProjectType {
        FREE("free", "免单"), VERIFY("verify", "打卡");

        private String code;
        private String name;

        ProjectType(String code, String name) {
            this.code = code;
            this.name = name;
        }

        public static ProjectType ofType(String code) {
            for (ProjectType e : ProjectType.values()) {
                if (StringUtils.equals(e.getCode(), code)) {
                    return e;
                }
            }
            return null;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
