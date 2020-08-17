package other.timeLine;


import java.io.Serializable;

public class TimeLine implements Serializable {

    private int timeValue;

    private int parentTimeValue;

    private String unit;

    public TimeLine(int timeValue, String unit) {
        this.timeValue = timeValue;
        this.unit = unit;
    }

    public TimeLine() {
    }

    public Integer getTimeValue() {
        return timeValue;
    }

    public void setTimeValue(Integer timeValue) {
        this.timeValue = timeValue;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getParentTimeValue() {
        return parentTimeValue;
    }

    public void setParentTimeValue(int parentTimeValue) {
        this.parentTimeValue = parentTimeValue;
    }
}
