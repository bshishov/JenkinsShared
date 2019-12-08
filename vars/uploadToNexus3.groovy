#!/usr/bin/env groovy
import groovy.transform.Field

@Field
Map defaults = [
    repository: 'releases'
]

//def call(String filename, String nexusUrl, String targetFilename, String repository = 'releases') {
def call(Map args = [:]) {
	assert args.filename: "filename must be set"
	assert args.nexusUrl: "nexusUrl must be set"
	assert args.targetFilename: "targetFilename must be set"

	args = defaults + args

	command = "curl -v --upload-file \"${args.filename}\" \"${args.nexusUrl}/repository/${args.repository}/${args.targetFilename}\""
	if (isUnix()) {
		sh command
	} else {
		bat command
	}
}