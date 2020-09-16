pipelineJob('smile-avm-account-create') {
	displayName('Smile AVM Account Create')
	definition {
		cpsScm {
			scm {
				git {
					remote {
						url('https://github.com/trexsolutions/smile-avm.git')
					}
					branches('*/master')
				}
			}
			scriptPath('pipelines/smile-avm-account-create.jenkins')
		}
	}
}

pipelineJob('smile-avm-account-delete') {
	displayName('Smile AVM Account Delete')
	definition {
		cpsScm {
			scm {
				git {
					remote {
						url('https://github.com/trexsolutions/smile-avm.git')
					}
					branches('*/master')
				}
			}
			scriptPath('pipelines/smile-avm-account-delete.jenkins')
		}
	}
}

pipelineJob('smile-avm-landing-zone-create') {
	displayName('Smile AVM Landing Zone Create')
	definition {
		cpsScm {
			scm {
				git {
					remote {
						url('https://github.com/trexsolutions/smile-avm.git')
					}
					branches('*/master')
				}
			}
			scriptPath('pipelines/smile-avm-landing-zone-create.jenkins')
		}
	}
}

pipelineJob('smile-avm-landing-zone-delete') {
	displayName('Smile AVM Landing Zone Delete')
	definition {
		cpsScm {
			scm {
				git {
					remote {
						url('https://github.com/trexsolutions/smile-avm.git')
					}
					branches('*/master')
				}
			}
			scriptPath('pipelines/smile-avm-landing-zone-delete.jenkins')
		}
	}
}
