String basePath = 'Smile'
String repo = 'https://github.com/trexsolutions/smile-cdk'

folder(basePath) {
  description('Smile Folder')
}

pipelineJob("$basePath/smile-builder") {
  description('Builds smile-builder image and pushes to ecr')
  definition {
      cpsScm {
          scm {
              git {
                  remote {
                    credentials('jenkins-github')
                    url(repo)
                  }
                  branches('*/master')
                }
            }
            scriptPath('pipelines/smile-builder/Jenkinsfile')
        }
    }
}

pipelineJob("$basePath/smile-provisioner") {
  description('Builds smile-provisioner and pushes to ecr')
  definition {
      cpsScm {
          scm {
              git {
                  remote {
                    credentials('jenkins-github')
                    url(repo)
                  }
                  branches('*/master')
                }
            }
            scriptPath('pipelines/smile-provisioner/Jenkinsfile')
        }
    }
}

pipelineJob("$basePath/smile-avm-account-create") {
  description('Creates an AWS Organization Account')
  definition {
      cpsScm {
          scm {
              git {
                  remote {
                    credentials('jenkins-github')
                    url(repo)
                  }
                  branches('*/master')
                }
            }
            scriptPath('pipelines/smile-avm/Jenkinsfile.create')
        }
    }
}

pipelineJob("$basePath/smile-avm-account-provision") {
  description('Provisions an AWS Organization Account')
  definition {
      cpsScm {
          scm {
              git {
                  remote {
                    credentials('jenkins-github')
                    url(repo)
                  }
                  branches('*/master')
                }
            }
            scriptPath('pipelines/smile-avm/Jenkinsfile.provision')
        }
    }
}

pipelineJob("$basePath/smile-avm-account-delete") {
  description('Deletes an AWS Organization Account')
  definition {
      cpsScm {
          scm {
              git {
                  remote {
                    credentials('jenkins-github')
                    url(repo)
                  }
                  branches('*/master')
                }
            }
            scriptPath('pipelines/smile-avm/Jenkinsfile.delete')
        }
    }
}
