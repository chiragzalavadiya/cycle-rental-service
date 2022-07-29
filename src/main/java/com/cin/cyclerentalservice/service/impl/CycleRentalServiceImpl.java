package com.cin.cyclerentalservice.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.cin.cyclerentalservice.service.CycleRentalService;
import com.cin.cyclerentalservice.util.CycleRentalMapper;
import com.cin.cyclerentalservice.vo.CycleRentalVO;
import com.cin.cyclerentalservice.vo.ReportType;

@Service
public class CycleRentalServiceImpl implements CycleRentalService {

	private static Logger logger = LoggerFactory.getLogger(CycleRentalServiceImpl.class);
	
	@Autowired
	private EntityManager em;
	
	@Autowired
	private CycleRentalMapper cycleRentalMapper;
	
	@Override
	@Transactional
	public String generateCycleRentalReport() {
		String reportGeneratedStatus = "All Reports are successfully generated.";
		
		List<Integer> dayWiseHighestDistTravellerLst = findDataBasedOnQueryKey("findDayWiseHighestDistTraveller");
		insertReportForReportType(dayWiseHighestDistTravellerLst, ReportType.DAY_WISE_HIGHEST_DIST_TRAVELLER);
		
		List<Integer> overallHighestDistTravellerLst = findDataBasedOnQueryKey("findOverallHighestDistTraveller");
		insertReportForReportType(overallHighestDistTravellerLst, ReportType.OVERALL_HIGHEST_DIST_TRAVELLER);
		
		List<Integer> dayWiseEarlyTravellerLst = findDataBasedOnQueryKey("findDayWiseEarlyTraveller");
		insertReportForReportType(dayWiseEarlyTravellerLst, ReportType.DAY_WISE_EARLY_TRAVELLER);
		
		List<Integer> overallEarlyTravellerLst = findDataBasedOnQueryKey("findOverallEarlyTraveller");
		insertReportForReportType(overallEarlyTravellerLst, ReportType.OVERALL_EARLY_TRAVELLER);
		
		List<Integer> oneWhoTravelledLongestTimeLst = findDataBasedOnQueryKey("findOneWhoTravelledLongestTime");
		insertReportForReportType(oneWhoTravelledLongestTimeLst, ReportType.ONE_WHO_TRAVELLED_LONGEST_TIME);
		
		return reportGeneratedStatus;
	}
	
	@SuppressWarnings("unchecked")
	private List<Integer> findDataBasedOnQueryKey(String queryKey) {
		List<Integer> integers = null;
		try {
			String queryString = getQueryFromProperty(queryKey);
			Query query = em.createNativeQuery(queryString);
			integers = query.getResultList();
		} catch (PersistenceException pe) {
			logger.error("Error occurred in findDataBasedOnQueryKey");
			pe.printStackTrace();
		}
		return integers;
	}
	
	@Transactional
	private void insertReportForReportType(List<Integer> rideIds, ReportType reportType) {
		for (Integer rideId : rideIds) {
			try {
				em.persist(cycleRentalMapper.getCycleRentalReport(reportType.name(), rideId));
			} catch (PersistenceException pe) {
				logger.error("Error occurred in insertReportForReportType");
				pe.printStackTrace();
			}
		}
	}
	
	@Override
	public List<CycleRentalVO> getReportBasedOnReportType(String reportType) {
		List<CycleRentalVO> cycleRentalVOs = new ArrayList<CycleRentalVO>();
		List<Object> objects = fetchReportBasedOnReportType(reportType);
		objects.forEach(object -> cycleRentalVOs.add(cycleRentalMapper.toCycleRentalVO(object)));
		return cycleRentalVOs;
	}

	@SuppressWarnings("unchecked")
	private List<Object> fetchReportBasedOnReportType(String reportType) {
		List<Object> objects = null;
		try {
			String queryString = getQueryFromProperty("fetchReportBasedOnReportType");
			Query query = em.createNativeQuery(queryString);
			query.setParameter(0, reportType);
			objects = query.getResultList();
		} catch (PersistenceException pe) {
			logger.error("Error occurred in fetchReportBasedOnReportType");
			pe.printStackTrace();
		}
		return objects;
	}
	
	private String getQueryFromProperty(String queryKey) {
		try {
			Properties properties = new Properties();
			File file = ResourceUtils.getFile("classpath:queries.properties");
            		InputStream in = new FileInputStream(file);
			properties.load(in);
		    return properties.getProperty(queryKey);
		} catch (IOException io) {
			io.printStackTrace();
			logger.error("Error occurred in getQueryFromProperty");
			io.printStackTrace();
		}
		return null;
	}
}
