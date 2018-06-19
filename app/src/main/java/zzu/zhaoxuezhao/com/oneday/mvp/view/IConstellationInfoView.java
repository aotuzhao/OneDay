package zzu.zhaoxuezhao.com.oneday.mvp.view;

import zzu.zhaoxuezhao.com.oneday.bean.constellation.Constellation;

public interface IConstellationInfoView {
    void showConstellation(Constellation constellation);
    void showError(String error);
}
