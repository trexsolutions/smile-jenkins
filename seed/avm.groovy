folder('smile') {
	displayName('Smile')
	description('Folder for Smile')
}
folder('smile/avm') {
	displayName('AVM')
	description('Folder for the Account Vending Machine')
}
folder('smile/lz') {
	displayName('LZ')
	description('Folder for Landing Zones')
}
folder('smile/container') {
	displayName('Container')
	description('Folder for Landing Zones')
}

pipelineJob('smile/avm/create') {
	displayName('Smile AVM Account Create')
	description('Creates a new Account in the Organization')
	definition {
    	cpsScm {
        	scm {
            	git {
                	remote {
                		url('https://github.com/trexsolutions/smile-cdk.git')
                    }
                    branches('*/master')
                }
            }
            scriptPath('pipelines/avm/account/create.groovy')
        }
	}
}
pipelineJob('smile/avm/delete') {
	displayName('Smile AVM Account Delete')
	description('Removes account from the Organization')
	definition {
    	cpsScm {
        	scm {
            	git {
                	remote {
                		url('https://github.com/trexsolutions/smile-cdk.git')
                    }
                    branches('*/master')
                }
            }
            scriptPath('pipelines/avm/account/delete.groovy')
        }
	}
}

pipelineJob('smile/avm/provision') {
	displayName('Smile AVM Account Provision')
	description('Provisions an account')
	definition {
    	cpsScm {
        	scm {
            	git {
                	remote {
                		url('https://github.com/trexsolutions/smile-cdk.git')
                    }
                    branches('*/master')
                }
            }
            scriptPath('pipelines/avm/account/provision.groovy')
        }
	}
}

pipelineJob('smile/lz/create') {
	displayName('Smile Landing Zone Create')
	description('Creates a Landing Zone')
	definition {
    	cpsScm {
        	scm {
            	git {
                	remote {
                		url('https://github.com/trexsolutions/smile-cdk.git')
                    }
                    branches('*/master')
                }
            }
            scriptPath('pipelines/lz/create.groovy')
        }
	}
}
pipelineJob('smile/lz/delete') {
	displayName('Smile Landing Zone Delete')
	description('Deletes a Landing Zone')
	definition {
    	cpsScm {
        	scm {
            	git {
                	remote {
                		url('https://github.com/trexsolutions/smile-cdk.git')
                    }
                    branches('*/master')
                }
            }
            scriptPath('pipelines/lz/delete.groovy')
        }
	}
}

pipelineJob('smile/container/build_publish') {
	displayName('Smile Container Build & Publish')
	description('Builds Dockerfile & Publishes to ECR')
	definition {
    	cpsScm {
        	scm {
            	git {
                	remote {
                		url('https://github.com/trexsolutions/smile-cdk.git')
                    }
                    branches('*/master')
                }
            }
            scriptPath('pipelines/container/build_publish.groovy')
        }
	}
}

