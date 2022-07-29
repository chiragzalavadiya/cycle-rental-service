package com.cin.cyclerentalservice.util;

import com.cin.cyclerentalservice.entity.Cycle;
import com.cin.cyclerentalservice.vo.CycleVO;

public interface CycleMapper {
	Cycle getCycle(CycleVO cycleVO, Cycle cycle);
	CycleVO getCycleVO(Cycle cycle);
}
