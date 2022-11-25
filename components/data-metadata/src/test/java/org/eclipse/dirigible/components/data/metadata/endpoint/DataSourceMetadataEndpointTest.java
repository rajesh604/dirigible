/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company and Eclipse Dirigible contributors
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * SPDX-FileCopyrightText: 2022 SAP SE or an SAP affiliate company and Eclipse Dirigible contributors
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.dirigible.components.data.metadata.endpoint;

import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Connection;

import javax.persistence.EntityManager;

import org.eclipse.dirigible.components.data.metadata.service.DataSourceMetadataService;
import org.eclipse.dirigible.components.data.sources.domain.DataSource;
import org.eclipse.dirigible.components.data.sources.manager.DataSourcesManager;
import org.eclipse.dirigible.components.data.sources.repository.DataSourceRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
@ComponentScan(basePackages = { "org.eclipse.dirigible.components" })
@EntityScan("org.eclipse.dirigible.components")
@Transactional
public class DataSourceMetadataEndpointTest {
	
//	@Autowired
//	private DataSourceRepository datasourceRepository;
//	
//	@Autowired
//    private DataSourcesManager datasourcesManager;
//	
//	@Autowired
//	MockMvc mockMvc;
//	
//	@Before
//    public void setup() {
//		DataSource datasource = new DataSource("", "TestDB", "", "", "org.h2.Driver", "jdbc:h2:~/test", "sa", "");
//		datasourceRepository.save(datasource);
//    }
//	
//	@Test
//	public void getDataSourceByName() throws Exception {
//
//		mockMvc.perform(get("/services/v8/data/metadata/{name}/{schema}/{structure}", 
//				"TestDB", "INFORMATION_SCHEMA", "INDEXES"))
//				.andDo(print())
//				.andExpect(status().is2xxSuccessful())
//		;
//	}
//
//	@SpringBootApplication
//	static class TestConfiguration {
//	}
}