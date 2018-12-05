package script;



public class Session {

    private int inventory;

    private String name;

    private RangeDateTime<String> range;

    private String date;

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RangeDateTime<String> getRange() {
        return range;
    }

    public void setRange(RangeDateTime<String> range) {
        this.range = range;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

