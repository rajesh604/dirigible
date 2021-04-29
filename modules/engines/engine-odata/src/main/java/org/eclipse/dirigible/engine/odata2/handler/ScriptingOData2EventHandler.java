/*
 * Copyright (c) 2010-2021 SAP SE or an SAP affiliate company and Eclipse Dirigible contributors
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * SPDX-FileCopyrightText: 2010-2021 SAP SE or an SAP affiliate company and Eclipse Dirigible contributors
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.dirigible.engine.odata2.handler;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.olingo.odata2.api.edm.EdmException;
import org.apache.olingo.odata2.api.ep.EntityProvider;
import org.apache.olingo.odata2.api.ep.EntityProviderException;
import org.apache.olingo.odata2.api.processor.ODataResponse;
import org.apache.olingo.odata2.api.uri.info.DeleteUriInfo;
import org.apache.olingo.odata2.api.uri.info.PostUriInfo;
import org.apache.olingo.odata2.api.uri.info.PutMergePatchUriInfo;
import org.eclipse.dirigible.commons.api.scripting.ScriptingException;
import org.eclipse.dirigible.engine.api.script.ScriptEngineExecutorsManager;
import org.eclipse.dirigible.engine.js.api.IJavascriptEngineExecutor;
import org.eclipse.dirigible.engine.odata2.api.ODataException;
import org.eclipse.dirigible.engine.odata2.definition.ODataHandlerDefinition;
import org.eclipse.dirigible.engine.odata2.definition.ODataHandlerMethods;
import org.eclipse.dirigible.engine.odata2.definition.ODataHandlerTypes;
import org.eclipse.dirigible.engine.odata2.service.ODataCoreService;
import org.eclipse.dirigible.engine.odata2.sql.api.OData2EventHandler;
import org.eclipse.dirigible.engine.odata2.sql.processor.DefaultSQLProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScriptingOData2EventHandler implements OData2EventHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(DefaultSQLProcessor.class);
	
	private static final String DIRIGIBLE_ODATA_WRAPPER_MODULE_ON_EVENT = "odata/wrappers/onEvent";
	
	@Inject
	private ODataCoreService odataCoreService;

	@Override
	public void beforeCreateEntity(PostUriInfo uriInfo, InputStream content, String requestContentType,
			String contentType) {
		try {
			String namespace = uriInfo.getTargetType().getNamespace();
			String name = uriInfo.getTargetType().getName();
			String method = ODataHandlerMethods.create.name();
			String type = ODataHandlerTypes.before.name();
			List<ODataHandlerDefinition> handlers = odataCoreService.getHandlers(namespace, name, method, type);
			executeHandlers(handlers);
		} catch (EdmException | ODataException e) {
			logger.error(e.getMessage(), e);
		}
	}

	@Override
	public void afterCreateEntity(PostUriInfo uriInfo, InputStream content, String requestContentType,
			String contentType, ODataResponse response) {
		try {
			String namespace = uriInfo.getTargetType().getNamespace();
			String name = uriInfo.getTargetType().getName();
			String method = ODataHandlerMethods.create.name();
			String type = ODataHandlerTypes.after.name();
			List<ODataHandlerDefinition> handlers = odataCoreService.getHandlers(namespace, name, method, type);
			executeHandlers(handlers);
		} catch (EdmException | ODataException e) {
			logger.error(e.getMessage(), e);
		}
	}

	@Override
	public boolean usingOnCreateEntity(PostUriInfo uriInfo, InputStream content, String requestContentType,
			String contentType) {
		try {
			String namespace = uriInfo.getTargetType().getNamespace();
			String name = uriInfo.getTargetType().getName();
			String method = ODataHandlerMethods.create.name();
			String type = ODataHandlerTypes.on.name();
			List<ODataHandlerDefinition> handlers = odataCoreService.getHandlers(namespace, name, method, type);
			return handlers.size() > 0;
		} catch (EdmException | ODataException e) {
			logger.error(e.getMessage(), e);
		}
		return false;
	}

	@Override
	public ODataResponse onCreateEntity(PostUriInfo uriInfo, InputStream content, String requestContentType,
			String contentType) {
		try {
			String namespace = uriInfo.getTargetType().getNamespace();
			String name = uriInfo.getTargetType().getName();
			String method = ODataHandlerMethods.create.name();
			String type = ODataHandlerTypes.on.name();
			List<ODataHandlerDefinition> handlers = odataCoreService.getHandlers(namespace, name, method, type);
			String responseMessage = executeHandler(handlers);
			ODataResponse response = EntityProvider.writeText(responseMessage);
			return response;
		} catch (EdmException | ODataException | EntityProviderException e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}

	@Override
	public boolean forbidCreateEntity(PostUriInfo uriInfo, InputStream content, String requestContentType,
			String contentType) {
		try {
			String namespace = uriInfo.getTargetType().getNamespace();
			String name = uriInfo.getTargetType().getName();
			String method = ODataHandlerMethods.create.name();
			String type = ODataHandlerTypes.forbid.name();
			List<ODataHandlerDefinition> handlers = odataCoreService.getHandlers(namespace, name, method, type);
			return handlers.size() > 0;
		} catch (EdmException | ODataException e) {
			logger.error(e.getMessage(), e);
		}
		return false;
	}

	@Override
	public void beforeUpdateEntity(PutMergePatchUriInfo uriInfo, InputStream content, String requestContentType,
			boolean merge, String contentType) {
		try {
			String namespace = uriInfo.getTargetType().getNamespace();
			String name = uriInfo.getTargetType().getName();
			String method = ODataHandlerMethods.update.name();
			String type = ODataHandlerTypes.before.name();
			List<ODataHandlerDefinition> handlers = odataCoreService.getHandlers(namespace, name, method, type);
			executeHandlers(handlers);
		} catch (EdmException | ODataException e) {
			logger.error(e.getMessage(), e);
		}
	}

	@Override
	public void afterUpdateEntity(PutMergePatchUriInfo uriInfo, InputStream content, String requestContentType,
			boolean merge, String contentType, ODataResponse response) {
		try {
			String namespace = uriInfo.getTargetType().getNamespace();
			String name = uriInfo.getTargetType().getName();
			String method = ODataHandlerMethods.update.name();
			String type = ODataHandlerTypes.after.name();
			List<ODataHandlerDefinition> handlers = odataCoreService.getHandlers(namespace, name, method, type);
			executeHandlers(handlers);
		} catch (EdmException | ODataException e) {
			logger.error(e.getMessage(), e);
		}
	}

	@Override
	public boolean usingOnUpdateEntity(PutMergePatchUriInfo uriInfo, InputStream content, String requestContentType,
			boolean merge, String contentType) {
		try {
			String namespace = uriInfo.getTargetType().getNamespace();
			String name = uriInfo.getTargetType().getName();
			String method = ODataHandlerMethods.update.name();
			String type = ODataHandlerTypes.on.name();
			List<ODataHandlerDefinition> handlers = odataCoreService.getHandlers(namespace, name, method, type);
			return handlers.size() > 0;
		} catch (EdmException | ODataException e) {
			logger.error(e.getMessage(), e);
		}
		return false;
	}

	@Override
	public ODataResponse onUpdateEntity(PutMergePatchUriInfo uriInfo, InputStream content, String requestContentType,
			boolean merge, String contentType) {
		try {
			String namespace = uriInfo.getTargetType().getNamespace();
			String name = uriInfo.getTargetType().getName();
			String method = ODataHandlerMethods.update.name();
			String type = ODataHandlerTypes.on.name();
			List<ODataHandlerDefinition> handlers = odataCoreService.getHandlers(namespace, name, method, type);
			String responseMessage = executeHandler(handlers);
			ODataResponse response = EntityProvider.writeText(responseMessage);
			return response;
		} catch (EdmException | ODataException | EntityProviderException e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}

	@Override
	public boolean forbidUpdateEntity(PutMergePatchUriInfo uriInfo, InputStream content, String requestContentType,
			boolean merge, String contentType) {
		try {
			String namespace = uriInfo.getTargetType().getNamespace();
			String name = uriInfo.getTargetType().getName();
			String method = ODataHandlerMethods.update.name();
			String type = ODataHandlerTypes.forbid.name();
			List<ODataHandlerDefinition> handlers = odataCoreService.getHandlers(namespace, name, method, type);
			return handlers.size() > 0;
		} catch (EdmException | ODataException e) {
			logger.error(e.getMessage(), e);
		}
		return false;
	}

	@Override
	public void beforeDeleteEntity(DeleteUriInfo uriInfo, String contentType) {
		try {
			String namespace = uriInfo.getTargetType().getNamespace();
			String name = uriInfo.getTargetType().getName();
			String method = ODataHandlerMethods.delete.name();
			String type = ODataHandlerTypes.before.name();
			List<ODataHandlerDefinition> handlers = odataCoreService.getHandlers(namespace, name, method, type);
			executeHandlers(handlers);
		} catch (EdmException | ODataException e) {
			logger.error(e.getMessage(), e);
		}
	}

	@Override
	public void afterDeleteEntity(DeleteUriInfo uriInfo, String contentType, ODataResponse response) {
		try {
			String namespace = uriInfo.getTargetType().getNamespace();
			String name = uriInfo.getTargetType().getName();
			String method = ODataHandlerMethods.delete.name();
			String type = ODataHandlerTypes.after.name();
			List<ODataHandlerDefinition> handlers = odataCoreService.getHandlers(namespace, name, method, type);
			executeHandlers(handlers);
		} catch (EdmException | ODataException e) {
			logger.error(e.getMessage(), e);
		}
	}

	@Override
	public boolean usingOnDeleteEntity(DeleteUriInfo uriInfo, String contentType) {
		try {
			String namespace = uriInfo.getTargetType().getNamespace();
			String name = uriInfo.getTargetType().getName();
			String method = ODataHandlerMethods.delete.name();
			String type = ODataHandlerTypes.on.name();
			List<ODataHandlerDefinition> handlers = odataCoreService.getHandlers(namespace, name, method, type);
			return handlers.size() > 0;
		} catch (EdmException | ODataException e) {
			logger.error(e.getMessage(), e);
		}
		return false;
	}

	@Override
	public ODataResponse onDeleteEntity(DeleteUriInfo uriInfo, String contentType) {
		try {
			String namespace = uriInfo.getTargetType().getNamespace();
			String name = uriInfo.getTargetType().getName();
			String method = ODataHandlerMethods.delete.name();
			String type = ODataHandlerTypes.on.name();
			List<ODataHandlerDefinition> handlers = odataCoreService.getHandlers(namespace, name, method, type);
			String responseMessage = executeHandler(handlers);
			ODataResponse response = EntityProvider.writeText(responseMessage);
			return response;
		} catch (EdmException | ODataException | EntityProviderException e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}

	@Override
	public boolean forbidDeleteEntity(DeleteUriInfo uriInfo, String contentType) {
		try {
			String namespace = uriInfo.getTargetType().getNamespace();
			String name = uriInfo.getTargetType().getName();
			String method = ODataHandlerMethods.delete.name();
			String type = ODataHandlerTypes.forbid.name();
			List<ODataHandlerDefinition> handlers = odataCoreService.getHandlers(namespace, name, method, type);
			return handlers.size() > 0;
		} catch (EdmException | ODataException e) {
			logger.error(e.getMessage(), e);
		}
		return false;
	}
	
	private void executeHandlers(List<ODataHandlerDefinition> handlers) {
		handlers.forEach(handler -> {
			Map<Object, Object> context = new HashMap<Object, Object>();
			context.put("location", handler.getLocation());
			context.put("namespace", handler.getNamespace());
			context.put("name", handler.getName());
			context.put("method", handler.getMethod());
			context.put("type", handler.getType());
			context.put("handler", handler.getHandler());
			try {
				ScriptEngineExecutorsManager.executeServiceModule(
						IJavascriptEngineExecutor.JAVASCRIPT_TYPE_DEFAULT, DIRIGIBLE_ODATA_WRAPPER_MODULE_ON_EVENT, context);
			} catch (ScriptingException e) {
				logger.error(e.getMessage(), e);
			}
		});
	}
	
	private String executeHandler(List<ODataHandlerDefinition> handlers) {
		if (handlers.size() > 0) {
			ODataHandlerDefinition handler = handlers.get(0);
			Map<Object, Object> context = new HashMap<Object, Object>();
			context.put("location", handler.getLocation());
			context.put("namespace", handler.getNamespace());
			context.put("name", handler.getName());
			context.put("method", handler.getMethod());
			context.put("type", handler.getType());
			context.put("handler", handler.getHandler());
			try {
				Object response = ScriptEngineExecutorsManager.executeServiceModule(
						IJavascriptEngineExecutor.JAVASCRIPT_TYPE_DEFAULT, DIRIGIBLE_ODATA_WRAPPER_MODULE_ON_EVENT, context);
				return response != null ? response.toString() : "Empty response.";
			} catch (ScriptingException e) {
				logger.error(e.getMessage(), e);
			}
		};
		return "No response.";
	}

}