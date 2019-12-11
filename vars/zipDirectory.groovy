#!/usr/bin/env groovy

def call(Map args = [:]) {
	assert args.directory: "directory must be set"
	assert args.file: "file must be set"

	// Hacky way to crossplatform zip (using JAVA's jar)
	echo "ZIP Archiving directory ${args.directory} to ${args.file}"
	if (isUnix()) {
		// TODO: Check
		sh "\"${env.JAVA_HOME}/bin/jar\" -cMf \"${args.file}\" -C \"${args.directory}\" ." 
	}
	else {
		bat "\"%JAVA_HOME%/bin/jar\" -cMf \"${args.file}\" -C \"${args.directory}\" ."
	}
}
