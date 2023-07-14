package com.codeflow.config;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.codeflow.api.VencimentoController;

@Configuration
@EnableScheduling
public class VencimentoConfig {

	    @Autowired
	    private VencimentoController vencimentoController;

	    @Bean
	    public void init() {
	        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

	        // Calcula o tempo até meia-noite
	        LocalDateTime now = LocalDateTime.now();
	        LocalDateTime midnight = now.with(LocalTime.MIDNIGHT);
	        if (now.compareTo(midnight) > 0) {
	            midnight = midnight.plusDays(1);
	        }
	        long initialDelay = Duration.between(now, midnight).getSeconds();

	        // Agenda a tarefa para executar à meia-noite todos os dias
	        executorService.scheduleAtFixedRate(() -> vencimentoController.verifyPoints(), initialDelay, 24 * 60 * 60, TimeUnit.SECONDS);
	    }
}
