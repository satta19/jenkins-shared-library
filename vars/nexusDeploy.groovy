def call(Map config=[:], Closure body) {
    pipeline {
	agent any

	stages {
	   stage ("Deploy") {
	      if(config.deploy) {
	        filesByGlob = findFiles(excludes: '', glob: 'target/*.jar');
                artifactPath = filesByGlob[0].path;
		echo "$artifactPath"
			}
			}
		}
	body()
    }
}
