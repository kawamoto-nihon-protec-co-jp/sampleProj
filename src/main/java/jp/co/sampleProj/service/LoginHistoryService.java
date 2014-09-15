package jp.co.sampleProj.service;

import jp.co.sampleProj.entity.LoginHistory;

public class LoginHistoryService extends AbstractService<LoginHistory> {

    public LoginHistory findById() {
        return select().id().getSingleResult();
    }
}