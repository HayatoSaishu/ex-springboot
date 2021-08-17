package com.example.domain;

/**
 * チームの情報を表すドメイン.
 * 
 * @author hayato.saishu
 *
 */
public class Team {

	/** ID */
	private Integer id;
	/** リーグ名 */
	private String leagueName;
	/** チーム名 */
	private String teamName;
	/** ホームグラウンド */
	private String headquarters;
	/** 発足日 */
	private String inauguration;
	/** 歴史 */
	private String history;

	public Team() {
	}

	public Team(Integer id, String leagueName, String teamName, String headQuaters, String inauguration,
			String history) {
		super();
		this.id = id;
		this.leagueName = leagueName;
		this.teamName = teamName;
		this.headquarters = headQuaters;
		this.inauguration = inauguration;
		this.history = history;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLeagueName() {
		return leagueName;
	}

	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getInauguration() {
		return inauguration;
	}

	public void setInauguration(String inauguration) {
		this.inauguration = inauguration;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	
	public String getHeadquarters() {
		return headquarters;
	}

	public void setHeadquarters(String headquarters) {
		this.headquarters = headquarters;
	}

	@Override
	public String toString() {
		return "TeamDomain [id=" + id + ", leagueName=" + leagueName + ", teamName=" + teamName + ", headQuaters="
				+ headquarters + ", inauguration=" + inauguration + ", history=" + history + "]";
	}

}
