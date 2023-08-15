package com.codeflow.service;

import com.codeflow.dto.DashboardDTO;

public interface DashboardService {

	/**
	 * Buscar dados do dashboard.
	 * @return lista de cliente dto.
	 */
	public DashboardDTO getData();
	
}
