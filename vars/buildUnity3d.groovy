#!/usr/bin/env groovy
import groovy.transform.Field

@Field
Map defaults = [
    jobName: "Unity3D Build"
]

def call(Map args = [:]) {
	assert args.projectPath: "projectPath must be set"
	assert args.buildArgs: "buildArgs must be set"

	args = defaults + args

	// This is an external parametrized build job that uses Unity3D 
	// plugin to build the Unity3D project located in ${projectPath}
	// For build args see https://docs.unity3d.com/Manual/CommandLineArguments.html
	build job: args.jobName, parameters: [
		string(name: "PROJECT_PATH", value: args.projectPath), 
		string(name: "BUILD_ARGS", value: args.buildArgs)
	]
}