package com.cin.cyclerentalservice.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cin.cyclerentalservice.entity.Cycle;
import com.cin.cyclerentalservice.service.CycleService;
import com.cin.cyclerentalservice.util.CycleMapper;
import com.cin.cyclerentalservice.vo.CycleVO;

@Service
public class CycleServiceImpl implements CycleService {

	private static Logger logger = LoggerFactory.getLogger(CycleServiceImpl.class);
	
	@Autowired
	private EntityManager em;
	
	@Autowired
	private CycleMapper cycleMapper;
	
	@Override
	public List<CycleVO> getAllCycleVOList() {
		List<CycleVO> cycleVOs = new ArrayList<CycleVO>();
		List<Cycle> cycles = findAllCycle();
		cycles.forEach(cycle -> cycleVOs.add(cycleMapper.getCycleVO(cycle)));
		return cycleVOs;
	}

	private List<Cycle> findAllCycle() {
		List<Cycle> cycles = null;
		try {
			TypedQuery<Cycle> query = em.createNamedQuery("findAll.cycle", Cycle.class);
			cycles = query.getResultList();
		} catch (PersistenceException pe) {
			logger.error("Error occurred in findAllCycle");
			pe.printStackTrace();
		}
		return cycles;
	}
}
