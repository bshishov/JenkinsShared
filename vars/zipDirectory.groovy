#!/usr/bin/env groovy

def call(String directory, String file) {
	// Hacky way to crossplatform zip (using JAVA's jar)
	echo "ZIP Archiving directory ${directory} to ${file}"
	if (isUnix()) {
		// TODO: Check
		sh "\"${env.JAVA_HOME}/bin/jar\" -cMf \"${file}\" \"${directory}\"" 
	}
	else {
		bat "\"%JAVA_HOME%/bin/jar\" -cMf \"${file}\" \"${directory}\""
	}
}