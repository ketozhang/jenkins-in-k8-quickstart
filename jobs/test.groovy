#!/usr/bin/env groovy

pipelineJob('test') {
    logRotator {
        numToKeep(10)
        daysToKeep(30)
    }

    configure { project ->
        project / 'properties' / 'org.jenkinsci.plugins.workflow.job.properties.DurabilityHintJobProperty' {
            hint('PERFORMANCE_OPTIMIZED')
        }
    }

    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url('https://github.com/ketozhang/jenkins-in-k8-quickstart')
                    }
                    branches('*/main')
                    extensions (
                        cloneOptions (
                            shallow(true)
                        )
                    )
                }
            }
            scriptPath('jenkins/hello-world.jenkinsfile')
        }
    }
}