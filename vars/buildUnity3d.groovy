#!/usr/bin/env groovy

def call(String projectPath, String buildArgs, String jobName = "Unity3D Build") {
	// This is an external parametrized build job that uses Unity3D 
	// plugin to build the Unity3D project located in ${projectPath}
	build job: jobName, parameters: [
		string(name: "PROJECT_PATH", value: projectPath), 
		string(name: "BUILD_ARGS", value: buildArgs)
	]
}