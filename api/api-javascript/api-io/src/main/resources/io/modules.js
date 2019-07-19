/*
 * Copyright (c) 2010-2019 SAP and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   SAP - initial API and implementation
 */
exports.getFiles = function() {
	var files = require('io/v4/files');
	return files;
};

exports.getStreams = function() {
	var streams = require('io/v4/streams');
	return streams;
};

exports.getZip = function() {
	var zip = require('io/v4/zip');
	return zip;
};

exports.getImage = function() {
	var image = require('io/v4/image');
	return image;
};

exports.getFtp = function() {
	var ftp = require('io/v4/ftp');
	return ftp;
};
