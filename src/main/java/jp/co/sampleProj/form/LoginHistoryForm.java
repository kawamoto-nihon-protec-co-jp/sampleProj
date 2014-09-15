package jp.co.sampleProj.form;


import java.sql.Timestamp;

import java.util.List;
import jp.co.sampleProj.entity.LoginHistory;

public class LoginHistoryForm {
	
	public String loginId = "";

	public String loginSeq = "";

	public String loginDate = "";


	public String offset = "0";
	
	public String count = "0";
	
	public String isNextPage = "true";
	
	public String isPrevPage = "true";

	public String totalNumber = "0";
	
	public String currentPageIndex = "0";
	
	public String totalPageIndex = "0";
}