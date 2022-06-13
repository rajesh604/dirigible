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
let extensions = require('core/v4/extensions');
let response = require('http/v4/response');

let perspectives = [];
let perspectiveExtensions = extensions.getExtensions('ide-perspective');

for (let i = 0; i < perspectiveExtensions.length; i++) {
	let module = perspectiveExtensions[i];
	try {
		let perspectiveExtension = require(module);
		let perspective = perspectiveExtension.getPerspective();
		perspectives.push(perspective);

		let duplication = false;
		for (let i = 0; i < perspectives.length; i++) {
			for (let j = 0; j < perspectives.length; j++) {
				if (i !== j) {
					if (perspectives[i].name === perspectives[j].name) {
						if (perspectives[i].link !== perspectives[j].link) {
							console.error('Duplication at perspective with name: [' + perspectives[i].name + '] pointing to links: ['
								+ perspectives[i].link + '] and [' + perspectives[j].link + ']');
						}
						duplication = true;
						break;
					}
				}
			}
			if (duplication) {
				break;
			}
		}
	} catch (error) {
		console.error('Error occured while loading metadata for the perspective: ' + module);
		console.error(error);
	}
}

perspectives.sort(function (p, n) {
	return (parseInt(p.order) - parseInt(n.order));
});
response.setContentType("application/json");
response.println(JSON.stringify(perspectives));