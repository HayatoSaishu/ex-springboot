package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Team;

/**
 * teamsテーブルの情報を操作するリポジトリ.
 * 
 * @author hayato.saishu
 *
 */
@Repository
public class TeamRepository {

	private static final RowMapper<Team> TEAM_ROW_MAPPER = (rs, i) ->{
		Team team = new Team();
		team.setId(rs.getInt("id"));
		team.setLeagueName(rs.getString("league_name"));
		team.setTeamName(rs.getString("team_name"));
		team.setHeadquarters(rs.getString("headquarters"));
		team.setInauguration(rs.getString("inauguration"));
		team.setHistory(rs.getString("history"));
		
		return team;
	};
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	/**
	 * チーム情報を発足日(昇順)で取得します.
	 * 
	 * @return チーム情報が入ったリスト
	 */
	public List<Team> findAll(){
		String sql = "SELECT id, league_name, team_name, headquarters, inauguration, history FROM teams ORDER BY inauguration;";
		
		List<Team> teamList = template.query(sql, TEAM_ROW_MAPPER);
		
		return teamList;
	}
	
	/**
	 * チーム情報を1件取得する.
	 * @param id ID
	 * @return チーム情報
	 */
	public Team load(Integer id) {
		String sql = "SELECT id, league_name, team_name, headquarters, inauguration, history FROM teams WHERE id=:id;";
		
		SqlParameterSource param = new MapSqlParameterSource("id", id);
		
		Team team = template.queryForObject(sql, param, TEAM_ROW_MAPPER);
		
		return team;
	}
	
}
