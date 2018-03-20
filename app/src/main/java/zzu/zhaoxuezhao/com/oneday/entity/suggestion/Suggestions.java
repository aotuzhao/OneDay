package zzu.zhaoxuezhao.com.oneday.entity.suggestion;

/**
 * Created by aotu on 2018/3/15.
 * 生活建议
 * 穿衣、紫外线强度、洗车、旅游、感冒、运动
 */

public class Suggestions {
    private CarWashing car_washing;
    private Dressing dressing;
    private Flu flu;
    private Sport sport;
    private Travel travel;
    private Uv uv;

    public CarWashing getCar_washing() {
        return car_washing;
    }

    public void setCar_washing(CarWashing car_washing) {
        this.car_washing = car_washing;
    }

    public Dressing getDressing() {
        return dressing;
    }

    public void setDressing(Dressing dressing) {
        this.dressing = dressing;
    }

    public Flu getFlu() {
        return flu;
    }

    public void setFlu(Flu flu) {
        this.flu = flu;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public Travel getTravel() {
        return travel;
    }

    public void setTravel(Travel travel) {
        this.travel = travel;
    }

    public Uv getUv() {
        return uv;
    }

    public void setUv(Uv uv) {
        this.uv = uv;
    }
}
