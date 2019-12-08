#!/usr/bin/env groovy

def call(
	String filename, 
	String nexusUrl, 
	String targetFilename,
	String repository = 'releases'
	) {
	command = "curl -v --upload-file \"${filename}\" \"${nexusUrl}/repository/${repository}/${targetFilename}\""
	if (isUnix()) {
		sh command
	} else {
		bat command
	}
}