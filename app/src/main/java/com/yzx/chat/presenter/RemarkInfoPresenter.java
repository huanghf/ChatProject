package com.yzx.chat.presenter;

import com.yzx.chat.bean.ContactBean;
import com.yzx.chat.contract.RemarkInfoContract;
import com.yzx.chat.network.chat.IMClient;

/**
 * Created by YZX on 2018年01月24日.
 * 优秀的代码是它自己最好的文档,当你考虑要添加一个注释时,问问自己:"如何能改进这段代码，以让它不需要注释？"
 */


public class RemarkInfoPresenter implements RemarkInfoContract.Presenter {


    @Override
    public void attachView(RemarkInfoContract.View view) {

    }

    @Override
    public void detachView() {

    }

    @Override
    public void save(ContactBean contact) {
        IMClient.getInstance().contactManager().updateContact(contact,null);
    }



}
