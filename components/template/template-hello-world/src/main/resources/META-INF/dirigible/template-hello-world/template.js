/*
 * Generated by Eclipse Dirigible based on model and template.
 *
 * Do not modify the content as it may be re-generated again.
 */
exports.getTemplate = function() {
	return {
		"name": "Hello World",
		"description": "Hello World Template",
		"sources": [{
			"location": "/template-hello-world/service.mjs.template", 
			"action": "generate",
			"rename": "{{fileName}}.mjs"
		},{
			"location": "/template-hello-world/service.js.template", 
			"action": "generate",
			"rename": "{{fileName}}.js"
		}],
		"parameters": [],
		"order": -1
	};
};
