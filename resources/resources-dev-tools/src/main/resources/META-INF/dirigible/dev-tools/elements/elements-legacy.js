/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company and Eclipse Dirigible contributors
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * SPDX-FileCopyrightText: 2021 SAP SE or an SAP affiliate company and Eclipse Dirigible contributors
 * SPDX-License-Identifier: EPL-2.0
 */
// Copyright 2019 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

import * as ElementsModule from './elements.js';

self.Elements = self.Elements || {};
Elements = Elements || {};

/** @constructor */
Elements.ClassesPaneWidget = ElementsModule.ClassesPaneWidget.ClassesPaneWidget;

/** @constructor */
Elements.ClassesPaneWidget.ButtonProvider = ElementsModule.ClassesPaneWidget.ButtonProvider;

/** @constructor */
Elements.ComputedStyleModel = ElementsModule.ComputedStyleModel.ComputedStyleModel;

/** @constructor */
Elements.ComputedStyleWidget = ElementsModule.ComputedStyleWidget.ComputedStyleWidget;

Elements.DOMLinkifier = {};

/** @constructor */
Elements.DOMLinkifier.Linkifier = ElementsModule.DOMLinkifier.Linkifier;

Elements.DOMPath = {};

Elements.DOMPath.fullQualifiedSelector = ElementsModule.DOMPath.fullQualifiedSelector;
Elements.DOMPath.cssPath = ElementsModule.DOMPath.cssPath;
Elements.DOMPath.jsPath = ElementsModule.DOMPath.jsPath;
Elements.DOMPath.xPath = ElementsModule.DOMPath.xPath;

/** @constructor */
Elements.ElementStatePaneWidget = ElementsModule.ElementStatePaneWidget.ElementStatePaneWidget;

/** @constructor */
Elements.ElementStatePaneWidget.ButtonProvider = ElementsModule.ElementStatePaneWidget.ButtonProvider;

/** @constructor */
Elements.ElementsBreadcrumbs = ElementsModule.ElementsBreadcrumbs.ElementsBreadcrumbs;

/** @constructor */
Elements.ElementsPanel = ElementsModule.ElementsPanel.ElementsPanel;

/** @constructor */
Elements.ElementsPanel.ContextMenuProvider = ElementsModule.ElementsPanel.ContextMenuProvider;

/** @constructor */
Elements.ElementsPanel.DOMNodeRevealer = ElementsModule.ElementsPanel.DOMNodeRevealer;

/** @constructor */
Elements.ElementsPanel.CSSPropertyRevealer = ElementsModule.ElementsPanel.CSSPropertyRevealer;

/** @constructor */
Elements.ElementsActionDelegate = ElementsModule.ElementsPanel.ElementsActionDelegate;

/** @constructor */
Elements.ElementsPanel.PseudoStateMarkerDecorator = ElementsModule.ElementsPanel.PseudoStateMarkerDecorator;

/** @constructor */
Elements.ElementsTreeElement = ElementsModule.ElementsTreeElement.ElementsTreeElement;

/** @constructor */
Elements.ElementsTreeOutline = ElementsModule.ElementsTreeOutline.ElementsTreeOutline;

/** @constructor */
Elements.ElementsTreeOutline.Renderer = ElementsModule.ElementsTreeOutline.Renderer;

/** @constructor */
Elements.EventListenersWidget = ElementsModule.EventListenersWidget.EventListenersWidget;

/** @constructor */
Elements.InspectElementModeController = ElementsModule.InspectElementModeController.InspectElementModeController;

/** @constructor */
Elements.InspectElementModeController.ToggleSearchActionDelegate =
    ElementsModule.InspectElementModeController.ToggleSearchActionDelegate;

/** @interface */
Elements.MarkerDecorator = ElementsModule.MarkerDecorator.MarkerDecorator;

Elements.GenericDecorator = ElementsModule.MarkerDecorator.GenericDecorator;

/** @constructor */
Elements.MetricsSidebarPane = ElementsModule.MetricsSidebarPane.MetricsSidebarPane;

/** @constructor */
Elements.NodeStackTraceWidget = ElementsModule.NodeStackTraceWidget.NodeStackTraceWidget;

/** @constructor */
Elements.PropertiesWidget = ElementsModule.PropertiesWidget.PropertiesWidget;

/** @constructor */
Elements.StylePropertyTreeElement = ElementsModule.StylePropertyTreeElement.StylePropertyTreeElement;

/** @constructor */
Elements.StylesSidebarPane = ElementsModule.StylesSidebarPane.StylesSidebarPane;

/** @constructor */
Elements.StylesSidebarPane.CSSPropertyPrompt = ElementsModule.StylesSidebarPane.CSSPropertyPrompt;

/** @constructor */
Elements.StylesSidebarPane.ButtonProvider = ElementsModule.StylesSidebarPane.ButtonProvider;

/** @constructor */
Elements.StylePropertiesSection = ElementsModule.StylesSidebarPane.StylePropertiesSection;