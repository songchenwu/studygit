package com.yc.vote.web.action;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;
import com.yc.vote.entity.Item;
import com.yc.vote.entity.OptionBean;
import com.yc.vote.entity.SubjectBean;
import com.yc.vote.entity.VoteBean;
import com.yc.vote.service.MoreVoteService;
import com.yc.vote.service.VoteService;

@Controller("voteAction")
public class VoteAction implements SessionAware, ModelDriven<Item> {
	private Item item;
	@Autowired
	private VoteService voteService;
	private Map<String, Object> session;
	@Autowired
	private MoreVoteService moreVoteService;

	public String list() {
		List<SubjectBean> subjects = voteService.findAllSubjectsBeans();
		LogManager.getLogger().debug("list请求成功...");
		session.put("subjects", subjects);
		return "list";
	}

	public String view() {
		LogManager.getLogger().debug("view取到的vsID=>" + item.getVsId());
		OptionBean optionBean = voteService.findOptionsByVsId(item.getVsId());
		session.put("optionBean", optionBean);
		return "view";
	}

	public String vote() {
		LogManager.getLogger().debug("vote取到的vsID=>" + item.getVsId());
		VoteBean voteBean = voteService.findVoteBeanByVsId(item.getVsId());
		session.put("voteBean", voteBean);
		return "vote";
	}

	public String save() {
		// 当
		String[] voId = ServletActionContext.getRequest().getParameterValues(
				"voId");
		LogManager.getLogger().debug(
				"save取到的item=>" + item + "voId" + Arrays.toString(voId));
		try {
			moreVoteService.saveVote(item, voId);
			return "saveSuccess";

		} catch (Exception e) {
		}
		session.put("saveMsg", "投票失败！！");
		return "saveFail";

	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@Override
	public Item getModel() {
		item = new Item();
		return item;
	}

}
