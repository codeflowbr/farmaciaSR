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

	          // Calcula o atraso até as 10 da manhã
	          LocalTime now = LocalTime.now();
	          LocalTime targetTime = LocalTime.of(10, 0); // Horário desejado (10:00 AM)
	          
	          long initialDelay = Duration.between(now, targetTime).getSeconds();
	          
	          if (initialDelay < 0) {
	              initialDelay += TimeUnit.DAYS.toSeconds(1); // Se já passou das 10 da manhã, agenda para amanhã
	          }
	          
	          // Agenda a tarefa para executar às 10 da manhã todos os dias
	          executorService.scheduleAtFixedRate(() -> vencimentoController.verifyPoints(), initialDelay, TimeUnit.DAYS.toSeconds(1), TimeUnit.SECONDS);
	    }
}
