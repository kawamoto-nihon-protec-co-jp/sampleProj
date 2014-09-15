package jp.co.sampleProj.action;

import java.sql.Timestamp;


import javax.annotation.Resource;

import org.apache.struts.action.ActionMessages;
import org.seasar.framework.beans.util.Beans;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;
import java.util.List;

import org.seasar.extension.jdbc.JdbcManager;
import org.seasar.extension.jdbc.where.SimpleWhere;

import jp.co.sampleProj.entity.LoginHistory;
import jp.co.sampleProj.service.LoginHistoryService;
import jp.co.sampleProj.form.LoginHistoryForm;

public class LoginHistoryAction {

    private Integer limit = 5;

    private Integer count;

    public List<LoginHistory> loginHistoryItems;
    
    @ActionForm
    @Resource
    protected LoginHistoryForm loginHistoryForm;

    @Resource
    protected LoginHistoryService loginHistoryService;

    public JdbcManager jdbcManager;

    @Execute(validator = false)
    public String index() {
        SimpleWhere swh = new SimpleWhere()
            .like("loginId", loginHistoryForm.loginId+"%")
        ;
        
        loginHistoryItems = jdbcManager.from(LoginHistory.class).where(swh)
                                  .orderBy("loginId")
                                  .getResultList();
        count = loginHistoryItems.size();
        loginHistoryForm.count = count.toString();
        loginHistoryForm.totalNumber = count.toString();
        loginHistoryForm.totalPageIndex = String.valueOf(count/limit);
        if (Integer.valueOf(loginHistoryForm.totalNumber)%limit != 0)
        	loginHistoryForm.totalPageIndex = String.valueOf(Integer.valueOf(loginHistoryForm.totalPageIndex)+1);
        loginHistoryForm.currentPageIndex = String.valueOf(Integer.valueOf(loginHistoryForm.offset)/limit+1);
        
        loginHistoryItems = jdbcManager.from(LoginHistory.class).where(swh)
                                  .orderBy("loginId")
                                  .limit(limit).offset(Integer.valueOf(loginHistoryForm.offset))
                                  .getResultList();        
        
        if (Long.valueOf(loginHistoryForm.offset) + limit < count) {
          loginHistoryForm.isNextPage = "true";
        } else {
          loginHistoryForm.isNextPage = "false";
        }
        if (0 <= Long.valueOf(loginHistoryForm.offset) - limit) {
          loginHistoryForm.isPrevPage = "true";
        } else {
          loginHistoryForm.isPrevPage = "false";
        }

        return "list.jsp";
    }

    @Execute(validator = false)
    public String retrieve() {
        return index();
    }

    @Execute(validator = false)
    public String nextPage() {
        Integer loffset = Integer.valueOf(loginHistoryForm.offset);
        loffset += limit;
        loginHistoryForm.offset = loffset.toString();
        return index();
    }

    @Execute(validator = false)
    public String lastPage() {
        count = Integer.valueOf(loginHistoryForm.count);
        Integer loffset;
        if (count%limit == 0) {
        	loffset = count/limit*limit - limit;
        } else {
        	loffset = count/limit*limit;
        }
        loginHistoryForm.offset = loffset.toString();
        return index();
    }

    @Execute(validator = false)
    public String prevPage() {
        Integer loffset = Integer.valueOf(loginHistoryForm.offset);
        loffset -= limit;
        loginHistoryForm.offset = loffset.toString();
        return index();
    }
    
    @Execute(validator = false)
    public String firsPage() {
        loginHistoryForm.offset = "0";
        return index();
    }




    @Execute(validator = false, urlPattern = "show")
    public String show() {
        LoginHistory entity = loginHistoryService.findById();
        Beans.copy(entity, loginHistoryForm).dateConverter("yyyy-MM-dd").execute();
        return "show.jsp";
    }

    @Execute(validator = false, urlPattern = "edit")
    public String edit() {
        LoginHistory entity = loginHistoryService.findById();
        Beans.copy(entity, loginHistoryForm).dateConverter("yyyy-MM-dd").execute();
        return "edit.jsp";
    }

    @Execute(validator = false)
    public String create() {
        return "create.jsp";
    }

    @Execute(validator = false, urlPattern = "delete", redirect = true)
    public String delete() {
        LoginHistory entity = Beans.createAndCopy(LoginHistory.class, loginHistoryForm).dateConverter("yyyy-MM-dd").execute();
        loginHistoryService.delete(entity);
        return "/loginHistory/";
    }

    @Execute(input = "create.jsp", redirect = true)
    public String insert() {
        LoginHistory entity = Beans.createAndCopy(LoginHistory.class, loginHistoryForm).dateConverter("yyyy-MM-dd").execute();
        loginHistoryService.insert(entity);
        return "/loginHistory/";
    }

    @Execute(input = "edit.jsp", redirect = true)
    public String update() {
        LoginHistory entity = Beans.createAndCopy(LoginHistory.class, loginHistoryForm).dateConverter("yyyy-MM-dd").execute();
        loginHistoryService.update(entity);
        return "/loginHistory/";
    }
}