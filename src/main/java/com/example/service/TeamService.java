package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Team;
import com.example.repository.TeamRepository;

/**
 * チーム情報の業務処理を行うサービス.
 * 
 * @author hayato.saishu
 *
 */
@Service
@Transactional
public class TeamService {

	@Autowired
	private TeamRepository teamRepository;
	
	/**
	 * チーム情報を全件取得する.
	 * 
	 * @return チーム全件の情報
	 */
	public List<Team> showList(){
		return teamRepository.findAll();
	}
	
	/**
	 * チーム情報を1件取得する.
	 * 
	 * @param ID
	 * @return Team チーム情報
	 */
	public Team showDetail(Integer id) {
		return teamRepository.load(id);
	}
}
