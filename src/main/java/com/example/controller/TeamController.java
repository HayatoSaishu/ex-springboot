package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.service.TeamService;

/**
 * チーム情報を操作するコントローラ.
 * 
 * @author hayato.saishu
 *
 */
@Controller
@RequestMapping("/")
public class TeamController {

	@Autowired
	private TeamService teamService;
	
	/**
	 * チーム情報を全件取得する.
	 * 
	 * @param model リクエストスコープに格納
	 * @return チームリストページへフォワード
	 */
	@RequestMapping("/showList")
	public String showList(Model model) {
		model.addAttribute("teamList", teamService.showList());
		return "team/team-list";
	}
	
	/**
	 * チームの詳細情報を取得する.
	 * 
	 * @param id チームID
	 * @param model リクエストスコープへ格納
	 * @return チーム詳細ページへフォワード
	 */
	@RequestMapping("/showDetail")
	public String showDetail(Integer id, Model model) {
		model.addAttribute("team", teamService.showDetail(id));
		return "team/team-detail";
	}
}
