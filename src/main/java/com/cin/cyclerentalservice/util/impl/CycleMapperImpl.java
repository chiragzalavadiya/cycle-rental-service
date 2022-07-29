package com.cin.cyclerentalservice.util.impl;

import org.springframework.stereotype.Component;

import com.cin.cyclerentalservice.entity.Cycle;
import com.cin.cyclerentalservice.util.CycleMapper;
import com.cin.cyclerentalservice.vo.CycleVO;

@Component
public class CycleMapperImpl implements CycleMapper {

	@Override
	public Cycle getCycle(CycleVO cycleVO, Cycle cycle) {
		if (cycle == null)
			cycle = new Cycle();
		cycle.setCycleId(cycleVO.getCycleId());
		cycle.setCycleBrandName(cycleVO.getCycleBrandName());
		cycle.setStatusCode(cycleVO.getStatusCode());
		return cycle;
	}

	@Override
	public CycleVO getCycleVO(Cycle cycle) {
		CycleVO cycleVO = new CycleVO();
		cycleVO.setCycleId(cycle.getCycleId());
		cycleVO.setCycleBrandName(cycle.getCycleBrandName());
		cycleVO.setStatusCode(cycle.getStatusCode());
		return cycleVO;
	}

}
